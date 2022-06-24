package com.lzq.redisv.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/** ThreadPoolTaskExecutor 相对来说比较适用于定时任务
 * 如果是主线程中使用线程池还请使用ThreadPoolExecutor来自定义想使用的线程池参数
 * 在使用完ThreadPoolExecutor线程池对象后记得销毁线程shutdown()（针对于局部变量）
*/
@Configuration
@ConditionalOnProperty(prefix="executor",name = "use", havingValue = "true")
@Slf4j
public class ExecutorConfig {

    private static int poolsize = 0;
    /** 这个是最初始的设置值 通过获取电脑的cpu的核心数来设置
    * @Description:
    * @Param:
    * @return:
    * @Author: xuxy
    * @Date: 2020/1/7
    */
    static {
        //通过RunTime获取获取当前主机的线程数
        int x = Runtime.getRuntime().availableProcessors();
        log.info("当前主机线程数个数为："+x);
        poolsize = x;
    }

    /**
     * IO密集型任务，设置最大线程数为核心线程数的两倍
     * @return
     */
    @Bean
    public Executor executor5() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("-线程池-");
        //最大线程
        executor.setMaxPoolSize(poolsize*2);
        //核心线程
        executor.setCorePoolSize(poolsize);
        //线程池队列
        executor.setQueueCapacity(11);
        //设置存活时间
        executor.setKeepAliveSeconds(20);
        //线程池拒绝方案
        // CallerRunsPolicy
        // 当调用被线程池限制的方法的线程数量大于此线程池的最大线程池,
        // 该拒绝方案不会丢弃掉线程，
        // 而是将线程任务添加到调用者线程中执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }




}
