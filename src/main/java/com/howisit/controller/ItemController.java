package com.howisit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ItemController {
	
	//상품 전체 리스트
	@GetMapping(value = "/item/shop")
	public String itemShopList() {
		return "item/itemShopList";
	}
	
	//상품 상세정보
	@GetMapping(value = "/item/info")
	public String itemInfo() {
		return "item/itemInfo";
	}
}
