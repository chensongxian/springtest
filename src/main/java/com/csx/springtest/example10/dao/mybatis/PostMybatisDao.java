package com.csx.springtest.example10.dao.mybatis;


import com.csx.springtest.example10.domain.Post;

public interface PostMybatisDao{
	void addPost(Post post);
	Post getPost(int postId);
}
