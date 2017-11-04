package cnam.nfe114.bdd;

import java.sql.*;

public class BddAffich extends BddModif {
    
    public BddAffich(String _drivers, String _url, String _user, String _pass) {
        super(_drivers,_url,_user,_pass);
    }
	
    public void affichTab(String champ) {
        try {
            boolean test = false;
            test = this.res.first();
	    while(test) {
                System.out.println(res.getString(champ));
                test = this.res.next();
	    }
	    } catch(SQLException evt) {
                System.err.println("==>SQL Exception :\n");
		while(evt!=null) {
                    System.out.println("Message: "+ evt.getMessage());
                    System.out.println("SQLState: "+ evt.getSQLState());
                    System.out.println("ErrorCode: "+ evt.getErrorCode());
                    evt = evt.getNextException();
                    System.out.println("");
				
                }
            }
    }
}
