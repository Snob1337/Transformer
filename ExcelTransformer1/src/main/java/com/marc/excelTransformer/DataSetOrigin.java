package com.marc.excelTransformer;

import com.opencsv.bean.CsvBindByName;

public class DataSetOrigin{

	@CsvBindByName(column = "Brand", required = true)
	private String brand;

	@CsvBindByName(column = "Name", required = false)
	private String name;

	@CsvBindByName(column = "Model", required = false)
	private String model;

	@CsvBindByName(column = "Part number", required = false)
	private String part;
	
	@CsvBindByName(column = "Your net price", required = false)
	private String your;

	@CsvBindByName(column = "Suggested retail price", required = false)
	private String suggested;

	@CsvBindByName(column = "EAN", required = false)
	private String ean;

	@CsvBindByName(column = "Size", required = false)
	private String size;

	@CsvBindByName(column = "Width", required = false)
	private String width;

	@CsvBindByName(column = "PCD", required = false)
	private String pcd;

	@CsvBindByName(column = "ET", required = false)
	private String et;

	@CsvBindByName(column = "Colour", required = false)
	private String colour;

	@CsvBindByName(column = "Center bore", required = false)
	private String center;
	
	@CsvBindByName(column = "Stock", required = false)
	private String stock;

	@CsvBindByName(column = "Next delivery", required = false)
	private String next;

	@CsvBindByName(column = "Photo", required = false)
	private String photo;
	
	@CsvBindByName(column = "3D link", required = false)
	private String threeD;

	@CsvBindByName(column = "Info", required = false)
	private String info;

	@CsvBindByName(column = "Release date", required = false)
	private String release;

	@Override
	public String toString() {
		return "DataSet [brand=" + brand + ", name=" + name + ", model=" + model + ", part=" + part + ", your=" + your
				+ ", suggested=" + suggested + ", ean=" + ean + ", size=" + size + ", width=" + width + ", pcd=" + pcd
				+ ", et=" + et + ", colour=" + colour + ", center=" + center + ", stock=" + stock + ", next=" + next
				+ ", photo=" + photo + ", threeD=" + threeD + ", info=" + info + ", release=" + release + "]";
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getYour() {
		return your;
	}

	public void setYour(String your) {
		this.your = your;
	}

	public String getSuggested() {
		return suggested;
	}

	public void setSuggested(String suggested) {
		this.suggested = suggested;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getPcd() {
		return pcd;
	}

	public void setPcd(String pcd) {
		this.pcd = pcd;
	}

	public String getEt() {
		return et;
	}

	public void setEt(String et) {
		this.et = et;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getThreeD() {
		return threeD;
	}

	public void setThreeD(String threeD) {
		this.threeD = threeD;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	
	public DataSetOrigin()
	{
		
	}


}
