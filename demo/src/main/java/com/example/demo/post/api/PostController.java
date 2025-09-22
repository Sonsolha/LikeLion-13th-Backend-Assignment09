package com.example.demo.post.api;

import com.example.demo.global.ApiResTemplate;
import com.example.demo.post.api.dto.request.PostSaveReq;
import io.swagger.v3.oas.annotations.Operation; import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/post") @Tag(name="포스트", description="게시글 관련 API")
public class PostController {
    @PostMapping("/save")
    @Operation(summary="게시글 저장", description="제목과 내용을 저장합니다.")
    public ApiResTemplate<String> save(@RequestBody @Valid PostSaveReq req){
        return ApiResTemplate.createdNoContent("글이 성공적으로 등록되었습니다.");
    }
}