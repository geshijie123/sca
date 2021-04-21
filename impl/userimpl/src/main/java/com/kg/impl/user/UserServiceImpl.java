package com.kg.impl.user;

import com.kg.user.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceImpl  implements UserService {
    @Override
    public String getUser() {
        return "2333";
    }
}
