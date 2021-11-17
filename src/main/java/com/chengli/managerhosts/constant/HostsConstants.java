package com.chengli.managerhosts.constant;

import java.io.File;

/**
 * @author ChengLi
 * @date 2021/11/12 13:07
 */
public interface HostsConstants {
    /**
     * 当前用户目录
     * <p>
     * 例如：C:\Users\ChengLi
     */
    String DATA_STORE_DIR = System.getProperty("user.home");

    /**
     * 数据文件名称
     */
    String DATA_FILE_NAME = "hosts.db";

    /**
     * 数据文件路径
     */
    String DATA_FILE_PATH = DATA_STORE_DIR + File.separator + DATA_FILE_NAME;
}
