package com.csx.springtest.example5.advice;

import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/08
 */
public class ForumService {
    public void removeForum(int forumId) {
        // do sth...
        throw new RuntimeException("运行异常。");
    }
    public void updateForum(Forum forum) throws Exception{
        // do sth...
        throw new SQLException("数据更新操作异常。");

    }
}
