package com.zhang.springboot.springbootjpa.dao;

import com.zhang.springboot.springbootjpa.domain.UserDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<UserDo, Long> {

    List<UserDo> findByAccount(String account);

    @Query("select o from UserDo o where o.account= :account1 or o.account= :account2")
    List<UserDo> findByAccounts(@Param("account1") String account1,@Param("account2") String account2);

    @Query(nativeQuery = true,value = "select u.* from auth_user u,auth_role_user ru where u.id=ru.user_id and ru.role_id= :roleId")
    List<UserDo> findUsersByRole(@Param("roleId") Long roleId);
}
