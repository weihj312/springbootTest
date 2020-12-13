package com.qf;

import com.qf.config.SimplePublisher;
import com.qf.fanout.FanoutPublisher;
import com.qf.router.RouterPublisher;
import com.qf.topic.TopicPublisher;
import com.qf.work.WorkPublisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot08ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private SimplePublisher simplePublisher;

    @Test
    public void testSiPu() {
        simplePublisher.send();
    }

    @Autowired
    private WorkPublisher workPublisher;

    @Test
    public void testWork() {
        for (int i = 0; i < 7; i++) {
            workPublisher.send();
        }
    }

    @Autowired
    private FanoutPublisher fanoutPublisher;

    @Test
    public void testFanout() {
        fanoutPublisher.send();
    }

    @Autowired
    private RouterPublisher routerPublisher;

    @Test
    public void testRouterPublisher() {
        routerPublisher.send();
    }

    @Autowired
    private TopicPublisher topicPublisher;

    @Test
    public void testTopicPublisher() {
        topicPublisher.send();
    }
}
