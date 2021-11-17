package com.chengli.managerhosts.data;

import com.chengli.managerhosts.core.domain.HostInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author ChengLi
 * @date 2021/11/12 13:17
 */
public final class DataHolder {
    private static final HashMap<String, Object> db = new HashMap<>();

    public static HashMap<String, Object> getDb() {
        return db;
    }

    /**
     * 获取所有服务器KEY
     *
     * @return
     */
    public static List<String> getKes() {
        Set<String> setKey = db.keySet();
        return new ArrayList<>(db.keySet());
    }

    /**
     * 获取服务器信息
     *
     * @param key
     * @return
     */
    public static HostInfo getHostInfo(String key) {
        Object o = db.get(key);
        if (o instanceof HostInfo) {
            return (HostInfo) o;
        }
        return null;
    }
}
