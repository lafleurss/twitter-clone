
package com.cooksys.socialmedia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.socialmedia.services.ValidateService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/validate")
@RequiredArgsConstructor
public class ValidateController {
	private final ValidateService validateService;


	@GetMapping("/tag/exists/{label}")
	public boolean validateTagExistsByLabel(@PathVariable String label) {
		return validateService.validateTagExistsByLabel(label);
	}
	
	@GetMapping("/username/exists/@{username}")
	public boolean validateUserByUsername(@PathVariable String username) {
		return validateService.validateUserByUsername(username);
	}

	@GetMapping("/username/available/@{username}")
	public boolean validateUsernameAvailable(@PathVariable String username) {
		return validateService.validateUsernameAvailable(username);
	}
}
