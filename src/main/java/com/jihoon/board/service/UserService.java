package com.jihoon.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jihoon.board.dto.response.ResponseDto;
import com.jihoon.board.dto.user.PostUserDto;
import com.jihoon.board.dto.user.PostUserResponseDto;
import com.jihoon.board.entity.MemberEntity;
import com.jihoon.board.repository.MemberRepository;

@Service
public class UserService {
	
	@Autowired MemberRepository memberRepository;

	public ResponseDto<PostUserResponseDto> postUser(PostUserDto dto) {
		
		// 데이터베이스에 해당 이메일이 존재하는지 체크
		// 존재한다면 Failed Response를 반환
		String email = dto.getEmail();
		MemberEntity member = memberRepository.findById(email).get();
		
		String password = dto.getPassword();
		String password2 = dto.getPassword2();
		
		if (!password.equals(password2)) return ResponseDto.setFailed("비밀번호가 서로 다릅니다.");
		
		member = MemberEntity
				.builder()
				.email(dto.getEmail())
				.password(dto.getPassword())
				.nickname(dto.getNickname())
				.telNumber(dto.getTelNumber())
				.address(dto.getAddress() + " " + dto.getAddressDetail())
				.build();
		
		// JpaRepository.save(Entity) 메서드
		// 해당 Entity Id가 데이터베이스 테이블에 존재하지 않으면!
		// Entity INSERT 작업을 수행
		// !!! 하지만 !!!
		// 해당 Entity Id가 데이터베이스 테이블에 존재하면!
		// 존재하는 Entity UPDATE 작업을 수행 
		memberRepository.save(member);
		
		return ResponseDto.setSuccess("회원가입에 성공했습니다.", new PostUserResponseDto(true));
	}
	
}
