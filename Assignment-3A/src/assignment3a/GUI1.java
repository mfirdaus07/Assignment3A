package assignment3a;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.SwingConstants;

public class GUI1 {

	private JFrame frmShortVideoDatabase;
	private JTextField jtxtTitle;
	private JTextField jtxtDate;
	private JTextField jtxtDesc;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI1 window = new GUI1();
					window.frmShortVideoDatabase.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmShortVideoDatabase = new JFrame();
		frmShortVideoDatabase.setTitle("Short Video Database System");
		frmShortVideoDatabase.setBounds(100, 100, 469, 407);
		frmShortVideoDatabase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmShortVideoDatabase.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 433, 136);
		frmShortVideoDatabase.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Video Title");
		lblNewLabel.setBounds(10, 11, 65, 14);
		panel.add(lblNewLabel);
		
		jtxtTitle = new JTextField();
		jtxtTitle.setBounds(143, 8, 195, 20);
		panel.add(jtxtTitle);
		jtxtTitle.setColumns(10);
		
		jtxtDate = new JTextField();
		jtxtDate.setBounds(143, 39, 116, 20);
		panel.add(jtxtDate);
		jtxtDate.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Date Released");
		lblNewLabel_1.setBounds(10, 45, 86, 14);
		panel.add(lblNewLabel_1);
		
		jtxtDesc = new JTextField();
		jtxtDesc.setBounds(143, 70, 261, 20);
		panel.add(jtxtDesc);
		jtxtDesc.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Description");
		lblNewLabel_2.setBounds(10, 76, 86, 14);
		panel.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Genre", "Animation", "Comedy", "Cartoon", "Documentary", "Thriller"}));
		comboBox.setBounds(143, 101, 116, 22);
		panel.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Genre");
		lblNewLabel_3.setBounds(10, 105, 46, 14);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.RED);
		panel_1.setBounds(10, 158, 433, 35);
		frmShortVideoDatabase.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Record");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{
						jtxtTitle.getText(),
						comboBox.getSelectedItem(),
						jtxtDate.getText(),
						jtxtDesc.getText(), 
						
				});
				
				if (table.getSelectedRow() == -1){
			           if (table.getRowCount() == 0){
			           JOptionPane.showMessageDialog(null, "Short Video Database System Update confirmed","Short Video Database System",
			                   JOptionPane.OK_OPTION);
			           }
			       }   
			}
			
		});
		btnNewButton.setBounds(6, 6, 101, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtxtTitle.setText("");
				jtxtDate.setText("");
				jtxtDesc.setText("");
				comboBox.setSelectedItem("Select Genre");
			}
		});
		btnNewButton_1.setBounds(117, 6, 75, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
		        if(table.getSelectedRow()==-1){
		            if(table.getRowCount()==0){

		                JOptionPane.showMessageDialog(null, "No data to delete ", 
		                        "Short Video Database System",JOptionPane.OK_OPTION);
		            }else{

		                JOptionPane.showMessageDialog(null, "Select a row to delete ", 
		                        "Short Video Database System",JOptionPane.OK_OPTION);
		            }
		        }else{
		            model.removeRow(table.getSelectedRow());
		        }    
				
			}
		});
		btnNewButton_2.setBounds(202, 6, 75, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Test");
		btnNewButton_4.setBounds(334, 6, 89, 23);
		panel_1.add(btnNewButton_4);
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Test");
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 203, 433, 98);
		frmShortVideoDatabase.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Video Title", "Genre", "Date Released" , "Description", 
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(84);
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 312, 433, 45);
		frmShortVideoDatabase.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_5 = new JButton("Exit");
		btnNewButton_5.setBounds(349, 11, 74, 23);
		panel_2.add(btnNewButton_5);
		
		JButton btnNewButton_3 = new JButton("Print");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					table.print();
				}
				catch(java.awt.print.PrinterException e1){
					System.err.format("No Printer found", e1.getMessage());
				}	
			}
		});
		btnNewButton_3.setBounds(252, 11, 87, 23);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_6 = new JButton("Export Text");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				try{
	                //the file path
	               File file = new File("C:\\Users\\User\\Desktop\\Lol.txt"); //change dir for file
	               //if the file not exist create one
	               if(!file.exists()){
	                   file.createNewFile();
	               }
	               
	               FileWriter fw = new FileWriter(file.getAbsoluteFile());
	               BufferedWriter bw = new BufferedWriter(fw);
	               
	               //loop for jtable rows
	               for(int i = 0; i < table.getRowCount(); i++){
	                   //loop for jtable column
	                   for(int j = 0; j < table.getColumnCount(); j++){
	                       bw.write(table.getModel().getValueAt(i, j)+" ");
	                   }
	                   //break line at the begin 
	                   //break line at the end 
	                   //bw.write("\n_________\n");
	                   bw.write("\n\n");
	               }
	               //close BufferedWriter
	               bw.close();
	               //close FileWriter 
	               fw.close();
	               JOptionPane.showMessageDialog(null, "Data Exported");
	               
	               }catch(Exception ex){
	                   ex.printStackTrace();
	               }
				
			}
		});
		btnNewButton_6.setBounds(0, 11, 107, 23);
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Export CSV");
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
		        fileChooser.setDialogTitle("Specify a file save");
		        int userSelection = fileChooser.showSaveDialog(null);
		        if(userSelection == JFileChooser.APPROVE_OPTION){
		            File fileToSave = fileChooser.getSelectedFile();
		            //lets write to file
		         
		            try {
		                  FileWriter fw = new FileWriter(fileToSave + ".csv");
		                BufferedWriter bw = new BufferedWriter(fw);
		                
		                for(int i = 0; i < table.getRowCount(); i++){
			                   //loop for jtable column
			                   for(int j = 0; j < table.getColumnCount(); j++){
			                       //bw.write(table.getModel().getValueAt(i, j)+" ");
		                //for (int i = 0; table.getRowCount(); i++) {
		                    //for (int j = 0; table.getColumnCount(); j++) {
		                        //write
		                        bw.write(table.getValueAt(i, j).toString()+",");
		                    }
		                    bw.newLine();//record per line 
		                }
		                JOptionPane.showMessageDialog(null, "Data Exported Succesfuly","Information",JOptionPane.INFORMATION_MESSAGE);
		                bw.close();
		                fw.close();
		            } catch (IOException ex) {
		               JOptionPane.showMessageDialog(null, "ERROR","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
		            }
		            
		            
		        }
			}
		});
		btnNewButton_7.setBounds(135, 11, 107, 23);
		panel_2.add(btnNewButton_7);
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmShortVideoDatabase =new JFrame();
		        if (JOptionPane.showConfirmDialog(frmShortVideoDatabase,"Confirm if you want to exit", "Short Video Database System",
		              JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
		            System.exit(0);
		        }
			}
		});
	}
}
