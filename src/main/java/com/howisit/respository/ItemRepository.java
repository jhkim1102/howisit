package com.howisit.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.howisit.entity.Item;



public interface ItemRepository {
	//JPQL(non native 쿼리) -> 컬럼명, 테이블명은 entity 클래스 기준으로 작성한다
	@Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
	List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);
	
	//JPQL(native 쿼리) -> h2 데이터베이스를 기준으로한 쿼리문 작성
	@Query(value="select*from item where item_detail like %:itemDetail% order by price desc", nativeQuery = true)
	List<Item>findByItemDetailByNative(@Param("itemDetail") String itemDetail);
}
