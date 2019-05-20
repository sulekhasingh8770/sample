package com.cg.currypoint.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.currypoint.dto.Vendor;
import com.cg.currypoint.service.VendorService;

@Controller
public class CurryPointController {
	   @Autowired
	   VendorService vendorService;
	
		@GetMapping("welcome")
		public String welcome() {
			return "Welcome";
		}
		@GetMapping("add")
		public ModelAndView getVendor(@ModelAttribute("vend") Vendor vendo) {
			List<String> listofItems=new ArrayList<String>();
			listofItems.add("Biryani");
			listofItems.add("Chicken");
			listofItems.add("Veg");
			listofItems.add("Rotis");
			return new ModelAndView("addVendor","addV",listofItems);
			//return new ModelAndView("addVendor");
		}
		@PostMapping("addVendor")
		public ModelAndView addVendor(@ModelAttribute("vend") Vendor vendo) {
			Vendor vendor=vendorService.addVendor(vendo);
			return new ModelAndView("Welcome","addV",vendor);
		}
		
		@GetMapping("search")
		public ModelAndView searchCity(@ModelAttribute("vend") Vendor vendo) {
			return new ModelAndView("searchByCity");
		}
		
		@PostMapping("searchByCity")
		public ModelAndView findCity(@ModelAttribute("vend") Vendor vendo) {
			List<Vendor> vendor=vendorService.searchByLocation(vendo.getAddress().getCity());
			return new ModelAndView("searchByCity","sCity",vendor);
		}
		
		@GetMapping("searchby")
		public ModelAndView searchName(@ModelAttribute("vend") Vendor vendo) {
			return new ModelAndView("searchByName");
		}
		
		@PostMapping("searchByName")
		public ModelAndView findName(@ModelAttribute("vend") Vendor vendo) {
			List<Vendor> vendor=vendorService.searchByLocation(vendo.getName());
			return new ModelAndView("searchByName","sName",vendor);
		}
}
