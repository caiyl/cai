package docker.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author chase
 * @date 2022/10/24 2:46 PM
 */

@Component
public class TaskService {



    @Scheduled(fixedRate=5000)
    public void scheduleUpdateNewsCount(){
        execute("执行任务" + new Date());
    }

    @Scheduled(fixedRate=5000)
    @SingleInstanceTask
    public void SingleInstanceTask(){
        execute("执行任务SingleInstanceTask" + new Date());
    }

    private void execute(String SERVICE_UUID_VAL) {
        System.out.println(SERVICE_UUID_VAL);
    }


}
