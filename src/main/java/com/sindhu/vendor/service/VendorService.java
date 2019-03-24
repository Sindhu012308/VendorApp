package com.sindhu.vendor.service;

import java.util.List;

import com.sindhu.vendor.entities.VendorDal;


public interface VendorService {

	VendorDal saveVendor(VendorDal vendorDal);
	VendorDal updateVendor(VendorDal vendorDal);
	void deleteVendor(VendorDal vendorDal);
	VendorDal getVendorById(int id);
	List<VendorDal> getAllVendors();
}
