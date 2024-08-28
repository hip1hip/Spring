package com.example.demo.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.member.Member;

@Service
public class ProductService {
	@Autowired
	private ProductDao dao;
	
	//등록과 수정 
	public ProductDto saveProd(ProductDto dto) {
		Product entitiy = dao.save(new Product(dto.getNum(), dto.getName(), dto.getPrice(), dto.getAmount(),dto.getSeller(),dto.getImg()));
		return new ProductDto(entitiy.getNum(), entitiy.getName(), entitiy.getPrice(), entitiy.getAmount(),entitiy.getSeller(),entitiy.getImg(), null);
	}
	
	//번호로검색 
	public ProductDto getProd(int num) {
		Product entitiy = dao.findById(num).orElse(null);
		if( entitiy != null) {
			return new ProductDto(entitiy.getNum(), entitiy.getName(), entitiy.getPrice(), entitiy.getAmount(),entitiy.getSeller(),entitiy.getImg(), null);
		}
		return null;
	}
	
	//전체검색 
	public ArrayList<ProductDto> getAll() {
		List<Product> l = dao.findAll();
		ArrayList<ProductDto> list = new ArrayList<ProductDto>();
		for(Product entitiy:l ) {
			list.add(new ProductDto(entitiy.getNum(), entitiy.getName(), entitiy.getPrice(), entitiy.getAmount(),entitiy.getSeller(),entitiy.getImg(), null));
		}
		return list;
	}
	
	//삭제 
	public void delProd(int num) {
		dao.deleteById(num);
	}
	
	//판매자로 검색
	public ArrayList<ProductDto> getBySeller(String seller){
		List<Product> l = dao.findBySeller(new Member(seller,"","","",""));
		ArrayList<ProductDto> list = new ArrayList<ProductDto>();
		for(Product entitiy:l ) {
			list.add(new ProductDto(entitiy.getNum(), entitiy.getName(), entitiy.getPrice(), entitiy.getAmount(),entitiy.getSeller(),entitiy.getImg(), null));
		}
		return list;
	}
	
	
	//가격대로 검색 
	public ArrayList<ProductDto> getByPrice(int p1, int p2){
		List<Product> l = dao.findByPriceBetween(p1, p2);
		ArrayList<ProductDto> list = new ArrayList<ProductDto>();
		for(Product entitiy:l ) {
			list.add(new ProductDto(entitiy.getNum(), entitiy.getName(), entitiy.getPrice(), entitiy.getAmount(),entitiy.getSeller(),entitiy.getImg(), null));
		}
		return list;
	}
	
	//상품명으로 검색 
	public ArrayList<ProductDto> getByName(String name){
		List<Product> l = dao.findByNameLike("%"+name+"%");
		ArrayList<ProductDto> list = new ArrayList<ProductDto>();
		for(Product entitiy:l ) {
			list.add(new ProductDto(entitiy.getNum(), entitiy.getName(), entitiy.getPrice(), entitiy.getAmount(),entitiy.getSeller(),entitiy.getImg(), null));
		}
		return list;
	} 
	
	
	
	
	
}
