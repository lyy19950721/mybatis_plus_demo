package com.mipo.plus;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mipo.entity.User;
import com.mipo.mapper.UserMapper;
import com.mipo.service.IUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname SampleTest
 * @Description TODO
 * @Date 2021/1/20 14:47
 * @Created by li.yy
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IUserService userService;

    @Test
    public void testSelectByMapper() {
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testServiceGetById() {
        User user = userService.getById(1);
        Assert.assertEquals("Jone", user.getName());
        System.out.println(user);
    }

    @Test
    public void testServiceGetOne() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq(User.Fields.name, "Jone");
        User user = userService.getOne(wrapper);
        Assert.assertEquals("Jone", user.getName());
        System.out.println(user);
    }

    @Test
    public void testServicePage() {
        Page page = new Page();
        page.setCurrent(1);
        page.setSize(2);
        page = userService.page(page);
        Assert.assertEquals(2, page.getRecords().size());
        page.getRecords().forEach(System.out::println);
    }

    @Test
    public void testServiceQuery() {
        User user = userService.query().eq(User.Fields.name, "Jack").one();
        Assert.assertEquals("Jack", user.getName());
        System.out.println(user);
    }

    @Test
    public void testServiceLambdaQuery() {
        Integer count = userService.lambdaQuery().like(User::getName, "J").count();
        Assert.assertTrue(2==count);
        System.out.println(count);
    }

    @Test
    public void testServiceAllEq() {
        QueryWrapper<User> userQueryWrapper = Wrappers.query();
        userQueryWrapper.allEq((k , v) -> k.startsWith("n") , MapUtil.of("name", "tom"), false);
        List<User> list = userService.list(userQueryWrapper);
        Assert.assertTrue(CollectionUtil.isNotEmpty(list));
        list.forEach(System.out::println);
    }

    @Test
    public void testServiceInsert() {
        boolean save = userService.save(new User().setName("liuxing").setAge(10).setEmail("sdsd@qq.com"));
        Assert.assertTrue(save);
    }

    @Test
    public void testServiceDelete() {
        boolean remove = userService.removeByIds(Arrays.asList("af8159198e6ac67fbc46d8787c0d70bd"));
        Assert.assertTrue(remove);
    }

    @Test
    public void testServiceUpdate() {
        User user = new User();
        user.setId("af8159198e6ac67fbc46d8787c0d70bd");
        user.setName("liubo");
        boolean update = userService.updateById(user);
        Assert.assertTrue(update);
    }
}
