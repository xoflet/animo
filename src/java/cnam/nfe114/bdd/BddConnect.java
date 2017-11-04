package cnam.nfe114.bdd;

import java.sql.*;

public class BddConnect extends Connect {

	String url;       
	String user;
	String pass;
	Connection con;
       
	
	public BddConnect(String _driv, String _url, String _user, String _pass) {

            super(_driv);
            this.url=_url;         
            this.user=_user;
            this.pass=_pass;

        }

        public BddConnect() {

            super("org.apache.derby.jdbc.ClientDriver");
            this.url="jdbc:derby://localhost:1527/animo";
            this.user="APP";
            this.pass="APP";

        }
        
	public void CloseConnect()
	{
		try{
			
		this.con.close();
	           }catch(SQLException evt)
	   	{
	   		System.err.println("==>SQL Exception :\n");
			while(evt!=null)
			{
				System.out.println("Message: "+ evt.getMessage());
				System.out.println("SQLState: "+ evt.getSQLState());
				System.out.println("ErrorCode: "+ evt.getErrorCode());
				evt = evt.getNextException();
				System.out.println("");
			}
		}
	}


	public boolean Connect() {
            try {

                boolean recup = this.DriversCharg();                
                con = DriverManager.getConnection(url,user,pass);
                
            } catch(SQLException evt) {
                System.err.println("==>SQL Exception :\n");
		while(evt!=null) {
                    System.out.println("Message: "+ evt.getMessage());
                    System.out.println("SQLState: "+ evt.getSQLState());
                    System.out.println("ErrorCode: "+ evt.getErrorCode());
                    evt = evt.getNextException();
                    System.out.println("");
                    return false;
                }
            }
            
            return true;

	}
	
	
}
	
