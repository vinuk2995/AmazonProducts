
@FunctionalInterface
public interface ProductSearchable {

	Product searchProduct(String name,String brand)throws  ProductNotFoundException;

}
