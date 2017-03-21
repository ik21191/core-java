package mpsTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SortList {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public static void main(String[] args) throws Exception{
		
		
		Date s1 = sdf.parse("2016-01-01");
		Date e1 = sdf.parse("2016-07-31");
		
		Date s2 = sdf.parse("2016-01-01");
		Date e2 = sdf.parse("2016-07-31");
		
		Date s3 = sdf.parse("2016-02-01");
		Date e3 = sdf.parse("2016-03-31");
		
		Date s4 = sdf.parse("2016-03-01");
		Date e4 = sdf.parse("2016-04-30");
		
		Date s5 = sdf.parse("2016-04-01");
		Date e5 = sdf.parse("2016-09-30");	
		
		Date s6 = sdf.parse("2016-04-01");
		Date e6 = sdf.parse("2016-09-29");	
		
		Date s7 = sdf.parse("2016-04-01");
		Date e7 = sdf.parse("2016-10-30");
		
		
		LicenseBean l1 = new LicenseBean("A",e1,s1);
		LicenseBean l2 = new LicenseBean("A",e2,s2);
		LicenseBean l3 = new LicenseBean("A",e3,s3);
		LicenseBean l4 = new LicenseBean("A",e4,s4);
		LicenseBean l5 = new LicenseBean("A",e5,s5);
		LicenseBean l6 = new LicenseBean("A",e6,s6);
		LicenseBean l7 = new LicenseBean("A",e7,s7);
		
		List<LicenseBean> sourceList = new ArrayList<LicenseBean>();
		sourceList.add(l1);
		sourceList.add(l2);
		sourceList.add(l3);
		sourceList.add(l4);
		sourceList.add(l5);
		sourceList.add(l6);
		sourceList.add(l7);
		ArrayList<LicenseBean> tempList = new ArrayList<LicenseBean>(sourceList);
		ArrayList<LicenseBean> latestList = new ArrayList<LicenseBean>();
		List<Integer> indexToRemove = new ArrayList<Integer>();
		for (int i = 0; i < sourceList.size(); i++) {
			Date targetStart = sdf.parse(sdf.format(sourceList.get(i).getStartDate()));
			Date targetEnd = sdf.parse(sdf.format(sourceList.get(i).getEndDate()));
			for (int j = i + 1; j < tempList.size(); j++) {
				Date sourceStart = sdf.parse(sdf.format(tempList.get(j).getStartDate()));			
				Date sourceEnd = sdf.parse(sdf.format(tempList.get(j).getEndDate()));
				i = j-1;
				if (sourceStart.compareTo(targetStart) >= 0	&& sourceEnd.compareTo(targetEnd) <= 0) {
					indexToRemove.add(j);				
				} else {		
					break;
				}
			}
		}
		for(int i=0;i<sourceList.size();i++){
			if(!indexToRemove.contains(i)){
				latestList.add(sourceList.get(i));
			}
		}
		System.out.println(latestList);
	}
}

	