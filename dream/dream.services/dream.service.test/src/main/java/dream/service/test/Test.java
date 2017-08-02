package dream.service.test;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.customer.CustomerService;
import com.blems.dream.api.model.customer.Customer;

public class Test {
	public static void main(String[] args) throws SQLException {
		SqlSession session = ServiceProvider.newSession();
		
		CustomerService customerService = (CustomerService) ServiceProvider.getService(CustomerService.ID);
		
		List<Customer> customers = customerService.getAll(); 
		System.out.println(customers);
		
		System.out.println(session.getConnection().getCatalog().getBytes());
		
		session.close();
	}
}
