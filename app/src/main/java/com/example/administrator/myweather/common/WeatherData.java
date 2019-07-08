package com.example.administrator.myweather.common;

import com.example.administrator.myweather.common.FutureDayBean;

import java.util.HashMap;

/**
 * Created by Administrator on 2019/4/11.
 */

public class WeatherData {

    /**
     * resultcode : 200
     * reason : successed!
     * result : {"sk":{"temp":"12","wind_direction":"西南风","wind_strength":"2级","humidity":"50%","time":"22:31"},"today":{"temperature":"6℃~19℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西南风微风","week":"星期四","city":"北京","date_y":"2019年04月11日","dressing_index":"较舒适","dressing_advice":"建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。","uv_index":"弱","comfort_index":"","wash_index":"较适宜","travel_index":"较不宜","exercise_index":"较不宜","drying_index":""},"future":{"day_20190411":{"temperature":"6℃~19℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西南风微风","week":"星期四","date":"20190411"},"day_20190412":{"temperature":"9℃~22℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"南风微风","week":"星期五","date":"20190412"},"day_20190413":{"temperature":"8℃~23℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西北风微风","week":"星期六","date":"20190413"},"day_20190414":{"temperature":"8℃~23℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"wind":"西南风微风","week":"星期日","date":"20190414"},"day_20190415":{"temperature":"12℃~27℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"wind":"南风微风","week":"星期一","date":"20190415"},"day_20190416":{"temperature":"9℃~22℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"南风微风","week":"星期二","date":"20190416"},"day_20190417":{"temperature":"8℃~23℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"wind":"西南风微风","week":"星期三","date":"20190417"}}}
     * error_code : 0
     */

    public String resultcode;
    public String reason;
    public ResultBean result;
    public int error_code;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * sk : {"temp":"12","wind_direction":"西南风","wind_strength":"2级","humidity":"50%","time":"22:31"}
         * today : {"temperature":"6℃~19℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西南风微风","week":"星期四","city":"北京","date_y":"2019年04月11日","dressing_index":"较舒适","dressing_advice":"建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。","uv_index":"弱","comfort_index":"","wash_index":"较适宜","travel_index":"较不宜","exercise_index":"较不宜","drying_index":""}
         * future : {"day_20190411":{"temperature":"6℃~19℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西南风微风","week":"星期四","date":"20190411"},"day_20190412":{"temperature":"9℃~22℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"南风微风","week":"星期五","date":"20190412"},"day_20190413":{"temperature":"8℃~23℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"西北风微风","week":"星期六","date":"20190413"},"day_20190414":{"temperature":"8℃~23℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"wind":"西南风微风","week":"星期日","date":"20190414"},"day_20190415":{"temperature":"12℃~27℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"wind":"南风微风","week":"星期一","date":"20190415"},"day_20190416":{"temperature":"9℃~22℃","weather":"多云","weather_id":{"fa":"01","fb":"01"},"wind":"南风微风","week":"星期二","date":"20190416"},"day_20190417":{"temperature":"8℃~23℃","weather":"晴","weather_id":{"fa":"00","fb":"00"},"wind":"西南风微风","week":"星期三","date":"20190417"}}
         */

        public SkBean sk;
        public TodayBean today;
        public HashMap<String,FutureDayBean> future;
        public SkBean getSk() {
            return sk;
        }

        public void setSk(SkBean sk) {
            this.sk = sk;
        }

        public TodayBean getToday() {
            return today;
        }

        public void setToday(TodayBean today) {
            this.today = today;
        }


        public static class SkBean {
            /**
             * temp : 12
             * wind_direction : 西南风
             * wind_strength : 2级
             * humidity : 50%
             * time : 22:31
             */

            public String temp;
            public String wind_direction;
            public String wind_strength;
            public String humidity;
            public String time;

            public String getTemp() {
                return temp;
            }

            public void setTemp(String temp) {
                this.temp = temp;
            }

            public String getWind_direction() {
                return wind_direction;
            }

            public void setWind_direction(String wind_direction) {
                this.wind_direction = wind_direction;
            }

            public String getWind_strength() {
                return wind_strength;
            }

            public void setWind_strength(String wind_strength) {
                this.wind_strength = wind_strength;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
        }

        public static class TodayBean {
            /**
             * temperature : 6℃~19℃
             * weather : 多云
             * weather_id : {"fa":"01","fb":"01"}
             * wind : 西南风微风
             * week : 星期四
             * city : 北京
             * date_y : 2019年04月11日
             * dressing_index : 较舒适
             * dressing_advice : 建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。
             * uv_index : 弱
             * comfort_index :
             * wash_index : 较适宜
             * travel_index : 较不宜
             * exercise_index : 较不宜
             * drying_index :
             */

            public String temperature;
            public String weather;
            public WeatherIdBean weather_id;
            public String wind;
            public String week;
            public String city;
            public String date_y;
            public String dressing_index;
            public String dressing_advice;
            public String uv_index;
            public String comfort_index;
            public String wash_index;
            public String travel_index;
            public String exercise_index;
            public String drying_index;

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public WeatherIdBean getWeather_id() {
                return weather_id;
            }

            public void setWeather_id(WeatherIdBean weather_id) {
                this.weather_id = weather_id;
            }

            public String getWind() {
                return wind;
            }

            public void setWind(String wind) {
                this.wind = wind;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDate_y() {
                return date_y;
            }

            public void setDate_y(String date_y) {
                this.date_y = date_y;
            }

            public String getDressing_index() {
                return dressing_index;
            }

            public void setDressing_index(String dressing_index) {
                this.dressing_index = dressing_index;
            }

            public String getDressing_advice() {
                return dressing_advice;
            }

            public void setDressing_advice(String dressing_advice) {
                this.dressing_advice = dressing_advice;
            }

            public String getUv_index() {
                return uv_index;
            }

            public void setUv_index(String uv_index) {
                this.uv_index = uv_index;
            }

            public String getComfort_index() {
                return comfort_index;
            }

            public void setComfort_index(String comfort_index) {
                this.comfort_index = comfort_index;
            }

            public String getWash_index() {
                return wash_index;
            }

            public void setWash_index(String wash_index) {
                this.wash_index = wash_index;
            }

            public String getTravel_index() {
                return travel_index;
            }

            public void setTravel_index(String travel_index) {
                this.travel_index = travel_index;
            }

            public String getExercise_index() {
                return exercise_index;
            }

            public void setExercise_index(String exercise_index) {
                this.exercise_index = exercise_index;
            }

            public String getDrying_index() {
                return drying_index;
            }

            public void setDrying_index(String drying_index) {
                this.drying_index = drying_index;
            }

            public static class WeatherIdBean {
                /**
                 * fa : 01
                 * fb : 01
                 */

                public String fa;
                public String fb;

                public String getFa() {
                    return fa;
                }

                public void setFa(String fa) {
                    this.fa = fa;
                }

                public String getFb() {
                    return fb;
                }

                public void setFb(String fb) {
                    this.fb = fb;
                }
            }
        }


    }
}
