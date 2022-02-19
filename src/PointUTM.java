/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.RemoteException;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JAFOJIAL
 */
public class PointUTM {
    
    /*
    double N = 0.0;
    double E = 0.0;
    private static final double f = 0.0033528106647475;//applatissement
    private static final double a = 6378.137;//rayon de la terre à l'equateur en Km
    double k0 = 0.9996;
    double E0 = 500.0;
    double n = f/(2 - f);
    double A = a*(1 + Math.pow(n/2,2) + Math.pow(n/2,4) + Math.pow(n/2,8) + Math.pow(n/2,16) + Math.pow(n/2,32));
    double epsi = N/(k0*A);
    double nu = (E - E0)/(k0*A);
     * */
    
    private int id;
    private String name;
    private double longitude, latitude;
    static DataBase db2;
    
    public PointUTM(int id, String name, double longitude, double latitude){
        
    	db2 = new DataBase();
        this.id = id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude ;
        
    }
    public void create() throws RemoteException{
        
        String requete = "INSERT INTO pointutm VALUES (default, '"+name+"', "+longitude+", "+latitude+")";
        db2.update(requete);
       
    
}
public static DefaultTableModel list(){
        
        DefaultTableModel table = new DefaultTableModel();
        String requete = "SELECT * FROM pointutm";
        return db2.fillDBTable(requete);
        
        
    }

public static void dump(){
    
    String requete = "truncate table pointutm";
    try {
		db2.update(requete);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
}
    
    
    public void export(DefaultTableModel table){
        
        
        
    }
    
    
    public void view(DefaultTableModel table){
        
        
        
    }
    
}
