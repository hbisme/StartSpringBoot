package com.hb.start_boot.service;

import com.hb.start_boot.entity.User;

import java.util.List;

public interface UserService {
    User getUserByName(String name);

    User getUser(Long id);

    User getUserByIdAndName(Long id, String name);

    Integer insertUser(User user);

    User getUser();

}
