package com.scores.demo.controllers;

import com.scores.demo.common.Message;
import com.scores.demo.common.ResultUtils;
import com.scores.demo.domain.EsScore;
import com.scores.demo.services.EsScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 搜索学生成绩信息controller
 */
@RestController
@Api(tags="搜索学生信息")
@RequestMapping("/esScore")
public class EsScoreController {
    @Autowired
    private EsScoreService esScoreService;

    @ApiOperation("导入所有数据库中学生数据到ES")
    @RequestMapping("/importAll")
    public Message importAllList(){
        int count = esScoreService.importAll();
        return ResultUtils.success(count);
    }

    @ApiOperation("根据id删除信息")
    @RequestMapping("/delete")
    public Message delete(@RequestParam @Validated Long id){
        esScoreService.delete(id);
        return ResultUtils.success(id);
    }

    @ApiOperation("根据id批量删除商品")
    @RequestMapping("/delete/batch")
    public Message delete(@RequestParam("ids") List<Long> ids) {
        esScoreService.delete(ids);
        return ResultUtils.success(null);
    }

    @ApiOperation("根据id创建信息")
    @RequestMapping("/create/{id}")
    public Message create(@PathVariable Long id) {
        EsScore esScore = esScoreService.create(id);
        if (esScore != null) {
            return ResultUtils.success(esScore);
        } else {
            return ResultUtils.error(404,"创建失败");
        }
    }

    @ApiOperation("简单搜索")
    @RequestMapping("/search/simple")
    public Message search(@RequestParam(required = false) String name,
                          @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                          @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsScore> esProductPage = esScoreService.search(name, pageNum, pageSize);
        return ResultUtils.success(esProductPage);
    }

}
