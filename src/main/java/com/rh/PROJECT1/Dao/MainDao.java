package com.rh.PROJECT1.Dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.rh.PROJECT1.Entity.Country;
import com.rh.PROJECT1.Entity.Employee;
@Repository
public class MainDao {
	@Autowired
	SessionFactory factory;
	public String insertCountry(Country c) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(c);
			tx.commit();
			msg = "Country data saved successfully..";
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return msg;
	}
	public String updateCountry(int id, Country c) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Country record = session.get(Country.class, id);
			record.setCname(c.getCname());
			session.merge(record);
			tx.commit();
			msg = "Country data updated successfully.";
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return msg;
	}
	public String deleteCountry(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Country record = session.get(Country.class, id);
			record.getCid();
			session.remove(record);
			tx.commit();
			msg = "Country data deleted successfully..";
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return msg;
	}
	public Country fetchsingleCountry(int id) {
		Session session = null;
		Transaction tx = null;
		Country cn = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from Country where id=:countryid";
			Query<Country> query = session.createQuery(hqlQuery, Country.class);
			query.setParameter("countryid", id);
			cn = query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return cn;
	}
	public List<Country> fetchallCountry() {
		Session session = null;
		Transaction tx = null;
		List<Country> list  = null;
		String hqlQuery = "from Country";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query<Country> query = session.createQuery(hqlQuery, Country.class);
			list = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return list;
	}
	public String addEmployee(Employee e) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			 tx = session.beginTransaction();
			 session.persist(e);
			 tx.commit();
			 msg = "Employee data saved successfully";
		} catch (Exception e2) {
			if (tx!=null) {
				tx.rollback();
			}
			e2.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return msg;
	}
	public String updateEmployee(int id, Employee e) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Employee record = session.get(Employee.class, id);
			record.setName(e.getName());
			record.setPhone(e.getPhone());
			record.setDepartment(e.getDepartment());
			record.setStatus(e.getStatus());
			record.setCreateddate(e.getCreateddate());
			record.setCreatedby(e.getCreatedby());
			record.setUpdateddate(e.getUpdateddate());
			record.setUpdatedby(e.getUpdatedby());
			record.setCountry(e.getCountry());
			session.merge(record);
			tx.commit();
			msg = "Employee data updated successfully";
		} catch (Exception e2) {
			if (tx!=null) {
				tx.rollback();
			}
			e2.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return msg;
	}
	public String deleteEmployee(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Employee record = session.get(Employee.class, id);
			record.getId();
			session.remove(record);
			tx.commit();
			msg = "Employee data delete successfully";
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return msg;
	}
	public Employee getSingleEmployee(int id) {
		Session session = null;
		Transaction tx = null;
		Employee emp = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from Employee where id=:empid";
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("empid", id);
			emp = query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return emp;
	}
	public List<Employee> getAllEmployee() {
		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from Employee";
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			list = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return list;
	}
	public List<Employee> getEmployeebyStatus(String status) {
		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from Employee where status=:mystatus";
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("mystatus", status);
			list = query.list();
			tx.commit();
		} catch (Exception e) {
			if (tx!=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session!=null) {
				session.close();
			}
		}
		return list;
	}
}