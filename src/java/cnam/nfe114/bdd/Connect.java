package cnam.nfe114.bdd;

public class Connect
{	
	public String drivers;

/* creation de l objet connect avec le nom des drivers en parametre*/	
	public Connect(String driv)
	{        
            this.drivers=driv;
	}

/* initialisation des drivers*/	
	public boolean DriversCharg()
	{
		try{
			Class.forName(drivers);			
                   }catch(ClassNotFoundException e)
		   	{
				System.err.println("Chargement drivers echoue\n"+e);
				return false;
			}
			return true;
	}      

}
