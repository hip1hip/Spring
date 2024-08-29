package com.example.demo.article;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/data")
public class ArticleController {
	@Autowired
	private ArticleService service;
	
	@Value("${spring.servlet.multipart.location}")
	private String path;
	
	@RequestMapping("/list")
	public void list(Model m) {
		m.addAttribute("list", service.getAll());
	}
	
	@GetMapping("/add")
	public void addForm() {}
	
	@PostMapping("/add")
	public String add(ArticleDto dto) {
		ArticleDto dto2 = service.saveArticle(dto);
		String fname = dto2.getNum() + dto.getF().getOriginalFilename();
		File newf = new File(path + fname);
		try {
			dto.getF().transferTo(newf);
			dto2.setData(fname);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.saveArticle(dto2);
		return "redirect:/data/list";
	}
	
	@GetMapping("/detail")
	public void detail(int num, Model m) {
		m.addAttribute("dto", service.getArticle(num));
	}
	
	
	
	
	
	
	
}