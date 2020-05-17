import org.junit.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class ResourceCentreTest {
	private Camcorder cc1;
	private Camcorder cc2;
	private Chromebook cb1;
	private Chromebook cb2;
	
	private ArrayList<Camcorder> camcorderList;
	private ArrayList<Chromebook> chromebookList;
	
	public ResourceCentreTest() {
		super();
	}
		
	
	@Before
	 public void setUp() throws Exception{
		
		cc1 = new Camcorder("CC0011", "Nikon HDSLR", 40);
		cc2 = new Camcorder("CC0012", "Sony DSC-RX100M7", 20);
		cb1 = new Chromebook("CB0011", "My Google Chromebook 1st ", "Mac OS");
		cb2 = new Chromebook("CB0012", "SAMSUNG Chromebook 4+", "Win 10");

		camcorderList= new ArrayList<Camcorder>();
		chromebookList= new ArrayList<Chromebook>();
	}
	
	@After
	 public void tearDown() throws Exception{
		cc1 = null;
		cc2 = null;
		cb1 = null;
		cb2 = null;
		camcorderList = null;
		chromebookList = null;
	}
	
	@Test
	public void addCamcorderTest() {

		assertNotNull("Check if there is valid Camcorder arraylist to add to", camcorderList);
		ResourceCentre.addCamcorder(camcorderList, cc1);
		
		assertEquals("Check that Camcorder arraylist size is 1", 1, camcorderList.size());
		assertEquals("Check that Camcorder is added", cc1, camcorderList.get(0));
		
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Check that Camcorder arraylist size is 2", 2, camcorderList.size());
	}
	@Test
	public void addChromebookTest() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void allCamcorderTest() {

		assertNotNull("Check if there is valid Camcorder arraylist to add to", camcorderList);
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Check that Camcorder arraylist size is 2", 2, camcorderList.size());
		
		String allCamcorder= ResourceCentre.allCamcorder(camcorderList);
		String testOutput = String.format("%-10s %-20s %-20s %-10s %-10s \n", "ASSET TAG", "DESCRIPTION", "OPTICAL ZOOM",
				"AVAILABLE", "DUE DATE");
		testOutput += String.format("%-10s %-20s %-20d %-10s %-10s \n","CC0011", "Nikon HDSLR", 40, "Yes", "");
		testOutput += String.format("%-10s %-20s %-20d %-10s %-10s \n","CC0012", "Sony DSC-RX100M7", 20, "Yes", "");
	
		assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
		
	}
	@Test
	public void allChromebookTest() {
		//fail("Not yet implemented");
	}

	@Test
	public void okLoanCamcorderTest() {
		assertNotNull("Check if there is valid Camcorder arraylist to add to", camcorderList);
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		cc2.setIsAvailable(false);
		
		Boolean ok = ResourceCentre.okLoanCamcorder(camcorderList, "CC0011", "8-8-2020" );
		assertTrue("Check that item is ok to loan?", ok);		
		
		ok = ResourceCentre.okLoanCamcorder(camcorderList, "CC0012", "8-8-2020" );
		assertFalse("Check that item is ok to loan?", ok);
		
		ok = ResourceCentre.okLoanCamcorder(camcorderList, "CC0013", "8-8-2020" );
		assertFalse("Check that item is ok to loan?", ok);
		
	}
	
	@Test
	public void okLoanChromebookTest() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void isReturnedCamcorderTest() {
		assertNotNull("Check if there is valid Camcorder arraylist to add to", camcorderList);
		ResourceCentre.addCamcorder(camcorderList, cc1);
		ResourceCentre.addCamcorder(camcorderList, cc2);
		cc2.setIsAvailable(false);
		
		Boolean isReturned = ResourceCentre.isReturnedCamcorder(camcorderList, "CC0011");
		assertFalse("Check that item is returned?", isReturned);		
		
		isReturned = ResourceCentre.isReturnedCamcorder(camcorderList, "CC0012");
		assertTrue("Check that item is returned", isReturned);
		
		isReturned = ResourceCentre.isReturnedCamcorder(camcorderList, "CC0013");
		assertFalse("Check that item is returned?", isReturned);
		
	}
	@Test
	public void isReturnedChromebookTest() {
		//fail("Not yet implemented");
	}
}
