package dream.service.test;

import org.junit.Test;

import com.belms.dream.api.service.LookupService;
import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceIds;
import com.belms.dream.api.service.ServiceProvider;
import com.blems.dream.api.model.BasedModel.OPER;
import com.blems.dream.api.model.carrier.Carrier;
import com.blems.dream.api.model.common.ObjectStatus;
import com.blems.dream.api.model.currency.Currency;
import com.blems.dream.api.model.payment.PaymentTerm;
import com.blems.dream.api.model.ship.ShipTerm;
import com.blems.dream.api.model.tax.TaxRate;
import com.blems.dream.api.model.vendor.Vendor;

public class VendorTest {

	
	public void test() {
		ProcessingService<Vendor> vendorService = ServiceProvider.get(ServiceIds.DEFAULT_SERVICE_ID).setSubServiceId(ServiceIds.VENDOR_SERVICE_ID).getService();
		Vendor object = new Vendor();
		object.setOper(OPER.ADD);
		object.setActiveFlag(true);
		object.setCreditLimit(3000);
		object.setCurrency(new Currency(1, "USD", "USD"));
		object.setCurrencyRate(1);
		object.setDefaultCarrier(new Carrier(1, "Will "));
		object.setDefaultPaymentTerm(new PaymentTerm(1, "COD"));
		object.setDefaultShipTerm(new ShipTerm(10, "Prepaid & Billed"));
		object.setLeadTime(20);
		object.setMinQtyOrderAmount(100);
		object.setName("Vendor 1");
		object.setNote("Note");
		object.setStatus(new ObjectStatus(10));
		object.setTaxRate(new TaxRate(1));
		object.setUrl("url.com");
		vendorService.process(object);
		//object.set
	}
	@Test
	public void testSelect() {
		LookupService<Object, Vendor> vendorService = ServiceProvider.get(ServiceIds.DEFAULT_SERVICE_ID).setSubServiceId(ServiceIds.VENDOR_SERVICE_ID).getLookupService();
		Vendor vendor = vendorService.getDataItemById(2);
		System.out.println(vendor.getName());
	}
}
