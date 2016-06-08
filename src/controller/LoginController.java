package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.UserDao;

@Controller
public class LoginController {
	@Resource(name="userDao")
	private UserDao udao;
	public void setUserDao(UserDao udao){
		this.udao = udao;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/index")
	public String index(){
		return "index";	
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/user")
	public String login(@RequestParam String username, @RequestParam String password, HttpSession session){
		if(udao.checkUser(username, password)){		
			session.setAttribute("sid", username);
			return "redirect:mainpage.html";
		}return "index";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/logup")
	public String logup(@RequestParam String sid, @RequestParam String sname, 
			@RequestParam String password){
		if(udao.insertUser(sid, sname, password)){
			System.out.println("插入成功");
			return "index";
		}
		System.out.println("插入失败");
		return "index";
	}
}
