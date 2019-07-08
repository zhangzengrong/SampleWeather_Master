package com.example.administrator.myweather.common;

import com.example.administrator.myweather.R;
import com.example.administrator.myweather.fragment.HomeFragment;
import com.example.administrator.myweather.fragment.MineFragment;


public class TabDb {
	public static String[] getTabsTxt(){
		String[] tabs={"首页","我的"};
		return tabs;
	}
	public static int[] getTabsImg(){
		int[] ids={R.drawable.foot_news_normal,R.drawable.foot_out_normal};
		return ids;
	}
	public static int[] getTabsImgLight(){
		int[] ids={R.drawable.foot_news_light,R.drawable.foot_out_light};
		return ids;
	}
	public static Class[] getFragments(){
		Class[] clz={HomeFragment.class,MineFragment.class};
		return clz;
	}
}
