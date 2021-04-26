package service.impl;

import dao.UserDao;
import dao.impl.UserDaoimpl;
import domain.User;
import service.UserService;

public class UserServiceimpl implements UserService {

    private UserDao userDao=new UserDaoimpl();
    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        //根据用户名查询用户对象
        User u = userDao.findByUsername(user.getUsername());
        //判断u是否为null
        System.out.println("U="+u);
        if(u!=null){
            return false;
        }else {
            //保存用户信息
            System.out.println("保存信息");
            userDao.save(user);
            return true;
        }

    }
    //登陆方法
    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
