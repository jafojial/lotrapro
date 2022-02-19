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
public class Project {
    
    static DataBase db = new DataBase();  
    
    private int id;
    private String name, region, town, author, description;
    private String date;
    
    
    public Project(int project, String namePro, String regionPro, String townPro, String datePro, String authorPro, String descriptionPro){
        
        name = namePro;
        region = regionPro; 
        town = townPro; 
        date = datePro;
        author = authorPro;
        description = descriptionPro;
        id=project;
        
    }
    
    
    public DefaultTableModel open(){
       
        DefaultTableModel table = new DefaultTableModel();
        
        String requete = "SELECT pointgauss.id, pointgauss.name, pointgauss.x, pointgauss.y "
                    + "FROM project, pointgauss WHERE project.id = pointgauss.project";
        table = db.fillDBTable(requete);
        
        return table;
    }
    
    
    
    
    //public void Create(int id, String name, String region, String town, Date date, String author)
    public void create() throws RemoteException{
        
            String requete = "INSERT INTO project VALUES (default, '"+name+"', '"+region+"', '"+town+"',"
                    + " '"+date+"', '"+author+"', '"+description+"')";
            System.out.println(requete);
            db.update(requete);
        
        
    }
    
    
    //public void Modify(int id, String name, String region, String town, Date date, String author)
    public void modify() throws RemoteException{
        
            String requete = "UPDATE project SET  name='"+name+"', region='"+region+"', town='"+town+"', date='"+date+"', author='"+author+"', description='"+description+"' WHERE id="+id+"";
            
            db.update(requete);
       
        
    }
    
    
    public void delete() throws RemoteException{
        
            String requete = "DELETE FROM project WHERE id="+id+"";
            db.update(requete);
       
    }
    
    
    public static DefaultTableModel list(){
        
        DefaultTableModel table = new DefaultTableModel();
        //???
        String requete = "SELECT * FROM project";
        table = db.fillDBTable(requete);
        //db.execute(requete);
        
        return table;
        
    }
	
    
    public static DefaultTableModel listName(String nameFilter){
        
        DefaultTableModel table = new DefaultTableModel();
        String requete = "SELECT * FROM project WHERE name LIKE %"+nameFilter+"";
        db.fillDBTable(requete);
                
        return table;
        
    }
    
	
    public static DefaultTableModel listRegion(String regionFilter){
        
        DefaultTableModel table = new DefaultTableModel();
        String requete = "SELECT * FROM project WHERE region LIKE %"+regionFilter+"";
        db.fillDBTable(requete);

        return table;
        
    }
	
    
    public static DefaultTableModel listTown(String townFilter){
        
        DefaultTableModel table = new DefaultTableModel();
        String requete = "SELECT * FROM project WHERE town LIKE %"+townFilter+"";
        db.fillDBTable(requete);
                
        return table;
        
    }
    
}
