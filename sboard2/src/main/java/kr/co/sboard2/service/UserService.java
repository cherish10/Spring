package kr.co.sboard2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sboard2.dao.UserDao;
import kr.co.sboard2.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	
	public void insertUser(UserVo vo) {
		dao.insertUser(vo);
	}
}
