package com.example.eslearning.controller;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/7/18 0018 11:43
 */
@RestController
public class EsController {

    @Autowired
    private TransportClient transportClient;

    @GetMapping("get/book/novel")
    public Object get(@RequestParam String id){

        GetResponse getResponse = transportClient.prepareGet("book", "novel", id).get();

        Map<String, Object> source = getResponse.getSource();

        return source;
    }

}
