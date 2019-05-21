package com.cg.currypoint.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.currypoint.dto.Item;
import com.cg.currypoint.dto.Vendor;
import com.cg.currypoint.service.VendorService;

@Controller
public class CurryPointController {
	   @Autowired
	   VendorService vendorService;
	   Vendor vedo;
		@GetMapping("welcome")
		public ModelAndView welcome() {
			return new ModelAndView("Welcome");
		}
		@GetMapping("add")
		public ModelAndView getVendor(@ModelAttribute("vend") Vendor vendo) {
			return new ModelAndView("addVendor");
		}
		@PostMapping("addVendor")
		public ModelAndView addVendor(@ModelAttribute("vend") Vendor vendo) {
			this.vedo=vendo;
			return new ModelAndView("addItems");
		}
		
		@GetMapping("search")
		public ModelAndView searchCity(@ModelAttribute("vend") Vendor vendo) {
			return new ModelAndView("searchByCity");
		}
		
		@PostMapping("searchByCity")
		public ModelAndView findCity(@RequestParam("city") String city,@ModelAttribute("vend") Vendor vendo) {
			List<Vendor> vendor=vendorService.searchByLocation(vendo.getAddress().getCity());
			return new ModelAndView("searchByCity","sCity",vendor);
		}
		
		@GetMapping("searchby")
		public ModelAndView searchName(@ModelAttribute("vend") Vendor vendo) {
			return new ModelAndView("searchByName");
		}
		
		@PostMapping("searchByName")
		public ModelAndView findName(@RequestParam("name") String name,@ModelAttribute("vend") Vendor vendo) {
			List<Vendor> vendor=vendorService.searchByLocation(vendo.getName());
			System.out.println(vendor);
			return new ModelAndView("searchByName","sName",vendor);
		}
		
		
		
		@PostMapping("additem")
		public ModelAndView additems(@RequestParam("id") int id,@RequestParam("name") String name,
				@RequestParam("price") BigDecimal price )
		{
			
			Item itm=new Item();
			itm.setId(id);
			itm.setName(name);
			itm.setPrice(price);;
			List<Item> itmList=new ArrayList<>();
			itmList.add(itm);
			Vendor vdor=new Vendor();
			vdor.setId(vedo.getId());
			vdor.setName(vedo.getName());
			vdor.setEmail(vedo.getEmail());
			vdor.setPhoneNumber(vedo.getPhoneNumber());
			vdor.setAddress(vedo.getAddress());
			vdor.setItems(itmList);
			Vendor vendor=vendorService.addVendor(vdor);
			return new ModelAndView("Welcome","adV",vendor);
		}
}
