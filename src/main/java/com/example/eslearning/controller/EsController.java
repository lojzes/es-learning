package com.example.eslearning.controller;

import com.example.eslearning.model.Novel;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
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
        if(!getResponse.isExists()){
            Map<String, Object> map = new HashMap<>();
            map.put("code",404);
            map.put("msg","未找到数据");
            return map;
        }
        Map<String, Object> source = getResponse.getSource();
        return source;
    }

    @PostMapping("add/book/novel")
    public Object add(@RequestBody Novel novel){
        try {
            XContentBuilder xContentBuilder = XContentFactory.jsonBuilder();
            xContentBuilder.startObject()
                    .field("title", novel.getTitle())
                    .field("author", novel.getAuthor())
                    .field("word_count", novel.getWordCount())
                    .field("publish_date", novel.getPublishDate())
                    .endObject();

            IndexResponse indexResponse = transportClient.prepareIndex("book", "novel")
                    .setSource(xContentBuilder)
                    .get();

            HashMap<String, Object> map = new HashMap<>();

            map.put("code",200);
            map.put("msg",indexResponse.getId());

            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("del/book/novel")
    public Object del(@RequestParam String id){
        DeleteResponse deleteResponse = transportClient
                .prepareDelete("book", "novel", id).get();
        return deleteResponse.toString();
    }

}
