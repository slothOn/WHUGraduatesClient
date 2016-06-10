package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;

import exception.SpringException;
import service.UserDao;

@Controller
public class LoginController {
	@Resource(name="userDao")
	private UserDao udao;
	public void setUserDao(UserDao udao){
		this.udao = udao;
	}
	
	@RequestMapping(value="/index")
	public String index(){
		return "index";	
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/user")
	public String login(@RequestParam String username, @RequestParam String password, @RequestParam String captcha, HttpSession session){
		if(captcha != null && captcha.equals(session.getAttribute(Constants.KAPTCHA_SESSION_KEY))){
			if(udao.checkUser(username, password)){		
				session.setAttribute("sid", username);
				return "redirect:mainpage.html";
			}
		}
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/logup")
	//@ExceptionHandler(value=SpringException.class)
	public ModelAndView logup(@RequestParam String sid, @RequestParam String sname, 
			@RequestParam String password, @RequestParam String captcha, HttpSession session){
		ModelAndView mav = new ModelAndView();
		String msg = null;
		if(captcha != null && captcha.equals(session.getAttribute(Constants.KAPTCHA_SESSION_KEY))){
			try{
				if(udao.insertUser(sid, sname, password)){
					System.out.println(sname);
					msg = "注册成功";
				}
			}catch(Exception e){
				msg = "注册失败，账号已存在";
			}		
		}else msg = "注册失败，验证码错误";
		mav.setViewName("index");
		mav.addObject("message", msg);
		return mav;
	}
	
	@RequestMapping(value="/logout")
	public void logout(@RequestParam String state, HttpSession session){
		session.setAttribute("sid", "");
		session.setAttribute("sname", "");
	}	
	
}
