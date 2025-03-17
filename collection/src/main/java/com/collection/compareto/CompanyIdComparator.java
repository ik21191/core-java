package com.collection.compareto;

import java.util.Comparator;

public class CompanyIdComparator implements Comparator<Company> {

	@Override
	public int compare(Company o1, Company o2) {
		return o1.getId() - o2.getId();
	}
}
