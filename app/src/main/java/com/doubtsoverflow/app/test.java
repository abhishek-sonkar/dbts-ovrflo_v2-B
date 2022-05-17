package com.doubtsoverflow.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class test {
	@RequestMapping("/test")
	public String handler() {
		return "testing";
	}

}
