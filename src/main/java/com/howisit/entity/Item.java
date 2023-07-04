package com.howisit.entity;

import com.howisit.constant.ItemSellStatus;
import com.howisit.constant.ItemType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity //엔티티 클래스로 정의
@Table(name="item") //테이블 이름지정
@Getter
@Setter
@ToString
public class Item {

	@Id
	@Column(name="item_id") //테이블로 생성될때 컬럼이름을 지정해준다.
	@GeneratedValue(strategy = GenerationType.AUTO)	//기본키를 자동으로 생성해주는 전략사용
	private Long id; //상품코드
	
	@Column(nullable = false, length = 50) //not null여부, 컬럼 크기지정
	private String itemNm; //숙소명 --> item_Nm
	
	@Column(nullable = false)
	private int price; //가격 --> price
	
	@Column(nullable = false)
	private int stockNumber; //재고수량 --> stock_Number
	
	@Lob //clob과 같은 큰타입의 문자타입으로 컬럼을 만든다
	@Column(nullable = false)
	private String itemDetail; //상품상세설명 --> item_Detail
	
	@Enumerated(EnumType.STRING) //enum의 이름을 DB에 저장
	private ItemSellStatus itemSellStatus; //판매상태 (sell,sold out) --> item_Sell_Status
	
	@Column(nullable = false)
	private String location; //지역명 --> location
	
	@Enumerated(EnumType.STRING)
	private ItemType itemType; // 숙박여부(rent,stay) --> item_Type
	
	
}
