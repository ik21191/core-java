package mpsTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {

	public static void main(String[] args) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date s1 = sdf.parse("2016-01-01");
		Date s2 = sdf.parse("2016-01-01");
		Date s3 = sdf.parse("2016-02-01");
		Date s4 = sdf.parse("2016-03-01");
		Date s5 = sdf.parse("2016-04-01");
		
		Date e1 = sdf.parse("2016-07-31");
		Date e2 = sdf.parse("2016-01-31");
		Date e3 = sdf.parse("2011-02-28");
		Date e4 = sdf.parse("2010-04-30");
		Date e5 = sdf.parse("2010-09-30");
		LicenseBean l1 = new LicenseBean("A",e1,s1);
		LicenseBean l2 = new LicenseBean("A",e2,s2);
		LicenseBean l3 = new LicenseBean("A",e3,s3);
		LicenseBean l4 = new LicenseBean("A",e4,s4);
		LicenseBean l5 = new LicenseBean("A",e5,s5);
		
		List<LicenseBean> list1 = new ArrayList<LicenseBean>();
		list1.add(l1);
		list1.add(l2);
		list1.add(l3);
		list1.add(l4);
		list1.add(l5);
		
		ArrayList<LicenseBean> list2 = new ArrayList<LicenseBean>(list1);
		try{
		for(LicenseBean bean : list1){
			Date sourceEnd = sdf.parse(sdf.format(bean.getEndDate()));
			Date sourceStart = sdf.parse(sdf.format(bean.getStartDate()));
			String p1= bean.getProductCode();
			for(int i=0; i<list2.size();i++){
				Date targetEnd = sdf.parse(sdf.format(list2.get(i).getEndDate()));
				
				if(targetEnd.compareTo(sourceEnd)<0){
					for(int j=0;j<list2.size();j++){
						Date targetStart = sdf.parse(sdf.format(list2.get(j).getStartDate()));
						String p2=list2.get(j).getProductCode();
						if(targetStart.compareTo(sourceStart)>0 && p1.equals(p2)){
							list2.remove(i);
						}
					}
				}
			}
		}}catch(Exception e){
			//list1.removeAll(list2);
		}
		System.out.println(list2);
	}

}
