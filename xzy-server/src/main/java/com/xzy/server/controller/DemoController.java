package com.xzy.server.controller;

import com.xzy.base.model.DemoData;
import com.xzy.base.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author luobo
 * @Date 2022-12-23
 **/
@RestController
@Slf4j
public class DemoController {


    @GetMapping("/demo")
    public String demo() {
        DemoData demoData = new DemoData();
        log.info("demoData:{}", JsonUtils.toJson(demoData));
        return "hello demo";
    }
}
