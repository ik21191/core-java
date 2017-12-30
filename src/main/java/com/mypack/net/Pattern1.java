package com.mypack.net;

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
	"^[^=!\\$]*";
	
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
		  //System.out.println(matcher.find());
		  //System.out.println(matcher.group());
		  return matcher.matches();

	  }
	  public static void main(String arr[])
	  {
		  //Pattern1 p=new Pattern1();
		  //System.out.println(p.validate("jdljldjldljj"));//pattern1
		  //System.out.println(p.validate("000000"));//pattern2
		  //System.out.println(p.validate("a1A#ii"));//pattern3
		  //System.out.println(p.validate("#aa0aaa"));//pattern4
		  //System.out.println(p.validate("imran\\$"));//pattern5
		  
		  
		  //Pattern regex = Pattern.compile("^[^=!\\$&amp;&lt;&gt;]*$");
		  //Matcher matcher = regex.matcher("imran.khan@adi-mps.com");
		  //System.out.println(matcher.find());
		  //String test = "tran&#x73;&nbsp;criptimran@adi-mps.com";
		  //String test1 = "imrani>rman@adi-mps.com";
		  
		  /*3.5. Negative look ahead
		  Negative look ahead provides the possibility to exclude a pattern. With this you can say that a 
		  string should not be followed by another string.
		  Negative look ahead are defined via (?!pattern). For example, the following will match "a" if "a" is not followed by "b".*/
		  //String test = "a";
		  //String regex1 = "^(?!.*(&|<|>|=|\\s|!|\\$)).*$";
		  //String regex = "a(?!b)";
	      //Pattern pattern1 = Pattern.compile(regex1);
	      //Matcher matcher1 = pattern1.matcher(test1);
	      //System.out.println(test1 + " : " + matcher1.matches());
	      
	      String test2 = "imrani$rman@adi-mps.com";
	      String regex2 = "^(.*(&|<|>|=|\\s|!|\\$)).*$";
		  //String regex = "a(?!b)";
	     
	      
	      Pattern pattern2 = Pattern.compile(regex2);
	      Matcher matcher2 = pattern2.matcher(test2);
	      System.out.println(test2 + " : " + matcher2.matches());
	      
		  
	      
	      
	  }

}
