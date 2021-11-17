package com.chengli.managerhosts.core.exec;

import cn.hutool.extra.ssh.JschUtil;
import com.chengli.managerhosts.core.command.Command;
import com.jcraft.jsch.Session;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author ChengLi
 * @date 2021/11/12 13:42
 */
@Component
public class SimpleExecutor implements Executor {

    /**
     * 执行
     *
     * @param session
     * @param command
     * @param options
     * @return
     */
    @Override
    public String exec(Session session, Command command, String... options) {
        return JschUtil.exec(session, command.build(options), StandardCharsets.UTF_8);
    }
}
