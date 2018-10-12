

import java.util.ArrayList;

public class DisplayThread extends Thread {

	 ArrayList<amzProduct> arrlist = new ArrayList<>();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		arrlist= new amzProductData(arrlist).loadData();
		
		for(amzProduct i : arrlist)
		{
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			//System.out.println(i);
		}
		
		
	}
}
