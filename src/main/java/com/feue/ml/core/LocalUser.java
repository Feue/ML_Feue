package com.feue.ml.core;

import com.feue.ml.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Feue
 * @create 2022-04-18 14:56
 */
public class LocalUser {
    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    public static void setUser(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        LocalUser.threadLocal.set(map);
    }

    public static User getUser() {
        return (User) threadLocal.get().get("user");
    }

    public static void clear() {
        LocalUser.threadLocal.remove();
    }
}
