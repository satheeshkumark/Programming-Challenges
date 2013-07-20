import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.*;
import java.util.Scanner;


public class MYSQLdb
{	
	Connection conn;
		
	void getConnection(){		
		try{	
			String hostname = "localhost"; 
			String port 	= "3306";
			String dbname 	= "CourtData";
			String username = "root";
			String password = "sat";
			
			String connstring = "jdbc:mysql" + "://" + hostname + ":" + port + "/" + dbname + 
			"?user=" + username + "&password=" + password;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(connstring);	
			System.out.println(conn);
		}	
		catch(SQLException e){
			System.out.println("SQL Exception: " + e.getMessage());

		}
		catch(Exception e){
			System.out.println("Exception Here1: " + e.getMessage());
		}
	}	
	
	void updateCitationFormats( String inputString ){
		String[] parseArray = inputString.split("\t");
		String countryname = parseArray[0];
		String courtname = parseArray[1];
		String citationformat = parseArray[2];
		String regexformat = parseArray[3];
		System.out.println(countryname + "\t" + courtname + "\t" + citationformat + "\t" + regexformat);
		String updateQuery = "UPDATE CourtDetails set CitationFormat = '" + citationformat + "', CitationRegex = '" + regexformat +"' where CountryId in (select CountryId from CountryDetails where CountryName = '" + countryname + "') and CourtName = '"+ courtname + "'";
		try {			
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.executeUpdate();
			System.out.println("SUCCESSFULLY UPDATED");
		}
		catch (SQLException e ) {
	    	System.out.println("SQLException: " + e.getMessage());
	    }
		catch(Exception e)
		{
			System.out.println("Exception Here2: " + e.getMessage());
		}
		finally{
		}
	}	
	
	void closeConnection(){
		try
		{
			conn.close();
			System.out.println();
		}   
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	void updateCitationsAndRegex(String inputFileName){
		Scanner sc = null;		
		try{
			sc = new Scanner(new FileReader(inputFileName));	
			while(sc.hasNext()){
				String inputString = sc.nextLine();
				updateCitationFormats(inputString);
			}
		}	
		catch(IOException e){
			System.out.println("IO Exception " + e.getMessage());
		}
		catch(Exception e){
			System.out.println("Exception Here3: " + e.getMessage());
		}
		finally{
			sc.close();
		}
	}
	
	public static void main(String[] args){
		String inputFileName = new String("src/citation_formats.txt");
		MYSQLdb obj= new MYSQLdb();
		obj.getConnection();
		obj.updateCitationsAndRegex(inputFileName);
		obj.closeConnection();
	}
}