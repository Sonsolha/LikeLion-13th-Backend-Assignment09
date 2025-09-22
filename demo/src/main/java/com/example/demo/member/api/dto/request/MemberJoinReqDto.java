package com.example.demo.member.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

public record MemberJoinReqDto(
        @NotBlank @Pattern(regexp="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        @Schema(description="사용자 이메일", example="test@example.com") String email,
        @NotBlank @Size(min=8) @Schema(description="사용자 비밀번호", example="password1234") String password,
        @NotBlank @Size(min=2,max=15) @Schema(description="사용자 이름", example="김철수") String name
) {}
