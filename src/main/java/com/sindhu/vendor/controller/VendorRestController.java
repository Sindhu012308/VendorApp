package com.sindhu.vendor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sindhu.vendor.entities.VendorDal;
import com.sindhu.vendor.repos.VendorDalRepos;

@RestController
@RequestMapping("/vendors")
public class VendorRestController {
	@Autowired
	VendorDalRepos vendorRepos;
	
	@GetMapping
	public List<VendorDal> getVendors(){
		return vendorRepos.findAll();	
	}
	
	@PostMapping
	public VendorDal createVendors(@RequestBody VendorDal vendor){
		return vendorRepos.save(vendor);	
	}
	
	@PutMapping
	public VendorDal updateVendors(@RequestBody VendorDal vendor){
		return vendorRepos.save(vendor);	
	}
	
	@DeleteMapping("/{id}") 
	public void deleteMapping(@PathVariable("id") int id) {
		vendorRepos.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public VendorDal getOneVendor(@PathVariable("id") int id) {
		return vendorRepos.findById(id).get();
	}
	
}
