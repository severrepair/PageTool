package com.bitc.pagetest.service;

import com.bitc.pagetest.dto.CustomersDto;
import com.bitc.pagetest.mapper.PageMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService{
    @Autowired
    private PageMapper pageMapper;

    @Override
    public List<CustomersDto> selectCustomersList() {
        return pageMapper.selectCustomersList();
    }

    @Override
    public Page<CustomersDto> selectCustomersList(int pageNo) {
//        startPage : 첫번째 매개변수로 화면에 출력할 페이지, 두번째 매개변수로 화면에 출력할 컨텐츠의 수 설정
        PageHelper.startPage(pageNo, 20);
        return pageMapper.selectCustomersListPage();
    }
}
