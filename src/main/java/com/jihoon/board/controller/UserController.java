package com.jihoon.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jihoon.board.dto.response.ResponseDto;
import com.jihoon.board.dto.user.PostUserDto;
import com.jihoon.board.dto.user.PostUserResponseDto;
import com.jihoon.board.service.UserService;

@RestController
@RequestMapping("api/user/")
public class UserController {
	
	// auto
	@Autowired UserService userService;

	@PostMapping("")
	public ResponseDto<PostUserResponseDto> postUser(@RequestBody PostUserDto requestBody) {
		return userService.postUser(requestBody);
	}
	
}










