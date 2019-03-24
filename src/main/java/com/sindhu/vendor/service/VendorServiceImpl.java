package com.sindhu.vendor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sindhu.vendor.entities.VendorDal;
import com.sindhu.vendor.repos.VendorDalRepos;

@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorDalRepos vendorRepos;
	
	@Override
	public VendorDal saveVendor(VendorDal vendorDal) {
		return vendorRepos.save(vendorDal);
	}

	@Override
	public VendorDal updateVendor(VendorDal vendorDal) {
		return vendorRepos.save(vendorDal);
	}

	@Override
	public void deleteVendor(VendorDal vendorDal) {
		vendorRepos.delete(vendorDal);
	}

	@Override
	public VendorDal getVendorById(int id) {
		return vendorRepos.findById(id).get();
	}

	@Override
	public List<VendorDal> getAllVendors() {
		return vendorRepos.findAll();
	}

}
