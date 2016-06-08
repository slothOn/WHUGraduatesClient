package controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import entity.Student_info;
import entity.Student_job;
import entity.Student_school;
import service.Student_infoDao;
import service.Student_jobDao;
import service.Student_schDao;

@Controller
public class StudentController {
	@Resource(name="studentinfoDao")
	private Student_infoDao studao;
	@Resource(name="studentschDao")
	private Student_schDao schdao;
	@Resource(name="studentjobDao")
	private Student_jobDao jobdao;
	
	public void setStudent_infoDao(Student_infoDao studao){
		this.studao = studao;
	}
	@RequestMapping(value="/mainpage")
	public ModelAndView mainpage(HttpSession session){
		ModelAndView mav = new ModelAndView();
		String sid = (String) session.getAttribute("sid");
		Student_info studentinfo = studao.getStudentinfoBysid(sid);
		session.setAttribute("sname", studentinfo.getSname());
		mav.setViewName("mainpage");
		mav.addObject("student", studentinfo);
		return mav;
	}
	@RequestMapping(value="/editinfo")
	public void addorupdate(Student_info stu, HttpServletResponse response) throws IOException{
		if(studao.saveorupdateStudentinfo(stu)){
			response.getWriter().write("0");
		}else response.getWriter().write("1");
		response.getWriter().flush();
	}
	
	@RequestMapping(value="/studentsch")
	public ModelAndView studentsch(HttpSession session){
		ModelAndView mav = new ModelAndView();
		String sid = (String) session.getAttribute("sid");
		List<Student_school> list = schdao.getschoollistBySid(sid);
		mav.setViewName("studentsch");
		mav.addObject("schoollist", list);
		return mav;
	}
	
	@RequestMapping(value="/studentjob")
	public ModelAndView studentjob(HttpSession session){
		ModelAndView mav = new ModelAndView();
		String sid = (String) session.getAttribute("sid");
		List<Student_job> list = jobdao.getjoblistBySid(sid);
		mav.setViewName("studentjob");
		mav.addObject("joblist", list);
		return mav;
	}
	
	@RequestMapping(value="/editschool")
	public void editschool(@RequestBody String requestbody, HttpServletResponse response, HttpSession session)  throws IOException{
		String sid = (String) session.getAttribute("sid");
		String sname = (String) session.getAttribute("sname");
		String requeststr = URLDecoder.decode(requestbody);
		JSONArray jsonarr = new JSONArray(requeststr);
		//System.out.println(requeststr);
		List<Student_school> slist = new ArrayList<Student_school>();
		for(int i = 0; i < jsonarr.length(); i++){
			JSONObject jsobj = jsonarr.getJSONObject(i);
			Student_school stusch = 
			new Student_school(0, sid, sname, (String)jsobj.get("activity"), (String)jsobj.get("honor"), 
			(String)jsobj.get("startyear"), (String)jsobj.get("endyear"));
			slist.add(stusch);
		}
		if(schdao.deleteAndUpdate(sid, slist)){
			response.getWriter().write("0");
		}else response.getWriter().write("1");
		response.getWriter().flush();
	}
	
	@RequestMapping(value="/editjob")
	public void editjob(@RequestBody String requestbody, HttpServletResponse response, HttpSession session)  throws IOException{
		String sid = (String) session.getAttribute("sid");
		String sname = (String) session.getAttribute("sname");
		String requeststr = URLDecoder.decode(requestbody);
		JSONArray jsonarr = new JSONArray(requeststr);
		List<Student_job> jlist = new ArrayList<Student_job>();
		for(int i = 0; i < jsonarr.length(); i++){
			JSONObject jsobj = jsonarr.getJSONObject(i);
			Student_job stujob = 
			new Student_job(0, sid, sname, (String)jsobj.get("time"), (String)jsobj.get("type"), (String)jsobj.get("cname"), 
					(String)jsobj.get("job"), (String)jsobj.get("comment"));
			jlist.add(stujob);
		}
		if(jobdao.deleteAndUpdate(sid, jlist)){
			response.getWriter().write("0");
		}else response.getWriter().write("1");
		response.getWriter().flush();
	}
}
