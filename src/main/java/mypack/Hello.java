package mypack;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Hello {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("This is Hello World Program.");
		Calendar todaysDate = new GregorianCalendar();
        int thisYear = todaysDate.get(Calendar.YEAR);
        System.out.println(thisYear);
        
        Date articleDate=new Date();
        Calendar freeJournalDate = new GregorianCalendar();
        freeJournalDate.setTime(articleDate);
        int articleYear = freeJournalDate.get(Calendar.YEAR);
        System.out.println(articleYear);
        
        GregorianCalendar freeArchive = new GregorianCalendar();
        freeArchive.setTime(articleDate);
        freeArchive.set(Calendar.MONTH, Calendar.DECEMBER);
        freeArchive.set(Calendar.DAY_OF_MONTH, 31);
        freeArchive.add(Calendar.YEAR, 4);
        //System.out.println(new GregorianCalendar().after(freeArchive));
        System.out.println(freeArchive.get(Calendar.YEAR));
        System.out.println(freeArchive.get(Calendar.MONTH));
        System.out.println(freeArchive.get(Calendar.DATE));
        GregorianCalendar a=new GregorianCalendar();
        Calendar b=new GregorianCalendar();
        System.out.println("==  "+a);
        System.out.println("==  "+b);
        
        System.out.println("----------------------");
     // create calendar objects.
        Calendar cal = Calendar.getInstance();
        Calendar future = Calendar.getInstance();

        // print the current date
        System.out.println("Current date: " + cal.getTime());

        // change year in future calendar
        future.set(Calendar.YEAR, 2017);
        System.out.println("Year is " + future.get(Calendar.YEAR));

        // check if calendar date is after current date
        Date time = future.getTime();
        if (future.after(cal)) {
        System.out.println("Date " + time + " is after current date.");
        }
        System.out.println("------------------------");
        HashMap<String,String> m=new HashMap<String,String>();
        m.put("a","abc");
        m.put("b","abc");
        m.put("c","abc");
        m.put("d","abc");
        m.put("e","abc");
        System.out.println(m);
        System.out.println("File Separater "+File.pathSeparatorChar);
        }

	
		
}
