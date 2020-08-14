package com.springboot.integrate.elasticjob.listener;

import ch.qos.logback.core.util.TimeUtil;
import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyElasticJobListener implements ElasticJobListener {
    private long beginTime;
    private long endTime;

    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        beginTime = System.currentTimeMillis();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        System.out.println(String.format("===>{} JOB BEGIN TIME: {} <===",shardingContexts.getJobName(),sd.format(beginTime)));
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        endTime = System.currentTimeMillis();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        System.out.println(String.format("===>{} JOB END TIME: {} <===",shardingContexts.getJobName(),sd.format(endTime)));

    }
}
