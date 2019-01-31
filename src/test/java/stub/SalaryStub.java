package stub;

import java.util.ArrayList;
import java.util.List;

import service.City;
import service.Salary;

public class SalaryStub implements Salary {

	public ArrayList<Integer> returnSalaries() {
		// TODO Auto-generated method stub
		ArrayList<Integer> salaries  = new ArrayList<Integer>();
		salaries.add(123456);
		salaries.add(78910);
		salaries.add(999);
		salaries.add(3847384);
		salaries.add(8349349);
		return salaries;
	}

}
