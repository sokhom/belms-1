package dream.service.test;

import org.junit.Test;

import com.belms.dream.api.service.ProcessingService;
import com.belms.dream.api.service.ServiceIds;
import com.belms.dream.api.service.ServiceProvider;
import com.blems.dream.api.model.BasedModel.OPER;
import com.blems.dream.api.model.common.ObjectType;
import com.blems.dream.api.model.part.Part;
import com.blems.dream.api.model.uom.Uom;

public class PartTest {

	@Test
	public void addPart() {
		ProcessingService<Part> processingService = ServiceProvider.get(ServiceIds.DEFAULT_SERVICE_ID).setSubServiceId(ServiceIds.PART_SERVICE_ID).getService();
		
		Part part = new Part();
		part.setActiveFlag(true);
		part.setAlertNote("Note");
		part.setAlwaysManufactureFlag(false);
		part.setDescription("description");
		part.setDetails("details");
		part.setHeight(10);
		part.setLen(10);
		part.setName("Part 1");
		part.setNum("part 001");
		part.setOper(OPER.ADD);
		part.setPickedInUomFlag(true);
		part.setSizeUom(new Uom(1));
		part.setStdCost(10);
		part.setType(new ObjectType(10));
		part.setUom(new Uom(1));
		part.setUpc("UPC");
		part.setUrl("URL");
		part.setWeight(10);
		part.setWidth(10);
		part.setWeightUom(new Uom(1));
		
		processingService.process(part);
		
	}
}
