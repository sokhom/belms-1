package dream.service.test;

import org.junit.Before;
import org.junit.Test;

import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.setup.SetupService;
import com.blems.dream.api.model.common.ObjectType;
import com.blems.dream.api.model.location.Location;

public class LocationTest {

	private SetupService service;
	@Before
	public void setUp() throws Exception {
		service = (SetupService) ServiceProvider.getService(SetupService.ID);
	}

	@Test
	public void test() {
		Location location = new Location();
		location.setName("Front Store");
		location.setDefaultFlag(false);
		location.setDescription("Front Store");
		location.setPickable(true);
		location.setReceivable(false);
		location.setDefaultFlag(false);
		location.setAvailableForSale(true);
		location.setType(new ObjectType(70));
		service.locationCrudOper().add(location);
	}

}
