package dao;

import bean.User;

public interface UserDao  {
    User query(User user);
    void insert(User user);
    boolean queryUsername(User user);
}
