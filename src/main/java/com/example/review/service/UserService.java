package com.example.review.service;


import com.example.review.domain.User;
import com.example.review.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository; // 중복 체크를하려면 db를 봐야함


    public String join(String userName, String password) {

        // userName 중복 체크 하기
        userRepository.findByUserName(userName) // db에서 userName 찾기
                .ifPresent(user -> { // 만약 이미 있다면
                    throw new RuntimeException("userName + 는 이미 있습니다.");
                });

        // 중복 체크를 한 후 저장
        User user = User.builder()
                .userName(userName)
                .password(password)
                .build();
        userRepository.save(user);

        return "SUCCESS";
    }
}
