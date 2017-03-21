package mpsTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LicenseBean {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String productCode;
	Date endDate;
	Date startDate;
	
	
	
	
	public LicenseBean(String productCode, Date endDate, Date startDate) {
		super();
		this.productCode = productCode;
		this.endDate = endDate;
		this.startDate = startDate;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	 public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Override
	public String toString() {
		
		return sdf.format(startDate) + " : " + sdf.format(endDate) + "\n";
	}
	
}
