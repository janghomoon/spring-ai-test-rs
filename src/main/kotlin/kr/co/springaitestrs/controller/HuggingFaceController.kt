package kr.co.springaitestrs.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import kr.co.springaitestrs.service.HuggingFaceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/chat")
@Tag(name = "HuggingFace Chat API", description = "HuggingFace AI API를 통한 채팅 기능")
class HuggingFaceController(
    private val myHuggingFaceService: HuggingFaceService
) {
    @Operation(summary = "텍스트 생성", description = "입력된 프롬프트를 기반으로 텍스트를 생성합니다. Hugging Face 모델 사용.")
    @GetMapping("/generate")
    fun generateText(
        @Parameter(description = "텍스트 생성 프롬프트", example = "Spring AI란 무엇인가요?")
        @RequestParam prompt: String
    ): String {
        return myHuggingFaceService.generateText("docker 를 설명해줘")
    }

    //    @Operation(summary = "농담 생성", description = "특정 주제에 대한 농담을 생성합니다.")
//    @GetMapping("/joke")
//    fun getJoke(
//        @Parameter(description = "농담 주제", example = "개발자")
//        @RequestParam(defaultValue = "programming") topic: String
//    ): String {
//        return myChatService.getJoke(topic)
//    }

//    @Operation(summary = "텍스트 생성", description = "입력된 프롬프트를 기반으로 텍스트를 생성합니다. Hugging Face 모델 사용.")
//    @GetMapping("/generate")
//    fun generateText(
//        @Parameter(description = "텍스트 생성 프롬프트", example = "Spring AI란 무엇인가요?")
//        @RequestParam prompt: String
//    ): String {
//        return myHuggingFaceService.generateText("docker 를 설명해줘")
//    }
}
