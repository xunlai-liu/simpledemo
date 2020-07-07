package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.example.exception.Result;
import org.example.exception.ResultEnum;
import org.example.model.ElasticEntity;
import org.example.model.ElasticEntityVo;
import org.example.model.QueryVo;
import org.example.service.BaseElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 */


@Slf4j
@RestController
@RequestMapping("elasticSearch")
public class ElasticSearchController {

    @Autowired
    BaseElasticService baseElasticService;


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(@RequestBody ElasticEntityVo elasticDataVo){
        Result response = new Result();
        try {
            if(StringUtils.isEmpty(elasticDataVo.getIdxName())){
                response.setCode(ResultEnum.NO_ELASTIC_INDEX.getCode());
                response.setMessage("索引为空，不允许提交");
                log.warn("索引为空");
                return response;
            }
            ElasticEntity elasticEntity = new ElasticEntity();
            elasticEntity.setId(elasticDataVo.getElasticEntity().getId());
            elasticEntity.setData(elasticDataVo.getElasticEntity().getData());

            baseElasticService.insertOrUpdateOne(elasticDataVo.getIdxName(), elasticEntity);

        } catch (Exception e) {
            response.setCode(ResultEnum.SERVER_ERROR.getCode());
            response.setMessage("服务忙，请稍后再试");
            log.error("插入数据异常，metadataVo={},异常信息={}", elasticDataVo.toString(),e.getMessage());
        }
        return response;
    }


    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public Result get(@RequestBody QueryVo queryVo){

        Result response = new Result();

        if(StringUtils.isEmpty(queryVo.getIdxName())){
            response.setCode(ResultEnum.NO_ELASTIC_INDEX.getCode());
            response.setMessage("索引为空，不允许提交");
            log.warn("索引为空");
            return response;
        }

        try {
            Map<String,Object> params = queryVo.getQuery().get("match");
            Set<String> keys = params.keySet();
            MatchQueryBuilder queryBuilders=null;
            for(String ke:keys){
                queryBuilders = QueryBuilders.matchQuery(ke, params.get(ke));
            }
            if(null!=queryBuilders){
                SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
                searchSourceBuilder.query(queryBuilders);//根据ID查询
                List<?> data = baseElasticService.search(queryVo.getIdxName(),searchSourceBuilder,ElasticEntity.class);
                response.setData(data);
            }
        } catch (Exception e) {
            response.setCode(ResultEnum.SERVER_ERROR.getCode());
            response.setMessage("服务忙，请稍后再试");
            log.error("查询数据异常，metadataVo={},异常信息={}", queryVo.toString(),e.getMessage());
        }
        return response;
    }



    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result delete(@RequestBody ElasticEntity elasticDataVo){
        Result response = new Result();
        try {
            if(StringUtils.isEmpty(elasticDataVo.getId())){
                response.setCode(ResultEnum.NO_ELASTIC_INDEX.getCode());
                response.setMessage("索引为空，不允许提交");
                log.warn("索引为空");
                return response;
            }
            baseElasticService.deleteIndex(elasticDataVo.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;

    }

}
