package com.cg.currypoint.dao;

public interface QueryRepository {

	public static final String FIND_BY_LOCATION="SELECT v FROM Vendor v, IN(v.address) a WHERE a.city= :city";
	public static final String FIND_BY_NAME=" FROM Vendor v WHERE name=?1";
}
