/*
 * Copyright 2022 李冲. All rights reserved.
 *
 */

package work.lichong.funcode.webmvc.demo.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import work.lichong.funcode.webmvc.demo.exception.LoadJarsException;
import work.lichong.funcode.webmvc.demo.util.LoadJarsUtil;

import javax.annotation.PostConstruct;

/**
 * @author 李冲
 * @see <a href="https://lichong.work">李冲博客</a>
 * @since 0.0.1
 */
@Component
@Slf4j
public class LoadLibJarsInitTask {

    @PostConstruct
    public void init() {
        try {
            LoadJarsUtil.loadJarsFromAppFolder();
        } catch (LoadJarsException e) {
            log.error("加载外部依赖失败，{}", e.getMessage());
        }
    }

}
