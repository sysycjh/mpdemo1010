package com.cjh.mpdemo1010;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cjh.mpdemo1010.entity.User;
import com.cjh.mpdemo1010.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class Mpdemo1010ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test //测试插入
    public void testInsert(){
//        User lucy = new User((long) 6,"lucy", 22, "123@qq.com");
//        System.out.println(userMapper.insert(lucy));

        User user = new User();
        user.setAge(30);
        user.setName("niko");
        user.setEmail("niko@qq.com");
//        user.setCreateTime(new Date());
//        user.setUpdateTime(new Date());
        int count = userMapper.insert(user);
        System.out.println(count);
    }

    @Test //测试修改
    public void testUpdate(){
        User user = new User();
        user.setId(1580045547457499137L);
        user.setAge(99);
        int row = userMapper.updateById(user);
        System.out.println(row);
    }

    @Test //测试乐观锁
    public void testOptimisticLock(){

        User user = userMapper.selectById(1580089870152679425L); //先查询，得到版本号
        user.setAge(33);
        int row = userMapper.updateById(user); //再修改，才会自动修改版本号，触发乐观锁 （直接修改version不会++）
        System.out.println(row);
    }

    @Test //测试批量查询
    public void testBatchSelect(){
        userMapper.selectBatchIds(Arrays.asList(1L,2L,3L));
    }

    @Test //通过map封装查询条件
    public void testSelectByMap() {
        HashMap<String, Object> map = new HashMap <>();
        map.put("age", 18);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test //测试分页查询
    public void testPage(){
        //1.创建page对象
        //传入两个参数：当前页 和 每页显示记录数
        Page<User> page = new Page<>(1, 3);
        //调用mp分页查询的方法
        //mp分页查询过程中，将所有分页查询得到的信息封装到page对象里面
        userMapper.selectPage(page,null);

        //通过page对象获取分页的信息
        System.out.println(page.getCurrent()); //当前页
        System.out.println(page.getRecords()); //当前页数据 list集合
        System.out.println(page.getSize()); //每页显示记录条数
        System.out.println(page.getTotal()); //总记录数
        System.out.println(page.getPages()); //总页数

        System.out.println(page.hasPrevious()); //是否有上一页
        System.out.println(page.hasNext());//是否有下一页
    }

}
