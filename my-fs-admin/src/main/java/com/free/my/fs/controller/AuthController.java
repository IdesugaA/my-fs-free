package com.free.my.fs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.free.my.fs.common.domain.Result;
import com.free.my.fs.core.domain.dto.LoginBody;
import com.free.my.fs.core.service.UserService;

import cn.dev33.satoken.stp.StpUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class AuthController {

	private final UserService userService;
	
	// 登录页
	@GetMapping("/login")
	public String login() {
		if (StpUtil.isLogin()) {
			return "redirect:index";
		}
		return "login";
	}
	
	// 注册页
	@GetMapping("/reg")
	public String reg() {
		return "reg";
	}
	
	@PostMapping("/login")
	@ResponseBody
	public Result<?> login(@Valid @RequestBody LoginBody body) {
		if (userService.doLogin(body)) {
			return Result.ok("登录成功");
		}
		return Result.error("登陆失败");
	}
	
	@GetMapping("/logout")
	public String logout() {
		StpUtil.logout();
		return "redirect:login";
	}
	
	
	
}
