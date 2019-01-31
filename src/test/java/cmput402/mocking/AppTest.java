package cmput402.mocking;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import service.City;
import stub.CityStub;
import stub.SalaryStub;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testCapitalizedNames() {
    	
    	assert("Abram Hindle".equals(Main.capitalizedNames("abram hindle")));
    }
    
    public void testFilterEdmonton() {
    	Util util = new Util();
    	CityStub stub = new CityStub();
    	assert(3 == util.filterEdmonton(stub));
    }
    
    public void testReturnSalaries() {
    	Util util = new Util();
    	SalaryStub stub = new SalaryStub();
    	assert(4 == util.filter50kSalary(stub));
    }
    
    public void testFilterEdmontonMockito() {
    	Util util = new Util();
    	City mockCity = mock(City.class);
    	List<String> cities  = new ArrayList<String>();
		cities.add("Toronto");
		cities.add("Edmonton");
		cities.add("Edmonton");
		cities.add("Calgary");
		
		List<String> cities2  = new ArrayList<String>();
		cities2.add("Toronto");
		cities2.add("Edmonton");
		cities2.add("Calgary");
		
		when(mockCity.listCities()).thenReturn(cities).thenReturn(cities2);
		
    	assert(2 == util.filterEdmonton(mockCity));
    	assert(1 == util.filterEdmonton(mockCity));
    	verify(mockCity, times(2)).listCities();
    }
}
