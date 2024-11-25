package com.example.demo.service;

import com.example.demo.Dto.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
//    @GetMapping("/hello")
    // 임시 데이터로 구현 (실제로는 DB에서 가져와야 함)
    public User getUserById(String userId) {
        User user = new User();
        user.setUserId(userId);
        user.setUsername("username");
        user.setEmail("test@example.com");
        user.setAge(25);
        user.setPhone("010-1234-5678");
        return user;
    }
    
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        // 테스트용 데이터
        User user1 = new User();
        user1.setUserId("1");
        user1.setUsername("user1");
        user1.setEmail("user1@example.com");
        users.add(user1);

        User user2 = new User();
        user2.setUserId("2");
        user2.setUsername("user2");
        user2.setEmail("user2@example.com");
        users.add(user2);
        
        return users;
    }
}