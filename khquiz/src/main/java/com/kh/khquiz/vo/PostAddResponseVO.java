package com.kh.khquiz.vo;

import com.kh.khquiz.dto.PostDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "게시글 추가 응답 정보")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class PostAddResponseVO {
	private PostDto post;
}
