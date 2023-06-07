package net.educoder.utils;

import net.educoder.mapper.Step1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunnerTest implements ApplicationRunner {

    @Autowired
    Step1Mapper mapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        mapper.init();
    }
}
