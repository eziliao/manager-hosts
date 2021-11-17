package com.chengli.managerhosts.init;

import com.chengli.managerhosts.constant.HostsConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 初始化上下文环境
 *
 * @author ChengLi
 * @date 2021/11/12 13:05
 */
@Order(1)
@Component
@Slf4j
public class InitContext implements ApplicationRunner {
    /**
     * Callback used to run the bean.
     *
     * @param args incoming application arguments
     * @throws Exception on error
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        String dbFilePath = HostsConstants.DATA_FILE_PATH;
        log.info("启动初始化数据文件：{} .....", dbFilePath);

        Path path = FileSystems.getDefault().getPath(dbFilePath);
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        log.info("初始化数据文件完成....");
    }
}
