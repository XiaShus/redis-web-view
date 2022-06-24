package com.lzq.redisv.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component

public class GlobalAnnotationDrivenListener {

    @Value("${server.port}")
    private String port;

    @EventListener
    public void handleApplicationStarted(ApplicationReadyEvent ase) {
        System.out.println(
                "  \t へ　　　　 ／|\n" +
                        "　　/ /　    ∠＿/\n" +
                        "　 /　│　　 ／　／    \n" +
                        "　│　Z ＿,＜　／　　 /`_\n" +
                        "　│　　　　　ヽ　　 /　  〉\n" +
                        "　 Y　　　　　`　 /　　/\n" +
                        "　ｲ●　､　●　　⊂⊃〈　　/\n" +
                        "　()　 へ　　　　|　＼〈\n" +
                        "　　>ｰ ､_　 ィ　 │ ／／\n" +
                        "　 / へ　　 /　ﾉ＜| ＼＼\n" +
                        "　 ヽ_ﾉ　　(_／　 │／／\n" +
                        "　　7　　　　　　　|／\n" +
                        "　　＞―r￣￣`ｰ―＿ ノ\n" +
                        "\n" +
                        "报告：皮卡丘没有发现任何问题！");
        System.out.println("----------------------------------------------------------\n\t" +
                "Application  is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port  + "/\n\t" +
                "swagger-doc: \t\thttp://localhost:" + port  + "/doc.html\n\t" +
                "druid: \t\thttp://localhost:" + port  + "/druid\n" +
                "----------------------------------------------------------");
    }
}
