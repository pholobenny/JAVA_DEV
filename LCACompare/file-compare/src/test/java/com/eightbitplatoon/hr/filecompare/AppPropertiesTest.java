/**
 * 
 */
package com.eightbitplatoon.hr.filecompare;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author gregf
 *
 */
public class AppPropertiesTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.eightbitplatoon.hr.filecompare.AppProperties#readProperty(java.lang.String)}.
	 */
	@Test
	public void testReadProperty() {
        AppProperties app = new AppProperties();
        String propertyName = "Property1";
        String value = app.readProperty(propertyName);
		System.out.println("Property::"+propertyName+"="+value);
		assertEquals("Value1", app.readProperty("Property1"));
	}

}
