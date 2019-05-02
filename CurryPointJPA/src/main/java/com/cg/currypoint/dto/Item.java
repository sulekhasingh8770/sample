package com.cg.currypoint.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="item_id")
	private int item_id;
	@Column(name="item_name")
	private String name;
	@Column(name="item_price")
	private BigDecimal price;
	
	public Item() {
		
	}

	public Item( String name, BigDecimal price) {
		super();
		//this.item_id = item_id;
		this.name = name;
		this.price = price;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [id=" + item_id + ", name=" + name + ", price=" + price + "]";
	}
	

}
