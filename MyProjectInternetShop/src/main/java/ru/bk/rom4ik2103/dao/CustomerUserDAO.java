package ru.bk.rom4ik2103.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.bk.rom4ik2103.usersPuck.CustomUser;

public interface CustomerUserDAO extends JpaRepository<CustomUser,Long>{
    @Query("SELECT u FROM CustomUser u WHERE u.login = :login")
    CustomUser findByLogin (@Param("login")String login);
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM CustomUser u WHERE u.login = :login")
    boolean existsByLogin(@Param("login") String login);

}
