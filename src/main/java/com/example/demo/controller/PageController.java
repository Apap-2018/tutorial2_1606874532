package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String viral() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name", required = false, defaultValue = "kiki") String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}
	
	@RequestMapping("/challenge/{name}")
	public String challengePath(@PathVariable String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}

	@RequestMapping("/generator")
	public String generator(@RequestParam(value = "a", required = false, defaultValue = "0") int a, @RequestParam(value = "b", required = false, defaultValue = "0") int b, Model model) {
		model.addAttribute("a",a);
		model.addAttribute("b",b);
		
		String xhm = "hm";
		String hasil = "";
		//membuat kata hm yang ditambah huruf m*a
		for(int i=0; i<a-1;i++) {
			xhm = xhm + "m";
		}
		//duplikasi kata hm yang telah dibuat sebanyak hm*x
		for(int x=0; x<b;x++) {
			if(a<=1) {
				xhm = "hm";
			}
			hasil = hasil+" "+ xhm;
		}
		//pengecualian jika nilai a dan b adalah 0 atau 1
		if (a<=1 && b<= 1) {
			hasil = "hm";
		}	
		model.addAttribute("hasil",hasil);
		
		return "viralgenerator";
	}
	
	
}

