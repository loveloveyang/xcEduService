package com.xuecheng.manage_cms.dao;


import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {
    @Autowired
    CmsPageRepository cmsPageRepository;

    //查询全部
    @Test
    public void testFindALL() {
        List<CmsPage> all = cmsPageRepository.findAll();
        System.out.println("===================================================");
        System.out.println("总共页数：" + all);
        System.out.println("===================================================");

    }

    //分页测试
    @Test
    public void testFindPage() {
        int page = 0;//从0开始
        int size = 10;//每页记录数
        Pageable pageable = PageRequest.of(page, size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println("===================================================");
        System.out.println(all);
        System.out.println("===================================================");
    }

    //自定义条件查询
    @Test
    public void testFindAll() {
        //条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        exampleMatcher = exampleMatcher.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        //页面别名模糊查询，需要自定义字符串的匹配器实现模糊查询
        // ExampleMatcher.GenericPropertyMatchers.contains() 包含
        // ExampleMatcher.GenericPropertyMatchers.startsWith()// 开头匹配
        // 条件值
        CmsPage cmsPage = new CmsPage();
        // 站点ID
        cmsPage.setSiteId("5a751fab6abb5044e0d19ea1");
        //模板ID
        cmsPage.setTemplateId("5a962c16b00ffc514038fafd");
        // cmsPage.setPageAliase("分类导航");
        // 创建条件实例
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        Pageable pageable = new PageRequest(0, 10);
        Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
        System.out.println(all);
    }
}
