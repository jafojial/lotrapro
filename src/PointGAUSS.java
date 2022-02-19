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
public class PointGAUSS {
    
    static DataBase db = new DataBase();
    
    private int project, id;
    private String name;
    private double x, y;
    
    
    public PointGAUSS(int proj, int idPoint, String namePoint, double abs, double ord){
        
        project = proj;
        id = idPoint;
        name = namePoint;
        x = abs;
        y = ord;
        
    }
    
    
    
    public void create() throws RemoteException{
       
            String requete = "INSERT INTO pointgauss VALUES (default, "+project+", '"+name+"', "+x+", "+y+")";
            db.update(requete);
           
        
    }
    
    
    public void modify() throws RemoteException{
        
            String requete = "UPDATE pointgauss SET  name = '"+name+"', x = "+x+", y = "+y+" WHERE id="+id+"";
            db.update(requete);
        
        
    }
    
    
    public void delete() throws RemoteException{
        
    	String requete = "DELETE FROM pointgauss WHERE id="+id+"";
            db.update(requete);
         
    }
    
    
     public static DefaultTableModel list(){
        
        DefaultTableModel table = new DefaultTableModel();
        String requete = "SELECT * FROM pointgauss";
        return db.fillDBTable(requete);
        
        
    }
    
    
     public static DefaultTableModel listName(String nameFilter){
        
        DefaultTableModel table = new DefaultTableModel();
        String requete = "SELECT * FROM pointgauss WHERE name LIKE %"+nameFilter+"";
        return db.fillDBTable(requete);
        
        
    }
     
     public static DefaultTableModel listProject(int projectFilter){
         
         DefaultTableModel table = new DefaultTableModel();
         String requete = "SELECT * FROM pointgauss WHERE project="+projectFilter+"";
         //System.out.println(requete);
         return db.fillDBTable(requete);
                  
     }
     
    
    
    public PointUTM Convert(PointGAUSS pointGAUSS){
        
        int idUTM = pointGAUSS.id;
        String nameUTM = pointGAUSS.name;
        double longitude = pointGAUSS.x - 3333534.81;
        double latitude = pointGAUSS.y + 999666.63;
        PointUTM pointUTM = new PointUTM(idUTM, nameUTM, longitude, latitude);
        
        return pointUTM;
        
    }
    
public PointUTM Convert2(){
        
        int idUTM = id;
        String nameUTM = name;
        double longitude = x - 3333534.81;
        double latitude = y + 999666.63;
        PointUTM pointUTM = new PointUTM(idUTM, nameUTM, longitude, latitude);
        
        return pointUTM;
        
    }
    
}
