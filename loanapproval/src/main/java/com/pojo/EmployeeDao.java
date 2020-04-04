package com.pojo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDao {

	private Configuration conf;
	private SessionFactory sf;
	private Session session;
	private Transaction tx;
	
	//register
	@SuppressWarnings("deprecation")
	public void saveData(Customer e) {
		
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		session.save(e);
		tx.commit();
	}
	
	
	//apply
		@SuppressWarnings("deprecation")
		public void apply(Customer e) {
			
			conf = new Configuration().configure("cts_hibernate.cfg.xml");
			sf = conf.buildSessionFactory();
			session = sf.openSession();
			tx= session.beginTransaction();
			session.save(e);
			tx.commit();
		}
	
	//login part
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public List login(String email, String pass) {
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		String sql="from Customer  as e where e.cemail=? and e.cpass=?";
		Query query1= session.createQuery(sql);
		query1.setParameter(0, email);
		query1.setParameter(1, pass);
		List list = query1.list();
		//list.add(email);
		return list;
	}
	
	
	//display data
	@SuppressWarnings("deprecation")
	public List displayData() {
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		List list = session.createQuery("from Customer").list();
		return list;
	}

	
	//login disp part
	public List getData(Customer e1) {
		List li = new ArrayList();
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		List list = session.createQuery("from Customer").list();
		Iterator it = list.iterator();
		while(it.hasNext())
		{
			Customer emp = (Customer)it.next();
			if( (e1.getCemail().equals(emp.getCemail())) && (e1.getCpass().equals(emp.getCpass())) )
			{
				Customer obj = new Customer();
				obj.setCust_id(emp.getCust_id());
				obj.setCname(emp.getCname());
				obj.setCaddress(emp.getCaddress());
				obj.setCloantype(emp.getCloantype());
				obj.setCemail(emp.getCemail());
				
				li.add(obj);
			}
			
		}
		return li;
		
	}

	
	
	//search data..
	public List searchData(Customer e) {
		List li = new ArrayList();
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		List list = session.createQuery("from Customer").list();
		Iterator it = list.iterator();
		while(it.hasNext())
		{
			Customer emp = (Customer)it.next();
			if(e.getCname().equalsIgnoreCase(emp.getCname()))
			{
				Customer obj = new Customer();
				obj.setCname(emp.getCname());
				obj.setCemail(emp.getCemail());
				obj.setCloantype(emp.getCloantype());
				obj.setCaddress(emp.getCaddress());
				li.add(obj);
			}
			
		}
		return li;
	}
	 //update data
	@SuppressWarnings("deprecation")
	public void updateData(Customer emp) {
		
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		Customer obj = (Customer) session.get(Customer.class, emp.getCust_id());
		 obj.setCemail(emp.getCemail());
		 obj.setCname(emp.getCname());
		 obj.setCaddress(emp.getCaddress());
		 session.update(obj);
		 tx.commit();
	}
	//delete data
	@SuppressWarnings("deprecation")
	public void deleteData(Customer emp) {
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		Customer obj = (Customer) session.get(Customer.class, emp.getCust_id());
		session.delete(obj);
		tx.commit();
		
		
	}

	
	
	//applying loan
		@SuppressWarnings("deprecation")
		public void ApplyData(Customer emp121) {
			
			conf = new Configuration().configure("cts_hibernate.cfg.xml");
			sf = conf.buildSessionFactory();
			session = sf.openSession();
			tx= session.beginTransaction();
			session.save(emp121);
			tx.commit();
		}
	
	
	
	
	
	

	
	// =========================================================================//
	//hod part
	
	public void saveManagerData(Manager e) {
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		session.save(e);
		tx.commit();
		
	}

	public List managerlogin(String email, String pass) {
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		String sql="from Manager  as e where e.memail=? and e.mpass=?";
		Query query1= session.createQuery(sql);
		query1.setParameter(0, email);
		query1.setParameter(1, pass);
		List list1 = query1.list();
		//list1.add(email);
		return list1;
	}

	@SuppressWarnings("deprecation")
	public List getManagerData(Manager e1) {
		List li = new ArrayList();
		conf = new Configuration().configure("cts_hibernate.cfg.xml");
		sf = conf.buildSessionFactory();
		session = sf.openSession();
		tx= session.beginTransaction();
		List list = session.createQuery("from Manager").list();
		Iterator it = list.iterator();
		while(it.hasNext())
		{
			Manager emp = (Manager)it.next();
			if( (e1.getMemail().equals(emp.getMemail())) && (e1.getMpass().equals(emp.getMpass())) )
			{
				Manager obj = new Manager();
				obj.setMid(emp.getMid());
				obj.setMname(emp.getMname());
				obj.setMaddress(emp.getMaddress());
				obj.setMemail(emp.getMemail());
				obj.setMdob(emp.getMdob());	
				li.add(obj);
			}
			
		}
		return li;
		
		
		
		
		
	}
	
	
	
	
	
		 //update data
		@SuppressWarnings("deprecation")
		public  void updateManagerData(Customer emp6) {
			
			conf = new Configuration().configure("cts_hibernate.cfg.xml");
			sf = conf.buildSessionFactory();
			session = sf.openSession();
			tx= session.beginTransaction();
			Customer obj = (Customer) session.get(Customer.class, emp6.getCust_id());
			 obj.setCemail(emp6.getCemail());
			 obj.setCname(emp6.getCname());
			 obj.setCaddress(emp6.getCaddress());
			 session.update(obj);
			 tx.commit();
	
		
		}
		
		
		//delete data
		@SuppressWarnings("deprecation")
		public void deleteManagerData(Customer emp) {
			conf = new Configuration().configure("cts_hibernate.cfg.xml");
			sf = conf.buildSessionFactory();
			session = sf.openSession();
			tx= session.beginTransaction();
			Customer obj = (Customer) session.get(Customer.class, emp.getCust_id());
			session.delete(obj);
			tx.commit();
			
			
		}
	}

	
	

