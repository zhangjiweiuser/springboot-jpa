package com.zhang.springboot.springbootjpa;

import com.zhang.springboot.springbootjpa.dao.UserDao;
import com.zhang.springboot.springbootjpa.domain.UserDo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.soap.Addressing;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJpaApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void testAdd() {
        UserDo userDO = new UserDo();
        userDO.setName("风清扬");
        userDO.setAccount("fengqy");
        userDO.setPwd("123456");
        userDao.save(userDO);
        userDO = new UserDo();
        userDO.setName("东方不败");
        userDO.setAccount("bubai");
        userDO.setPwd("123456");
        userDao.save(userDO);
        userDO = new UserDo();
        userDO.setName("向问天");
        userDO.setAccount("wentian");
        userDO.setPwd("123456");
        userDao.save(userDO);
    }
    @Test
    public void testDel() {
        userDao.deleteById(1L);
    }

    @Test
    public void testQuery(){
        List<UserDo> userDoList = userDao.findAll();
        Assert.assertEquals(3,userDoList.size());
        userDoList.forEach(u-> System.out.println(u.toString()));
    }
    @Test
    public void testQueryByName(){
        List<UserDo> userDoList = userDao.findByAccount("wentian");
        Assert.assertNotNull(userDoList);
        userDoList.forEach(u-> System.out.println(u.toString()));
    }
    @Test
    public void testQueryManyParam(){
        List<UserDo> userDoList = userDao.findByAccounts("wentian","aa");
        Assert.assertNotNull(userDoList);
        userDoList.forEach(u-> System.out.println(u.toString()));
    }

    @Test
    public void testQueryByRole(){
        List<UserDo> userDoList = userDao.findUsersByRole(1L);
        Assert.assertNotNull(userDoList);
        userDoList.forEach(u-> System.out.println(u.toString()));
    }
}
