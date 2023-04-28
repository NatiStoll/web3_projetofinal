package com.example.web3apitest.feignClients;

import com.example.web3apitest.model.request.UserRequest;
import com.example.web3apitest.model.response.UserResponse;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@FeignClient(name = "web3-user", url = "http://localhost:8000")
public interface UserFeign {
    //adicionar contratos
    @PostMapping
    ResponseEntity<Mono<Void>> save(@Valid @RequestBody UserRequest request);

    @GetMapping(value = "/test/{id}")
    ResponseEntity<Mono<UserResponse>> findById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<Flux<UserResponse>> findAll();

    @PatchMapping(value = "/test/{id}")
    ResponseEntity<Mono<UserResponse>> update(@PathVariable String id, @RequestBody UserRequest request);

    @DeleteMapping(value = "/test/{id}")
    ResponseEntity<Mono<Void>> delete(@PathVariable String id);
}

