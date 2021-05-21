package com.mypack.design.pattern.creational;

import org.apache.log4j.Logger;

class Computer {
	private String hdd;
	private String ram;
	private boolean isGraphicsCardEnabled;
	private boolean isBlutueToothEnabled;
	
	public String getHdd() {
		return hdd;
	}
	public String getRam() {
		return ram;
	}
	public boolean isGraphicsCardEnabled() {
		return isGraphicsCardEnabled;
	}
	public boolean isBlutueToothEnabled() {
		return isBlutueToothEnabled;
	}
	
	@Override
	public String toString() {
		return "hdd: " + hdd + ", ram: " + ram + ", isGraphicsCardEnabled: " + isGraphicsCardEnabled + ", isBlutueToothEnabled: " + isBlutueToothEnabled;
	}
	
	private Computer(ComputerBuilder builder) {
		this.hdd = builder.hdd;
		this.ram = builder.ram;
		this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
		this.isBlutueToothEnabled = builder.isBlutueToothEnabled;
	}
	
	static class ComputerBuilder {
		private String hdd;
		private String ram;
		private boolean isGraphicsCardEnabled;
		private boolean isBlutueToothEnabled;
		
		public ComputerBuilder(String hdd, String ram) {
			this.hdd = hdd;
			this.ram = ram;
		}

		public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
			this.isGraphicsCardEnabled = isGraphicsCardEnabled;
			return this;
		}

		public ComputerBuilder setBlutueToothEnabled(boolean isBlutueToothEnabled) {
			this.isBlutueToothEnabled = isBlutueToothEnabled;
			return this;
		}
		
		public Computer build() {
			return new Computer(this);
		}
	}
}

public class BuilderPatterDemo {
	private static final Logger log = Logger.getLogger(BuilderPatterDemo.class);
	public static void main(String[] args) {
		Computer computer = new Computer.ComputerBuilder("500GB", "5GB").setGraphicsCardEnabled(true).build();
		log.info(computer);
	}
}
