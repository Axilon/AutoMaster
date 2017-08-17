package ru.bk.rom4ik2103.services;


import ru.bk.rom4ik2103.usersPuck.CustomUser;

import java.util.List;

public interface UserService {
    CustomUser getUserByLogin(String login);
    void deleteUsers(long [] ids);
    boolean existsByLogin(String login);
    void addUser(CustomUser customUser);
    void updateUser(CustomUser customUser);
    List<CustomUser> listOfUsers();
}
