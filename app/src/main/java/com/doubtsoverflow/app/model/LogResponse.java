package com.doubtsoverflow.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogResponse {
	private boolean success;
	private String username;
	private String token;
	private String message;
}
