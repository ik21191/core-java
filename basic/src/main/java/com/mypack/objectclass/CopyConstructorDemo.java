package com.mypack.objectclass;

class City {
	private String cityName;

	public City(String cityName) {
		this.cityName = cityName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}

class Employee {
	private int employeeId;
	private String name;
	private City city;
	
	
	public Employee(int employeeId, String name, City city) {
		this.employeeId = employeeId;
		this.name = name;
		this.city = city;
	}

	public Employee(Employee employee) {
		this.employeeId = employee.getEmployeeId();
		this.name = employee.getName();
		City city = new City(employee.getCity().getCityName());
		this.city = city;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", city=" + city.getCityName() + "]";
	}
}

public class CopyConstructorDemo {

	public static void main(String[] args) {
		City city = new City("New Delhi");
		Employee employee1 = new Employee(101, "Imran Khan", city);
		System.out.println(employee1);
		
		Employee employee2 = new Employee(employee1);
		
		System.out.println("Updating city for employee2");
		employee2.getCity().setCityName("Noida");
		
		System.out.println(employee1);
		System.out.println(employee2);
	}

}
