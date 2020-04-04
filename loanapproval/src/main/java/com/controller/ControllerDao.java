package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pojo.Customer;
import com.pojo.EmployeeDao;
import com.pojo.Manager;


@Controller
public class ControllerDao {

	private ApplicationContext conn;

	@RequestMapping("/register1")
	public String view2(Model m )
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Customer  emp = conn.getBean("info", Customer.class);
		m.addAttribute("bean",emp);
		return "register";
	}

	
	
	
	
	@RequestMapping("/apply")
	public String view21(Model m )
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Customer  emp = conn.getBean("info", Customer.class);
		m.addAttribute("bean",emp);
		return "apply";
	}


	@RequestMapping("/save")
	public String view3(@ModelAttribute("bean") Customer e,Model m )
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
		obj.saveData(e);
		m.addAttribute("msg", "record inserted....");
		return "register";
	}


	//display

	@RequestMapping("/display")	
	public String view191(Model m, HttpServletRequest request)
	{		
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		HttpSession session = request.getSession();
		Customer use = (Customer)session.getAttribute("sdata");
		//if(!use.getFemail().isEmpty()) {
		if(use.getFlag()==1) {
			EmployeeDao  obj = conn.getBean("dao", EmployeeDao.class);
			List list  = obj.displayData();
			if(!list.isEmpty())
			{
				m.addAttribute("data",list);
			}
			else {
				m.addAttribute("msg", "no data found..");
			}
			return "display";
		}
		else {
			m.addAttribute("msg", "Login First..");
			return "redirect:index.jsp";	
		}
	}

	//login

	@RequestMapping("/login1")
	public String view51(Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Customer  obj = conn.getBean("info", Customer.class);
		m.addAttribute("bean",obj);
		return "login";
	}

	@RequestMapping("/logindata")
	public String login21(@ModelAttribute("bean") Customer  obj ,HttpServletRequest request,Model m) {
		
		obj.setCemail(request.getParameter("cemail"));
		obj.setCpass(request.getParameter("cpass"));
		String email = obj.getCemail();
		String pass = obj.getCpass();
		EmployeeDao  obj1 =  new EmployeeDao();

		List list = obj1.login(email,pass);
		if((list!=null) && (list.size()>0))
		{
			//my part
			conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			EmployeeDao obj2 = conn.getBean("dao", EmployeeDao.class);
			Customer e1 = new Customer();
			e1.setCemail(email);
			e1.setCpass(pass);
			
			List list22 = obj2.getData(e1);
			if(!list22.isEmpty())
			{
				m.addAttribute("li2", list22);
				Customer e11 = new Customer();
				e11.setCemail(email);
				e11.setFlag(1);
				
				HttpSession session = request.getSession();
				session.setAttribute("sdata", e11);
				return "home";				
			}

			//till here
		}
		else{
			m.addAttribute("msg","login failed.try again..");

		}
		//return "redirect:index.jsp";	
		return "login";

	}

	//logout
	@RequestMapping("/logout1")
	public String logout(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Customer obj = (Customer)session.getAttribute("sdata");
		obj.setCemail(null);
		obj.setFlag(0);
		System.out.println("now:" + obj.getCemail());
		return "redirect:index.jsp";
	}


	
	//search
	@RequestMapping("/find")
	public String view33(Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Customer  emp = conn.getBean("info", Customer.class);
		m.addAttribute("bean",emp);
		return "search";
	}

	@RequestMapping("/search1")
	public String view34(@ModelAttribute("bean") Customer e,Model m,HttpServletRequest request)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		HttpSession session = request.getSession();
		Customer use = (Customer)session.getAttribute("sdata");
		if(use.getFlag()==1) {
		EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
		List list = obj.searchData(e);
		if(!list.isEmpty())
		{
			m.addAttribute("li", list);
		}
		else {
			m.addAttribute("msg1","no record found..");
		}
		return "search";
	}
		else
		{
			m.addAttribute("msg1","login first..");
			return "redirect:index.jsp";
		}
	}

	//update
	@RequestMapping("/update1")
	public String view314(@ModelAttribute("bean") Customer emp, Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
		obj.updateData(emp);
		m.addAttribute("msg2", "Successfully Updated..");

		return "home";


	}

	//delete
	@RequestMapping("/delete1")
	public String view7(@ModelAttribute("bean") Customer emp, Model m,HttpServletRequest request)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
		//obj.deleteData(emp);
		obj.deleteData(emp);
		m.addAttribute("msg3", "Successfully Deleted Entry..");
		HttpSession session = request.getSession();
		Customer obj1 = (Customer)session.getAttribute("sdata");
		obj1.setCemail(null);
		obj1.setFlag(0);
		m.addAttribute("msg","Record Deleted... SignUp or SIgnIn now.");
		return "login";
		//return "home";

	}



	//apply
		@RequestMapping("/apply11")
		public String view3143(@ModelAttribute("bean") Customer emp121, Model m)
		{
			conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
			obj.ApplyData(emp121);
			m.addAttribute("msg5", "You have applied successfully, We will inform you soon aboud approval");

			return "home";


		}











	// =========================================================================//
	//hod part

	//register
	@RequestMapping("/hregister")
	public String view27(Model m )
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Manager  emp = conn.getBean("info1", Manager.class);
		m.addAttribute("bean",emp);
		return "managerregister";
	}

	@RequestMapping("/hsave")
	public String view43(@ModelAttribute("bean") Manager e,Model m )
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
		obj.saveManagerData(e);
		m.addAttribute("msg", "Manager record inserted....");
		return "managerregister";
	}



	//login	
	@RequestMapping("/hlogin1")
	public String view561(Model m)
	{
		conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		Manager  emp = conn.getBean("info1", Manager.class);
		m.addAttribute("bean",emp);
		return "managerlogin";
	}

	@RequestMapping("/managerlogindata")
	public String login261(@ModelAttribute("bean") Manager  obj ,HttpServletRequest request,HttpServletResponse response,Model m) {

		obj.setMemail(request.getParameter("memail"));
		obj.setMpass(request.getParameter("mpass"));
		String email = obj.getMemail();
		String pass = obj.getMpass();
		EmployeeDao  obj1 =  new EmployeeDao();

		List list = obj1.managerlogin(email,pass);
		if((list!=null) && (list.size()>0))
		{
			//my part
			conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			EmployeeDao obj2 = conn.getBean("dao", EmployeeDao.class);
			Manager e1 = new Manager();
			e1.setMemail(email);
			e1.setMpass(pass);
			
			List list22 = obj2.getManagerData(e1);
			if(!list22.isEmpty())
			{
				m.addAttribute("li2", list22);
				Manager e11 = new Manager();
				e11.setMemail(email);
				e11.setHflag(1);
				
				HttpSession session = request.getSession();
				session.setAttribute("shdata", e11);
				return "managerhome";				
			}

			//till here
		}
		else{
			m.addAttribute("msg","login failed,please try again..........");

		}
		//return "redirect:index.jsp";	
		return "managerlogin";
	}
	
	
	
	
	
	
	//update
	@RequestMapping("/hupdate1")
	//update

		public String view3144(@ModelAttribute("bean") Customer emp6, Model m)
		{
			conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
			obj.updateManagerData(emp6);
			m.addAttribute("msg2", "Successfully Updated..");

			return "managerhome";


		}

	
	
	//delete
		@RequestMapping("/hdelete1")
		public String view71(@ModelAttribute("bean") Customer emp, Model m,HttpServletRequest request)
		{
			conn = new ClassPathXmlApplicationContext("ApplicationContext.xml");
			EmployeeDao obj = conn.getBean("dao", EmployeeDao.class);
			//obj.deleteData(emp);
			obj.deleteManagerData(emp);
			m.addAttribute("msg3", "Successfully Deleted Entry..");
			HttpSession session = request.getSession();
			Customer obj1 = (Customer)session.getAttribute("sdata");
			obj1.setCemail(null);
			obj1.setFlag(0);
			m.addAttribute("msg","Record Deleted... SignUp or SIgnIn now.");
			return "login";
			//return "home";

		}
	
	

    //hod logout part..
	@RequestMapping("/hlogout1")
	public String hodlogout(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Manager obj = (Manager)session.getAttribute("shdata");
		obj.setMemail(null);
		obj.setHflag(0);
		//System.out.println("now:" + obj.getHemail());
		return "redirect:managerhome.jsp";
	}

}


