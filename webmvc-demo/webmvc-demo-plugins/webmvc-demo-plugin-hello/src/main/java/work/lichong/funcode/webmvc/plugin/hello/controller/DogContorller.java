/*
 * Copyright 2022 李冲. All rights reserved.
 *
 */

package work.lichong.funcode.webmvc.plugin.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.lichong.funcode.webmvc.plugin.hello.service.DogHelloService;

/**
 * @author 李冲
 * @see <a href="https://lichong.work">李冲博客</a>
 * @since 0.0.1
 */
@RestController
@RequestMapping("/api/plugin/hello")
public class DogContorller {

    @Autowired
    DogHelloService dogHelloService;

    @GetMapping("/dog")
    public String sayHello() {
        return dogHelloService.sayHello();
    }
}
