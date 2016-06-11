package controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;

import entity.User;
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
	public ModelAndView login(@RequestParam String username, @RequestParam String password, @RequestParam String captcha, HttpSession session){
		ModelAndView mav = new ModelAndView();
		String msg = null;
		if(captcha != null && captcha.equals(session.getAttribute(Constants.KAPTCHA_SESSION_KEY))){
			List list = udao.checkUser(username, password);
			if(list != null && list.size() > 0){		
				User u = (User) list.get(0);
				session.setAttribute("sid", username);
				session.setAttribute("sname", u.getSname());
				mav.setViewName("redirect:mainpage.html");
				return mav;
			}
			msg = "账户名或密码错误";
		}else msg = "验证码错误";
		mav.setViewName("index");
		mav.addObject("message", msg);
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/logup")
	public void logup(@RequestBody String requestbody, HttpServletResponse response, HttpSession session) throws IOException{
		String requeststr = URLDecoder.decode(requestbody);
		System.out.println(requeststr);
		JSONObject jsobj = new JSONObject(requeststr);
		String sid = (String)jsobj.get("sid");
		String sname = (String)jsobj.get("sname");
		String password = (String)jsobj.get("password");
		String captcha = (String)jsobj.get("captcha");
		String msg = null;
		if(captcha != null && captcha.equals(session.getAttribute(Constants.KAPTCHA_SESSION_KEY))){
			try{
				if(udao.insertUser(sid, sname, password)){
					msg = "0";
				}
			}catch(Exception e){
				msg = "1";
			}		
		}else msg = "2";
		response.getWriter().write(msg);
		response.getWriter().flush();
	}
	
	@RequestMapping(value="/logout")
	public void logout(@RequestParam String state, HttpSession session){
		session.setAttribute("sid", "");
		session.setAttribute("sname", "");
	}	
	
}
