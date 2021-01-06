package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.ProductDao;
import domain.Product;

//@Transactional
public class ProductService {
	//业务层注入Dao的类
	//@Autowired
	private ProductDao productDao;
	
	public void save(Product product) {
		productDao.save(product);
		
	}

	/**
	 * @return the productDao
	 */
	public ProductDao getProductDao() {
		return productDao;
	}

	/**
	 * @param productDao the productDao to set
	 */
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

}
