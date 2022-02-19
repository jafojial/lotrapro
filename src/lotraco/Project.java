/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lotraco;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JAFOJIAL
 */
public class Project {
    
    DataBase db = new DataBase();  
    
    private int id;
    private String name, region, town, author, description;
    private String date;
    
    
    public Project(int idPro, String namePro, String regionPro, String townPro, String datePro, String authorPro, String descriptionPro){
        
        id = idPro;
        name = namePro;
        region = regionPro; 
        town = townPro; 
        date = datePro;
        author = authorPro;
        description = descriptionPro;
        System.out.println(id);
        System.out.println(name);
        System.out.println(region);
        System.out.println(town);
        System.out.println(date);
        System.out.println(author);
        System.out.println(description);
        
    }
    
    
    public DefaultTableModel open(){
       
        DefaultTableModel table = new DefaultTableModel();
        
        String requete = "SELECT pointgauss.id, pointgauss.name, pointgauss.x, pointgauss.y "
                    + "FROM project, pointgauss WHERE project.id = pointgauss.project";
        table = db.fillDBTable(requete);
        
        return table;
    }
    
    
    
    
    //public void Create(int id, String name, String region, String town, Date date, String author)
    public void create(){
        
        try {
            String requete = "INSERT INTO project VALUES ('0', '"+name+"', '"+region+"', '"+town+"',"
                    + " '"+date+"', '"+author+"', '"+description+"')";
            System.out.println(requete);
            db.update(requete);
            
        } catch (RemoteException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    //public void Modify(int id, String name, String region, String town, Date date, String author)
    public void modify(){
        
        try {
            String requete = "UPDATE project SET id = '"+id+"', name = '"+name+"', region = '"+region+"', town = '"+town+"', "
                    + "date = '"+date+"', author = '"+author+"', description = '"+description+"' WHERE id='"+id+"'";
            db.update(requete);
            
        } catch (RemoteException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void delete(){
        
       try {
            String requete = "DELETE FROM project WHERE id='"+id+"'";
            db.update(requete);
           
        } catch (RemoteException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    
    public DefaultTableModel list(){
        
        DefaultTableModel table = new DefaultTableModel();
        //???
        String requete = "SELECT * FROM project";
        table = db.fillDBTable(requete);
        //db.execute(requete);
        
        return table;
        
    }
	
    
    public DefaultTableModel listName(String nameFilter){
        
        DefaultTableModel table = new DefaultTableModel();
        String requete = "SELECT * FROM project WHERE name LIKE %'"+nameFilter+"'";
        db.fillDBTable(requete);
                
        return table;
        
    }
    
	
    public DefaultTableModel listRegion(String regionFilter){
        
        DefaultTableModel table = new DefaultTableModel();
        String requete = "SELECT * FROM project WHERE region LIKE %'"+regionFilter+"'";
        db.fillDBTable(requete);

        return table;
        
    }
	
    
    public DefaultTableModel listTown(String townFilter){
        
        DefaultTableModel table = new DefaultTableModel();
        String requete = "SELECT * FROM project WHERE town LIKE %'"+townFilter+"'";
        db.fillDBTable(requete);
                
        return table;
        
    }
    
}
