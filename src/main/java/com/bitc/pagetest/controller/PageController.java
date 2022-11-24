package com.bitc.pagetest.controller;

import com.bitc.pagetest.dto.CustomersDto;
import com.bitc.pagetest.service.PageService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private PageService pageService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/page")
    public ModelAndView page(@RequestParam(required = false, defaultValue = "1") int pageNum) throws Exception {
        ModelAndView mv = new ModelAndView("page");

//        List<CustomersDto> customersList = pageService.selectCustomersList();
//        mv.addObject("customersList", customersList);

//        PageHelper : Mybatis에서 페이징 기법을 쉽게 사용할 수 있도록 도와주는 라이브러리
//        https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/en/HowToUse.md
        
//        PageInfo : ArrayList와 비슷한 형태의 클래스, 해당 클래스 타입의 객체에 실제 DB에서 받아온 데이터를 저장하고 VIew로 전송함
//        PageInfo 클래스는 페이징을 쉽게 하기 위한 멤버를 제공하고 있음

//        int pageNum: 현재 페이지
//        int pageSize: 페이지당 수량
//        int size: 페이지 수
//        int startRow: 현제 페이지에서 첫번째 요소가 데이터베이스에 있는 줄 번호
//        int endRow: 현재 페이지에서 마지막 요소가 데이터베스에 있는 줄 번호
//        int pages: 전체 페이지 수
//        int prePage: 이전 페이지
//        int nextPage: 다음 페이지
//        boolean isFirstPage: 첫번째 페이지 존재 여부
//        boolean isLastPage: 마지막 페이지 존재 여부
//        boolean hasPreviousPage: 이전 페이지 존재 여부
//        int hasNextPage: 다음 페이지 존재 여부
//        int navigatePages: 네비게이션 페이지 번호
//        int[] navigatePageNums: 모든 네이게이션 페이지 번호
//        int navigateFisrstPage: 네비게이션 바의 첫번째 페이지
//        int navigateLastPage: 네비게이션 바의 마지막 페이지

//        List<t> list() : 실제 데이터 리스트가 들어있는 ArrayList



//        첫번째 매개변수로 Service를 이용하여 데이터를 가져오기 위한 메서드를 지정
//        두번째 매개변수로 이동을 하기 위한 페이지 번호 수 설정
        PageInfo<CustomersDto> customersList = new PageInfo<>(pageService.selectCustomersList(pageNum), 10);
        mv.addObject("customersList", customersList);

        return mv;
    }

}
