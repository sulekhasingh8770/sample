
/**
 
 This class is written to retrieval data from data source. 
 This program contains three methods which performs adding vendor details, findby given location and findby by vendor name.
*/

package com.cg.currypoint.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.currypoint.dto.Address;
import com.cg.currypoint.dto.Item;
import com.cg.currypoint.dto.Vendor;
import com.cg.currypoint.exception.VendorNotFoundException;
import com.cg.currypoint.util.DbUtil;

public class VendorRepositoryImpl implements VendorRepository {
	Connection connection = DbUtil.getConnection();//it establishes connection with database
	PreparedStatement pstm; 
	public Vendor save(Vendor vendor) {
		 try {
			 //in this block we are performing insertion operation into address table
			 pstm = connection.prepareStatement(QueryRepository.queryInsertAddress);
			System.out.println(vendor);
			int addressId=0;
			try {
		        pstm.setLong(1, vendor.getAddress().getHouseNumber());   
		        pstm.setString(2, vendor.getAddress().getLandmark());
				pstm.setString(3, vendor.getAddress().getArea());
				pstm.setString(4, vendor.getAddress().getCity());
				pstm.setString(5, vendor.getAddress().getState());
				pstm.setLong(6, vendor.getAddress().getPincode());           
		        pstm.executeUpdate();
		        
		       pstm = connection.prepareStatement( QueryRepository.queryMaxAddressId);// in this situation it takes last inserted id
		       ResultSet result = pstm.executeQuery();//storing the execute query data in result by using resultset
		       //this result.next goes to next row
		       if(result.next()) {
		    	   addressId = result.getInt(1);
		       }
		    }
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			//insertion of data into vendor table
		    try (PreparedStatement pstm = connection.prepareStatement
		    		(QueryRepository.queryInsertVendor)){
		        pstm.setString(1, vendor.getName());  
		        pstm.setString(2, vendor.getEmail());
		        pstm.setString(3, vendor.getPhoneNumber().toString());
		        pstm.setInt(4, addressId);
		        pstm.executeUpdate();
		    }
		} catch (SQLException e1) {
			e1.printStackTrace();
			}
	
		 int vendorId=0; 
		try {
			pstm = connection.prepareStatement(QueryRepository.queryMaxVendorId);// in this situation it takes last inserted id
		       ResultSet result = pstm.executeQuery();//storing the execute query data in result by using resultset
		       if(result.next()) {
		    	    vendorId= result.getInt(1);
		       }
		       
		       
		       //inserting data into item table
			pstm = connection.prepareStatement(QueryRepository.queryInsertItem);
	      for (Item items : vendor.getItems()) {
			pstm.setString(1, items.getName());
			pstm.setBigDecimal(2, items.getPrice());
			pstm.setInt(3, vendorId);

	        pstm.executeUpdate();
		}
	
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
		return vendor;
	}
		
	
	public List<Vendor> findByLocation(String city) {//in this it search by location and returns the list of vendors found
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
					item.setId(rs.getInt(2));
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

}
