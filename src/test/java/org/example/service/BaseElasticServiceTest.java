package org.example.service;

import org.example.model.ElasticEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.SchemaOutputResolver;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BaseElasticServiceTest {

    @Autowired
    BaseElasticService baseElasticService;

    @Test
    void createIndex() throws Exception {
        String index = "haha";
        System.out.println("gggggg");
        ElasticEntity entity = new ElasticEntity();
        entity.setId("hei");
        entity.setData("{\"hello\":\"world\"}");
        baseElasticService.insertOrUpdateOne(index, entity);

        boolean b = baseElasticService.indexExist(index);
//        baseElasticService.deleteIndex(index);
        b = baseElasticService.indexExist(index);
        System.out.println(b);
    }

    @Test
    void search() {

    }

    @Test
    void deleteIndex() {
    }

    @Test
    void deleteByQuery() {
    }
}