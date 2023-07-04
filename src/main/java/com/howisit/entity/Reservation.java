package com.howisit.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.howisit.constant.ReservationStatus;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="reservation")
@Getter
@Setter
@ToString
public class Reservation {
	
	@Id
	@Column(name="reservation_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="member_id")
	private Member member;
	

	@OneToMany(mappedBy = "reservation", cascade= CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY) //연관관계의 주인 설정(왜래키로 지정)
	private List<ReservationItem> ReservationItems = new ArrayList<>();
	
	private LocalDateTime reservationdate; //주문일
	
	@Enumerated(EnumType.STRING)
	private ReservationStatus reservationstatus; //주문상태

}
