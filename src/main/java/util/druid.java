package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

public class druid {
    public static void main(String[] args) throws Exception {
        Properties pro=new Properties();
        pro.load(druid.class.getClassLoader().getResourceAsStream("druid.properties"));
        DataSource ds= DruidDataSourceFactory.createDataSource(pro);
        Connection conn=ds.getConnection();
        System.out.println(conn);
    }
}
