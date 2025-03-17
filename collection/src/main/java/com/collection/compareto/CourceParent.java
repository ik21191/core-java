package com.collection.compareto;

import java.util.Comparator;

public class CourceParent extends Cource implements Comparator<Cource> {
	public int compare(Cource o1, Cource o2) {
		if("desc_id".equalsIgnoreCase(getSortBy()))
			return o2.id-o1.id;
		else if("asc_name".equalsIgnoreCase(getSortBy()))
			return o1.name.compareTo(o2.name);
		else if("desc_name".equalsIgnoreCase(getSortBy()))
			return o2.name.compareTo(o1.name);
		else
			return o1.id-o2.id;
	}
}
