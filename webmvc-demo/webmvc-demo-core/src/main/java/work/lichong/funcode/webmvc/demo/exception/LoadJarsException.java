/*
 * Copyright 2022 李冲. All rights reserved.
 *
 */

package work.lichong.funcode.webmvc.demo.exception;

/**
 * 加载外部jar异常
 *
 * @author 李冲
 * @see <a href="https://lichong.work">李冲博客</a>
 * @since 0.0.1
 */
public class LoadJarsException  extends Exception {

    public LoadJarsException(String message) {
        super(message);
    }

    public LoadJarsException(String message, Throwable cause) {
        super(message, cause);
    }
}
