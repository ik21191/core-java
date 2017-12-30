package com.mypack.net;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class Pattern3 
{
	public static void main(String[] args) {
		String origional = "\"[^\"]*\"|'[^']*'|\\[[^\\[]*\\]|(\\\\s|\\S)+";
		//String arg1 = "\\[[^\\[]*\\]";
		String arg1 = "\\[([^\\]]+)\\]";
		String subject = "He is a \"man of his\" words\\ always **?., 'and forever' [this is single]";
		Pattern pattern = Pattern.compile(origional);
		try{
		Matcher matcher = pattern.matcher( subject );
		String line = null;
		System.out.println("Process started......");
		while( matcher.find() ) {
			line = matcher.group(0);
			line = StringUtils.replace(line, "\"", "");
		    //line = line.replace("\"", "\"");
		    //line = line.replace("[", "");
		    //line = line.replace("]", "");
		    System.out.println(line);
		  //  throw new StackOverflowError("this is stack overflow exception");
		    throw new Exception();
		}
		} catch(StackOverflowError e) {
			System.out.println("hello this is error");
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("process done.");
	}

}
