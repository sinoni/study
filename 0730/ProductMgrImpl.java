package com.ssafy.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import com.ssafy.model.dto.CodeNotFindException;
import com.ssafy.model.dto.DuplicateException;
import com.ssafy.model.dto.Product;
import com.ssafy.model.dto.ProductNotFoundException;
import com.ssafy.model.dto.Refrigerator;
import com.ssafy.model.dto.TV;

public class ProductMgrImpl implements IProductMgr{
	private List<Product> prds;
	private String fileName="product.dat";
	
	public ProductMgrImpl() {
		prds = new LinkedList<Product>();
		load();
	}
	
	public void load() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		File file = null;
		try {
			file = new File(fileName);
			if (file.exists() && file.canRead()) {
				fis = new FileInputStream(file);	
				ois = new ObjectInputStream(fis);
				prds = (List) ois.readObject();		
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ois!=null)try {ois.close();} catch (Exception e2){}
			if(fis!=null)try {fis.close();} catch (Exception e2){}
		}
	}
	public void save() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(prds);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(oos!=null) try {oos.close();}catch(Exception e2) {}
			if(fos!=null) try {fos.close();}catch(Exception e2) {}
		}
	}
	
	public int findIndex(int p_no) {
		if (p_no > 0) {
			for (int i = 0; i < prds.size(); i++) {
				Product prd = prds.get(i);
				if (p_no==(prd.getP_no())) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public void add(Product prd) throws DuplicateException {
		System.out.println("Product 등록!!!......");
		if (prd != null) {
			int p_no = prd.getP_no();
			int index = findIndex(p_no);
			if (index<-1) {
				try {
					String msg = String.format("%s 제품번호는 이미 등록된 번호입니다.", prd);
					throw new DuplicateException(msg);
				}catch (DuplicateException e){
					e.printStackTrace();
				}
			}else {
				prds.add(prd);
			}
		}
	}
	
	public List<Product> searchAll() {
		return prds;
	}
	
	public Product findProduct(int p_no) throws CodeNotFindException {
		int index = findIndex(p_no);
		if (index>-1) {
			return prds.get(index);
		}else {
			try {
				String msg = String.format("상품번호 %d는 존재하지 않는 상품번호입니다.", p_no);
				throw new CodeNotFindException(msg);
			} catch (CodeNotFindException e) {
				e.printStackTrace();
			}finally {
				return null;
			}
			
		}
	}
	
	public List<Product> findProduct_name(String p_name) {
		List<Product> result = new LinkedList<>();
		if (p_name != null) {
			for (int i = 0; i < prds.size(); i++) {
				Product p = prds.get(i);
				if (p.getP_name().contains(p_name)) {
					result.add(p);
				}
			}
		}
		return result;
	}

	public List<Product> Search(String type) {
		List<Product> result = new LinkedList<>();
		if (type == "TV") {
			for (int i = 0; i < prds.size(); i++) {
				if (prds.get(i) instanceof TV) {
					result.add(prds.get(i));
				}
			}
		}else if (type == "Refrigerator") {
			for (int i = 0; i < prds.size(); i++) {
				if (prds.get(i) instanceof Refrigerator) {
					result.add(prds.get(i));
				}
			}
		}else {
			System.err.println("잘못된 상품 타입입니다. 타입은 TV/Refrigerator 두 가지 입니다!!!");
		}
		return result;
	}
	
	public List<Refrigerator> findRefrigerator400() throws ProductNotFoundException {
		LinkedList<Refrigerator> rlist	 = new LinkedList<>();
		List<Product> list = Search("Refrigerator");
		for(int i=0; i<list.size(); i++) {
			Refrigerator r = (Refrigerator)list.get(i);
			if (r.getCapacity()>=400) {
				rlist.add(r);
			}
		}
		if (rlist.size()==0) {
			try {
				throw new ProductNotFoundException();
			} catch (ProductNotFoundException e) {
				e.printStackTrace();
			}finally {
				return null;
			}
		}else {
			return rlist;
		}
	}
	
	public List<TV> findTV50() throws ProductNotFoundException {
		LinkedList<TV> tlist = new LinkedList<>();
		List<Product> list = Search("TV");
		for(int i=0; i<list.size(); i++) {
			TV t = (TV)list.get(i);
			if (t.getInch()>=50) {
				tlist.add(t);
			}
		}
		if (tlist.size()==0) {
			try {
				throw new ProductNotFoundException();
			} catch (ProductNotFoundException e) {
				e.printStackTrace();
			}finally {
				return null;
			}
		}else {
			return tlist;
		}
	}
	
	public void remove(int p_no) {
		int index = findIndex(p_no);
		if (index >-1) {
			prds.remove(index);
		}else {
			System.out.println("상품번호에 해당하는 제품이 등록되지 않아 삭제할 수 없습니다.");
		}
	}
	public int sumPrice() {
		int sumPrice = 0;
		int sum=0;
		for (int i = 0; i < prds.size(); i++) {
			sumPrice=prds.get(i).getPrice()*prds.get(i).getCount();
//			System.out.println("상품번호"+prds.get(i).getP_no()+"의 전체 재고 상품 금액:"+sumPrice+"원");
			sum+=sumPrice;
		}
		return sum;
	}
	public void updatePrice(int p_no, int price) {
		int index = findIndex(p_no);
		if (index>-1) {
			prds.get(index).setPrice(price);
		}else {
			System.out.println("제품번호에 해당하는 제품이 없습니다. 가격 업데이트 못함");
		}
		
	}
	public void close() {
		System.exit(0);	//JVM종료
		save();
	}

}
