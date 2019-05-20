package com.cg.currypoint.service;

import java.util.List;
import com.cg.currypoint.dto.Vendor;

public interface VendorService {
	public Vendor addVendor(Vendor vendor);
	public List<Vendor> searchByLocation(String city);
	public List<Vendor> searchByName(String name);
}
