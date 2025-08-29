package kr.co.springaitestrs.service

import org.springframework.ai.huggingface.HuggingfaceChatModel
import org.springframework.stereotype.Service

@Service
class HuggingFaceService(
    private val huggingfaceChatModel: HuggingfaceChatModel
) {

    fun generateText(prompt: String): String {
        return huggingfaceChatModel.call(prompt)
    }
}
