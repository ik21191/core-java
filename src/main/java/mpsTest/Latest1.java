package mpsTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Latest1 {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public static void main(String[] args) throws Exception{
		
		
		Date s1 = sdf.parse("2016-01-01");
		Date s2 = sdf.parse("2016-01-01");
		Date s3 = sdf.parse("2016-02-01");
		Date s4 = sdf.parse("2016-03-01");
		Date s5 = sdf.parse("2016-04-01");
		
		Date e1 = sdf.parse("2016-07-31");
		Date e2 = sdf.parse("2016-02-28");
		Date e3 = sdf.parse("2016-03-31");
		Date e4 = sdf.parse("2016-04-30");
		Date e5 = sdf.parse("2016-09-30");
		LicenseBean l1 = new LicenseBean("A",e1,s1);
		LicenseBean l2 = new LicenseBean("A",e2,s2);
		LicenseBean l3 = new LicenseBean("A",e3,s3);
		LicenseBean l4 = new LicenseBean("A",e4,s4);
		LicenseBean l5 = new LicenseBean("A",e5,s5);
		
		List<LicenseBean> sourceList = new ArrayList<LicenseBean>();
		sourceList.add(l1);
		sourceList.add(l2);
		sourceList.add(l3);
		sourceList.add(l4);
		sourceList.add(l5);
		ArrayList<LicenseBean> tempList = new ArrayList<LicenseBean>(sourceList);
		for(LicenseBean licenseBean : sourceList) {
			if(checkDuplicateStartDate(tempList, licenseBean)){
				tempList = removeElement(tempList, licenseBean);
			}
		}
		for(LicenseBean licenseBean : sourceList) {
			if(checkRedundant(tempList, licenseBean)){
				tempList = removeElement(tempList, licenseBean);
			}
		}
		System.out.println(tempList);
	}

	public static boolean checkDuplicateStartDate(ArrayList<LicenseBean> list, LicenseBean checkBean)throws Exception{
		boolean status=false;
		for(LicenseBean listBean: list){
			Date listBeanStart = sdf.parse(sdf.format(listBean.getStartDate()));
			Date checkBeanStart = sdf.parse(sdf.format(checkBean.getStartDate()));
			Date listBeanEnd = sdf.parse(sdf.format(listBean.getEndDate()));
			Date checkBeanEnd = sdf.parse(sdf.format(checkBean.getEndDate()));
			if(checkBeanStart.compareTo(listBeanStart)==0 && checkBeanEnd.compareTo(listBeanEnd)<0 ){
				status = true;
			}
		}
		return status;
	}
	
	public static boolean checkRedundant(ArrayList<LicenseBean> list, LicenseBean checkBean)throws Exception{
		boolean status=false;
		for(LicenseBean listBean: list){
			Date listBeanStart = sdf.parse(sdf.format(listBean.getStartDate()));
			Date checkBeanStart = sdf.parse(sdf.format(checkBean.getStartDate()));
			Date listBeanEnd = sdf.parse(sdf.format(listBean.getEndDate()));
			Date checkBeanEnd = sdf.parse(sdf.format(checkBean.getEndDate()));
			if(checkBeanStart.compareTo(listBeanStart)>0 && checkBeanEnd.compareTo(listBeanEnd)<0 ){
				status = true;
			}
		}
		return status;
	}
	
	public static ArrayList<LicenseBean> removeElement(ArrayList<LicenseBean> removeList, LicenseBean removeBean)throws Exception{
		ArrayList<LicenseBean> updatedList = new ArrayList<LicenseBean>();
		for(LicenseBean listBean: removeList){
			Date listBeanStart = sdf.parse(sdf.format(listBean.getStartDate()));
			Date checkBeanStart = sdf.parse(sdf.format(removeBean.getStartDate()));
			Date listBeanEnd = sdf.parse(sdf.format(listBean.getEndDate()));
			Date checkBeanEnd = sdf.parse(sdf.format(removeBean.getEndDate()));
			if(!(checkBeanStart.compareTo(listBeanStart)==0 && checkBeanEnd.compareTo(listBeanEnd)==0) ){
				updatedList.add(listBean);
			}
		}
		return updatedList;
	}
}
