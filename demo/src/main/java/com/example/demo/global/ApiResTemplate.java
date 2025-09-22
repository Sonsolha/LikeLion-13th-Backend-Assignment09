package com.example.demo.global;
import lombok.AllArgsConstructor; import lombok.Getter;
@Getter @AllArgsConstructor
public class ApiResTemplate<T> {
    private int code; private String message; private T data;
    public static <T> ApiResTemplate<T> created(String msg, T data){ return new ApiResTemplate<>(201, msg, data); }
    public static ApiResTemplate<String> createdNoContent(String msg){ return new ApiResTemplate<>(201, msg, null); }
}