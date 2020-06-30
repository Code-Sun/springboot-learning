package quickstart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduleTask {

    @Autowired
    UerService uerService;

    @Scheduled(fixedDelay=3000)
    private void configureTasks() {
        uerService.visit();
    }
}
