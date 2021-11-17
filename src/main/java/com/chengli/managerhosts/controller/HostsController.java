package com.chengli.managerhosts.controller;

import com.chengli.managerhosts.common.ResultRsp;
import com.chengli.managerhosts.core.command.AppendRowHostsCommand;
import com.chengli.managerhosts.core.command.CatHostsCommand;
import com.chengli.managerhosts.core.command.DeleteByContentHostsCommand;
import com.chengli.managerhosts.core.command.DeleteByLineHostsCommand;
import com.chengli.managerhosts.core.connect.ConnectRepository;
import com.chengli.managerhosts.core.domain.HostInfo;
import com.chengli.managerhosts.core.exec.Executor;
import com.chengli.managerhosts.data.DataHolder;
import com.jcraft.jsch.Session;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * hosts 相关接口
 *
 * @author ChengLi
 * @date 2021/11/12 13:00
 */
@RestController
@RequestMapping(value = "/hosts")
@Slf4j
public class HostsController {
    @Autowired
    private ConnectRepository connectRepository;
    @Autowired
    private Executor executor;

    @GetMapping(value = "/list")
    public Map<String, Object> listHosts() {
        List<String> keys = DataHolder.getKes();
        if (CollectionUtils.isEmpty(keys)) {
            log.warn("当前没有配置任何服务器信息.......");
            return new HashMap<>();
        }
        Map<String, Object> map = new HashMap<>();
        keys.forEach(r -> {
            Session session = connectRepository.getSession(DataHolder.getHostInfo(r));
            String res = executor.exec(session, new CatHostsCommand());
            map.put(r, res);
            connectRepository.closeSession(session);
            System.out.println(res);
        });
        return map;
    }

    @GetMapping(value = "/get")
    public String getHost(@RequestParam String key) {
        HostInfo hostInfo = DataHolder.getHostInfo(key);
        if (hostInfo == null) {
            return "";
        }
        Session session = null;
        try {
            session = connectRepository.getSession(hostInfo);
            String res = executor.exec(session, new CatHostsCommand());
            return res;
        } catch (Throwable e) {
            log.error("查询失败", e);
        } finally {
            connectRepository.closeSession(session);
        }
        return "";
    }

    @PostMapping(value = "/add")
    public ResultRsp<?> add(@RequestParam String content, @RequestParam String key) {
        HostInfo hostInfo = DataHolder.getHostInfo(key);
        if (hostInfo == null) {
            return ResultRsp.fail("Key：" + key + " 没有对应的 Host 信息");
        }
        Session session = null;
        try {
            session = connectRepository.getSession(hostInfo);
            executor.exec(session, new AppendRowHostsCommand(), content);
        } catch (Throwable e) {
            log.error("操作失败", e);
            return ResultRsp.fail("操作失败");
        } finally {
            connectRepository.closeSession(session);
        }
        return ResultRsp.ok();
    }

    @PostMapping(value = "/deleteByLine")
    public ResultRsp<?> deleteByLine(@RequestParam Integer line, @RequestParam String key) {
        HostInfo hostInfo = DataHolder.getHostInfo(key);
        if (hostInfo == null) {
            return ResultRsp.fail("Key：" + key + " 没有对应的 Host 信息");
        }
        Session session = null;
        try {
            session = connectRepository.getSession(hostInfo);
            executor.exec(session, new DeleteByLineHostsCommand(), String.valueOf(line));
        } catch (Throwable e) {
            log.error("操作失败", e);
            return ResultRsp.fail("操作失败");
        } finally {
            connectRepository.closeSession(session);
        }
        return ResultRsp.ok();
    }

    @PostMapping(value = "/deleteByContent")
    public ResultRsp<?> deleteByContent(@RequestParam String content, @RequestParam String key) {
        HostInfo hostInfo = DataHolder.getHostInfo(key);
        if (hostInfo == null) {
            return ResultRsp.fail("Key：" + key + " 没有对应的 Host 信息");
        }
        Session session = null;
        try {
            session = connectRepository.getSession(hostInfo);
            executor.exec(session, new DeleteByContentHostsCommand(), content);
        } catch (Throwable e) {
            log.error("操作失败", e);
            return ResultRsp.fail("操作失败");
        } finally {
            connectRepository.closeSession(session);
        }
        return ResultRsp.ok();
    }
}
