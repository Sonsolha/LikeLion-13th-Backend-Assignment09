package com.example.demo.post.api.dto.request;
import io.swagger.v3.oas.annotations.media.Schema; import jakarta.validation.constraints.NotBlank;
public record PostSaveReq(
        @NotBlank @Schema(example="swagger 사용법 복습") String title,
        @NotBlank @Schema(example="swagger를 사용하여 봅시다.") String content
) {}