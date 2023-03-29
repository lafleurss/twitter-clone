package com.cooksys.socialmedia.dto;

import java.sql.Timestamp;

import com.cooksys.socialmedia.entity.Credentials;
import com.cooksys.socialmedia.entity.Profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseDto {

	//private Credentials credentials;

	private String username;

	private Profile profile;

	private Timestamp joined;

}
