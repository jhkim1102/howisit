package com.howisit.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="reservation_item")
@Getter
@Setter
@ToString
public class ReservationItem {
	
	@Id
	@Column(name="reservation_item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="item_id")
	private Item item;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="reservation_id")
	private Reservation reservation;
	
	private int reservationPrice; //주문가격
	
	private int count; //수량
}
