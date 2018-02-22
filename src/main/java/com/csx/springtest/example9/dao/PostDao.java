package com.csx.springtest.example9.dao;

import com.csx.springtest.example9.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/22
 */
@Repository
public class PostDao {
    private JdbcTemplate jdbcTemplate;

    public void addPost(final Post post) {
        String sql = " INSERT INTO t_post(topic_id,post_text)"
                + " VALUES(?,?)";
        Object[] params = new Object[]{post.getTopicId(),post.getPostText()};
        jdbcTemplate.update(sql, params);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
