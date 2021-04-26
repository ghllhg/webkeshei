package util;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test {

    public static void main(String[] args)  {
        System.out.println("111");
        Connection conn= null;
        PreparedStatement ps=null;
        try {
            conn = JDBCUtils.getConnection();
            System.out.println("2222");
            String sql="insert into user(username,password,phone,email) values(?,?,?,?) ";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"2");
            ps.setString(2,"2");
            ps.setInt(3,2);
            ps.setString(4,"3");

            int cout = ps.executeUpdate();
            System.out.println(cout+"END");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(conn,ps);
        }

    }

}
