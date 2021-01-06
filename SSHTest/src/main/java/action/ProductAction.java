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
	/**ִ�н����
	 * CustomInterceptor....preHandle
	 * Action�е�save����ִ����...
	 * Hibernate: insert into product (pname, price) values (?, ?)
	 * DAO�е�save����ִ����...
	 * CustomInterceptor....postHandle
	 * CustomInterceptor....afterCompletion
	 * 
	 */
	//������Ʒ��ִ�еķ���:save
	@RequestMapping(value="save",produces = "text/html;charset=utf-8")
	@ResponseBody
	public String save(){
	System.out.println("Action�е�save����ִ����...");
	Product product=new Product("���������޷�",333.33);
	productService.save(product);
	return "����ɹ�";
	}  

}
