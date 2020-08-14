package com.springboot.integrate.elasticjob.config;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 声明一个 zookeeper 配置类
@Configuration
public class ElasticRegCenterConfig {
    /**
     * 配置 zookeeper 注册中心
     */

    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter regCenter(
            @Value("${elasticJob.zookeeper.serverlist}") final String serverlist,
            @Value("${elasticJob.zookeeper.namespace}") final String namespace ){
        return new ZookeeperRegistryCenter(new ZookeeperConfiguration(serverlist, namespace));
    }

}
