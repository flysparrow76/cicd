package com.kh.khquiz.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name = "게시글 정보")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class PostDto {
	private Integer postNo;
	private String postTitle;
	private String postContent;
	private String postPassword;
	private LocalDateTime postCtime;
	private LocalDateTime postUtime;
}
