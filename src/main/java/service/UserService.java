package service;

import domain.User;

public interface UserService {
    boolean regist(User user);

    User login(User user);
}
