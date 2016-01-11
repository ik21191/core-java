package mypackage;

import java.util.regex.*;

public class Pattern1 
{
	private Pattern pattern;
	private Matcher matcher;
	//private static final String USERNAME_PATTERN1 = "\\.+?";//Matches anything
	//private static final String USERNAME_PATTERN1 = "<[^>]+>|[^<]*";
	//private static final String USERNAME_PATTERN1 = "\\p{L}+";
	private static final String USERNAME_PATTERN2 = "^[a-z0-9_-]{3,15}$";
	private static final String USERNAME_PATTERN3 = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	//private static final String USERNAME_PATTERN3 = "((?=.*\\d)(?=.*[a-z]).*)";
	//private static final String USERNAME_PATTERN3 = "(?=.*\\d).+";
	private static final String USERNAME_PATTERN4 = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
	private static final String USERNAME_PATTERN5 = 
	"[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public Pattern1(){
		  pattern = Pattern.compile(USERNAME_PATTERN5);
	  }

	  /**
	   * Validate username with regular expression
	   * @param username username for validation
	   * @return true valid username, false invalid username
	   */
	  public boolean validate(final String username){

		  matcher = pattern.matcher(username);
		  System.out.println(matcher.find());
		  System.out.println(matcher.group());
		  return matcher.matches();

	  }
	  public static void main(String arr[])
	  {
		  Pattern1 p=new Pattern1();
		  //System.out.println(p.validate("jdljldjldljj"));//pattern1
		  //System.out.println(p.validate("000000"));//pattern2
		  //System.out.println(p.validate("a1A#ii"));//pattern3
		  //System.out.println(p.validate("#aa0aaa"));//pattern4
		  System.out.println(p.validate("imr+an.khan@abc.com"));//pattern5
	  }

}
