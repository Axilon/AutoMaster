package ru.bk.rom4ik2103.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bk.rom4ik2103.dao.CustomerUserDAO;
import ru.bk.rom4ik2103.usersPuck.CustomUser;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private CustomerUserDAO userRepository;

    @Override
    @Transactional(readOnly = true)
    public CustomUser getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public void deleteUsers(long[] idList) {
        for (long id : idList)
            userRepository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByLogin(String login) {
        return userRepository.existsByLogin(login);
    }

    @Override
    @Transactional
    public void addUser(CustomUser customUser) {
        userRepository.save(customUser);
    }

    @Override
    @Transactional
    public void updateUser(CustomUser customUser) {
        userRepository.save(customUser);
    }

    @Override
    @Transactional
    public List<CustomUser> listOfUsers() {
        return userRepository.findAll();
    }

}
