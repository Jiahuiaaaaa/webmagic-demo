package com.test.demo;

import com.test.demo.task.JobProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    JobProcessor jobProcessor;

    @Test
    void contextLoads() {
        jobProcessor.process();
    }

}
