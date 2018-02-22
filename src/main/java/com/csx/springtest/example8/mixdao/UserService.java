package com.csx.springtest.example8.mixdao;

import com.csx.springtest.example8.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/22
 */
@Service("userService")
public class UserService extends BaseService{
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Autowired
    private ScoreService scoreService;

    /**
     * JDBC和hibernate的共用同一个事物而缓存不同步
     * 在混合数据访问的方案中一定要考虑缓存带来的问题
     * @param userName
     */
    public void logon(String userName) {
        /*
         * 通过hibernate技术访问数据
         */
        System.out.println("before userService.updateLastLogonTime()..");
        updateLastLogonTime(userName);
        System.out.println("end userService.updateLastLogonTime()..");

        /*
         * 通过jdbc访问数据
         */
        System.out.println("before scoreService.addScore()..");
        scoreService.addScore(userName, 20);
        System.out.println("end scoreService.addScore()..");
    }

    public void updateLastLogonTime(String userName) {
        User user = hibernateTemplate.get(User.class,userName);
        user.setLastLogonTime(System.currentTimeMillis());
        hibernateTemplate.update(user);
        /*
         * 必须显示调用flush，因为hibernate的数据的更改只记录在一级缓存中，只有在事物提交或显示调用flush时
         * 才会把一级缓存中的数据同步到数据库中。如果所有针对数据库的操作都是使用hibernate,那么不会有这种问题.
         * 但是上面的logon方法同时使用了hibernate和JDBC,JDBC无法自动感知hibernate的一级缓存,如果不及时调用
         * flush,JDBC进行数据更改的结果很有可能被hibernate覆盖,因为hibernate的一级缓存要等legon方法返回前才会
         * 同步到数据库中
         */
        hibernateTemplate.flush();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/smart/mixdao/applicationContext.xml");
        UserService service = (UserService) ctx.getBean("userService");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        //插入一条记录，初始分数为10
        jdbcTemplate.execute("INSERT INTO t_user(user_name,password,score,last_logon_time) VALUES('tom','123456',10,"+System.currentTimeMillis()+")");

        //调用工作在无事务环境下的服务类方法,将分数添加20分
        System.out.println("before userService.logon()..");
        service.logon("tom");
        System.out.println("after userService.logon()..");

        int score = jdbcTemplate.queryForObject("SELECT score FROM t_user WHERE user_name ='tom'", Integer.class);
        System.out.println("score:"+score);
        jdbcTemplate.execute("DELETE FROM t_user WHERE user_name='tom'");
    }
}
