package com.springboot.integrate.elasticjob.config;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.springboot.integrate.elasticjob.job.SimpleJobDemo;
import com.springboot.integrate.elasticjob.listener.MyElasticJobListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticJobConfig {

    @Autowired
    private ZookeeperRegistryCenter registryCenter;

    /**
     * 注册监听器
     */
    @Bean
    public MyElasticJobListener regElasticJob(){
        return new MyElasticJobListener();
    }


    /*
    * liteJobConfiguration 核心配置
    * */
    public LiteJobConfiguration getliteJobConfiguration(
            final Class<? extends SimpleJob> jobClass,
            final String cron,
            final int shardingTotalCount,
            final String shardingItemParameters){
        return LiteJobConfiguration.newBuilder(new SimpleJobConfiguration(
           JobCoreConfiguration.newBuilder(jobClass.getName(), cron, shardingTotalCount)
                   .shardingItemParameters(shardingItemParameters)
                   .build(),jobClass.getCanonicalName()
        )).build();
    }

    @Bean(initMethod = "init")
    public JobScheduler simpleJobScheduler(
            final SimpleJobDemo simpleJobDemo,
            @Value("${elasticJob.cron}") final String cron,
            @Value("${elasticJob.shardingTotalCount}") final  int shardingTotalCount,
            @Value("${elasticJob.shardingItemParameters}") final String shardingItemParameters){
        MyElasticJobListener myElasticJobListener = new MyElasticJobListener();
        SpringJobScheduler springJobScheduler = new SpringJobScheduler(simpleJobDemo, registryCenter,
                getliteJobConfiguration(simpleJobDemo.getClass(), cron, shardingTotalCount, shardingItemParameters) ,myElasticJobListener );
        return springJobScheduler;
    }


}
