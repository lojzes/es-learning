package com.example.eslearning.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/7/18 0018 11:58
 */

@Configuration
public class SysConfig {

    @Bean
    public TransportClient clients(){
        InetSocketTransportAddress inetSocketTransportAddress = null;
        try {
            inetSocketTransportAddress = new InetSocketTransportAddress(
                      InetAddress.getByName("localhost"),9300
            );
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        Settings settings = Settings.builder()
                .put("cluster.name","lojzes-elasticsearch")
                .build();

        TransportClient transportClient = new PreBuiltTransportClient(settings);
        transportClient.addTransportAddress(inetSocketTransportAddress);

        return transportClient;
    }
}
