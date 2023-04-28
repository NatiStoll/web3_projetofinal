package com.example.web3apitest.service;

import com.example.web3apitest.controller.TestController;
import com.example.web3apitest.feignClients.UserFeign;
import com.example.web3apitest.model.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class TestControlerService {

    //será que é controller ou service

    private final UserFeign userFeign;

    @GetMapping("/{idPlayer}")
    public ResponseEntity<Mono<TestController>> getPlayerTest(@PathVariable Long idPlayer, @RequestBody TestController test){

        Mono<UserResponse> userMono = userFeign.findById(idPlayer).getBody();

        return ResponseEntity.ok().body(
                userMono.flatMap(userResponse -> Mono.just(
                        new TestController(userResponse.name(),
                                test.getTestForHand(),
                                test.getTestBackHand(),
                                (test.getTestForHand() + test.getTestBackHand())/2,
                                test.getStatus())
                ))
        );
    }
}
