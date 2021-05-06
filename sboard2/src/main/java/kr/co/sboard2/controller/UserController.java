package kr.co.sboard2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.sboard2.service.UserService;
import kr.co.sboard2.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value = {"/", "/index"})
	public String index(HttpSession sess) {
		
		UserVo user = (UserVo) sess.getAttribute("suser");
		
		if(user ==  null) {
			return "forward:/user/login";
		}else {
			return "forward:/list";
		}
		
	}
	
	@GetMapping("/user/login")
	public String login() {
		return "/user/login";
	}
	@GetMapping("/user/terms")
	public String terms() {
		return "/user/terms";
	}
	@GetMapping("/user/register")
	public String register() {
		return "/user/register";
	}
	
	@PostMapping("/user/register")
	public String register(UserVo vo) {
		service.insertUser(vo);
		return "/user/register";
	}
}
