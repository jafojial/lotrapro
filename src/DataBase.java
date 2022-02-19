
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class DataBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	/**
	 * 
	 */
	Connection connect;
	
	
	public DataBase(){
	super();
	String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	String dbName="lotraprodb";
	String connectionURL = "jdbc:derby:" + dbName; 

	try{
	    Class.forName(driver); 
	} catch(java.lang.ClassNotFoundException e) {
	    e.printStackTrace();
	}

	try {
	    connect = DriverManager.getConnection(connectionURL); 

	    //body of code to go here

	}  catch (Throwable e)  {   
	    e.printStackTrace();
	}		
    }
	
	
	
	
	public int execute(String requete) throws RemoteException {
		ResultSet résultats = null;
		int resultat=0;
		try {
		Statement stmt = connect.createStatement();
		ResultSet result = stmt.executeQuery(requete);
		ResultSetMetaData md = result.getMetaData();
		if(result.next()) resultat = 100;
		//nbMaj = stmt.executeUpdate(requete);
		System.out.println("Résultat : "+resultat);
		} catch (SQLException e) {
		}
		//Acceuil.actualiser();
		return resultat;
	}
	
	
	
		public DefaultTableModel fillDBTable(String requete) {
			 Vector tabLignes=new Vector(), nomCols=new Vector();
		      int i;
		      
		      try {
				Statement state = connect.createStatement();
				ResultSet result = state.executeQuery(requete);
				ResultSetMetaData md = result.getMetaData();
		        nomCols = new Vector();
		        for( i=1; i<=md.getColumnCount (); i++)
		             nomCols.add( md.getColumnLabel(i));
		        while( result.next()) {
		           Vector ligne=new Vector();
		           for(i=1; i<=md.getColumnCount (); i++) 
		           {
		               String ch=result.getString(i);
		               ligne.add(ch);
		           }
		           tabLignes.add(ligne);
		         }
		       }
		     catch(Exception e) { 
		         System.out.print("erreur :  "+e.getMessage());
		     }
		     DefaultTableModel model = new DefaultTableModel(tabLignes,nomCols);
		    

		     return model;
		}
		
		
		
		
		public Vector list(String requete, int indice) throws RemoteException {
			Vector tabLignes=new Vector();
		      int i;
		      
		      try {
				Statement state = connect.createStatement();
				ResultSet result = state.executeQuery(requete);
				ResultSetMetaData md = result.getMetaData();
		        while( result.next()) {
		           Vector ligne=new Vector();
		               ligne.add(result.getString(indice));

		           tabLignes.add(ligne);
		         }
		       }
		     catch(Exception e) { 
		         System.out.print("erreur1 "+e.getMessage());
		     }
		    // Acceuil.actualiser();
		     return tabLignes;
		
		}



		public int update(String requete) throws RemoteException {
			// TODO Auto-generated method stub
			ResultSet résultats = null;
			int nbMaj=0;
			try {
			Statement stmt = connect.createStatement();
			nbMaj = stmt.executeUpdate(requete);
			System.out.println("nb mise a jour = "+nbMaj);
			} catch (SQLException e) {
                            e.printStackTrace();
			}
		//	Acceuil.actualiser();
			return nbMaj;
		}


			 
}

