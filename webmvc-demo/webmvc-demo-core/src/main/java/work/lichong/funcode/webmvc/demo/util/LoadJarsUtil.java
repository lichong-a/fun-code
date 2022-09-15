/*
 * Copyright 2022 李冲. All rights reserved.
 *
 */

package work.lichong.funcode.webmvc.demo.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import work.lichong.funcode.webmvc.demo.constant.CodeConst;
import work.lichong.funcode.webmvc.demo.exception.LoadJarsException;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Objects;

/**
 * 动态加载lib下所有jar包的方法
 *
 * @author 李冲
 * @see <a href="https://lichong.work">李冲博客</a>
 * @since 0.0.1
 */
@UtilityClass
@Slf4j
public class LoadJarsUtil {

    public static String getApplicationFolder() {
        String path = LoadJarsUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        return new File(path).getParent();
    }

    public static void loadJarsFromAppFolder() throws LoadJarsException {
        File f = new File(CodeConst.CODE_LIB_DIR);
        if (f.isDirectory()) {
            for (File subf : Objects.requireNonNull(f.listFiles())) {
                if (subf.isFile()) {
                    loadJarFile(subf);
                }
            }
        } else {
            loadJarFile(f);
        }
    }

    public static void loadJarFile(File path) throws LoadJarsException {
        URL url;
        try {
            url = path.toURI().toURL();
            log.info("加载第三方jar：{}", url);
            // 可以获取到AppClassLoader，可以提到前面，不用每次都获取一次
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            // 加载
            if (classLoader instanceof URLClassLoader) {
                URLClassLoader sysloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
                Class<?> sysclass = URLClassLoader.class;
                Method method = sysclass.getDeclaredMethod("addURL", URL.class);
                method.setAccessible(true);
                method.invoke(sysloader, url);
            } else {
                Field field = classLoader.getClass().getDeclaredField("ucp");
                field.setAccessible(true);
                Object ucp = field.get(classLoader);
                Method method = ucp.getClass().getDeclaredMethod("addURL", URL.class);
                method.setAccessible(true);
                method.invoke(ucp, url);
            }
        } catch (MalformedURLException e) {
            throw new LoadJarsException("URL转换时异常", e);
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | NoSuchFieldException e) {
            throw new LoadJarsException("反射异常", e);
        }
    }
}
