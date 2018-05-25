package com.csx.springtest.example1.dao;

import com.csx.springtest.example1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/31
 */
@Service
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    private  final static String MATCH_COUNT_SQL = " SELECT count(*) FROM t_user  " +
            " WHERE user_name =? and password=? ";
    private  final static String UPDATE_LOGIN_INFO_SQL = " UPDATE t_user SET " +
            " last_visit=?,last_ip=?,credits=?  WHERE user_id =?";

    public int getMatchCount(String userName, String password) {

        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[]{userName, password}, Integer.class);
    }

    public User findUserByUserName(final String userName) {
        String sqlStr = " SELECT user_id,user_name,credits "
                + " FROM t_user WHERE user_name =? ";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[] { userName },(ResultSet rs)->{
           user.setUserId(rs.getInt("user_id"));
           user.setUserName(userName);
           user.setCredits(rs.getInt("credits"));
        });
        return user;
    }


    public void updateLoginInfo(User user) {
        Object[] args={user.getLastVisit(),
                user.getLastIp(),user.getCredits(),user.getUserId()};
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL,args);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
