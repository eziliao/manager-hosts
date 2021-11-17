package com.chengli.managerhosts.core.connect;

import com.chengli.managerhosts.core.domain.HostInfo;
import com.jcraft.jsch.Session;

/**
 * @author ChengLi
 * @date 2021/11/12 13:52
 */
public interface ConnectRepository {
    /**
     * 获取服务器连接session
     *
     * @param hostInfo
     * @return
     */
    Session getSession(HostInfo hostInfo);

    /**
     * 关闭session
     *
     * @param session
     */
    void closeSession(Session session);
}
