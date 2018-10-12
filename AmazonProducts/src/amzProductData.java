

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class amzProductData  implements ProductSearchable {
	ArrayList<amzProduct> arrlist = new ArrayList<>();
	
	public amzProductData(ArrayList<amzProduct> arrlist) {
		super();
		this.arrlist = arrlist;
	}
	
	public ArrayList<amzProduct> loadData()
	{
		
		BufferedReader br;
		
		try {
			br = new BufferedReader(new FileReader("C:\\Users\\vinayak.kharate\\Desktop\\java\\amazon\\src\\amazondata.txt"));
			Scanner scanner = new Scanner(br);
			
			while(scanner.hasNextLine())
			{
				String ldata = scanner.nextLine();
				String[] details = ldata.split(";");			
				String name1 = details[0];
				String brand1= details[1];
				String type1 = details[2];
				String pr1 = details[3];
				int price1 = Integer.parseInt(pr1);
				
				amzProduct a=new amzProduct(name1, brand1,type1,price1);
				arrlist.add(a);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrlist;
		
	}

	@Override
	public Product searchProduct(String name , String brand) throws ProductNotFoundException{
		// TODO Auto-generated method stub
		for (amzProduct ele : arrlist) {
			
			if(ele.getName().equals(name) && ele.getBrand().equals(brand))
			{
				ele.displayProduct();
				return ele;
			}
		}
		
		System.out.println("Product Name is " + name + "Products brand is " + brand);

		throw new ProductNotFoundException();
	}
		

}
