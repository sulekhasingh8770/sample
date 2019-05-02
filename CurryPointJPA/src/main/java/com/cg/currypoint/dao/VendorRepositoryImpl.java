
/**
 
 This class is written to retrieval data from data source. 
 This program contains three methods which performs adding vendor details, findby given location and findby by vendor name.
*/

package com.cg.currypoint.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cg.currypoint.dto.Address;
import com.cg.currypoint.dto.Item;
import com.cg.currypoint.dto.Vendor;
import com.cg.currypoint.exception.ConnectionException;
import com.cg.currypoint.exception.VendorNotFoundException;
import com.cg.currypoint.util.DbUtil;

public class VendorRepositoryImpl implements VendorRepository {
	EntityManager em = DbUtil.getConnection();
	public VendorRepositoryImpl() {
		em = DbUtil.getConnection();
		}
	public Vendor save(Vendor vendor) {
		em.persist(vendor);
		em.getTransaction().commit();
		return vendor;
	}
	@Override
	public List<Vendor> findByLocation(String city) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Vendor> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
		
	
	/*public List<Vendor> findByLocation(String city) {//in this it search by location and returns the list of vendors found
		List<Vendor> vendors=new ArrayList<>();//storing the list of vendors in vendors
		try {
			pstm=connection.prepareStatement(QueryRepository.queryFindByLocation );//through query it retrieves data from database
			pstm.setString(1, city);
			ResultSet rs=pstm.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Vendor vendor=new Vendor();
					Address address=new Address();
					vendor.setName(rs.getString(1));
					address.setHouseNumber(rs.getLong(2));
					address.setLandmark(rs.getString(3));
					address.setArea(rs.getString(4));
					address.setCity(rs.getString(5));
					address.setState(rs.getString(6));
					address.setPincode(rs.getLong(7));
					vendor.setAddress(address);
					vendors.add(vendor);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vendors;
		
	}

	public List<Vendor> findByName(String name) {//in this it search by name and returns the list of vendors and items present in it
		List<Vendor> vendors=new ArrayList<>();//storing the list of vendors in vendors
		try {
			pstm=connection.prepareStatement(QueryRepository.queryFindByName);//through query it retrieves data from database
			pstm.setString(1, name);
			ResultSet rs=pstm.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Vendor vendor=new Vendor();
					List<Item> items=new ArrayList<Item>();
					Item item=new Item();
					vendor.setName(rs.getString(1));
					item.setItem_id(rs.getInt(2));
					item.setName(rs.getString(3));
					item.setPrice(rs.getBigDecimal(4));
					items.add(item);
					vendor.setItems(items);
					vendors.add(vendor);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vendors;
	}
*/
}
