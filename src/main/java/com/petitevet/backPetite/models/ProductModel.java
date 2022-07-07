package com.petitevet.backPetite.models;

public class ProductModel {
	private String name;
	private String description;
	private String img;
	private double precio;
	private String SKU;
	private int id;
	private static int total=0;
	
	public ProductModel(String name, String description, String img, double precio, String sKU) {
		super();
		this.name = name;
		this.description = description;
		this.img = img;
		this.precio = precio;
		total ++;
		this.id = total;
		SKU = sKU;
	}//Constructor
	

	public ProductModel() {
		total ++;
		this.id=total;
	}//Constructor por default

	public String getName() {
		return name;
	}//getName

	public void setName(String name) {
		this.name = name;
	}//setName

	public String getDescription() {
		return description;
	}//getDescription

	public void setDescription(String description) {
		this.description = description;
	}//setDescription

	public String getImg() {
		return img;
	}//getImg

	public void setImg(String img) {
		this.img = img;
	}//setImg

	public double getPrecio() {
		return precio;
	}//getPRecio

	public void setPrecio(double precio) {
		this.precio = precio;
	}//setPrecio

	public int getId() {
		return id;
	}//getId

	public String getSKU() {
		return SKU;
	}//getSKU

	public void setSKU(String sKU) {
		SKU = sKU;
	}//getSKU

	@Override
	public String toString() {
		return "ProductModel [name=" + name + ", description=" + description + ", img=" + img + ", precio=" + precio
				+ ", id=" + id + ", SKU=" + SKU + "]";
	}//toString
	
}
