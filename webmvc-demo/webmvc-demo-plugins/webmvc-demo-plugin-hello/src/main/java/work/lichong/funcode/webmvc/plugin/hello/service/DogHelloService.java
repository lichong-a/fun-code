/*
 * Copyright 2022 李冲. All rights reserved.
 *
 */

package work.lichong.funcode.webmvc.plugin.hello.service;

import org.springframework.stereotype.Service;
import work.lichong.funcode.webmvc.plugin.api.IHello;

/**
 * @author 李冲
 * @see <a href="https://lichong.work">李冲博客</a>
 * @since 0.0.1
 */
@Service
public class DogHelloService implements IHello {
    @Override
    public String sayHello() {
        return "汪！！！";
    }
}
