/***
 * @author ngounphanny
 * 
 */

package com.belms.dream.repository.customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.belms.dream.api.dto.customer.CustomerInitDataWrapperDto;
import com.belms.dream.repository.common.AbstractRepo;
import com.belms.dream.repository.common.mapper.AccountMapper;
import com.belms.dream.repository.common.mapper.AddressMapper;
import com.belms.dream.repository.common.mapper.ContactMapper;
import com.belms.dream.repository.customer.mapper.CustomerMapper;
import com.blems.dream.api.model.account.Account;
import com.blems.dream.api.model.address.Address;
import com.blems.dream.api.model.address.Country;
import com.blems.dream.api.model.carrier.Carrier;
import com.blems.dream.api.model.carrier.CarrierService;
import com.blems.dream.api.model.contact.Contact;
import com.blems.dream.api.model.currency.Currency;
import com.blems.dream.api.model.customer.Customer;
import com.blems.dream.api.model.customer.CustomerStatus;
import com.blems.dream.api.model.payment.PaymentTerm;
import com.blems.dream.api.model.ship.ShipTerm;

public class CustomerRepo extends AbstractRepo<Customer> {

	public CustomerRepo(SqlSession session) {
		super(session);
	}

	List<Customer> customerList;

	public Customer getById(int id) {
		CustomerMapper customerMapper = getSqlSession().getMapper(CustomerMapper.class);
		return customerMapper.selectCustomerById(id);
	}

	
	public Customer add(Customer t) {
		
		try {
			
			AccountMapper accountMapper = getSqlSession().getMapper(AccountMapper.class);
			Account account = new Account();
			accountMapper.insert(account);
			t.setAccount(account);
			CustomerMapper customerMapper = getSqlSession().getMapper(CustomerMapper.class);
			customerMapper.insert(t);
			AddressMapper addressMapper = getSqlSession().getMapper(AddressMapper.class);
			ContactMapper contactMapper = getSqlSession().getMapper(ContactMapper.class);
			for (Address address : t.getAddresses()) {
				address.setAccount(account);
				addressMapper.insert(address);
				
				for (Contact contact: address.getContacts()) {
					contact.setAccount(account);
					contact.setAddress(address);
					contactMapper.insert(contact);
				}
				
			}
			getSqlSession().commit();
		}catch (Exception e) {
			getSqlSession().rollback();
			System.out.println(e);
		}finally {
			getSqlSession().close();
		}
		
		return t;
	}
	
	public List<Customer> getAll() {
		//initCustomerList();
		CustomerMapper customerMapper =  getSqlSession().getMapper(CustomerMapper.class);
		return customerMapper.selectAll();
	}

	public CustomerInitDataWrapperDto getInitData() {
		return createInitData();
	}

	private void initCustomerList() {
		if (customerList == null) {
			customerList = new ArrayList<Customer>();
			customerList.add(createCustomer(1, "Phanny co. ltd"));
			customerList.add(createCustomer(2, "Phanny1 co. ltd"));
			
			Customer customer = createCustomer(3, "Hello");
			customer.setAddresses(createAddresses());
			customerList.add(customer);
		}

	}

	private Customer createCustomer(int id, String name) {
		Customer customer = new Customer();
		customer.setId(id);
		customer.setActiveFlag(true);
		customer.setName(name);
		customer.setCreditLimit(0.0f);
		customer.setUrl("nagaworld.com");
		customer.setDateCreated(new Date());
		customer.setDateLastModified(new Date());
		customer.setAccount(new Account());
		customer.setCreditLimit(3000);
		customer.setCurrency(new Currency(2, "MXN", "Mexican Peso"));
		
		return customer;

	}

	private CustomerInitDataWrapperDto createInitData() {

		CustomerInitDataWrapperDto customerInitDataWrapperDto = new CustomerInitDataWrapperDto();

		customerInitDataWrapperDto.addCurrency(new Currency(1, "CAD", "Canadian Dollar"));
		customerInitDataWrapperDto.addCurrency(new Currency(2, "MXN", "Mexican Peso"));
		customerInitDataWrapperDto.addCurrency(new Currency(3, "JPY", "Japanese Yen"));
		customerInitDataWrapperDto.addCurrency(new Currency(4, "CNY", "Chinese Yuan Renminbi"));
		customerInitDataWrapperDto.addCurrency(new Currency(5, "AUD", "Australian Dollar"));
		customerInitDataWrapperDto.addCurrency(new Currency(6, "USD", "US Dollar"));

		customerInitDataWrapperDto.addStatus(new CustomerStatus(50, "Hold All"));
		customerInitDataWrapperDto.addStatus(new CustomerStatus(30, "Hold Sales"));
		customerInitDataWrapperDto.addStatus(new CustomerStatus(40, "Hold Shipment"));
		customerInitDataWrapperDto.addStatus(new CustomerStatus(10, "Normal"));
		customerInitDataWrapperDto.addStatus(new CustomerStatus(20, "Preferred"));

		customerInitDataWrapperDto.addPaymentTerm(new PaymentTerm(1, "COD"));
		customerInitDataWrapperDto.addPaymentTerm(new PaymentTerm(2, "CIA"));
		customerInitDataWrapperDto.addPaymentTerm(new PaymentTerm(3, "CCD"));
		customerInitDataWrapperDto.addPaymentTerm(new PaymentTerm(4, "NET 30"));

		customerInitDataWrapperDto.addShipTerm(new ShipTerm(10, "Prepaid & Billed"));
		customerInitDataWrapperDto.addShipTerm(new ShipTerm(10, "Prepaid"));
		customerInitDataWrapperDto.addShipTerm(new ShipTerm(30, "Freight Collect"));

		customerInitDataWrapperDto.addCarrier(new Carrier(1, "Will Call"));
		customerInitDataWrapperDto.addCarrier(new Carrier(2, "Delivery"));
		customerInitDataWrapperDto.addCarrier(new Carrier(8, "UPS"));
		customerInitDataWrapperDto.addCarrier(new Carrier(11, "FedEx"));
		customerInitDataWrapperDto.addCarrier(new Carrier(19, "USPS"));

		customerInitDataWrapperDto.addCarrierService(new CarrierService(1, "Next Day Air"));
		customerInitDataWrapperDto.addCarrierService(new CarrierService(2, "2nd Day Airr"));
		customerInitDataWrapperDto.addCarrierService(new CarrierService(3, "Ground"));
		customerInitDataWrapperDto.addCarrierService(new CarrierService(4, "3 Day Select"));
		customerInitDataWrapperDto.addCarrierService(new CarrierService(5, "Next Day Air Saver"));
		customerInitDataWrapperDto.addCarrierService(new CarrierService(6, "Next Day Air Early A.M."));
		customerInitDataWrapperDto.addCarrierService(new CarrierService(7, "2nd Day Air A.M."));

		return customerInitDataWrapperDto;

	}

	private List<Address> createAddresses() {

		List<Address> addresses = new ArrayList<Address>();

		Address address = new Address();
		address.setName("Phanny Co.LTD");
		address.setAddress("#434, st. 223 Sangkat Roka knong, Kan Doun Keo");
		address.setCity("Takeo");
		address.setCountry(new Country(1, "Cambodia"));

		addresses.add(address);

		address = new Address();
		address.setName("Phanny1 Co.LTD");
		address.setAddress("#434, st. 223 Sangkat Roka knong, Kan Doun Keo");
		address.setCity("Takeo");
		address.setCountry(new Country(1, "Cambodia"));

		addresses.add(address);

		return addresses;
	}

}
