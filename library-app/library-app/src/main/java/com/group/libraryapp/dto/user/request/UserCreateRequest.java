package com.group.libraryapp.dto.user.request;

public class UserCreateRequest {

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    private String name;
    private Integer age; //Integer는 int와 달리 null표현 가능
}
