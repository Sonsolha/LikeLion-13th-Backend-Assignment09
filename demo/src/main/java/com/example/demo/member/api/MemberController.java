package com.example.demo.member.api;

import com.example.demo.global.ApiResTemplate;
import com.example.demo.member.api.dto.request.*; import com.example.demo.member.api.dto.response.MemberInfoResDto;
import com.example.demo.member.application.MemberService;
import io.swagger.v3.oas.annotations.Operation; import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid; import lombok.RequiredArgsConstructor; import org.springframework.web.bind.annotation.*;

@RestController @RequiredArgsConstructor @RequestMapping("/member")
@Tag(name="멤버 API", description="멤버 관리하는 api ")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/join")
    @Operation(summary="멤버 회원가입", description="멤버 회원가입 설명란입니다.")
    public ApiResTemplate<String> join(@RequestBody @Valid MemberJoinReqDto dto){
        memberService.join(dto);
        return ApiResTemplate.createdNoContent("회원가입에 성공하였습니다.");
    }

    @PostMapping("/login")
    @Operation(summary="멤버 로그인", description="멤버 로그인 설명란입니다.")
    public ApiResTemplate<MemberInfoResDto> login(@RequestBody @Valid MemberLoginReqDto dto){
        var res = memberService.login(dto);
        return ApiResTemplate.created("로그인에 성공하였습니다.", res);
    }
}
