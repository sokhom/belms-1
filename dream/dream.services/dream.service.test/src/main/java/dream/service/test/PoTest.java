package dream.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.belms.dream.api.dto.customer.po.PoInitDataWrapperDto;
import com.belms.dream.api.dto.part.PartInitWrapperDto;
import com.belms.dream.api.service.LookupService;
import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceIds;
import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.action.Action;
import com.blems.dream.api.model.BasedModel.OPER;
import com.blems.dream.api.model.address.Country;
import com.blems.dream.api.model.carrier.Carrier;
import com.blems.dream.api.model.common.ObjectStatus;
import com.blems.dream.api.model.currency.Currency;
import com.blems.dream.api.model.location.LocationGroup;
import com.blems.dream.api.model.part.Part;
import com.blems.dream.api.model.payment.PaymentTerm;
import com.blems.dream.api.model.po.Po;
import com.blems.dream.api.model.po.PoItem;
import com.blems.dream.api.model.ship.ShipTerm;
import com.blems.dream.api.model.vendor.Vendor;

public class PoTest {
	private ProcessingService<Po> service;
	private LookupService<PartInitWrapperDto, Part> partLookupService;
	private LookupService<PoInitDataWrapperDto, Po> poLookupService;

	@Before
	public void setUp() throws Exception {
		service = ServiceProvider.getProcessingService(ServiceIds.PO_SERVICE_ID);
		partLookupService = ServiceProvider.get(ServiceIds.DEFAULT_SERVICE_ID)
				.setSubServiceId(ServiceIds.PART_SERVICE_ID).getLookupService();
		poLookupService = ServiceProvider.getLookupService(ServiceIds.PO_SERVICE_ID);
	}

	public void test() {
		List<Action> actions = service.getValidActions(null, right -> true);
		Action action = getAction(actions, "PO.SAVE");

		Po po = new Po();
		po.setBuyerId(1);
		po.setCarrier(new Carrier(1, "Will"));
		po.setCurrency(new Currency(1, "USD", "USD"));
		po.setCurrencyRate(1);
		po.setCustomerSo("Customer SO");
		po.setLocationGroup(new LocationGroup(1));
		po.setNum(2);
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

		PoItem item = createPoItem(1); // new PoItem();
		items.add(item);
		item.setPo(po);
		item.setNote("Note");
		item.setQtyToFulfill(20);
		item.setSeq(1);
		item.setUnitCost(10.1);
		item.calc();
		service.setAction(action).process(po);
	}

	
	public void testSave() {
		Po po = poLookupService.getDataItemById(1);

		List<Action> actions = service.getValidActions(po, right -> true);
		Action action = getAction(actions, "PO.SAVE");
		po.setOper(OPER.EDIT);
		po.setShipToCity("shipToCity 1111");
		PoItem poItem = po.getItems().get(0);
		poItem.setQtyToFulfill(poItem.getQtyToFulfill() + 1);
		poItem.setOper(OPER.EDIT);
		poItem.calc();
		service.setAction(action).process(po);
		System.out.println(po);
	}

	private PoItem createPoItem(int partId) {
		try {
			Part part = partLookupService.getDataItemById(partId);
			PoItem item = new PoItem();
			item.initData(part);
			return item;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Test
	public void issue() {
		Po po = poLookupService.getDataItemById(1);
		List<Action> actions = service.getValidActions(po, right -> true);
		Action action = getAction(actions, "PO.ISSUE");
		service.setAction(action).process(po);
		System.out.println(po);
	}
	
	private Action getAction(List<Action> actions, String actionId) {
		for (Action action : actions) {
			if (actionId.equalsIgnoreCase(action.getActionId())) {
				return action;
			}
		}

		return null;
	}
}
