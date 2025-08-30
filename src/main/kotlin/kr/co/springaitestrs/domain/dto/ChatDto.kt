package kr.co.springaitestrs.domain.dto

import io.swagger.v3.oas.annotations.media.Schema


@Schema(description = "채팅 요청 데이터 모델")
data class ChatRequestDto(
    @Schema(description = "사용자 질문", example = "안녕하세요")
    val query: String,

    @Schema(description = "사용할 LLM 모델", example = "gpt-3.5-turbo", defaultValue = "gpt-3.5-turbo")
    val model: String = "gpt-3.5-turbo"
)
