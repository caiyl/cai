package docker.service;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * 单实例定时任务切面
 * @author chase
 */
@Slf4j
@Aspect
@Component
public class SingleInstanceTaskAspect {


    @Autowired
    private StringRedisTemplate redisTemplate;
    private static  final String SERVICE_UUID_KEY = "SMART_LIFE_SERVICE_UUID";
    /**
     * uuid值
     */
    private static  String SERVICE_UUID_VAL ;

    @PostConstruct
    public void  init(){
        String uuid = UUID.randomUUID().toString();
        SERVICE_UUID_VAL = uuid;
        redisTemplate.opsForValue().set(SERVICE_UUID_KEY,SERVICE_UUID_VAL);
    }

    @Pointcut("@annotation(org.springframework.scheduling.annotation.Scheduled)")
//    @Pointcut("@annotation(docker.service.SingleInstanceTask)")
    public void pointCut(){}

    @Around("pointCut()")
    public void pointCut(ProceedingJoinPoint joinPoint){
        if (tryAcquire()) {
            try {
                joinPoint.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
                // TODO: 2022/10/24 异常日志记录
            }
        }
    }

    boolean tryAcquire(){
        String serviceUuid = redisTemplate.opsForValue().get(SERVICE_UUID_KEY);
        return serviceUuid != null && serviceUuid.equals(SERVICE_UUID_VAL);
    }


}
