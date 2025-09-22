package com.example.demo.member.application;

import com.example.demo.member.api.dto.request.*; import com.example.demo.member.api.dto.response.MemberInfoResDto;
import org.springframework.stereotype.Service; import java.util.*; import java.util.concurrent.ConcurrentHashMap;

@Service
public class MemberService {
    private final Map<String, User> store = new ConcurrentHashMap<>();
    public void join(MemberJoinReqDto dto){ store.put(dto.email(), new User(dto.email(), dto.password(), dto.name())); }
    public MemberInfoResDto login(MemberLoginReqDto dto){
        var u = store.get(dto.email());
        if (u==null || !u.password.equals(dto.password())) throw new IllegalArgumentException("이메일/비밀번호 불일치");
        String token = "dummy." + UUID.randomUUID(); // 더미 토큰(Authorize에 붙일 값)
        return new MemberInfoResDto(u.email, u.name, token);
    }
    private record User(String email, String password, String name){}
}
