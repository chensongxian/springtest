package com.csx.springtest.example9.dao;

import com.csx.springtest.example9.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/22
 */
@Repository
public class TopicDao {
    private JdbcTemplate jdbcTemplate;

    public void addTopic(final Topic topic) {
        final String sql = "INSERT INTO t_topic(topic_title) VALUES(?)";

//		KeyHolder keyHolder = new GeneratedKeyHolder();
//		getJdbcTemplate().update(new PreparedStatementCreator() {
//			public PreparedStatement createPreparedStatement(Connection conn)
//					throws SQLException {
//				PreparedStatement ps = conn.prepareStatement(sql);
//				ps.setString(1, topic.getTopicTitle());
//				return ps;
//			}
//		}, keyHolder);
//		topic.setTopicId(keyHolder.getKey().intValue());

        Object[] params = new Object[]{topic.getTopicTitle()};
        jdbcTemplate.update(sql, params);
    }

    public double getReplyRate(int userId){
        String sql="SELECT topic_replies,topic_views FROM t_topic where user_id=?";
        double rate=jdbcTemplate.queryForObject(sql, new Object[]{userId}, new RowMapper<Double>() {
            @Override
            public Double mapRow(ResultSet resultSet, int i) throws SQLException {
                int replies=resultSet.getInt("topic_replies");
                int views=resultSet.getInt("topic_views");
                if(views>0){
                    return new Double((double) replies/views);
                }else{
                    return new Double(0.0);
                }
            }
        });
        return rate;
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
