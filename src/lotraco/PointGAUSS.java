/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lotraco;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JAFOJIAL
 */
public class PointGAUSS {
    
    DataBase db = new DataBase();
    
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
    
    
    
    public void create(){
       
        try {
            String requete = "INSERT INTO pointgauss VALUES ('0', '"+name+"', '"+x+"', '"+y+"')";
            db.update(requete);
            
        } catch (RemoteException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void modify(){
        
        try {
            String requete = "UPDATE pointgauss SET id = '0', name = '"+name+"', x = '"+x+"', y = '"+y+"' WHERE id='"+id+"'";
            db.update(requete);
            
        } catch (RemoteException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void delete(){
        
        try {
            String requete = "DELETE pointgauss WHERE id='"+id+"'";
            db.update(requete);
           
        } catch (RemoteException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    
     public DefaultTableModel list(){
        
        DefaultTableModel table = new DefaultTableModel();
        String requete = "SELECT * FROM pointgauss";
        db.fillDBTable(requete);
        
        return table;
        
    }
    
    
     public DefaultTableModel listName(String nameFilter){
        
        DefaultTableModel table = new DefaultTableModel();
        String requete = "SELECT * FROM pointgauss WHERE name LIKE %'"+nameFilter+"'";
        db.fillDBTable(requete);
        
        return table;
        
    }

    
    
    public PointUTM Convert(PointGAUSS pointGAUSS){
        
        int idUTM = pointGAUSS.id;
        String nameUTM = pointGAUSS.name;
        double longitude = pointGAUSS.x - 3333534.81;
        double latitude = pointGAUSS.y + 999666.63;
        PointUTM pointUTM = new PointUTM(idUTM, nameUTM, longitude, latitude);
        
        return pointUTM;
        
    }
    
}
