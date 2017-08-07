package dream.service.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.belms.dream.api.dto.customer.CustomerInitDataWrapperDto;
import com.belms.dream.api.service.LookupService;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.customer.CustomerService;
import com.belms.dream.api.service.setup.SetupService;
import com.blems.dream.api.model.address.Address;
import com.blems.dream.api.model.address.Country;
import com.blems.dream.api.model.carrier.Carrier;
import com.blems.dream.api.model.carrier.CarrierService;
import com.blems.dream.api.model.common.ObjectStatus;
import com.blems.dream.api.model.common.ObjectType;
import com.blems.dream.api.model.contact.Contact;
import com.blems.dream.api.model.currency.Currency;
import com.blems.dream.api.model.customer.Customer;
import com.blems.dream.api.model.payment.PaymentTerm;
import com.blems.dream.api.model.ship.ShipTerm;

public class CustomerDataTest {
	
	private void saveCustomer() {
		CustomerService customerService = (CustomerService) ServiceProvider.getLookupService(CustomerService.ID);
		Customer customer = new Customer();
		customer.setActiveFlag(true);
		customer.setCarrierService(new CarrierService(1, "Next Day Air"));
		customer.setDefaultCarrier(new Carrier(1, "Will"));
		customer.setDefaultSalePersonId(1);
		customer.setDefaultShipTerm(new ShipTerm(10, "Prepaid & Billed"));
		customer.setDefaultPaymentTerm(new PaymentTerm(1, "COD"));
		customer.setCurrency(new Currency(1, "USD", "USD"));
		customer.setCreditLimit(1000);
		customer.setLastChangedUserId(1);
		
		customer.setName("Customer1");
		customer.setStatus(new ObjectStatus(10));
		customer.setToBeEmailed(true);
		customer.setToBePrinted(true);
		
		List<Address> addresses = new ArrayList<Address>();
		
		customer.setAddresses(addresses);
		
		Address address = new Address();
		addresses.add(address);
		address.setName("Customer1 address1");
		address.setAddress("St. 232, #323 , .. , ..");
		address.setCountry(new Country(61, "Cambodia"));
		address.setCity("Phnom Penh");
		address.setResidentialFlag(false);
		address.setDefaultFlag(true);
		address.setType(new ObjectType(10));
		
		List<Contact> contacts = new ArrayList<Contact>();
		
		Contact contact = new Contact();
		contacts.add(contact);
		contact.setName("contact1");
		contact.setContact("855923444");
		contact.setDefaultFlag(true);
		contact.setType(new ObjectType(10));
		address.setContacts(contacts);
		customerService.add(customer);
	}
	
	
	private Customer searchCustomer(int id) {
		
		LookupService<CustomerInitDataWrapperDto, Customer> lookupService = ServiceProvider.getLookupService(CustomerService.ID);
	
		CustomerService customerService = (CustomerService) ServiceProvider.getLookupService(CustomerService.ID);
		return customerService.getById(id);
	}
	
	public static void main(String[] args) throws SQLException {
		
		SetupService service = (SetupService) ServiceProvider.getLookupService(SetupService.ID);
		service.locationCrudOper().findById(1);
		
		CustomerDataTest customerDataTest = new CustomerDataTest();
//		customerDataTest.saveCustomer();
		
		Customer customer= customerDataTest.searchCustomer(9);
		
		System.out.println(customer.getName());
		
		System.out.println(customer.getDefaultCarrier());
		
		System.out.println(customer.getCarrierService());
		System.out.println(customer.getDefaultPaymentTerm());
		
		customer =  customerDataTest.searchCustomer(4);
		
		System.out.println(customer.getName());
	}
}
