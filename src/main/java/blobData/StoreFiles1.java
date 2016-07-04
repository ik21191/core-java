package blobData;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class StoreFiles1 
{
	public static void main(String[] args) throws Exception
	{
		File file = new File("E://files/Maven.docx");
        FileInputStream input = new FileInputStream(file);

		Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection
        ("jdbc:mysql://localhost:3306/test","root","root");
           PreparedStatement stm=con.prepareStatement("insert into file1 values(?,?)");
            stm.setString(1,"101");
            stm.setBinaryStream(2,input, input.available());
            stm.execute();
        //ResultSet rset=stm.executeQuery();
        
        
        // set parameters
        
        // store the resume file in database
        System.out.println("Reading file " + file.getAbsolutePath());
        System.out.println("Store file in the database.");
        //stm.executeUpdate();
        
        
        
        
        
        
        
        
       
	}
}
