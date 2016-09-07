package com.control;

import com.beans.ContractRecordBean;
import com.config.Serial_Num_Config;
import com.connect.db.NewDBConn;
import com.connect.db.PreConn;
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

    public int Upload(ContractRecordBean CRBean){
        int rsInt = 0;
        String Serial_Num = CreateSerial_Num();
        try {
            String sql = "insert into " + TableConfig.copyright_contract_record +
                    "(`Serial_Num`,`RegisterType`,`WorkName`,`WorkType`" +
                    ", `Register_Num`, `CopyrightBen`, `RegisterWay`, `Erop_Name`, `Erop_Addr`, `Erop_Contact`, " +
                    "`Erop_Tel`, `TransferorName`, `TransferorAddr`, `TransferorContact`, `TransferorTel`, " +
                    "`ContractProperty`, `Ertu`, `RightStartTime`, `RightEndTime`, `ContractSignTime`, `RegionScope`) values" +
                    "('"+Serial_Num+"','Z20','东方跆拳道教育馆--教育流程','文字'" +
                    ", 'qq', 'qq', 'qq', 'qq', 'qq', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q', 'q')";
            logger.debug(sql);
            rsInt = NewDBConn.excuteupdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsInt;
    }

    public int test(){
        int rs = 0;
        try {
            String sql = "insert into test" +
                    "(id,name) values( ?,?)";
            logger.debug(sql);
            rs = PreConn.update(sql,11,"abd");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public static void main(String[] args) {
        UploadContract u1 = new UploadContract();

        logger.debug("just new a UploadContract="+u1.test());

    }
}
