package annotation1;
public class Test1 {

	/**
	 * @param args
	 */
	@MyAnnotationInterface1(name="imran khan")
	public static void test(@MyAnnotationInterface1(parameter="xyz") String n)
	{
		System.out.println("test() of Test1");
	}
	public static void main(String[] args) 
	{
		test("abc");
	}
}
