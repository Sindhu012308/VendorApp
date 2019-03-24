package com.sindhu.vendor.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sindhu.vendor.entities.VendorDal;

public interface VendorDalRepos extends JpaRepository<VendorDal, Integer> {

	@Query(value="Select type, count(type)  from vendortab group by type", nativeQuery = true)
	public List<Object[]> TypeAndCount();
}
