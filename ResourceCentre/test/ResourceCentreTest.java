import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;
	
	ArrayList<Camcorder> camcorderList = new ArrayList<Camcorder>();
	ArrayList<Chromebook> chromebookList = new ArrayList<Chromebook>();
	
	
	
	@Before
	 public void setUp() throws Exception{
		
		cc1 = new Camcorder("CC001", "Sony HDR-CX405", 35);
		cc2 = new Camcorder("CC002", "Panasonic HC-MDH2", 10);
		cb1 = new Chromebook("CB001", "ASUS Chromebook ", "Win 10");
		cb2 = new Chromebook("CB002", "HP Chromebook", "Win 10");
		
	}


	@Test
	void addCamcorderTest() {
		assertNotNull("Check if there is valid Camcorder arraylist to add to", camcorderList);
		ResourceCentre.addCamcorder(camcorderList, cc1);
		
		assertEquals("Check that Camcorder arraylist size is 1", 1, camcorderList.size());
		assertEquals("Check that Camcorder is added", cc1, camcorderList.get(0));
		
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Check that Camcorder arraylist size is 1", 2, camcorderList.size());
	}
	@Test
	void addChromebookTest() {
		fail("Not yet implemented");
	}
}
