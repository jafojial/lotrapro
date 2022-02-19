/**
	 * Fenetre pour calculer les nombres complexes
	 * @author anjoelus
	 * @version 1.0
	 * @since 1.0
	 * @param args
	 */
import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Date;

import javax.imageio.ImageIO;
import javax.swing.JPanel; 
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


public class Interface extends JFrame{
	Interface containeurLourd = this; //on sauvegarde la reference du containeur car on entre dans une classe anonyme
	private int choice = 0, idData = 0, project;
	//menu panes
	private PanelImage menu;
	
	private JPanel content = new JPanel();
	private PanelImage easyConverterMenu;
	private PanelImage ProjectsMenu;
	private PanelImage DataMenu;
	private PanelImage HelpMenu;
	private PanelImage AboutMenu;
	private PanelImage ClientMenu;
	private PanelImage spaceMenu0;
	private PanelImage spaceMenu1;
	private PanelImage spaceMenu2;
	private PanelImage spaceMenu3;
	private PanelImage spaceMenu4;
	private PanelImage spaceMenu5;
	private PanelImage spaceMenu6;
	private PanelImage spaceMenu7;
	private PanelImage spaceMenu8;
	private PanelImage spaceMenu9;
	
	private javax.swing.JButton easyConverterboutonConvert;
    private javax.swing.JTextField easyConvertercoordX;
    private javax.swing.JTextField easyConvertercoordX1;
    private javax.swing.JTextField easyConvertercoordY;
    private javax.swing.JTextField easyConvertercoordY1;
    private PanelImage easyConverterContent2;
    private PanelImage easyConverterjPanel1;
    private PanelImage easyConverterjPanel3;
    private javax.swing.JLabel easyConverterlabelX;
    private javax.swing.JLabel easyConverterlabelX2;
    private javax.swing.JLabel easyConverterlabelX3;
    private javax.swing.JLabel easyConverterlabelY;
    private PanelImage easyConverterjPanel2;
    
    private PanelImage projectContentjPanelMenu;
    private PanelImage projectContentjPanelMenuDelete;
    private PanelImage projectContentjPanelMenuEdit;
    private PanelImage projectContentjPanelMenuNew;
    private PanelImage projectContentjPanelMenuOpen;
    private PanelImage projectContentjPanelSeparator1;
    private PanelImage projectContentjPanelSeparator2;
    private PanelImage projectContentjPanelTable;
    private javax.swing.JScrollPane projectContentjScrollPane2;
    private javax.swing.JTable projectContentjTable;
    private javax.swing.JDialog DataParameters;
    private javax.swing.JPanel DataParametersjPanel4;
    private javax.swing.JPanel DataParametersjPanel5;
    private javax.swing.JPanel DataParametersjPanel6;
    private javax.swing.JLabel DataParameterslabelNameData;
    private javax.swing.JLabel DataParameterslabelX;
    private javax.swing.JLabel DataParameterslabelY;
    private javax.swing.JTextField DataParametersnameData;
    private javax.swing.JButton DataParametersboutonCancelData;
    private javax.swing.JButton DataParametersboutonSaveData;
    private javax.swing.JTextField DataParametersx;
    private javax.swing.JTextField DataParametersy;
    
    
    private javax.swing.JPanel DataContentjPanelConvert;
    private javax.swing.JPanel DataContentjPanelExport;
    private javax.swing.JPanel DataContentjPanelImport;
    private javax.swing.JPanel DataContentjPanelMenu;
    private javax.swing.JPanel DataContentjPanelMenuDelete;
    private javax.swing.JPanel DataContentjPanelMenuEdit;
    private javax.swing.JPanel DataContentjPanelMenuNew;
    private javax.swing.JPanel DataContentjPanelOperations;
    private javax.swing.JPanel DataContentjPanelSeparator1;
    private javax.swing.JPanel DataContentjPanelSeparator2;
    private javax.swing.JPanel DataContentjPanelTable;
    private javax.swing.JScrollPane DataContentjScrollPane2;
    private javax.swing.JTable DataContentjTable;
	    
    private javax.swing.JDialog ProjectParameters;
    private javax.swing.JTextField author;
    private javax.swing.JButton boutonCancel;
    private javax.swing.JButton boutonSave;
    private javax.swing.JTextField date;
    private javax.swing.JTextField description;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel labelAuthor;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelDescription;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelRegion;
    private javax.swing.JLabel labelTown;
    private javax.swing.JTextField name;
    private javax.swing.JTextField region;
    private javax.swing.JTextField town;
    
    
	
	private CardLayout cardLayout = new CardLayout();
	
	JLabel easyConverterLabel = new JLabel(" E-Convert");
	JLabel ProjectsLabel = new JLabel("  Projects");
	JLabel DataLabel = new JLabel("     Data");
	JLabel HelpLabel = new JLabel("    Help");
	JLabel AboutLabel = new JLabel("   About");
	
	private PanelImage easyConverterContent;
	private PanelImage ProjectsContent;
	private PanelImage DataContent;
	private PanelImage HelpContent;
	private PanelImage AboutContent;
	private PanelImage start;
	
	private JPanel mainPane = new JPanel();
	
	public Interface(){
		super("LOTRAPRO V1.0");
		 Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		        try {
		                 // Set LnF to platform default.
		                 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		                }
		                // Silently consume exception.
		                catch (Exception e) {
		                        e.printStackTrace();
		                }
		                
		buildEasyConverterUI();
		buildProjectsUI();
		buildDataUI();
		buildGUI();
		this.handleEvent();
		this.setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);
		DataParameters.setSize(230, 230);
		ProjectParameters.setSize(365, 60);
		DataParameters.setResizable(false);
		DataParameters.setTitle("Point parameter");
		DataParameters.setLocation((screen.width - DataParameters.getSize().width)/2,(screen.height - DataParameters.getSize().height)/2);
		ProjectParameters.setLocation((screen.width - DataParameters.getSize().width)/2,(screen.height - DataParameters.getSize().height)/2);
	}
	
	private void buildGUI() {
		// TODO Auto-generated method stub
		try{
		 easyConverterMenu = new PanelImage("images/easy-converter-menu.png");
		 ProjectsMenu  = new PanelImage("images/projects-menu.png");
		 DataMenu  = new PanelImage("images/data-menu.png");
		 DataMenu.setEnabled(false);
		 HelpMenu = new PanelImage("images/help-menu.png");
		 AboutMenu = new PanelImage("images/about-menu.png");
		 ClientMenu = new PanelImage("images/client.png");
		 
		 spaceMenu0 = new PanelImage("images/space.png");
		 spaceMenu1 = new PanelImage("images/space.png");
		 spaceMenu2 = new PanelImage("images/space.png");
		 spaceMenu3 = new PanelImage("images/space.png");
		 spaceMenu4 = new PanelImage("images/space.png");
		 spaceMenu5 = new PanelImage("images/space.png");
		 spaceMenu6 = new PanelImage("images/space.png");
		 spaceMenu7 = new PanelImage("images/space.png");
		 spaceMenu8 = new PanelImage("images/space.png");
		 spaceMenu9 = new PanelImage("images/space.png");
		 
		 
		 easyConverterLabel.setFont(new java.awt.Font("gisha", 1, 10));
		 ProjectsLabel.setFont(new java.awt.Font("gisha", 1, 10));
		 DataLabel.setFont(new java.awt.Font("gisha", 1, 10));
		 HelpLabel.setFont(new java.awt.Font("gisha", 1, 10));
		 AboutLabel.setFont(new java.awt.Font("gisha", 1, 10));
		 easyConverterLabel.setForeground(new java.awt.Color(0, 121, 165));
		 ProjectsLabel.setForeground(new java.awt.Color(0, 121, 165));
		 DataLabel.setForeground(new java.awt.Color(0, 121, 165));
		 HelpLabel.setForeground(new java.awt.Color(0, 121, 165));
		 AboutLabel.setForeground(new java.awt.Color(0, 121, 165));
		 
		 start  = new PanelImage("images/start.png");
		 ProjectsContent  = new PanelImage("images/ProjectsContent.png");
		 DataContent  = new PanelImage("images/DataContent.png");
		 HelpContent = new PanelImage("images/HelpContent.png");
		 AboutContent = new PanelImage("images/AboutContent.png");
		 easyConverterContent = new PanelImage("images/easyConverterContent.png");
		 
		 easyConverterContent.add(easyConverterjPanel2);
		 easyConverterContent.add(easyConverterContent2);
		 
		 ProjectsContent.add(projectContentjPanelSeparator1);
		 ProjectsContent.add(projectContentjPanelMenu);
		 ProjectsContent.add(projectContentjPanelSeparator2);
		 ProjectsContent.add(projectContentjPanelTable);
		 
		 DataContent.add(DataContentjPanelSeparator1);
		 DataContent.add(DataContentjPanelMenu);
		 DataContent.add(DataContentjPanelSeparator2);
		 DataContent.add(DataContentjPanelTable);
		 
	
		 
		 menu = new PanelImage("images/menu.png");
		}
		catch(IOException e){e.printStackTrace();}
		//construction du menu
		ProjectsMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		DataMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		HelpMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		AboutMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		easyConverterMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		easyConverterMenu.setLayout(new BoxLayout(easyConverterMenu, BoxLayout.PAGE_AXIS));
		easyConverterMenu.add(new JLabel(" "));
		easyConverterMenu.add(new JLabel(" "));
		easyConverterMenu.add(new JLabel(" "));
		easyConverterMenu.add(new JLabel(" "));
		easyConverterMenu.add(easyConverterLabel);
		
		ProjectsMenu.setLayout(new BoxLayout(ProjectsMenu, BoxLayout.PAGE_AXIS));
		ProjectsMenu.add(new JLabel(" "));
		ProjectsMenu.add(new JLabel(" "));
		ProjectsMenu.add(new JLabel(" "));
		ProjectsMenu.add(new JLabel(" "));
		ProjectsMenu.add(ProjectsLabel);
		
		DataMenu.setLayout(new BoxLayout(DataMenu, BoxLayout.PAGE_AXIS));
		DataMenu.add(new JLabel(" "));
		DataMenu.add(new JLabel(" "));
		DataMenu.add(new JLabel(" "));
		DataMenu.add(new JLabel(" "));
		DataMenu.add(DataLabel);
		
		HelpMenu.setLayout(new BoxLayout(HelpMenu, BoxLayout.PAGE_AXIS));
		HelpMenu.add(new JLabel(" "));
		HelpMenu.add(new JLabel(" "));
		HelpMenu.add(new JLabel(" "));
		HelpMenu.add(new JLabel(" "));
		HelpMenu.add(HelpLabel);
		
		AboutMenu.setLayout(new BoxLayout(AboutMenu, BoxLayout.PAGE_AXIS));
		AboutMenu.add(new JLabel(" "));
		AboutMenu.add(new JLabel(" "));
		AboutMenu.add(new JLabel(" "));
		AboutMenu.add(new JLabel(" "));
		AboutMenu.add(AboutLabel);
		
		
		menu.setMaximumSize(new Dimension(800, 75));
		menu.setLayout(new GridLayout(1,15));
			menu.add(spaceMenu0);
		menu.add(easyConverterMenu);
		menu.add(spaceMenu2);
		menu.add(ProjectsMenu);
		menu.add(spaceMenu3);
		menu.add(DataMenu);
		menu.add(spaceMenu4);
		menu.add(HelpMenu);
		menu.add(spaceMenu5);
		menu.add(AboutMenu);
		menu.add(spaceMenu6);
		menu.add(spaceMenu7);
		menu.add(spaceMenu1);
		menu.add(spaceMenu8);
		menu.add(spaceMenu9);
		
		
		content.setLayout(cardLayout);
		content.setMaximumSize(new Dimension(800, 525));
		content.add(start, "start");
		content.add(easyConverterContent, "easyConverterContent");
		content.add(ProjectsContent, "ProjectsContent");
		content.add(DataContent, "DataContent");
		content.add(HelpContent, "HelpContent");
		content.add(AboutContent, "AboutContent");
		
		
		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.PAGE_AXIS));
		mainPane.add(menu);
		mainPane.add(content);
		
		
		mainPane.setBackground(java.awt.Color.white);
		content.setBackground(java.awt.Color.white);
		
		this.setContentPane(mainPane);
		
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(800, 600);
	}
	private void handleEvent() {
		// TODO Auto-generated method stub
        DataContentjPanelMenuNew.addMouseListener (new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	 
            	DataParametersnameData.setText("");
            	DataParametersx.setText("");
            	DataParametersy.setText("");
                
                DataParameters.setVisible(true);
                choice = 0;
            }
            
        });
        
        projectContentjPanelMenuNew.addMouseListener (new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	 
            	name.setText("");
            	region.setText("");
            	town.setText("");
            	date.setText("");
            	author.setText("");
            	description.setText("");
                
                ProjectParameters.setVisible(true);
                choice = 0;
            }
            
        });
		
        DataContentjPanelMenuEdit.addMouseListener (new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	choice = 1;
                int ligne = DataContentjTable.getRowCount();
                for(int i = 0; i < ligne; i++){
                    if(DataContentjTable.isRowSelected(i)){
                        
                        DataParametersnameData.setText(DataContentjTable.getValueAt(i, 2).toString());
                        DataParametersx.setText(DataContentjTable.getValueAt(i, 3).toString());
                        DataParametersy.setText(DataContentjTable.getValueAt(i, 4).toString());
                        
                        idData = Integer.parseInt(DataContentjTable.getValueAt(i, 0).toString());
                        
                        DataParameters.setVisible(true);
                        
                        
                    }
                }
            }
            
        });
        projectContentjPanelMenuEdit.addMouseListener (new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	 choice = 1;
                 int ligne = projectContentjTable.getRowCount();
                 for(int i = 0; i < ligne; i++){
                     if(projectContentjTable.isRowSelected(i)){
                         
                    	 name.setText(projectContentjTable.getValueAt(i, 1).toString());
                    	 region.setText(projectContentjTable.getValueAt(i, 2).toString());
                    	 town.setText(projectContentjTable.getValueAt(i, 3).toString());
                    	 date.setText(projectContentjTable.getValueAt(i, 4).toString());
                    	 author.setText(projectContentjTable.getValueAt(i, 5).toString());
                    	 description.setText(projectContentjTable.getValueAt(i, 6).toString());
                    	 project = Integer.parseInt(projectContentjTable.getValueAt(i, 0).toString());
                         //id.setText(tableProject.getValueAt(i, 6).toString());
                         
                         ProjectParameters.setVisible(true);
                     }
                 }
            }
            
        });
		
        DataContentjPanelMenuDelete.addMouseListener (new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	String a="";
            	double b=0,c=0;
            	int ligne = DataContentjTable.getRowCount();
                for(int i = 0; i < ligne; i++){
                    if(DataContentjTable.isRowSelected(i)){
                        
                    	a = DataContentjTable.getValueAt(i, 2).toString();
                    	b = Double.parseDouble(DataContentjTable.getValueAt(i, 3).toString());
                    	c = Double.parseDouble(DataContentjTable.getValueAt(i, 3).toString());
                        
                        idData = Integer.parseInt(DataContentjTable.getValueAt(i, 0).toString());
                    }
                }
                   PointGAUSS ptg = new PointGAUSS(project, idData , a, b, c);
                   try {
					ptg.delete();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                        
                   DataContentjTable.removeAll();
                   DataContentjTable.setModel(PointGAUSS.listProject(project));
                   DataContentjTable.revalidate();
                }
            
           
        });
        
        boutonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	 String namePro = name.getText().toString();
                 String regionPro = region.getText().toString();
                 String townPro = town.getText().toString();
                 String authorPro = author.getText().toString();
                 String descriptionPro = description.getText().toString();
                
                 Project pro = new Project(project, namePro , regionPro, townPro, date.getText().toString(), authorPro, descriptionPro);
                 if(choice == 0){
                     try {
						pro.create();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                 }
                 else if(choice == 1){
                     try {
						pro.modify();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                 }
                 ProjectParameters.dispose();
                 projectContentjTable.removeAll();
                 projectContentjTable.setModel(pro.list());
                 projectContentjTable.revalidate();
            }
        });
        
        boutonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	ProjectParameters.dispose();
            }
        });
        
        projectContentjPanelMenuDelete.addMouseListener (new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	 int ligne = projectContentjTable.getRowCount();
                 for(int i = 0; i < ligne; i++){
                     if(projectContentjTable.isRowSelected(i)){
                         
                         String namePro = projectContentjTable.getValueAt(i, 1).toString();
                         String regionPro = projectContentjTable.getValueAt(i, 2).toString();
                         String townPro = projectContentjTable.getValueAt(i, 3).toString();
                         
                         String authorPro = projectContentjTable.getValueAt(i, 5).toString();
                         String descriptionPro = projectContentjTable.getValueAt(i, 6).toString();
                         int idPro = Integer.parseInt(projectContentjTable.getValueAt(i, 0).toString());
                         
                         Project pro = new Project( idPro, namePro , regionPro, townPro, projectContentjTable.getValueAt(i, 4).toString(), authorPro, descriptionPro);
                         try {
							pro.delete();
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                         
                         projectContentjTable.removeAll();
                         projectContentjTable.setModel(pro.list());
                         projectContentjTable.revalidate();
            }
                 }}
        });
		
        projectContentjPanelMenuOpen.addMouseListener (new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	
            	project = Integer.parseInt(projectContentjTable.getValueAt(projectContentjTable.getSelectedRow(), 0).toString());
                DataContentjTable.setModel(PointGAUSS.listProject(project));
                projectContentjTable.revalidate();
            	DataMenu.setEnabled(true);
            	cardLayout.show(content, "DataContent");
            }
           
        });
		
		
		
		easyConverterMenu.addMouseListener (new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	cardLayout.show(content, "easyConverterContent");
            }
        });
		
		DataContentjPanelImport.addMouseListener (new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	
            	JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichier Excel 97-2003", "xls");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(chooser);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    String chemin = chooser.getSelectedFile().getPath();
                    char car = '\\', ncar = '/';
                    for(int i=0; i<chemin.length(); i++){
                        if(chemin.charAt(i)==car){
                            chemin = chemin.replace(car, ncar);
                        }
                        
                    }
                    System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
                    System.out.println("The path of this file is: " + chooser.getSelectedFile().getPath());
                    System.out.println("The path and name of this file is: " + chemin);
                    //jTextFieldImagePersonnel.setText(chooser.getSelectedFile().getName());
                    DefaultTableModel table = new DefaultTableModel();
                    ReadExcelFile file = new ReadExcelFile();
                    try {
                        table = file.Read(chemin);
                    } catch (    IOException | InvalidFormatException ex) {
                    }
                    for(int i=0; i<table.getRowCount(); i++){
                        String name = table.getValueAt(i, 0).toString();
                        Double x = Double.parseDouble(table.getValueAt(i, 1).toString());
                        Double y = Double.parseDouble(table.getValueAt(i, 2).toString());
                        
                        PointGAUSS point = new PointGAUSS(project, idData, name, x, y);
                        try {
							point.create();
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                        point.list();
                        
                        DataContentjTable.removeAll();
                        DataContentjTable.setModel(point.listProject(project));
                        DataContentjTable.revalidate();
                        
                    }
                }
            	
            }
        });
		
		DataContentjPanelExport.addMouseListener (new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	enregistrerSous(DataContentjTable, "data_project"+project+".xls");
            }
        });
		
		DataContentjPanelConvert.addMouseListener (new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	(new ResultUI(project)).setVisible(true);
            }
        });
		
		ProjectsMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	
            	cardLayout.show(content, "ProjectsContent");
            }
        });
		DataMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	if(DataMenu.isEnabled())
            	cardLayout.show(content, "DataContent");
            }
        });
		HelpMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	cardLayout.show(content, "HelpContent");
            }
        });
		AboutMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	cardLayout.show(content, "AboutContent");
            }
       /*     public void mouseEntered(MouseEvent evt) {
            	try {
					AboutMenu.setImage("images/about-menu2.png");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	AboutMenu.validate();
            }
            public void mouseExited(MouseEvent evt) {
            	try {
					AboutMenu.setImage("images/about-menu.png");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	AboutMenu.validate();
            }*/
        });
	}
	private void easyConverterboutonConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonConvertActionPerformed
        // TODO add your handling code here:
        
        Double xUTM = Double.parseDouble(easyConvertercoordX.getText().toString()) - 3333534.81;
        Double yUTM = Double.parseDouble(easyConvertercoordY.getText().toString()) + 999666.63;
        
        easyConvertercoordX1.setText(xUTM.toString());
        easyConvertercoordY1.setText(yUTM.toString());
        
    }
	
	public void buildDataUI(){
		try{
			DataContentjPanelSeparator1 = new PanelImage("images/space.png");
			DataContentjPanelMenu = new PanelImage("images/space.png");
			DataContentjPanelMenuEdit = new PanelImage("images/ProjectContentEdit.png");
			DataContentjPanelMenuNew = new PanelImage("images/ProjectContentNew.png");
			DataContentjPanelMenuDelete = new PanelImage("images/ProjectContentDelete.png");
			DataContentjPanelSeparator2 = new PanelImage("images/space.png");
			DataContentjPanelTable = new PanelImage("images/space.png");
			DataContentjPanelOperations = new PanelImage("images/space.png");
			DataContentjPanelImport = new PanelImage("images/DataContentImport.png");
			DataContentjPanelExport = new PanelImage("images/DataContentExport.png");
			DataContentjPanelConvert = new PanelImage("images/DataContentConvert.png");
			}
			catch(Exception e){e.printStackTrace();}
	    DataContentjScrollPane2 = new javax.swing.JScrollPane();
	    DataContentjTable = new JTable();
	    
	    DataContentjPanelImport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	    DataContentjPanelExport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	    DataContentjPanelConvert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	    
	    
	    DataParametersboutonSaveData = new javax.swing.JButton();
		DataParametersboutonCancelData = new javax.swing.JButton();
		DataParametersnameData = new javax.swing.JTextField();
		DataParametersx = new javax.swing.JTextField();
		DataParametersy = new javax.swing.JTextField();
		DataParameterslabelNameData = new javax.swing.JLabel();
		DataParameterslabelX = new javax.swing.JLabel();
		DataParameterslabelY = new javax.swing.JLabel();
		DataParametersboutonSaveData.setText("Save");
		DataParametersboutonSaveData.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	try {
						DataParametersboutonSaveDataActionPerformed(evt);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	        });
		DataParametersboutonCancelData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	DataParametersboutonCancelDataActionPerformed(evt);
            }
        });
		DataParametersboutonCancelData.setText("Cancel");
		DataParametersnameData.setText("jTextField3");

		DataParametersx.setText("jTextField1");

		DataParametersy.setText("jTextField2");

		DataParameterslabelX.setText("X");

		DataParameterslabelY.setText("Y");

		DataParameterslabelNameData.setText("Name");
		
		try {
			
			DataParametersjPanel4 = new PanelImage("images/dataForm.png");
			DataParametersjPanel5 = new PanelImage("images/space.png");
			DataParametersjPanel6 = new PanelImage("images/space.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DataParameters = new javax.swing.JDialog();
		DataParameters.setModal(true);
		ProjectParameters.setModal(true);
		DataParametersjPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, null, javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
		jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, null, javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, null));
        
	    DataContentjPanelMenuEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	    DataContentjPanelMenuNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	    DataContentjPanelMenuDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	    DataContentjPanelImport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	    DataContentjPanelExport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
	    DataContentjPanelConvert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        
        DataContentjPanelSeparator1.setMaximumSize(new java.awt.Dimension(679, 3));
        DataContentjPanelSeparator1.setMinimumSize(new java.awt.Dimension(679, 3));
        DataContentjPanelSeparator1.setName("DataContentjPanelSeparator1"); // NOI18N
        DataContentjPanelSeparator1.setPreferredSize(new java.awt.Dimension(679, 3));

        javax.swing.GroupLayout DataContentjPanelSeparator1Layout = new javax.swing.GroupLayout(DataContentjPanelSeparator1);
        DataContentjPanelSeparator1.setLayout(DataContentjPanelSeparator1Layout);
        DataContentjPanelSeparator1Layout.setHorizontalGroup(
            DataContentjPanelSeparator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        DataContentjPanelSeparator1Layout.setVerticalGroup(
            DataContentjPanelSeparator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        DataContentjPanelMenu.setMaximumSize(new java.awt.Dimension(679, 26));
        DataContentjPanelMenu.setMinimumSize(new java.awt.Dimension(679, 26));
        DataContentjPanelMenu.setName("DataContentjPanelMenu"); // NOI18N
        DataContentjPanelMenu.setPreferredSize(new java.awt.Dimension(679, 26));

        DataContentjPanelMenuDelete.setName("DataContentjPanelMenuDelete"); // NOI18N

        javax.swing.GroupLayout DataContentjPanelMenuDeleteLayout = new javax.swing.GroupLayout(DataContentjPanelMenuDelete);
        DataContentjPanelMenuDelete.setLayout(DataContentjPanelMenuDeleteLayout);
        DataContentjPanelMenuDeleteLayout.setHorizontalGroup(
            DataContentjPanelMenuDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 89, Short.MAX_VALUE)
        );
        DataContentjPanelMenuDeleteLayout.setVerticalGroup(
            DataContentjPanelMenuDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        DataContentjPanelMenuNew.setName("DataContentjPanelMenuNew"); // NOI18N

        javax.swing.GroupLayout DataContentjPanelMenuNewLayout = new javax.swing.GroupLayout(DataContentjPanelMenuNew);
        DataContentjPanelMenuNew.setLayout(DataContentjPanelMenuNewLayout);
        DataContentjPanelMenuNewLayout.setHorizontalGroup(
            DataContentjPanelMenuNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 89, Short.MAX_VALUE)
        );
        DataContentjPanelMenuNewLayout.setVerticalGroup(
            DataContentjPanelMenuNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        DataContentjPanelMenuEdit.setName("DataContentjPanelMenuEdit"); // NOI18N

        javax.swing.GroupLayout DataContentjPanelMenuEditLayout = new javax.swing.GroupLayout(DataContentjPanelMenuEdit);
        DataContentjPanelMenuEdit.setLayout(DataContentjPanelMenuEditLayout);
        DataContentjPanelMenuEditLayout.setHorizontalGroup(
            DataContentjPanelMenuEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 89, Short.MAX_VALUE)
        );
        DataContentjPanelMenuEditLayout.setVerticalGroup(
            DataContentjPanelMenuEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DataContentjPanelMenuLayout = new javax.swing.GroupLayout(DataContentjPanelMenu);
        DataContentjPanelMenu.setLayout(DataContentjPanelMenuLayout);
        DataContentjPanelMenuLayout.setHorizontalGroup(
            DataContentjPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DataContentjPanelMenuLayout.createSequentialGroup()
                .addContainerGap(485, Short.MAX_VALUE)
                .addComponent(DataContentjPanelMenuNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DataContentjPanelMenuEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DataContentjPanelMenuDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        DataContentjPanelMenuLayout.setVerticalGroup(
            DataContentjPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DataContentjPanelMenuDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(DataContentjPanelMenuEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(DataContentjPanelMenuNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        DataContentjPanelSeparator2.setMaximumSize(new java.awt.Dimension(679, 40));
        DataContentjPanelSeparator2.setMinimumSize(new java.awt.Dimension(679, 40));
        DataContentjPanelSeparator2.setName("DataContentjPanelSeparator2"); // NOI18N
        DataContentjPanelSeparator2.setPreferredSize(new java.awt.Dimension(679, 40));

        javax.swing.GroupLayout DataContentjPanelSeparator2Layout = new javax.swing.GroupLayout(DataContentjPanelSeparator2);
        DataContentjPanelSeparator2.setLayout(DataContentjPanelSeparator2Layout);
        DataContentjPanelSeparator2Layout.setHorizontalGroup(
            DataContentjPanelSeparator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        DataContentjPanelSeparator2Layout.setVerticalGroup(
            DataContentjPanelSeparator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        DataContentjPanelTable.setMaximumSize(new java.awt.Dimension(679, 350));
        DataContentjPanelTable.setMinimumSize(new java.awt.Dimension(679, 350));
        DataContentjPanelTable.setName("DataContentjPanelTable"); // NOI18N
        DataContentjPanelTable.setPreferredSize(new java.awt.Dimension(679, 350));

        DataContentjScrollPane2.setName("DataContentjScrollPane2"); // NOI18N

        DataContentjTable.setMaximumSize(new java.awt.Dimension(300, 64));
        DataContentjTable.setMinimumSize(new java.awt.Dimension(300, 64));
        DataContentjTable.setName("DataContentjTable"); // NOI18N
        DataContentjScrollPane2.setViewportView(DataContentjTable);
        DataContentjPanelOperations.setMaximumSize(new java.awt.Dimension(135, 340));
        DataContentjPanelOperations.setMinimumSize(new java.awt.Dimension(135, 340));
        DataContentjPanelOperations.setName("DataContentjPanelOperations"); // NOI18N
        DataContentjPanelOperations.setPreferredSize(new java.awt.Dimension(135, 340));

        DataContentjPanelImport.setName("DataContentjPanelImport"); // NOI18N

        javax.swing.GroupLayout DataContentjPanelImportLayout = new javax.swing.GroupLayout(DataContentjPanelImport);
        DataContentjPanelImport.setLayout(DataContentjPanelImportLayout);
        DataContentjPanelImportLayout.setHorizontalGroup(
            DataContentjPanelImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );
        DataContentjPanelImportLayout.setVerticalGroup(
            DataContentjPanelImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        DataContentjPanelExport.setName("DataContentjPanelExport"); // NOI18N
        DataContentjPanelExport.setPreferredSize(new java.awt.Dimension(135, 48));

        javax.swing.GroupLayout DataContentjPanelExportLayout = new javax.swing.GroupLayout(DataContentjPanelExport);
        DataContentjPanelExport.setLayout(DataContentjPanelExportLayout);
        DataContentjPanelExportLayout.setHorizontalGroup(
            DataContentjPanelExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );
        DataContentjPanelExportLayout.setVerticalGroup(
            DataContentjPanelExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        DataContentjPanelConvert.setName("DataContentjPanelConvert"); // NOI18N
        DataContentjPanelConvert.setPreferredSize(new java.awt.Dimension(135, 48));

        javax.swing.GroupLayout DataContentjPanelConvertLayout = new javax.swing.GroupLayout(DataContentjPanelConvert);
        DataContentjPanelConvert.setLayout(DataContentjPanelConvertLayout);
        DataContentjPanelConvertLayout.setHorizontalGroup(
            DataContentjPanelConvertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );
        DataContentjPanelConvertLayout.setVerticalGroup(
            DataContentjPanelConvertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DataContentjPanelOperationsLayout = new javax.swing.GroupLayout(DataContentjPanelOperations);
        DataContentjPanelOperations.setLayout(DataContentjPanelOperationsLayout);
        DataContentjPanelOperationsLayout.setHorizontalGroup(
            DataContentjPanelOperationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DataContentjPanelImport, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
            .addComponent(DataContentjPanelExport, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
            .addComponent(DataContentjPanelConvert, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );
        DataContentjPanelOperationsLayout.setVerticalGroup(
            DataContentjPanelOperationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataContentjPanelOperationsLayout.createSequentialGroup()
                .addComponent(DataContentjPanelImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DataContentjPanelExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addComponent(DataContentjPanelConvert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout DataContentjPanelTableLayout = new javax.swing.GroupLayout(DataContentjPanelTable);
        DataContentjPanelTable.setLayout(DataContentjPanelTableLayout);
        DataContentjPanelTableLayout.setHorizontalGroup(
            DataContentjPanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DataContentjPanelTableLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(DataContentjScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(DataContentjPanelOperations, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        DataContentjPanelTableLayout.setVerticalGroup(
            DataContentjPanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DataContentjPanelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DataContentjPanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DataContentjScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addComponent(DataContentjPanelOperations, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DataContentjPanelTable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(DataContentjPanelSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(DataContentjPanelSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(DataContentjPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(DataContentjPanelSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DataContentjPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(DataContentjPanelSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DataContentjPanelTable, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
        );
        javax.swing.GroupLayout DataParametersLayout = new javax.swing.GroupLayout(DataParameters.getContentPane());
        DataParameters.getContentPane().setLayout(DataParametersLayout);
        DataParametersLayout.setHorizontalGroup(
            DataParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataParametersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DataParametersjPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        DataParametersLayout.setVerticalGroup(
            DataParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataParametersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DataParametersjPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        javax.swing.GroupLayout DataParametersjPanel4Layout = new javax.swing.GroupLayout(DataParametersjPanel4);
        DataParametersjPanel4.setLayout(DataParametersjPanel4Layout);
        DataParametersjPanel4Layout.setHorizontalGroup(
            DataParametersjPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DataParametersjPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DataParametersjPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DataParametersjPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        DataParametersjPanel4Layout.setVerticalGroup(
            DataParametersjPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataParametersjPanel4Layout.createSequentialGroup()
                .addComponent(DataParametersjPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DataParametersjPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        javax.swing.GroupLayout DataParametersjPanel5Layout = new javax.swing.GroupLayout(DataParametersjPanel5);
        DataParametersjPanel5.setLayout(DataParametersjPanel5Layout);
        DataParametersjPanel5Layout.setHorizontalGroup(
        		DataParametersjPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DataParametersjPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DataParametersboutonSaveData, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(DataParametersboutonCancelData)
                .addGap(10, 10, 10))
        );
        DataParametersjPanel5Layout.setVerticalGroup(
        		DataParametersjPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DataParametersjPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(DataParametersboutonCancelData, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addComponent(DataParametersboutonSaveData, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
        );
        
        javax.swing.GroupLayout DataParametersjPanel6Layout = new javax.swing.GroupLayout(DataParametersjPanel6);
        DataParametersjPanel6.setLayout(DataParametersjPanel6Layout);
        DataParametersjPanel6Layout.setHorizontalGroup(
        		DataParametersjPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DataParametersjPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DataParametersjPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DataParameterslabelY, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(DataParameterslabelX, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(DataParameterslabelNameData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DataParametersjPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DataParametersy, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DataParametersx, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DataParametersnameData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addContainerGap())
        );
        DataParametersjPanel6Layout.setVerticalGroup(
            DataParametersjPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataParametersjPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DataParametersjPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DataParameterslabelNameData, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(DataParametersnameData, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DataParametersjPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DataParametersx, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DataParameterslabelX, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGroup(DataParametersjPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DataParametersjPanel6Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(DataParametersy, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                    .addGroup(DataParametersjPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DataParameterslabelY, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                .addContainerGap())
        );
	}
	public void buildProjectsUI(){
		try{
		projectContentjPanelSeparator1 = new PanelImage("images/space.png");
        projectContentjPanelMenu = new PanelImage("images/space.png");
        projectContentjPanelMenuOpen  = new PanelImage("images/projectContentOpen.png");
        projectContentjPanelMenuEdit = new PanelImage("images/projectContentEdit.png");
        projectContentjPanelMenuNew = new PanelImage("images/projectContentNew.png");
        projectContentjPanelMenuDelete = new PanelImage("images/projectContentDelete.png");
        projectContentjPanelSeparator2 = new PanelImage("images/space.png");
        projectContentjPanelTable = new PanelImage("images/space.png");
		}
		catch(Exception e){e.printStackTrace();}
		
		
		
		projectContentjPanelMenuOpen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		projectContentjPanelMenuEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		projectContentjPanelMenuNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		projectContentjPanelMenuDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
        projectContentjScrollPane2 = new javax.swing.JScrollPane();
        projectContentjTable = new javax.swing.JTable();


        projectContentjPanelSeparator1.setName("projectContentjPanelSeparator1"); // NOI18N
        projectContentjPanelSeparator1.setMaximumSize(new java.awt.Dimension(679, 3));
        projectContentjPanelSeparator1.setMinimumSize(new java.awt.Dimension(679, 3));
        projectContentjPanelSeparator1.setPreferredSize(new java.awt.Dimension(679, 3));

        javax.swing.GroupLayout projectContentjPanelSeparator1Layout = new javax.swing.GroupLayout(projectContentjPanelSeparator1);
        projectContentjPanelSeparator1.setLayout(projectContentjPanelSeparator1Layout);
        projectContentjPanelSeparator1Layout.setHorizontalGroup(
            projectContentjPanelSeparator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 679, Short.MAX_VALUE)
        );
        projectContentjPanelSeparator1Layout.setVerticalGroup(
            projectContentjPanelSeparator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        projectContentjPanelMenu.setMaximumSize(new java.awt.Dimension(679, 26));
        projectContentjPanelMenu.setMinimumSize(new java.awt.Dimension(679, 26));
        projectContentjPanelMenu.setName("projectContentjPanelMenu"); // NOI18N
        projectContentjPanelMenu.setPreferredSize(new java.awt.Dimension(679, 26));

        projectContentjPanelMenuOpen.setName("projectContentjPanelMenuOpen"); // NOI18N

        javax.swing.GroupLayout projectContentjPanelMenuOpenLayout = new javax.swing.GroupLayout(projectContentjPanelMenuOpen);
        projectContentjPanelMenuOpen.setLayout(projectContentjPanelMenuOpenLayout);
        projectContentjPanelMenuOpenLayout.setHorizontalGroup(
            projectContentjPanelMenuOpenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 89, Short.MAX_VALUE)
        );
        projectContentjPanelMenuOpenLayout.setVerticalGroup(
            projectContentjPanelMenuOpenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        projectContentjPanelMenuEdit.setName("projectContentjPanelMenuEdit"); // NOI18N

        javax.swing.GroupLayout projectContentjPanelMenuEditLayout = new javax.swing.GroupLayout(projectContentjPanelMenuEdit);
        projectContentjPanelMenuEdit.setLayout(projectContentjPanelMenuEditLayout);
        projectContentjPanelMenuEditLayout.setHorizontalGroup(
            projectContentjPanelMenuEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 89, Short.MAX_VALUE)
        );
        projectContentjPanelMenuEditLayout.setVerticalGroup(
            projectContentjPanelMenuEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        projectContentjPanelMenuNew.setName("projectContentjPanelMenuNew"); // NOI18N

        javax.swing.GroupLayout projectContentjPanelMenuNewLayout = new javax.swing.GroupLayout(projectContentjPanelMenuNew);
        projectContentjPanelMenuNew.setLayout(projectContentjPanelMenuNewLayout);
        projectContentjPanelMenuNewLayout.setHorizontalGroup(
            projectContentjPanelMenuNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 89, Short.MAX_VALUE)
        );
        projectContentjPanelMenuNewLayout.setVerticalGroup(
            projectContentjPanelMenuNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        projectContentjPanelMenuDelete.setName("projectContentjPanelMenuDelete"); // NOI18N

        javax.swing.GroupLayout projectContentjPanelMenuDeleteLayout = new javax.swing.GroupLayout(projectContentjPanelMenuDelete);
        projectContentjPanelMenuDelete.setLayout(projectContentjPanelMenuDeleteLayout);
        projectContentjPanelMenuDeleteLayout.setHorizontalGroup(
            projectContentjPanelMenuDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 89, Short.MAX_VALUE)
        );
        projectContentjPanelMenuDeleteLayout.setVerticalGroup(
            projectContentjPanelMenuDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout projectContentjPanelMenuLayout = new javax.swing.GroupLayout(projectContentjPanelMenu);
        projectContentjPanelMenu.setLayout(projectContentjPanelMenuLayout);
        projectContentjPanelMenuLayout.setHorizontalGroup(
            projectContentjPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, projectContentjPanelMenuLayout.createSequentialGroup()
                .addContainerGap(277, Short.MAX_VALUE)
                .addComponent(projectContentjPanelMenuNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(projectContentjPanelMenuEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(projectContentjPanelMenuDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(projectContentjPanelMenuOpen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        projectContentjPanelMenuLayout.setVerticalGroup(
            projectContentjPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(projectContentjPanelMenuOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(projectContentjPanelMenuDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(projectContentjPanelMenuEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(projectContentjPanelMenuNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        projectContentjPanelSeparator2.setName("projectContentjPanelSeparator2"); // NOI18N
        projectContentjPanelSeparator2.setMaximumSize(new java.awt.Dimension(679, 40));
        projectContentjPanelSeparator2.setMinimumSize(new java.awt.Dimension(679, 40));
        projectContentjPanelSeparator2.setPreferredSize(new java.awt.Dimension(679, 40));

        javax.swing.GroupLayout projectContentjPanelSeparator2Layout = new javax.swing.GroupLayout(projectContentjPanelSeparator2);
        projectContentjPanelSeparator2.setLayout(projectContentjPanelSeparator2Layout);
        projectContentjPanelSeparator2Layout.setHorizontalGroup(
            projectContentjPanelSeparator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 679, Short.MAX_VALUE)
        );
        projectContentjPanelSeparator2Layout.setVerticalGroup(
            projectContentjPanelSeparator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        projectContentjPanelTable.setMaximumSize(new java.awt.Dimension(679, 350));
        projectContentjPanelTable.setMinimumSize(new java.awt.Dimension(679, 350));
        projectContentjPanelTable.setPreferredSize(new java.awt.Dimension(679, 350));
        projectContentjPanelTable.setName("projectContentjPanelTable"); // NOI18N

        projectContentjScrollPane2.setName("projectContentjScrollPane2"); // NOI18N

        projectContentjTable.setModel(Project.list());
        projectContentjTable.setName("projectContentjTable"); // NOI18N
        projectContentjScrollPane2.setViewportView(projectContentjTable);

        javax.swing.GroupLayout projectContentjPanelTableLayout = new javax.swing.GroupLayout(projectContentjPanelTable);
        projectContentjPanelTable.setLayout(projectContentjPanelTableLayout);
        projectContentjPanelTableLayout.setHorizontalGroup(
            projectContentjPanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, projectContentjPanelTableLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(projectContentjScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        projectContentjPanelTableLayout.setVerticalGroup(
            projectContentjPanelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectContentjPanelTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(projectContentjScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(projectContentjPanelTable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(projectContentjPanelSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(projectContentjPanelSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(projectContentjPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(projectContentjPanelSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(projectContentjPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(projectContentjPanelSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(projectContentjPanelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        
        
        
        ProjectParameters = new javax.swing.JDialog();
        
        ProjectParameters.setLocationByPlatform(true);
        ProjectParameters.setResizable(false);
        
        try {
        	jPanel4 = new PanelImage("images/projectForm.png");
        	jPanel5 = new PanelImage("images/space.png");
			jPanel6 = new PanelImage("images/space.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        name = new javax.swing.JTextField();
        region = new javax.swing.JTextField();
        town = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        author = new javax.swing.JTextField();
        description = new javax.swing.JTextField();
        labelName = new javax.swing.JLabel();
        labelRegion = new javax.swing.JLabel();
        labelTown = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();
        labelAuthor = new javax.swing.JLabel();
        labelDescription = new javax.swing.JLabel();
       
        boutonSave = new javax.swing.JButton();
        boutonCancel = new javax.swing.JButton();
       

        ProjectParameters.setLocationByPlatform(true);
        ProjectParameters.setMinimumSize(new java.awt.Dimension(375, 300));
        
        ProjectParameters.setResizable(false);
        ProjectParameters.setTitle("Project Parameters");


        labelName.setText("Name");

        labelRegion.setText("Region");

        labelTown.setText("Town");

        labelDate.setText("Date");

        labelAuthor.setText("Author");

        labelDescription.setText("Description");
        boutonSave.setText("Save");
        boutonCancel.setText("Cancel");
        
        
        
        
        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelRegion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelTown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelDescription))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(author, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                            .addComponent(date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                            .addComponent(town, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                            .addComponent(region, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                            .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                            .addComponent(description, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(region, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRegion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(town, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTown))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(author, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAuthor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDescription))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        
        javax.swing.GroupLayout ProjectParametersLayout = new javax.swing.GroupLayout(ProjectParameters.getContentPane());
        ProjectParameters.getContentPane().setLayout(ProjectParametersLayout);
        ProjectParametersLayout.setHorizontalGroup(
            ProjectParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
            .addGroup(ProjectParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ProjectParametersLayout.createSequentialGroup()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        ProjectParametersLayout.setVerticalGroup(
            ProjectParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
            .addGroup(ProjectParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ProjectParametersLayout.createSequentialGroup()
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(43, Short.MAX_VALUE)))
        );
        
        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(boutonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boutonCancel)
                .addGap(80, 80, 80))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutonSave, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(boutonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
       
	}
	private void DataParametersboutonSaveDataActionPerformed(java.awt.event.ActionEvent evt) throws RemoteException {                                               
        // TODO add your handling code here:
        
        String nameD = DataParametersnameData.getText().toString();
        double xD = Double.parseDouble(DataParametersx.getText().toString());
        double yD = Double.parseDouble(DataParametersy.getText().toString());
        
        PointGAUSS pt = new PointGAUSS( project, idData, nameD , xD, yD);
        if(choice == 0){
            pt.create();
        } else if(choice == 1){
            pt.modify();
        }
        DataParameters.dispose();
        DataContentjTable.removeAll();
        DataContentjTable.setModel(PointGAUSS.listProject(project));
        DataContentjTable.revalidate();
        
    }
	private void DataParametersboutonCancelDataActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
		DataParameters.dispose();
    }
	public static void enregistrerSous(JTable jTable1, String nom)
	{
		 HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("Bordereau");
			int  a = jTable1.getRowCount();
			int b =jTable1.getColumnCount();
			for(int i=0;i<a;i++)
			{
			   HSSFRow row = sheet.createRow(i);
			   for(int j=0;j<b;j++)
			   {
				  HSSFCell cell = row.createCell((short)j);
				  cell.setCellValue((String) jTable1.getValueAt(i,j));

			   }
			}
			JFileChooser save=new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
				   "Fichier Excel 2003", "xls");
				save.setFileFilter(filter);
			save.setSelectedFile(new File(nom));
			int retour=save.showSaveDialog(jTable1.getParent());

			FileOutputStream fileOut;
			try {
			  fileOut = new FileOutputStream(save.getSelectedFile().getPath());
			  wb.write(fileOut);
			  fileOut.close();
			  ouvrirProg(save.getSelectedFile().getPath());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public static void ouvrirProg(String chemin)
	 {
		 if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();
				if (desktop.isSupported(java.awt.Desktop.Action.OPEN)) {
					try {
						desktop.open(new File(chemin));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			else
			{
				String[] cmdArray = null;
				final String filePath = new File(chemin).getAbsolutePath();

				String osName = System.getProperty("os.name");
				if (osName.indexOf("Windows") >= 0) {
					// Sous Windows la commande diff�re selon la version :
					if (osName.indexOf("Windows 9")>=0 || osName.indexOf("Windows Me")>=0) {
						// Sous les Windows 9x ou Me, on doit utiliser "command.com" :
						cmdArray = new String[] {"command.com", "/C", filePath};
					} else {
						// Sous Windows NT ou les Windows depuis 2000, on utilise cmd.exe :
						cmdArray = new String[] {"cmd.exe", "/C", filePath};
					}
				} else if (osName.indexOf("Mac OS") >= 0) {
					// Sous Max OS on utilise directement 'open'
					cmdArray = new String[] {"open", filePath};
				} else if (osName.indexOf("Linux") >= 0) {
					// Sous linux on utilise directement 'xdg-open'
					cmdArray = new String[] {"xdg-open", filePath};
				} else {
					try {
						throw new IOException("Unsupported Operating System : " + osName);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				// On lance le process correspondant :
				try {
					Process process = Runtime.getRuntime().exec(cmdArray);
					// Et on ferme les flux d'E/S standard
					// (sinon cela peut provoquer des blocages)
					process.getInputStream().close();
					process.getOutputStream().close();
					process.getErrorStream().close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	 }
	
	
	public void buildEasyConverterUI(){
		try{
		easyConverterContent2 = new PanelImage("images/space.png");
		easyConverterjPanel1 = new PanelImage("images/space.png");
		easyConverterjPanel3 = new PanelImage("images/space.png");
		easyConverterjPanel2 = new PanelImage("images/space.png");
		}
		catch(Exception e){e.printStackTrace();}
        
        easyConvertercoordX = new javax.swing.JTextField();
        easyConvertercoordY = new javax.swing.JTextField();
        easyConverterlabelX = new javax.swing.JLabel();
        easyConverterlabelY = new javax.swing.JLabel();
        
        easyConvertercoordX1 = new javax.swing.JTextField();
        easyConvertercoordY1 = new javax.swing.JTextField();
        easyConverterlabelX2 = new javax.swing.JLabel();
        easyConverterlabelX3 = new javax.swing.JLabel();
        easyConverterboutonConvert = new javax.swing.JButton();
        easyConverterboutonConvert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                easyConverterboutonConvertActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 800, 525));
        setName("Form"); // NOI18N
        setResizable(false);

        easyConverterContent2.setMaximumSize(new java.awt.Dimension(509, 114));
        easyConverterContent2.setName("easyConverterContent2"); // NOI18N
        easyConverterContent2.setPreferredSize(new java.awt.Dimension(509, 114));
        
        easyConverterjPanel2.setMaximumSize(new java.awt.Dimension(509, 170));
        easyConverterjPanel2.setName("easyConverterContent2"); // NOI18N
        easyConverterjPanel2.setPreferredSize(new java.awt.Dimension(509, 170));

        easyConverterjPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gauss Point", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, null)); // NOI18N
        easyConverterjPanel1.setName("easyConverterjPanel1"); // NOI18N

        easyConvertercoordX.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        easyConvertercoordX.setName("easyConvertercoordX"); // NOI18N

        easyConvertercoordY.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        easyConvertercoordY.setName("easyConvertercoordY"); // NOI18N
        easyConverterlabelX.setText("X"); // NOI18N
        easyConverterlabelX.setName("easyConverterlabelX"); // NOI18N

        easyConverterlabelY.setText("Y"); // NOI18N
        easyConverterlabelY.setName("easyConverterlabelY"); // NOI18N
        
        easyConverterjPanel2.setName("jPanel2"); // NOI18N

        javax.swing.GroupLayout easyConverterjPanel2Layout = new javax.swing.GroupLayout(easyConverterjPanel2);
        easyConverterjPanel2.setLayout(easyConverterjPanel2Layout);
        easyConverterjPanel2Layout.setHorizontalGroup(
        		easyConverterjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
        );
        easyConverterjPanel2Layout.setVerticalGroup(
        		easyConverterjPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        
        javax.swing.GroupLayout easyConverterjPanel1Layout = new javax.swing.GroupLayout(easyConverterjPanel1);
        easyConverterjPanel1.setLayout(easyConverterjPanel1Layout);
        easyConverterjPanel1Layout.setHorizontalGroup(
            easyConverterjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(easyConverterjPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(easyConverterjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(easyConverterjPanel1Layout.createSequentialGroup()
                        .addComponent(easyConverterlabelX, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(easyConvertercoordX, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(easyConverterjPanel1Layout.createSequentialGroup()
                        .addComponent(easyConverterlabelY, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(easyConvertercoordY, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        easyConverterjPanel1Layout.setVerticalGroup(
            easyConverterjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(easyConverterjPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(easyConverterjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(easyConvertercoordX, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(easyConverterlabelX, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(easyConverterjPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(easyConvertercoordY, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(easyConverterlabelY, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        easyConverterjPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "UTM Point", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, null)); // NOI18N
        easyConverterjPanel3.setName("easyConverterjPanel3"); // NOI18N

        easyConvertercoordX1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        easyConvertercoordX1.setName("easyConvertercoordX1"); // NOI18N

        easyConvertercoordY1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        easyConvertercoordY1.setName("easyConvertercoordY1"); // NOI18N

        easyConverterlabelX2.setText("Long"); // NOI18N
        easyConverterlabelX2.setName("easyConverterlabelX2"); // NOI18N

        easyConverterlabelX3.setText("Latt"); // NOI18N
        easyConverterlabelX3.setName("easyConverterlabelX3"); // NOI18N

        javax.swing.GroupLayout easyConverterjPanel3Layout = new javax.swing.GroupLayout(easyConverterjPanel3);
        easyConverterjPanel3.setLayout(easyConverterjPanel3Layout);
        easyConverterjPanel3Layout.setHorizontalGroup(
            easyConverterjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(easyConverterjPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(easyConverterjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(easyConverterjPanel3Layout.createSequentialGroup()
                        .addComponent(easyConverterlabelX2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(easyConvertercoordX1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(easyConverterjPanel3Layout.createSequentialGroup()
                        .addComponent(easyConverterlabelX3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(easyConvertercoordY1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        easyConverterjPanel3Layout.setVerticalGroup(
            easyConverterjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(easyConverterjPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(easyConverterjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(easyConvertercoordX1, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(easyConverterlabelX2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(easyConverterjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(easyConvertercoordY1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(easyConverterlabelX3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        easyConverterboutonConvert.setText("Convert"); // NOI18N
        easyConverterboutonConvert.setName("easyConverterboutonConvert"); // NOI18N

        javax.swing.GroupLayout easyConverterContent2Layout = new javax.swing.GroupLayout(easyConverterContent2);
        easyConverterContent2.setLayout(easyConverterContent2Layout);
        easyConverterContent2Layout.setHorizontalGroup(
            easyConverterContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(easyConverterContent2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(easyConverterjPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(easyConverterboutonConvert)
                .addGap(18, 18, 18)
                .addComponent(easyConverterjPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        easyConverterContent2Layout.setVerticalGroup(
            easyConverterContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(easyConverterContent2Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(easyConverterboutonConvert))
            .addGroup(easyConverterContent2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(easyConverterContent2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(easyConverterjPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(easyConverterjPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(91, 91, 91)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(easyConverterjPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(easyConverterContent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(131, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(easyConverterjPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(easyConverterContent2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31))
            );
       
	}
}
