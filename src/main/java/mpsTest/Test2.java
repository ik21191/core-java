package mpsTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test2 {

	public static void main(String[] args) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date s1 = sdf.parse("2016-01-01");
		Date s2 = sdf.parse("2016-01-01");
		Date s3 = sdf.parse("2016-02-01");
		Date s4 = sdf.parse("2016-03-01");
		Date s5 = sdf.parse("2016-04-01");
		
		Date e1 = sdf.parse("2016-07-31");//1 Jul
		Date e2 = sdf.parse("2016-02-28");
		Date e3 = sdf.parse("2016-03-31");
		Date e4 = sdf.parse("2016-04-30");
		Date e5 = sdf.parse("2016-09-30");//2 Sep
		LicenseBean l1 = new LicenseBean("A",e1,s1);
		LicenseBean l2 = new LicenseBean("A",e2,s2);
		LicenseBean l3 = new LicenseBean("A",e3,s3);
		LicenseBean l4 = new LicenseBean("A",e4,s4);
		LicenseBean l5 = new LicenseBean("A",e5,s5);
		
		List<LicenseBean> list1 = new ArrayList<LicenseBean>();
		list1.add(l1);
		list1.add(l2);
		//list1.add(l3);
		//list1.add(l4);
		//list1.add(l5);
		LicenseBean b=null;
		ArrayList<LicenseBean> list2 = new ArrayList<LicenseBean>(list1);
		for(LicenseBean bean : list1){
			Date sourceStart = sdf.parse(sdf.format(bean.getStartDate()));
			Date sourceEnd = sdf.parse(sdf.format(bean.getEndDate()));
			for(int i=0; i<list2.size();i++){
				Date targetStart = sdf.parse(sdf.format(list2.get(i).getStartDate()));
				Date targetEnd = sdf.parse(sdf.format(list2.get(i).getEndDate()));
				if(targetStart.compareTo(sourceStart)==0){
					if(targetEnd.compareTo(sourceEnd)<0){
						for(int j=0;j<list2.size();j++){
							Date targetStart1 = sdf.parse(sdf.format(list2.get(j).getStartDate()));
							if(targetStart1.compareTo(sourceStart)>0 || targetStart1.compareTo(sourceStart)==0 ){
								b=list2.get(i);
								list2.remove(i);
							}
						}
					}
				}
				else if(targetEnd.compareTo(sourceEnd)<0){
					for(int j=0;j<list2.size();j++){
						Date targetStart1 = sdf.parse(sdf.format(list2.get(j).getStartDate()));
						if(targetStart1.compareTo(sourceStart)>0 || targetStart1.compareTo(sourceStart)==0 ){
							b=list2.get(i);
							list2.remove(i);
						}
					}
				}
			}
		}//list1.removeAll(list2);
		list2.add(b);
		System.out.println(list2);
	}

}
