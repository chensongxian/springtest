package com.csx.springtest.example9.service;

import com.csx.springtest.example9.dao.ForumDao;
import com.csx.springtest.example9.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class ForumService1 {
	public ForumDao forumDao;
	public TransactionTemplate template;
	public void addForum(final Forum forum) {
		
		template.execute(new TransactionCallbackWithoutResult() {
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				forumDao.addForum(forum);
			}
		});

	}

	@Autowired
	public void setForumDao(ForumDao forumDao) {
		this.forumDao = forumDao;
	}
	@Autowired
	public void setTemplate(TransactionTemplate template) {
		this.template = template;
	}

	
	
}
