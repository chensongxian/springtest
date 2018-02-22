package com.csx.springtest.example9.service;

import com.csx.springtest.example9.dao.ForumDao;
import com.csx.springtest.example9.dao.PostDao;
import com.csx.springtest.example9.dao.TopicDao;
import com.csx.springtest.example9.domain.Forum;
import com.csx.springtest.example9.domain.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BbtForum {
    public ForumDao forumDao;

    public TopicDao topicDao;

    public PostDao postDao;

    public void addTopic(Topic topic) throws Exception {
        topicDao.addTopic(topic);
//		if(true) throw new PessimisticLockingFailureException("fail");
        postDao.addPost(topic.getPost());
    }


    @Transactional(readOnly = true)
    public Forum getForum(int forumId) {
        return forumDao.getForum(forumId);
    }

    public void updateForum(Forum forum) {
        forumDao.updateForum(forum);
    }

    public int getForumNum() {
        return forumDao.getForumNum();
    }

    @Autowired
    public void setForumDao(ForumDao forumDao) {
        this.forumDao = forumDao;
    }

    @Autowired
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Autowired
    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }
}
