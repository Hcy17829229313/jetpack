package com.example.tesy.music;

public  class TimeUtils {
 public   static String timefenUtil(int s){
        String time;
        int round =(int) Math.round(s);
        int miao = round % 60;
        int fen = round / 60;
        if (fen > 9) {
            if (miao>9){
                time=(""+fen+":"+miao);
            }else{
                time=(""+fen+":0"+miao);
            }
        } else {
            if (miao>9){
                time=("0"+fen+":"+miao);
            }else{
                time=("0"+fen+":0"+miao);
            }
        }
        return time;

    }
}
