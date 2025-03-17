package creational.factory;

public class Iphone implements Mobile {
	private int ramSize;
	private String processor;
	private boolean fingerTouch;
	
	public Iphone() {
		
	}

	public Iphone(int ramSize, String processor, boolean fingerTouch) {
		this.ramSize = ramSize;
		this.processor = processor;
		this.fingerTouch = fingerTouch;
	}

	@Override
	public void mobileBrand() {
		System.out.println("IPhone");
	}
}
