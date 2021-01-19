package com.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product implements Serializable {

	private static final long serialVersionUID = -7446162716367847201L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productid;
	private String description;
	private String productname;
	private double price;
	private int quantity;
	private String categoria;
	private String size;
	private String sex;
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Lob
	private byte[] productimage;

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public byte[] getProductimage() {
		return productimage;
	}

	public void setProductimage(byte[] productimage) {
		this.productimage = productimage;
	}

	public Product() {
		super();
	}

	public Product( Integer id, String description, String productname, double price, int quantity,
			byte[] productimage, String categoria, String size,String sex) {
		super();
		 
		this.description = description;
		this.productname = productname;
		this.price = price;
		this.quantity = quantity;
		this.productimage = productimage;
		this.categoria = categoria;
		this.size = size;
		this.sex = sex;
	}
	public Product(  Integer id, String description, String productname, double price, int quantity,
			byte[] productimage ) {
		super();
		 
		this.description = description;
		this.productname = productname;
		this.price = price;
		this.quantity = quantity;
		this.productimage = productimage;
		this.categoria = categoria;
		this.size = size;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
}