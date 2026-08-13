package com.kh.khquiz.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Schema(name = "게시글 추가 요청 정보")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostAddRequestVO {
	@NotNull @Positive
	private int postNo;
	@NotNull
	private String postTitle;
	@NotNull
	private String postContent;
	@NotNull
	private String postPassword;
	private LocalDateTime postCtime;
	private LocalDateTime postUtime;
}
