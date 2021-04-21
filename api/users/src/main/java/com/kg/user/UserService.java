package com.kg.user;

import org.springframework.web.bind.annotation.RequestMapping;

public interface UserService {
    @RequestMapping("getUser")
    String getUser();
}
