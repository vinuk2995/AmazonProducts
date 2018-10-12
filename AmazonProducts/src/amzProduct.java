

public class amzProduct extends Product {


	 public amzProduct(String name, String brand,String type,int price) 
	{
		// TODO Auto-generated constructor stub
		super.setName(name);
		super.setBrand(brand);
		super.setType(type);
		super.setPrice(price);
	}
	
	public void displayProduct() {

		System.out.println("Product name is :" + this.getName()); 
		System.out.println("Product brand  is :" + this.getBrand());
		System.out.println("Product type is : " + this.getType());
		System.out.println("product pice is " + this.getPrice());
	}
	
}
