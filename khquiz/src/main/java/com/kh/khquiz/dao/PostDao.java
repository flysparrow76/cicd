package com.kh.khquiz.dao;

import java.util.List;

import com.kh.khquiz.dto.PostDto;

public interface PostDao {
	
	int sequence();
	void insert(PostDto postDto);
	List<PostDto> selectList();
	PostDto selectOne(int postNo);
	boolean delete(int postNo);
	boolean update(PostDto postDto);
}
