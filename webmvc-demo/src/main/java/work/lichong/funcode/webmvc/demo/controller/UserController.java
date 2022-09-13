/*
 * Copyright (c) 2022. 李冲. All rights reserved.
 */

package work.lichong.funcode.webmvc.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.lichong.funcode.webmvc.demo.common.bean.ApiResponse;
import work.lichong.funcode.webmvc.demo.common.enumeration.ResponseStatus;
import work.lichong.funcode.webmvc.demo.model.User;

/**
 * @author lichong
 * @see <a href="https://lichong.work">李冲博客</a>
 * @since 0.0.1
 */
@Slf4j
@Tag(name = "人员操作")
@RestController
@RequestMapping("/api")
public class UserController {

    @Operation(summary = "测试")
    @GetMapping("/test")
    public ApiResponse<User> test() {
        User user = User.builder().name("张三").age(18).build();
        log.info("result={}", user);
        return new ApiResponse<>(ResponseStatus.RESPONSE_2XX_OK, user);
    }
}
