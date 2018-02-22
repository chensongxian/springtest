package com.csx.springtest.example9.service;


import com.csx.springtest.example9.ForumTransactional;
import com.csx.springtest.example9.TopicTransactional;
import com.csx.springtest.example9.dao.ForumDao;
import com.csx.springtest.example9.dao.PostDao;
import com.csx.springtest.example9.dao.TopicDao;
import com.csx.springtest.example9.domain.Forum;
import com.csx.springtest.example9.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiForumService {
	private ForumDao forumDao;
	private TopicDao topicDao;
	private PostDao postDao;
	
//	@Transactional("topic")
	@TopicTransactional
	public void addTopic(Topic topic) throws Exception {
       System.out.println("topic tx");
	}
	
//	@Transactional("forum")
	@ForumTransactional
	public void updateForum(Forum forum) {
		System.out.println("forum tx");
	}

	public ForumDao getForumDao() {
		return forumDao;
	}
	@Autowired
	public void setForumDao(ForumDao forumDao) {
		this.forumDao = forumDao;
	}
	public TopicDao getTopicDao() {
		return topicDao;
	}
	@Autowired
	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}
	public PostDao getPostDao() {
		return postDao;
	}
	@Autowired
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	
}
