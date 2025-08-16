package com.example.demo.services.serviceImpl;

import com.example.demo.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<String> getUsers() {
        List<String> list = new ArrayList<>();
        list.add("Niro");
        list.add("Botu");
        list.add("Meow");

        return list;
    }
}
