package com.control;

import com.config.Serial_Num_Config;
import com.connect.db.NewDBConn;
import com.connect.db.TableConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 版权合同备案数据库相关操作
 * Created by Administrator on 2016/9/6.
 */
public class UploadContract {
    private static final Logger logger = LogManager.getLogger(UploadContract.class);

    /**
     * 生成流水号
     * 著作权合同备案号：苏合备JS20  -  号
     * @return
     */
    public String CreateSerial_Num(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        String year = format.format(date);

        String Serial_Num = null;
        if(year.equals(Serial_Num_Config.getYear())){//如果年份并未发生变化,则在原先的登记号上累加
            Serial_Num = year+"Z20JS"+String.valueOf(Serial_Num_Config.Add_Z20_Num()+100000000).substring(1,9);
        }else{
            Serial_Num_Config.init_Z20();
            Serial_Num_Config.setyear(year);
            Serial_Num = year+"Z20JS"+String.valueOf(Serial_Num_Config.Add_Z20_Num()+100000000).substring(1,9);
        }
        return Serial_Num;
    }

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();//获取一个Claender实例
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");//格式化日期的形式
        cal.set(2016,05,13);//设置日期，此时的日期是2013年11月30号
        String date = sf.format(cal.getTime());//此时的date值为20131130
        cal.add(Calendar.DAY_OF_YEAR, 90);//减去一天
        date = sf.format(cal.getTime());//此时date的日期为20131129


       // Date date = new Date();

        System.out.println(date+",,,,");
//        date = date.getTime() + 90;
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd");
//        String year1 = format1.format(date.getTime()+ 90 * 24 * 60 * 60 * 1000);
//        System.out.println(year1);


//        UploadContract u1 = new UploadContract();
//        logger.debug("just new a UploadContract");
//        logger.info(u1.CreateSerial_Num());
//        try {
//            String sql = "insert into " + TableConfig.copyright_contract_record +
//                    "(`Serial_Num`,`RegisterType`,`WorkName`,`WorkType`" +
//                    ", `Register_Num`, `CopyrightBen`, `RegisterWay`, `Erop_Name`, `Erop_Addr`, `Erop_Contact`, " +
//                    "`Erop_Tel`, `TransferorName`, `TransferorAddr`, `TransferorContact`, `TransferorTel`, " +
//                    "`ContractProperty`, `Ertu`, `RightStartTime`, `RightEndTime`, `ContractSignTime`, `RegionScope`) values" +
//                    "('"+u1.CreateSerial_Num()+"','Z20','东方跆拳道教育馆--教育流程','文字'" +
//                    ", 'qq', 'qq', 'qq', 'qq', 'qq', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q')";
//            logger.debug(sql);
//            NewDBConn.excuteupdate(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
