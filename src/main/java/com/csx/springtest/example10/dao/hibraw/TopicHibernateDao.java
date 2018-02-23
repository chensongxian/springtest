package com.csx.springtest.example10.dao.hibraw;

import com.csx.springtest.example10.domain.Topic;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TopicHibernateDao{
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void addTopic(Topic topic) {
		sessionFactory.getCurrentSession().save(topic);
	}
}
