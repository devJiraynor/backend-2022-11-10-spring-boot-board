package com.jihoon.board.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponseDto {
	private String email;
	private String nickname;
	private String profile;
	private String telNumber;
	private String address;
}
