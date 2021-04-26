package dao;

import domain.User;

public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 用户保存
     * @param user
     * @return
     */
    public User save(User user);

    /**
     * 查询用户名和密码
     * @param username
     * @param password
     * @return
     */
     User findByUsernameAndPassword(String username, String password);
}
