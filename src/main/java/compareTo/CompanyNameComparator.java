package compareTo;

import java.util.Comparator;

public class CompanyNameComparator implements Comparator<Company> {

	@Override
	public int compare(Company o1, Company o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
}
