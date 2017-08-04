package dream.service.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.belms.dream.api.service.ServiceProvider;
import com.belms.dream.api.service.setup.SetupService;
import com.blems.dream.api.model.location.LocationGroup;

public class LocationGroupTest {

	private SetupService service;
	@Before
	public void setUp() throws Exception {
		service = (SetupService) ServiceProvider.getLookupService(SetupService.ID);
	}

//	@Test
	public void test() {
		LocationGroup group = new LocationGroup();
		group.setActiveFlag(true);
		group.setDescription("Phnom penhhead quater");
		group.setName("PHN");
		service.locationGroupCrudOper().add(group);
	}
	
	@Test
	public void testSelect() {
		LocationGroup group = service.locationGroupCrudOper().findById(1);
		System.out.println(group.getName());
	}

	
	@Test
	public void testSelectAll() {
		List<LocationGroup> groups = service.locationGroupCrudOper().findAll();
		System.out.println(groups.size());
	
	}
}
