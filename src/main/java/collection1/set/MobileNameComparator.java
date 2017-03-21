package collection1.set;

import java.util.Comparator;

public class MobileNameComparator implements Comparator<Mobile> {

	@Override
	public int compare(Mobile m1, Mobile m2) {
		return m1.getName().compareTo(m2.getName());
	}

}
