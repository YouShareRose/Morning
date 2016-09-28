package com.config;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/6.
 */
public class Serial_Num_Config {


    private static int Z41_Num = 1;

    public synchronized static int Add_Z41_Num() {
        return Z41_Num++;
    }

    public static void setZ41_Num(int z41_Num) {
        Z41_Num = z41_Num;
    }

    // 获取当前年份
    public synchronized static String getYear() {
        //从ocs读取
        String year = null;
//        if(Ocs.getData("year")==null){
            Date date = new Date();
            SimpleDateFormat sdformat = new SimpleDateFormat("yyyy");
            year = sdformat.format(date);
//            setYear(year);
//        }else{
//            year = (String)Ocs.getData("year");
//        }
        return year;
    }

}
