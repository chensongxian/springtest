package com.csx.springtest.example10.service.mybatis;

import com.csx.springtest.example10.dao.mybatis.ForumMybatisDao;
import com.csx.springtest.example10.dao.mybatis.PostMybatisDao;
import com.csx.springtest.example10.dao.mybatis.TopicMybatisDao;
import com.csx.springtest.example10.domain.Forum;
import com.csx.springtest.example10.domain.Post;
import com.csx.springtest.example10.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BbtForumSerive{
	private ForumMybatisDao forumDao;

	private TopicMybatisDao topicDao;

	private PostMybatisDao postDao;

	@Autowired
	public void setForumDao(ForumMybatisDao forumDao) {
		this.forumDao = forumDao;
	}

	@Autowired
	public void setTopicDao(TopicMybatisDao topicDao) {
		this.topicDao = topicDao;
	}

	@Autowired
	public void setPostDao(PostMybatisDao postDao) {
		this.postDao = postDao;
	}

	public void addForum(Forum forum) {
		forumDao.addForum(forum);
	}
	public void addTopic(Topic topic) {
		topicDao.addTopic(topic);
	}
	public void addPost(Post post) {
		postDao.addPost(post);
	}

	public Forum getForum(int forumId) {
		return forumDao.getForum(forumId);
	}
	public void updateForum(Forum forum) {
		forumDao.updateForum(forum);
	}
	public long getForumNum() {
		return forumDao.getForumNum();
	}
	public List<Forum> findForumByName(String forumName) {
		return forumDao.findForumByName(forumName);
	}
	public Post getPost(int postId) {
		return postDao.getPost(postId);
	}

}
