package com.lzq.redisv.util;


import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelId;
import io.netty.handler.codec.http.HttpHeaders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.MultiValueMap;
import org.yeauty.annotation.*;
import org.yeauty.pojo.Session;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Winner
 * @version 1.0
 * @description: TODO
 * @date 2022/1/6 9:15
 */
@Slf4j
@ServerEndpoint(path = "/websocket", port = "8888")
public class WebSocketUtil {

    private Session session;
    private static ConcurrentHashMap<String, List<WebSocketUtil>> webSocketMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, String> webSocketMappingMap = new ConcurrentHashMap<>();

    /**
     * 客户端连接到 websocket 时触发
     *
     * @param session 客户的 session，其中有一个 ChannelId 用来标识不同用户
     * @param headers
     */
    @OnOpen
    public void onOpen(Session session, HttpHeaders headers, @RequestParam MultiValueMap reqMap) {
        ChannelId id = session.id();
        log.info("客户端：{} 连接到 websocket", id);
        this.session = session;
        String redisId = reqMap.get("id").toString();
        if (redisId.startsWith("[") && redisId.endsWith("]")) {
            redisId = redisId.substring(1, redisId.length() - 1);
        }

        List<WebSocketUtil> webSocketUtils = webSocketMap.get(redisId);
        if (CollectionUtil.isEmpty(webSocketUtils)) {
            webSocketUtils = new CopyOnWriteArrayList<>();
        }
        webSocketUtils.add(this);
        webSocketMap.put(redisId, webSocketUtils);
        webSocketMappingMap.put(id.toString(), redisId);

        R res = R.success(id.toString());
        String resStr = JSONObject.toJSONString(res);
        log.info("返回：{}", resStr);
        session.sendText(resStr);
    }

    /**
     * 客户端断开 websocket 时触发
     *
     * @param session
     * @throws IOException
     */
    @OnClose
    public void onClose(Session session) throws IOException {
        String id = session.id().toString();
        log.info("客户端：{} 断开 websocket", id);
        String mqType = webSocketMappingMap.get(id);
        webSocketMappingMap.remove(mqType);
        webSocketMap.get(mqType).remove(mqType);
    }

    /**
     * 客户端连接异常时触发
     *
     * @param session
     * @param throwable
     */
    @OnError
    public void onError(Session session, Throwable throwable) {
        String id = session.id().toString();
        String mqType = webSocketMappingMap.get(id);
        webSocketMappingMap.remove(mqType);
        webSocketMap.get(mqType).remove(mqType);
        log.error("客户端：{} 发生异常，", id, throwable);
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        log.info("客户端 {}：{}", session.id().toString(), message);
        session.sendText("Hello Netty!");
    }


    /**
     * 群发消息给所有用户
     *
     * @param msg
     */
    public static void sendMessage(String msg) {
        Set<Map.Entry<String, List<WebSocketUtil>>> entries = webSocketMap.entrySet();
        for (Map.Entry<String, List<WebSocketUtil>> entry : entries) {
            List<WebSocketUtil> value = entry.getValue();
            for (WebSocketUtil ws : value) {
                ws.session.sendText(msg);
            }
        }
    }

    /**
     * 单独给用户发送消息
     *
     * @param channelId
     * @param msg
     */
    public static void sendMessage(String channelId, String msg) {
        Session session = getSessionByChannelId(channelId);
        session.sendText(msg);
    }

    /**
     * 单独给用户发送消息
     *
     * @param mqId
     * @param msg
     */
    public static void sendMessageByMqType(String mqId, String msg) {
        List<WebSocketUtil> webSocketUtils = webSocketMap.get(mqId);
        if (CollectionUtil.isEmpty(webSocketUtils)) {
            return;
        }
        for (WebSocketUtil webSocketUtil : webSocketUtils) {
            webSocketUtil.session.sendText(msg);
        }
    }

    /**
     * 根据标识查询到用户
     *
     * @param channelId
     * @return
     */
    private static Session getSessionByChannelId(String channelId) {
        String mqType = webSocketMappingMap.get(channelId);
        List<WebSocketUtil> webSocketUtils = webSocketMap.get(mqType);
        if (CollectionUtil.isEmpty(webSocketUtils)) {
            return null;
        }
        for (WebSocketUtil ws : webSocketUtils) {
            if (ws.session.id().toString().equals(channelId)) {
                return ws.session;
            }
        }
        return null;
    }
}
