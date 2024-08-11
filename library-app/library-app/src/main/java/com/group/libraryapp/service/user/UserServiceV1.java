package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//유저 존재여부 확인 후 예외처리
@Service
public class UserServiceV1 {

    private final UserJdbcRepository userJdbcRepository;
    public UserServiceV1(UserJdbcRepository userJdbcRepository) {
        this.userJdbcRepository = userJdbcRepository;
    }

    public void saveUser(UserCreateRequest request) {
        userJdbcRepository.saveUser(request.getName(), request.getAge());
    }

    public List<UserResponse> getUsers() {
        return userJdbcRepository.getUsers();
    }

    public void updateUser(UserUpdateRequest request) {
        //Controller와 달리 controller가 변환한 객체를 그대로 받으므로 @Request 관련 어노테이션 없음
        //boolean isUserNotExist = userRepository.isUserNotExist(jdbcTemplate, request.getId());
        if (userJdbcRepository.isUserNotExist(request.getId())) {
            throw new IllegalArgumentException();
        }
        //String sql = "UPDATE user SET name = ? WHERE id = ?";
        //jdbcTemplate.update(sql, request.getName(), request.getId());
        userJdbcRepository.updateUserName(request.getName(), request.getId());
    }

    public void deleteUser(String name){
        if (userJdbcRepository.isUserNotExist(name)) {
            throw new IllegalArgumentException();
        }
    }
}
