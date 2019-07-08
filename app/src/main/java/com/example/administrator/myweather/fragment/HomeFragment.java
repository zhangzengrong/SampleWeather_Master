package com.example.administrator.myweather.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.administrator.myweather.R;
import com.example.administrator.myweather.common.WeatherData;
import com.example.administrator.myweather.common.CommonAdapter;
import com.example.administrator.myweather.common.FutureDayBean;
import com.example.administrator.myweather.common.ViewHolder;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Response;

public class HomeFragment extends Fragment {
	private String url="http://v.juhe.cn/weather/index?cityname=";
	private String wei="&dtype=&format=1&key=f3484e00bfeb2096e37d4c6983b6e122";
	private String city="深圳";
	private EditText etCity;
	private TextView search,content,wendu,tvsuggest;
	private Spinner tvCity;
	private RecyclerView rv;
	private CommonAdapter<FutureDayBean> adapter;
	private List<FutureDayBean> list=new ArrayList<>();
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}
    private View view;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	if (view==null){
		view=inflater.inflate(R.layout.activity_weather,null,false);
		initView();
	}
		return view;
	}

	private void initView() {
		rv=(RecyclerView)view.findViewById(R.id.rv);
		rv.setLayoutManager(new LinearLayoutManager(getActivity()));
		adapter=new CommonAdapter<FutureDayBean>(getActivity(),R.layout.item_layout,list) {
			@Override
			public void convert(ViewHolder holder, FutureDayBean futureDayBean) {
				holder.setText(R.id.date,futureDayBean.date+"\t"+futureDayBean.week)
						.setText(R.id.weather,futureDayBean.weather)
						.setText(R.id.wendu,futureDayBean.temperature);
			}
		};
		rv.setAdapter(adapter);
		etCity=(EditText)view.findViewById(R.id.et_city);
		content=(TextView)view.findViewById(R.id.tv_content);
		search=(TextView)view.findViewById(R.id.btn_search);
		wendu=(TextView)view.findViewById(R.id.tv_wendu);
		tvCity=(Spinner) view.findViewById(R.id.tv_city);
		tvsuggest=(TextView)view.findViewById(R.id.tv_suggest);
		search.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (!TextUtils.isEmpty(etCity.getText().toString())){
					city=etCity.getText().toString();
					String ur=url+city+wei;
					Log.d("url","url:"+ur);
					doGet(ur);
				}
			}
		});
		tvCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
				city=  getResources().getStringArray(R.array.spinner)[i];
				String ur=url+city+wei;
				Log.d("url","url:"+ur);
				doGet(ur);
			}

			@Override
			public void onNothingSelected(AdapterView<?> adapterView) {

			}
		});
		doGet(url+city+wei);
	}
	/**
	 * 获取天气预报数据信息
	 */
      /*
    * 传入一个Url地址  返回一个JSON字符串
    * 网络请求的情况分析:
    *   如果是404 500 ... 代表网络(Http协议)请求失败
    *   200 服务器返回成功
    *       业务成功  /业务失败
    *       okgo 简单网络请求
    * */
	public  void doGet(String urlPath) {
		OkGo.get(urlPath)                            // 请求方式和请求url
				.tag(this)                       // 请求的 tag, 主要用于取消对应的请求
				.cacheKey("cacheKey")            // 设置当前请求的缓存key,建议每个不同功能的请求设置一个
				.cacheMode(CacheMode.DEFAULT)    // 缓存模式，详细请看缓存介绍
				.execute(new StringCallback() {
					@Override
					public void onSuccess(String s, Call call, Response response) {
						Log.d("data:","data:"+s);
						//todo 使用gson 来解析数据s
						Gson gson = new Gson();
						WeatherData data=gson.fromJson(s, WeatherData.class);
						if(data.getResultcode().equals("200"))
							content.setText(data.getResult().getToday().getWind()+"\n"+data.getResult().getToday().getTemperature()+"\n"+data.getResult().getToday().getWeather());
						wendu.setText(data.getResult().getSk().getTemp()+"");
						tvsuggest.setText("* 建议 : "+data.getResult().getToday().getDressing_advice());
						tvsuggest.setSelected(true);
						list.clear();

						// 获取所有键值对对象的集合
						Set<Map.Entry<String, FutureDayBean>> set =data.getResult().future.entrySet();
						// 遍历键值对对象的集合，得到每一个键值对对象
						for (Map.Entry<String, FutureDayBean> me : set) {
							// 根据键值对对象获取键和值
							String key = me.getKey();
							list.add(me.getValue());
						}
						Collections.sort(list);
						adapter.notifyDataSetChanged();
					}
				});

	}


	@Override
	public void setArguments(Bundle args) {
		// TODO Auto-generated method stub
		super.setArguments(args);
	}

}
