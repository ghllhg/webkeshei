package dao.impl;

import domain.Phone;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

public class hello {
    public static void main(String[] args) {
         PhoneDaoimpl a=new PhoneDaoimpl();
        int b=3;
        System.out.println(a.AddFindPhone(4).getPhonemodel());

    }
}
