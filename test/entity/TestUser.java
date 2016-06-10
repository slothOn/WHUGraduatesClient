package entity;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.UserDao;
import service.impl.UserDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:WHUGraduatesClient-servlet.xml"})
public class TestUser extends AbstractTransactionalJUnit4SpringContextTests{
	@Resource(name="userDao")
	private UserDao udao;
	@Test
	public void checkTest(){
		if(udao.checkUser("2012301130118", "wudazihuan") != null){
			System.out.println("登录成功");
		}else System.out.println("登录失败");
	}
	
	public void checkInsert(){
		
	}
}
