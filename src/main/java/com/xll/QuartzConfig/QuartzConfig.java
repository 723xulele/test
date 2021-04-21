package com.xll.QuartzConfig;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.quartz.CronScheduleBuilder.cronSchedule;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author : XuLeLe
 * @Date : 2021/03/18/21:47
 * @Description:
 */
@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail davpMailSchedule() {
        JobDetail davpMailJob = JobBuilder.newJob(TestConfig001.class).withIdentity("doTest").storeDurably().build();
        return davpMailJob;
    }

    @Bean
    public Trigger davpMailTrigger() {
        Trigger trigger = TriggerBuilder.newTrigger().forJob(davpMailSchedule()).withIdentity("doTest")
                .withSchedule(cronSchedule("0/5 * * * * ? ")).build();
        return trigger;
    }
}
