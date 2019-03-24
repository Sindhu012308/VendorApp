package com.sindhu.vendor.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sindhu.vendor.entities.VendorDal;
import com.sindhu.vendor.repos.VendorDalRepos;
import com.sindhu.vendor.service.VendorService;
import com.sindhu.vendor.util.EmailUtil;
import com.sindhu.vendor.util.ReportUtil;

@Controller
public class VendorController {
	@Autowired
	VendorService service;
	
	@Autowired
	VendorDalRepos vendorRepos;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	ReportUtil reportUtil;
	
	@Autowired
	ServletContext sc;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createVendor";
	}
	
	@RequestMapping("/SaveVendor")
	public String saveVendor(@ModelAttribute("vendorDal") VendorDal vendorDal, ModelMap modelMap) {
		VendorDal vendorSaved = service.saveVendor(vendorDal);
		String mesg = "Vendor data is saved with ID:"+vendorSaved.getId();
		modelMap.addAttribute("mesg",mesg);
		emailUtil.sendEmail("katta.sweety.2301@gmail.com","Hi Sasi","Hope you are doing good! You Successfully saved the Vendor Information. Thank You, Sindhu Katta.");
		return "createVendor";
	}
	
	@RequestMapping("/displayVendors")
	public String displayVendor(ModelMap modelMap){
		List<VendorDal> allVendor = service.getAllVendors();
		modelMap.addAttribute("allVendor", allVendor);
		return "displayVendors";
	}
	
	@RequestMapping("/deleteVendor")
	public String deleteVendor(@RequestParam("id") int id,ModelMap modelMap ){
		VendorDal vendorbyId = service.getVendorById(id);
		service.deleteVendor(vendorbyId);
		List<VendorDal> allVendor = service.getAllVendors();
		modelMap.addAttribute("allVendor", allVendor);
		return "displayVendors";
	}
	
	@RequestMapping("/editVendor")
	public String editVendor(@RequestParam("id") int id, ModelMap modelMap) {
		VendorDal vendorbyId = service.getVendorById(id);
		modelMap.addAttribute("vendorbyId", vendorbyId);
		return "updateVendorData";
	}
	
	@RequestMapping("/updateData")
	public String updateData(@ModelAttribute("vendorbyId") VendorDal vendorbyId, ModelMap modelMap) {
		service.updateVendor(vendorbyId);
		List<VendorDal> allVendor = service.getAllVendors();
		modelMap.addAttribute("allVendor",allVendor);
		return "displayVendors";
	}
	
	@RequestMapping("/generateReport")
	public String generateReport() {
		String path = sc.getRealPath("/");
		List<Object[]> data = vendorRepos.TypeAndCount();
		reportUtil.generateChart(path, data);
		return "report";
	}
}
