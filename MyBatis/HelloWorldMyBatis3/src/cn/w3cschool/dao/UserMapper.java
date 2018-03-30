package cn.w3cschool.dao;

import java.util.List;
import cn.w3cschool.domain.User;

//½Ó¿Ú
public interface UserMapper {  
    public User findUserById(int id);
    public List<User> findUserAll();
    public void insertUser(User user);
    public void deleteUserById(int id);
    public void updateUserPassword(User user);
}
