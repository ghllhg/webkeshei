package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

public class UserDaoimpl implements UserDao {

    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findByUsername(String username) {
        User user =null;
        try {
            String sql="select * from user where username =?";
             user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
            System.out.println("有重复名");
        } catch (DataAccessException e) {

        }
        System.out.println("user zhi="+user);
        return user;

    }

    @Override
    public User save(User user) {
        String sql="insert into user(username,password,phone,email) values(?,?,?,?)";
        template.update(sql,user.getUsername(),
                user.getPassword(),
                user.getPhone(),
                user.getEmail());
        return user;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user =null;
        try {
            String sql="select * from user where username =? and password =?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username,password);
            System.out.println("有重复名");
        } catch (DataAccessException e) {

        }
        System.out.println("user ="+user);
        return user;
    }
}
