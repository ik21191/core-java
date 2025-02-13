package creational.factory;

public class Sony implements Mobile {
	private int ramSize;
	private String processor;
	
	public Sony() {
		
	}

	public Sony(int ramSize, String processor) {
		this.ramSize = ramSize;
		this.processor = processor;
	}

	@Override
	public void mobileBrand() {
		System.out.println("Sony");
	}
}