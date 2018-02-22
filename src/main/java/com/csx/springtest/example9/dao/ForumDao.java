package com.csx.springtest.example9.dao;

import com.csx.springtest.example9.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/22
 */
@Repository
public class ForumDao {
    private JdbcTemplate jdbcTemplate;

    public void addForum(final Forum forum) {
        final String sql = "INSERT INTO t_forum(forum_name,forum_desc) VALUES(?,?)";
        //绑定参数并指定对应参数的类型
//        Object[] params=new Object[]{forum.getForumName(),forum.getForumDesc()};
//        int[] types=new int[]{Types.VARCHAR,Types.VARCHAR};
//        jdbcTemplate.update(sql,params,types);

        //通过匿名内部类定义回调实例
//        jdbcTemplate.update(sql, new PreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement ps) throws SQLException {
//                ps.setString(1, forum.getForumName());
//                ps.setString(2, forum.getForumDesc());
//            }
//        });


        //返回新增记录对应主键
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection conn)
                    throws SQLException {
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, forum.getForumName());
                ps.setString(2, forum.getForumDesc());
                return ps;
            }
        }, keyHolder);
        forum.setForumId(keyHolder.getKey().intValue());
    }

    /**
     * 批量插入操作
     * @param forums
     */
    public void addForums(final List<Forum> forums){
        final String sql = "INSERT INTO t_forum(forum_name,forum_desc) VALUES(?,?)";
        jdbcTemplate.update(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Forum forum = forums.get(i);
                ps.setString(0,forum.getForumName());
                ps.setString(1,forum.getForumDesc());
            }

            @Override
            public int getBatchSize() {
                return forums.size();
            }
        });
    }
    public Forum getForum(final int forumId) {
        String sql = "SELECT forum_name,forum_desc FROM t_forum WHERE forum_id=?";
        final Forum forum = new Forum();
        jdbcTemplate.query(sql, new Object[]{forumId},
                new RowCallbackHandler() {
                    public void processRow(ResultSet rs) throws SQLException {
                        forum.setForumId(forumId);
                        forum.setForumName(rs.getString("forum_name"));
                        forum.setForumDesc(rs.getString("forum_desc"));
                    }
                });
        return forum;
    }

    public List<Forum> getForums(final int fromId,final int toId){
        String sql = "SELECT forum_id,forum_name,forum_desc FROM t_forum WHERE forum_id between ? and ?";
        final List<Forum> forums=new ArrayList<>();
//        jdbcTemplate.query(sql, new Object[]{fromId, toId}, new RowCallbackHandler() {
//            @Override
//            public void processRow(ResultSet resultSet) throws SQLException {
//                Forum forum=new Forum();
//                forum.setForumId(resultSet.getInt("forum_id"));
//                forum.setForumName(resultSet.getString("forum_name"));
//                forum.setForumDesc(resultSet.getString("forum_desc"));
//                forums.add(forum);
//            }
//        });
//        return forums;
        return jdbcTemplate.query(sql, new Object[]{fromId, toId}, new RowMapper<Forum>() {
            @Override
            public Forum mapRow(ResultSet resultSet, int i) throws SQLException {
                Forum forum=new Forum();
                forum.setForumId(resultSet.getInt("forum_id"));
                forum.setForumName(resultSet.getString("forum_name"));
                forum.setForumDesc(resultSet.getString("forum_desc"));
                return forum;
            }
        });
    }

    /**
     * 计算结果集行数
     * @return
     */
    public int getCount(){
        RowCountCallbackHandler countCallbackHandler=new RowCountCallbackHandler();
        jdbcTemplate.query("select * from user",countCallbackHandler);
        return countCallbackHandler.getRowCount();
    }

    public int getForumNum() {
        String sql = "SELECT forum_id FROM t_forum ";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public void updateForum(final Forum forum) {
        final String sql = "UPDATE  t_forum SET forum_name=?,forum_desc=? WHERE forum_id=?";
        Object[] params = new Object[]{forum.getForumName(),forum.getForumDesc(),forum.getForumId()};
        jdbcTemplate.update(sql, params);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
