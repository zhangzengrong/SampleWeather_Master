package com.example.administrator.myweather.common;

/**
 * Created by Administrator on 2019/4/13.
 */

public class FutureDayBean implements Comparable<FutureDayBean>{
    /**
         * temperature : 6℃~19℃
         * weather : 多云
         * weather_id : {"fa":"01","fb":"01"}
         * wind : 西南风微风
         * week : 星期四
         * date : 20190411
         */

        public String temperature;
        public String weather;
        public WeatherIdBeanX weather_id;
        public String wind;
        public String week;
        public String date;
    @Override
    public int compareTo(FutureDayBean o) {
        int i =(int)( Long.parseLong(this.date)- Long.parseLong(o.date));//先按照年龄排序

        return i;
    }




        public static class WeatherIdBeanX {
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


