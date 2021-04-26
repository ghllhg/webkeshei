package dao.impl;

import dao.PhoneDao;
import domain.Phone;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class PhoneDaoimpl implements PhoneDao {
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int findTotalCount(int phoneID) {
        String sql="select count(*) from phone where phoneID=?";
        return template.queryForObject(sql,Integer.class,phoneID);
    }

    @Override
    public List<Phone> FindallPhone(int start, int pageSize ) {
        String sql="select * from phone limit ?,?";
        return template.query(sql,new BeanPropertyRowMapper<Phone>(Phone.class),start,pageSize);
    }

    @Override
    public Phone AddPhone(Phone phone) {
        String sql="insert into phone(phoneID,phonemodel,phonecpu,phonename) value(?,?,?,?)";
        template.update(sql,phone.getPhoneID(),
                phone.getPhonemodel(),
                phone.getPhonecpu(),
                phone.getPhonename());
        return phone;
    }
    @Override
    public Phone AddFindPhone(int phoneID) {
        Phone phone=null;
        try {
            String sql="select * from phone where phoneID=?";
            phone=template.queryForObject(sql,new BeanPropertyRowMapper<Phone>(Phone.class),phoneID);
        } catch (DataAccessException e) {

        }
        return phone;
    }
   /* @Test
    public void test2(){
        PhoneDaoimpl p=new PhoneDaoimpl();
        Phone phone = p.AddFindPhone(2);
        System.out.println(phone);
    }*/
    //update phone set phonemodel=?,phonecpu=?,phonename=? where phoneID=?
    @Override
    public Phone UpdatePhone(Phone phone) {
        String sql="update phone set phonemodel=?,phonecpu=?,phonename=? where phoneID=?";
        template.update(sql,phone.getPhonemodel(),
                phone.getPhonecpu(),
                phone.getPhonename(),
                phone.getPhoneID());
        return phone;
    }

    @Override
    public Phone DeletePhone(Phone phone) {
        String sql="delete from phone where phoneID =?";

        template.update(sql,phone.getPhoneID());

        return phone;
    }

   /* public static void main(String[] args) {
        PhoneDaoimpl a=new PhoneDaoimpl();

        System.out.println(a.template);
    }*/
}

