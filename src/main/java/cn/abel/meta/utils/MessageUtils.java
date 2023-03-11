package cn.abel.meta.utils;

import cn.abel.meta.vo.ChatParam;
import cn.hutool.core.util.StrUtil;

import java.util.concurrent.ConcurrentHashMap;

public class MessageUtils {
    /**
     * 用于存历史消息
     */
    public static final ConcurrentHashMap<String, ChatParam> CHAT_MAP = new ConcurrentHashMap<>(8);


    public static void saveMsg(String id, ChatParam chatParam) {
        CHAT_MAP.put(id, chatParam);
    }

    public static ChatParam getMsg(String id) {
        if (StrUtil.isEmpty(id)) {
            return null;
        }
        return CHAT_MAP.get(id);
    }
}
