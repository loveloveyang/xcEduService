package com.xuecheng.dictionaty.service;

import com.xuecheng.dictionaty.dao.SysDicthinaryRepository;
import com.xuecheng.framework.domain.system.SysDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService {
    @Autowired
    SysDicthinaryRepository sysDicthinaryRepository;
    //查询数据字典
    public SysDictionary getByType(String type){
        return sysDicthinaryRepository.findByDType(type);
    }
}
