package com.howisit.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.howisit.entity.Member;
import com.howisit.respository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional	//쿼리문 수행시 에러가 발생하면 데이터를 이전상태로 콜백시켜줌
@RequiredArgsConstructor //@Autowired를 사용하지 않고 필드의 의존성 주입을 시켜줌
public class MemberService implements UserDetailsService{

	private final MemberRepository memberrepository;
	
	
	
	//회원가입 데이터를 DB에 저장한다
	public Member saveMember(Member member) {
		validateDuplicateMember(member); //이메일 중복체크
		Member savedMember = memberrepository.save(member); //insert
		return savedMember; //회원가입된 데이터를 리턴해준다
	}
	
	//이메일 중복체크
	private void validateDuplicateMember(Member member) {
		Member findMember = memberrepository.findByEmail(member.getEmail());
		
		if(findMember !=null) {
			throw new IllegalStateException("이미 가입된 회원입니다.");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		//사용자가 입력한 email이 DB에 있는지 쿼리문을 사용한다.
		Member member = memberrepository.findByEmail(email);
		
		if(member == null) { //사용자가 없다면
			throw new UsernameNotFoundException(email);
		}
		
		//사용자가 있다면 userDetails 객체를 만들어서 반환
		return User.builder()
				.username(member.getEmail())
				.password(member.getPassword())
				.roles(member.getRole().toString())
				.build();
	}
}
