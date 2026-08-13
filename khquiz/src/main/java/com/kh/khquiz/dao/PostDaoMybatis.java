package com.kh.khquiz.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.khquiz.dto.PostDto;

@Repository
public class PostDaoMybatis implements PostDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int sequence() {
		return sqlSession.selectOne("mapper.post.sequence");
	}

	@Override
	public void insert(PostDto postDto) {
		sqlSession.insert("mapper.post.add",postDto);
	}

	@Override
	public List<PostDto> selectList() {
		return sqlSession.selectList("mapper.post.list");
	}

	@Override
	public PostDto selectOne(int postNo) {
		return sqlSession.selectOne("mapper.post.find",postNo);
	}

	@Override
	public boolean delete(int postNo) {
		return sqlSession.delete("mapper.post.delete",postNo)>0;
	}

	@Override
	public boolean update(PostDto postDto) {
		return sqlSession.update("mapper.post.update",postDto)>0;
	}
	

}
