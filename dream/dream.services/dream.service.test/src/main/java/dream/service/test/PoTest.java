package dream.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceIds;
import com.belms.dream.api.service.ServiceProvider;
import com.blems.dream.api.model.BasedModel.OPER;
import com.blems.dream.api.model.address.Country;
import com.blems.dream.api.model.carrier.Carrier;
import com.blems.dream.api.model.common.ObjectStatus;
import com.blems.dream.api.model.common.ObjectType;
import com.blems.dream.api.model.currency.Currency;
import com.blems.dream.api.model.location.LocationGroup;
import com.blems.dream.api.model.part.Part;
import com.blems.dream.api.model.payment.PaymentTerm;
import com.blems.dream.api.model.po.Po;
import com.blems.dream.api.model.po.PoItem;
import com.blems.dream.api.model.ship.ShipTerm;
import com.blems.dream.api.model.uom.Uom;
import com.blems.dream.api.model.vendor.Vendor;

public class PoTest {
	private ProcessingService<Po> service;
	@Before
	public void setUp() throws Exception {
		service =  ServiceProvider.getProcessingService(ServiceIds.PO_SERVICE_ID);
	}

	@Test
	public void test() {
		
		Po po = new Po();
		
//		po.setNum("PO-001");
//		LocationGroup group = new LocationGroup();
//		group.setId(10);
//		po.setStatus(new ObjectStatus(1));
//		
//		po.setLocationGroup(group);
//		po.setCurrency(new Currency(1, "USD", "US Dollar"));
//		po.setCurrencyRate(1);
//		po.setCustomerSo(null);
//		po.setVendorSo(null);
//		
//		po.setBuyerId(1);
//		
//		Carrier carrier = new Carrier(1, "Will");
//		po.setCarrier(carrier);
//		
//		po.setPaymentTerm(new PaymentTerm(1, "COD"));
//		
//		po.setVendor(new Vendor(2));
//		po.set
//		
		po.setBuyerId(1);
		po.setCarrier(new Carrier(1, "Will"));
		po.setCurrency(new Currency(1, "USD", "USD"));
		po.setCurrencyRate(1);
		po.setCustomerSo("Customer SO");
		po.setLocationGroup(new LocationGroup(2));
		po.setNum(1);
		po.setOper(OPER.ADD);
		po.setPaymentTerm(new PaymentTerm(1, "COD"));
		po.setShipTerm(new ShipTerm(10, "Prepaid & Billed"));
		po.setShipToAddress("ship to address");
		po.setShipToCity("ship to city");
		po.setShipToCountry(new Country(1, "US"));
		po.setStatus(new ObjectStatus(10));
		po.setVendor(new Vendor(2));
		po.setVendorAddress("Vendor to address");
		po.setVendorCity("Vendor to city");
		po.setVendorContact("vendor contact");
		po.setVendorCountry(new Country(1, "USD"));
		po.setVendorSo("Vendor SO");
		po.setVendorZip("vendor zip");
		
		
		List<PoItem> items = new ArrayList<>();
	
		po.setItems(items);
		
		PoItem item = new PoItem();
		items.add(item);
		
		item.setDescription("Part1");
		item.setOper(OPER.ADD);
		item.setPart(new Part());
		item.setPo(po);
		item.setNote("Note");
		item.setPartNum("part001");
		item.setQtyToFulfill(10);
		item.setRepairFlag(false);
		item.setSeq(1);
		item.setStatus(new ObjectStatus(10)); //enter
		item.setUnitCost(10.1);
		item.setTotalCost(10.10);
		item.setType(new ObjectType(10)); //purchase
		item.setVendorPartNum("v-part-0001");
		item.setUom(new Uom(1));
	
		
		service.process(po);
	}
}
