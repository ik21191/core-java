package com.mypack.design.pattern.structural.decorator;
interface Shape {
	void draw();
}
class Ractangle implements Shape {
	@Override
	public void draw() {
		System.out.println("Ractangle created.");
	}
}
abstract class ShapeDecorator implements Shape {
	private Shape shape;
	public ShapeDecorator(Shape shape) {
		this.shape = shape;
	}
	@Override
	public void draw() {
		System.out.println("draw of ShapeDecorator called.");
		shape.draw();
	}
}
class RedRactangle extends ShapeDecorator {
	public RedRactangle(Shape shape) {
		super(shape);
	}
	@Override
	public void draw() {
		super.draw();
		fillRedColor();
	}
	public void fillRedColor() {
		System.out.println("Ractangle filled with Red color");
	}
}
class ApplyThickness extends ShapeDecorator {
	public ApplyThickness(Shape shape) {
		super(shape);
	}
	@Override
	public void draw() {
		super.draw();
		applyThickness();
	}
	public void applyThickness() {
		System.out.println("Thickness applied.");
	}
} 
public class DecoratorPatternDemo {

	public static void main(String[] args) {
		Shape shape = new RedRactangle(new ApplyThickness(new Ractangle()));
		shape.draw();

	}

}
