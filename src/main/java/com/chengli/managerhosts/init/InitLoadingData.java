package com.chengli.managerhosts.init;

import com.alibaba.fastjson.JSON;
import com.chengli.managerhosts.constant.HostsConstants;
import com.chengli.managerhosts.data.DataHolder;
import com.chengli.managerhosts.core.domain.HostInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * 初始加载配置
 *
 * @author ChengLi
 * @date 2021/11/12 12:58
 */
@Order(2)
@Component
@Slf4j
public class InitLoadingData implements ApplicationRunner {
    /**
     * Callback used to run the bean.
     *
     * @param args incoming application arguments
     * @throws Exception on error
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Path filePath = FileSystems.getDefault().getPath(HostsConstants.DATA_FILE_PATH);
        byte[] dbBytes = Files.readAllBytes(filePath);
        String dataJSON = new String(dbBytes, StandardCharsets.UTF_8);
        log.info("加载数据文件内容，文件大小：{}，文件内容：{}", dbBytes.length, dataJSON);
        List<HostInfo> hostInfos = JSON.parseArray(dataJSON, HostInfo.class);
        if (hostInfos != null) {
            hostInfos.forEach(r -> {
                DataHolder.getDb().put(r.getHost(), r);
            });
        }
        log.info("数据文件初始化完成，Host数量：{}", CollectionUtils.size(hostInfos));
    }
}
