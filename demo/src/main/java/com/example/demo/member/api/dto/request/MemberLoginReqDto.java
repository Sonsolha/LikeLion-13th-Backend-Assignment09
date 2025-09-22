package com.example.demo.member.api.dto.request;
import io.swagger.v3.oas.annotations.media.Schema; import jakarta.validation.constraints.*;
public record MemberLoginReqDto(
        @NotBlank @Email @Schema(description="이메일", example="test@example.com") String email,
        @NotBlank @Schema(description="비밀번호", example="password1234") String password
) {}
