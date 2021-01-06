package action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.Product;
import service.ProductService;
/*extends ActionSupport implements ModelDriven<Product>*/
@Controller
public class ProductAction  {

	@Autowired
	private ProductService productService;
	
	/**
	 * @return the productService
	 */
	public ProductService getProductService() {
		return productService;
	}

	/**
	 * @param productService the productService to set
	 */
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	/**执行结果：
	 * CustomInterceptor....preHandle
	 * Action中的save方法执行了...
	 * Hibernate: insert into product (pname, price) values (?, ?)
	 * DAO中的save方法执行了...
	 * CustomInterceptor....postHandle
	 * CustomInterceptor....afterCompletion
	 * 
	 */
	//保存商品的执行的方法:save
	@RequestMapping(value="save",produces = "text/html;charset=utf-8")
	@ResponseBody
	public String save(){
	System.out.println("Action中的save方法执行了...");
	Product product=new Product("阿依莲羽绒服",333.33);
	productService.save(product);
	return "保存成功";
	}  

}
