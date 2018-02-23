package com.csx.springtest.example10.service.hibernate;


import com.csx.springtest.example10.dao.hibernate.ForumHibernateDao;
import com.csx.springtest.example10.dao.hibernate.PostHibernateDao;
import com.csx.springtest.example10.dao.hibernate.TopicHibernateDao;
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

	private ForumHibernateDao forumDao;

	private TopicHibernateDao topicDao;

	private PostHibernateDao postDao;


	@Autowired
	public void setTopicDao(TopicHibernateDao topicDao) {
		this.topicDao = topicDao;
	}
	@Autowired
	public void setPostDao(PostHibernateDao postDao) {
		this.postDao = postDao;
	}

	@Autowired
	public void setForumDao(ForumHibernateDao forumDao) {
		this.forumDao = forumDao;
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
	public List findForumByName(String forumName) {
		return forumDao.findForumByName(forumName);
	}
	public Post getPost(int postId) {
		return postDao.getPost(postId);
	}

}
