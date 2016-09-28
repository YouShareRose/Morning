package com.control;

import com.config.Serial_Num_Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/6.
 */
public class UploadContract {
    private static final Logger logger = LogManager.getLogger(UploadContract.class);
    /**
     * 生成流水号
     * @return
     */
    public String CreateSerial_Num(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        String year = format.format(date);
        logger.debug(year);
        logger.trace(year);
        logger.error(year);
        //Ju 流水号代码更换 2015.1.8
        //wh edit 2015/1/25
        String Serial_Num = null;
//        if(year.equals(Serial_Num_Config.getYear())){//如果年份并未发生变化,则在原先的登记号上累加
//            Serial_Num = year+"Z41JS"+String.valueOf(Serial_Num_Config.Add_Z41_Num()+100000000).substring(1,9);
//        }else{
//            Serial_Num_Config.init_Z41();
//            Serial_Num_Config.setyear(year);
//            Serial_Num = year+"Z41JS"+String.valueOf(Serial_Num_Config.Add_Z41_Num()+100000000).substring(1,9);
//        }
        return Serial_Num;
    }

    public static void main(String[] args) {
        UploadContract u1 = new UploadContract();
        u1.CreateSerial_Num();
    }
}
