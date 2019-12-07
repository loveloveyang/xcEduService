package com.xuecheng.dictionaty.controller;

import com.xuecheng.api.SysDictionary.SysDicthinaryControllerApi;
import com.xuecheng.dictionaty.service.DictionaryService;
import com.xuecheng.framework.domain.system.SysDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys")
public class SysDicthinaryController implements SysDicthinaryControllerApi {
    @Autowired
    DictionaryService dictionaryService;

    @GetMapping("/dictionary/get/{dType}")
    @Override
    public SysDictionary getByType(@PathVariable("dType") String type) {
        return dictionaryService.getByType(type);
    }
}
