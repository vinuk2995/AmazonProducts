

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.security.auth.Subject;

public class amzProductTest extends amzProductData {
	
        public amzProductTest(ArrayList<amzProduct> arrlist) {
		super(arrlist);
		// TODO Auto-generated constructor stub
	}
		

    static ArrayList<amzProduct> arrlist = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    public static void aptSearch()
	{
    	System.out.println("Enetr product name to be searched\n");
		
		
			String nameToSer = sc.next();
			System.out.println("Entered name is " + nameToSer);

			System.out.println("Enetr brand name to be searched\n");
			String brandToSer = sc.next();
			//System.out.println("Entered name is " + brandToSer);
			
			amzProductData flashCradsdata = new amzProductData(arrlist);
			try {
				flashCradsdata.searchProduct(nameToSer,brandToSer);
			} catch (ProductNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
    
    public static void filter1()
    {
    	
 		System.out.println("\n\t  ***Amazon Prime products having price below 25k***\n");
		List<amzProduct> strlist = arrlist.stream().
		filter(p ->p.getType().equals("prime") && p.getPrice() <25000)     
		.collect(Collectors.toList());  
		System.out.println(strlist);
    }
    public static void filter2()
    {
    	System.out.println("\n\t ***Products having price more than 25k***\n");

		List<amzProduct> strlist1 = arrlist.stream().
		filter(p ->p.getPrice() > 25000)                
        .collect(Collectors.toList());  
		System.out.println(strlist1);  
    }
	
    public static void main(String[] args) throws FileNotFoundException  
	{
		// TODO Auto-generated method stub

		
		arrlist= new amzProductData(arrlist).loadData();
		
		DisplayThread dt  = new DisplayThread();
		dt.run();
		
		
		PrintStream o = new PrintStream(new File("a.txt"));
		PrintStream console = System.out; 
		
		System.setOut(console);
		System.out.println("output is writen in file"); 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n1.Amazon Prime products having price below 25k "
							+ "\n 2.Products having price more than 25k"
							+ "\n 3.Serach for particular product"
							+ "\n 4.Sort products accourding to their price low-high"
							+ "\n 5.Sort products accourding to their price high-low");
		int key;
		
		do {
			System.setOut(console);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Enter your choice \t Enter 0 if u want to exit");
		 key = sc.nextInt();
		 
		switch (key) {

		case 1:System.setOut(o); 
			   filter1();
			   break;
			
		case 2: System.setOut(o);
				filter2();
				break;
				
		case 3:System.setOut(console); 
			aptSearch();
				break;
				
		case 4:

			System.setOut(o);
			System.out.println("\n\nproduct list sorted accourding to producrt price low-high");
			Collections.sort(arrlist , ( p1, p2) ->  p1.getPrice() > p2.getPrice() ? 1:-1);
			arrlist.forEach(t->System.out.println(t));
			break;
			
		case 5:

			System.setOut(o);
			System.out.println("\n\nproduct list accourding to poducts price high-low");
			Collections.sort(arrlist , ( p1, p2) ->  p2.getPrice() > p1.getPrice() ? 1:-1);
			arrlist.forEach(t->System.out.println(t));
			break;	
		
		default:
			
			if(key==0)
			{
			System.out.println("you have logged out successfully");	
			}
			else
				System.out.println("please enter valid input");
			break;
		}
		
		}while(key != 0);
	}

}
