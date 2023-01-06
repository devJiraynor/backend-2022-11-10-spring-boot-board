package com.jihoon.board.service;

import org.springframework.stereotype.Service;

import com.jihoon.board.dto.auth.AuthPostDto;
import com.jihoon.board.dto.auth.LoginDto;

import com.jihoon.board.dto.response.ResponseDto;

// @Serivce : 해당 클래스가 Serivce 레이어 역할을 함
@Service
public class AuthService {
	
	public ResponseDto<LoginDto> login(AuthPostDto dto) {
		LoginDto result = new LoginDto("JWT", 3600000);
		return ResponseDto.setSuccess("", result);
	}

}








