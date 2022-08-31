/*
 * Copyright (c) 2022. 李冲. All rights reserved.
 */

package work.lichong.webmvc.demo.controller.advice;

import work.lichong.webmvc.demo.common.bean.ApiResponse;
import work.lichong.webmvc.demo.common.enumeration.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author 李冲
 * @see <a href="https://lichong.work">李冲博客</a>
 * @since 0.0.1
 */
@Slf4j
@ControllerAdvice
@EnableWebMvc
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    ApiResponse<Object> globalException(Exception e) {
        log.warn(e.getMessage());
        return new ApiResponse<>(ResponseStatus.RESPONSE_5XX_INTERNAL_SERVER_ERROR, e.getMessage());
    }

}
