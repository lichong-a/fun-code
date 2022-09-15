/*
 * Copyright 2022 李冲. All rights reserved.
 *
 */

package work.lichong.funcode.webmvc.demo.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 李冲
 * @see <a href="https://lichong.work">李冲博客</a>
 * @since 0.0.1
 */
@Component
public class CodeConst {

    public static String CODE_LIB_DIR;

    @Value("${code.lib.dir}")
    public void setAppid(String codeLibDir) {
        this.CODE_LIB_DIR = codeLibDir;
    }
}
