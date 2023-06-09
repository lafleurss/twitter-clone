
package com.cooksys.socialmedia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.socialmedia.dto.CredentialsDto;
import com.cooksys.socialmedia.dto.ProfileDto;
import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.dto.UserRequestDto;
import com.cooksys.socialmedia.dto.UserResponseDto;
import com.cooksys.socialmedia.entity.Credentials;
import com.cooksys.socialmedia.entity.Profile;
import com.cooksys.socialmedia.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
	private final UserService userService;

	@GetMapping
	public List<UserResponseDto> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/@{username}")
	public UserResponseDto getUserByUsername(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}

	@PostMapping
	public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
		return userService.createUser(userRequestDto);
	}

	@PatchMapping("/@{username}")
	public UserResponseDto updateUsername(@PathVariable String username, @RequestBody UserRequestDto userRequestDto) {
		return userService.updateUsername(username, userRequestDto);
	}

	@DeleteMapping("/@{username}")
	public UserResponseDto deleteUserByUsername(@PathVariable String username, @RequestBody Credentials credentials) {
		return userService.deleteUserByUsername(username, credentials);
	}

	@GetMapping("/@{username}/mentions")
	public List<TweetResponseDto> getAllTweetsByMentions(@PathVariable String username) {
		return userService.getAllTweetsByMentions(username);
	}

	@GetMapping("/@{username}/followers")
	public List<UserResponseDto> getAllFollowers(@PathVariable String username) {
		return userService.getAllFollowers(username);
	}

	@GetMapping("/@{username}/following")
	public List<UserResponseDto> getAllFollowing(@PathVariable String username) {
		return userService.getAllFollowing(username);
	}

	@GetMapping("/@{username}/tweets")
	public List<TweetResponseDto> getAllTweetsByUsername(@PathVariable String username) {
		return userService.getAllTweetsByUsername(username);
	}

	@GetMapping("/@{username}/feed")
	public List <TweetResponseDto> getFeedByUsername(@PathVariable String username) {
		return userService.getFeedByUsername(username);

	}

	@PostMapping("/@{username}/follow")
	public void followUserByUsername(@PathVariable String username, @RequestBody Credentials credentials) {
		userService.followUserByUsername(username, credentials);
	}

	@PostMapping("/@{username}/unfollow")
	public void unfollowUserByUsername(@PathVariable String username, @RequestBody Credentials credentials) {
		userService.unfollowUserByUsername(username, credentials);
	}
}
