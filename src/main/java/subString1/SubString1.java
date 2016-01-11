package subString1;
import java.io.*;
import javax.swing.JOptionPane;
class SubString1
{
	public static void main(String arr[])throws Exception
	{
            System.out.println("Creating files.............");
		String input=JOptionPane.showInputDialog("Enter folder name :");
		File file=new File("d:/"+input);
		String myfile=null;
		if(file.isDirectory())
		{
			File list[]=file.listFiles();
			for(int i=0;i<list.length;i++)
			{
                            myfile=list[i].getAbsolutePath();
                            BufferedReader br=new BufferedReader(new FileReader(myfile));
                            PrintWriter out=new PrintWriter(new FileWriter("d:/b/"+list[i].getName()),true);
                            String line=null;
                            while((line=br.readLine())!=null)
                            {
                                out.println(line.substring(0,12));
                            }
			}
                }
		          System.out.println("Created.");	
	}
}
