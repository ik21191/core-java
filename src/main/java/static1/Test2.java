package static1;

import java.util.ArrayList;
import java.util.List;

public class Test2 
{
final String name;// Without constructor it will show compile time error because the final value must be initialized
final static List<String> list=null;
	public Test2(String name) 
	{
		this.name=name;
	}
	public static void main(String[] args) {
		Test2 t=new Test2("Imrann Khan");
		System.out.println(t.name);
		//list=new ArrayList<String>();//You can not assign object to this final variable
	}

}
