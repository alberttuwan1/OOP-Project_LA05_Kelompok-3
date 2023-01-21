package main;


import javafx.scene.image.Image;

abstract public class Accomodation {
	
	protected String name;
	protected String Address;
	protected int grade;
	protected int price;
	protected Image image;
	

	public Accomodation(String name, String address, int grade, int price, Image image) {
		super();
		this.name = name;
		Address = address;
		this.grade = grade;
		this.price = price;
		this.image = image;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}



	public int getPrice() {
		return price;
	}
	
	
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	
	

}
