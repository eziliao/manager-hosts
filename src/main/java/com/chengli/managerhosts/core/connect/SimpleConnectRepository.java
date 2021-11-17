package com.chengli.managerhosts.core.connect;

import cn.hutool.extra.ssh.JschUtil;
import com.chengli.managerhosts.core.domain.HostInfo;
import com.jcraft.jsch.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author ChengLi
 * @date 2021/11/12 13:53
 */
@Component
@Slf4j
public class SimpleConnectRepository implements ConnectRepository {
    /**
     * 获取服务器连接session
     *
     * @param hostInfo
     * @return
     */
    @Override
    public Session getSession(HostInfo hostInfo) {
        return JschUtil.openSession(hostInfo.getHost(), hostInfo.getPort(), hostInfo.getUser(), hostInfo.getPassword());
    }

    /**
     * 关闭session
     *
     * @param session
     */
    @Override
    public void closeSession(Session session) {
        if (session != null) {
            try {
                session.disconnect();
                log.info("===============Session 关闭=================");
            } catch (Throwable e) {
                log.warn("关闭Session错误", e);
            }
        }
    }
}
