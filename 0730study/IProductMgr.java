package com.ssafy.model.dao;

import java.util.List;

import com.ssafy.model.dto.Product;
import com.ssafy.model.dto.Refrigerator;
import com.ssafy.model.dto.TV;


public interface IProductMgr {
	void add(Product prd);
	List<Product> searchAll();
	List<Product> findProduct_name(String p_name);
	Product findProduct(int p_no);
	List<Product> Search(String type);
	List<Refrigerator> findRefrigerator400();
	List<TV> findTV50();
	void updatePrice(int p_no, int price);
	void remove(int p_no);
	int sumPrice();
	void close();
	
}
