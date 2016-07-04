package overriding1;
class Parent{
	public void display(){
		System.out.println("Parent");
	}
}
class Child extends Parent{
public void display(){
		System.out.println("Child");
	}
}
public class ClassCastEx1 {
	public static void main(String arr[]){
	Parent parent = new Child();//new Parent // will throw ClassCastException
	Child child = (Child)parent;
	child.display();
	}
}
