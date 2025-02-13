package creational.factory;

public class OnePlus implements Mobile {
	private int ramSize;
	private String processor;
	private boolean fingerTouch;
	
	public OnePlus() {
		
	}

	public OnePlus(int ramSize, String processor, boolean fingerTouch) {
		this.ramSize = ramSize;
		this.processor = processor;
		this.fingerTouch = fingerTouch;
	}

	@Override
	public void mobileBrand() {
		System.out.println("OnePlus");
	}

}