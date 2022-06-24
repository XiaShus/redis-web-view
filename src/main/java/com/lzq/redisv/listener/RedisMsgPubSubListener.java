package com.lzq.redisv.listener;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * Redis PUB、SUB频道
 *
 * @author LZQ
 */
@Slf4j
public class RedisMsgPubSubListener extends JedisPubSub {

    @Override
    public void unsubscribe() {
        super.unsubscribe();
    }

    @Override
    public void unsubscribe(String... channels) {
        super.unsubscribe(channels);
    }

    @Override
    public void subscribe(String... channels) {
        super.subscribe(channels);
    }

    @Override
    public void psubscribe(String... patterns) {
        super.psubscribe(patterns);
    }

    @Override
    public void punsubscribe() {
        super.punsubscribe();
    }

    @Override
    public void punsubscribe(String... patterns) {
        super.punsubscribe(patterns);
    }

    @Override
    public void onMessage(String channel, String message) {
        log.info("onMessage: channel[{}], message[{}]", channel, message);
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        log.info("onPMessage: pattern[{}], channel[{}], message[{}]", pattern, channel, message);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        log.info("onSubscribe: channel[{}], subscribedChannels[{}]", channel, subscribedChannels);
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        log.info("onPUnsubscribe: pattern[{}], subscribedChannels[{}]", pattern, subscribedChannels);
    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        log.info("onPSubscribe: pattern[{}], subscribedChannels[{}]", pattern, subscribedChannels);
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        log.info("channel:{} is been subscribed:{}", channel, subscribedChannels);
    }

    public static void main(String[] args) {
        Jedis jr = null;
        try {
            // redis服务地址和端口号
            jr = new Jedis("192.168.137.130", 26379, 0);
            RedisMsgPubSubListener sp = new RedisMsgPubSubListener();
            // jr客户端配置监听 channel
            jr.subscribe(sp, "+slave", "+reboot", "-role-change", "+convert-to-slave", "+role-change");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jr != null) {
                jr.disconnect();
            }
        }
    }
}
