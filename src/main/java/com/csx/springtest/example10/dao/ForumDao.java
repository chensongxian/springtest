package com.csx.springtest.example10.dao;


import com.csx.springtest.example10.domain.Forum;

public class ForumDao extends BaseDao<Forum> {
	public long getForumNum() {
		Object obj = getHibernateTemplate().iterate(
		"select count(f.forumId) from Forum f").next();
        return (Long) obj;
	}
}
