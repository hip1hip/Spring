package jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {


  @RequestMapping("/")
  public String home(){
    log.info("home controller");  // log 찍어보는거
    return "home";  // templates 안에 home.html 를 불러옴

  }


}
