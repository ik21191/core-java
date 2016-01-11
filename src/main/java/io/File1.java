package io;

import java.io.*;

public class File1 
{
	public static void main(String[] args) 
	{
		try
		{
			File file=new File("d://file1/abc.txt");
			System.out.println("Checking file : "+file.exists());
			System.out.println(file.createNewFile());
			byte b[]=new byte[]{65,97,66};
			//System.out.println(new String(b));
			ByteArrayInputStream in=new ByteArrayInputStream(b);
			byte out1[]=new byte[in.available()];
			in.read(out1);
			System.out.println("Creating String from byte : "+new String(out1));
			//InputStream in=new FileInputStream(file);
			File outFile=new File("d://file1/xyz.txt");
			outFile.createNewFile();
			FileOutputStream fout=new FileOutputStream(outFile);
			int data;
			while((data=in.read())!=-1)
			{
				//System.out.println(data);
				//System.out.print((char)data);
				fout.write(data);
			}
			FileReader fr=new FileReader("d:/file1/pqr.txt");
			FileWriter frout=new FileWriter("d://file1/mno.txt",true);
			int charData;
			while(true)
			{
				charData=fr.read();
				if(charData==-1)
					break;
					else
					{
				frout.write((char)charData);
				System.out.print((char)charData);}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
