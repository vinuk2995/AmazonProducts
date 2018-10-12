

public class ProductNotFoundException extends Exception {

	private String msg;
	
	public ProductNotFoundException() {
		// TODO Auto-generated constructor stub

		 msg = "The product you are looking for is not available ";
	}

	public ProductNotFoundException(String msg) {
		// TODO Auto-generated constructor stub

		super(msg);
	}
	
	

}
