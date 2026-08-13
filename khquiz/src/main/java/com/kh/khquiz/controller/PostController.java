package com.kh.khquiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.khquiz.annotation.CommonsApiResponse;
import com.kh.khquiz.dao.PostDao;
import com.kh.khquiz.dto.PostDto;
import com.kh.khquiz.error.TargetNotfoundException;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "게시글 API")
@CrossOrigin
@CommonsApiResponse
@RestController
@RequestMapping("/api/post")
public class PostController {
	@Autowired
	private PostDao postDao;

	//등록
	@ApiResponse(responseCode = "200",description = "게시글 등록")
	@PostMapping(value = "/", produces = "application/json")
	public PostDto insert(@RequestBody PostDto postDto) {
		int postNo = postDao.sequence();
		postDto.setPostNo(postNo);
		postDao.insert(postDto);
		return postDto;
		
	}
	//조회
	@ApiResponse(responseCode = "200",description = "게시글 조회")
	@GetMapping("/")
	public List<PostDto> list(){
		return postDao.selectList();
	}
	
	//상세
	@GetMapping("/{postNo}")
	public PostDto find(@PathVariable int postNo) {
		PostDto postDto = postDao.selectOne(postNo);
		if(postDto == null) throw new TargetNotfoundException();
		return postDto;
	}
		
	//삭제
	@DeleteMapping("/{postNo}")
	public PostDto delete(@PathVariable int postNo) {
		PostDto postDto = postDao.selectOne(postNo);
		if(postDto == null) throw new TargetNotfoundException();
		postDao.delete(postNo);
		return postDto;
	}
	//수정
	@PutMapping("/{postNo}")
	public PostDto update(@RequestBody PostDto postDto,
							@PathVariable int postNo) {
		PostDto findPostDto = postDao.selectOne(postNo);
		if(findPostDto == null) throw new TargetNotfoundException();
		
		postDto.setPostNo(postNo);
		postDao.update(postDto);
		
		return postDto;
	}
	
	
}
