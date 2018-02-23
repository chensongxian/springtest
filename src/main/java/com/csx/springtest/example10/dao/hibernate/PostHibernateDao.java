package com.csx.springtest.example10.dao.hibernate;

import com.csx.springtest.example10.domain.Post;
import org.springframework.stereotype.Repository;


@Repository
public class PostHibernateDao extends BaseDao {
	
	public void addPost(Post post) {
		getHibernateTemplate().save(post);	
	}

	public Post getPost(int postId) {
		// TODO Auto-generated method stub
		return null;
	}

}
