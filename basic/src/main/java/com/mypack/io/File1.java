package com.mypack.io;

import java.io.*;

public class File1 
{
	
	void print1() {
		String routePath = this.getClass().getClassLoader().getResource(File.separator).getPath();
		System.out.println(routePath);
	}
	public static void main(String[] args)throws Exception 
	{
		try
		{
			String fileWithFolder = "file/myfile.txt";
			String fileLocation = System.getProperty("user.dir");
			String path = fileLocation + File.separator + fileWithFolder; 
			new File(path).createNewFile();
			//System.out.println(System.getProperty("user.dir" + File.separator + "myfile.txt"));
			//new File1().print1();
			
			
			/*
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
		*/}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		//print();
		//print();
		//print();
	}
	
	public static void print() throws Exception {
		
		String routePath = File1.class.getClass().getClassLoader().getResource(File.separator).getPath();
		System.out.println(routePath);
		
		
		File processedFile = new File("e:/dia/data/cancelOrder.txt");
    	PrintWriter writer = null;
    	writer = new PrintWriter(new FileWriter(processedFile, true), true);
    	
    	writer.println("hello");
	}

}
