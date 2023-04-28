package com.example.web3apitest.model.response;


public record UserResponse(
        String id,
        String name,
        String email,
        String password
) { }
