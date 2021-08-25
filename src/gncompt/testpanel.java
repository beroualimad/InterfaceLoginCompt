package gncompt;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import gncompt.connexion;

public class testpanel extends JFrame {
	
	private JPanel panel3;
	private JTable table;
	
	private  JTextField N_ccp1;
	JFrame frame=new JFrame();
	JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
	
	
	private  JPasswordField passwordField;
	private JTextField N_ccp;
	private  JTextField Nom;
	private JPasswordField Pass;
	private JTextField adresse;
	private JTextField Phone;
	private JTextField Cle;
	private JTextField prenom;
	private JPasswordField configpass;
	private JComboBox choice;
	JButton bChangerPanel = new JButton();
	
	connexion con=new connexion();
	private Statement st=null;
	private ResultSet rs=null;
	
	
testpanel() throws Exception {
	
	
      
	/*private Statement st=null;
	private ResultSet rs=null;*/
		//ImageIcon icon=new ImageIcon(ImageIO.read(new File("/images/user.png")));
		
         
	     
		
		//this.panel1.setEnabled(false);
	    //frame.getContentPane().setBackground(new Color(51, 204, 204));
	    //frame.getContentPane().new ImageIcon(ImageIO.read(new File("/images/user.png"))));
		
		panel1.setForeground(Color.RED);
	    panel1.setBounds(100, 100, 450, 300);
		
		panel1.setLayout(null);
		
		
		
		JLabel lblN_Ccp = new JLabel("N_Ccp");
		//lblUsername.setIcon(new ImageIcon(getClass().getResource("/images/user.png")));
		lblN_Ccp.setFont(new Font("Lucida Sans Typewriter", Font.BOLD | Font.ITALIC, 11));
		lblN_Ccp.setForeground(new Color(0, 102, 0));
		lblN_Ccp.setBackground(new Color(51, 102, 204));
		lblN_Ccp.setBounds(23, 91, 106, 23);
		panel1.add(lblN_Ccp);
		
		N_ccp1 = new JTextField();
		N_ccp1.setBackground(new Color(51, 204, 102));
		N_ccp1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		N_ccp1.setForeground(new Color(51, 0, 255));
		N_ccp1.setBounds(139, 91, 161, 23);
		panel1.add(N_ccp1);
		N_ccp1.setColumns(10);
		
		JLabel lblPassword = new JLabel("passWord");
		lblPassword.setForeground(new Color(0, 102, 0));
		lblPassword.setFont(new Font("Lucida Sans Typewriter", Font.BOLD | Font.ITALIC, 11));
		lblPassword.setBounds(23, 154, 100, 14);
		panel1.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(51, 204, 102));
		passwordField.setForeground(new Color(51, 0, 204));
		passwordField.setBounds(139, 150, 161, 23);
		panel1.add(passwordField);
		
		
		JButton btnLogin = new JButton("Login ");
		btnLogin.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnLogin.setBackground(new Color(102, 0, 51));
		btnLogin.setForeground(new Color(204, 0, 0));
		btnLogin.setBounds(211, 202, 89, 23);
		panel1.add(btnLogin);
		
	
		JLabel lblVeriferCompeBoncaire = new JLabel("   Login");
		lblVeriferCompeBoncaire.setForeground(new Color(0, 0, 0));
		lblVeriferCompeBoncaire.setBackground(new Color(255, 0, 51));
		lblVeriferCompeBoncaire.setFont(new Font("Microsoft Uighur", Font.BOLD, 35));
		lblVeriferCompeBoncaire.setBounds(177, 0, 78, 68);
		panel1.add(lblVeriferCompeBoncaire);
		
		JLabel lblNewAccounet = new JLabel(">>No Account !Create one?");
		lblNewAccounet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Border label_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.red);
				lblNewAccounet.setBorder(label_border);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewAccounet.setBorder(null);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				  frame.setContentPane(panel2);
			        frame.revalidate();
			}
		});
	
		lblNewAccounet.setForeground(new Color(255,51,51));
		
		lblNewAccounet.setBounds(139,267, 155, 14);
		panel1.add(lblNewAccounet);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 102));
		panel.setBounds(0, 0, 434, 68);
		panel1.add(panel);
		
		
	
		btnLogin.addActionListener(new ActionListener()  {
			
			
			@Override
			public void actionPerformed(ActionEvent e){
				boolean b=false;
				try {
				
				  Connection conn = connexion.getMySqlConnection();
				  	
					PreparedStatement ps=conn.prepareStatement("Select * from Clientinf where N_ccp = ? and passeword=?");
				
					ps.setString(1,N_ccp1.getText() );
					ps.setString(2,passwordField.getText() ); 
				    ResultSet rms=ps.executeQuery();
	     
		            if(((ResultSet) rms).next()) {
		            	b=true;
		            	
		            }
		           
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
		    
	  if(b==true) {
		    JOptionPane.showMessageDialog(frame,"you are sucessfuly login");
		 
		    frame.setContentPane(panel3);
		  }else {
		JOptionPane.showMessageDialog(frame,"Invalid username or password");
        }
	  N_ccp1.setText("");	  
	  passwordField.setText("");
			}});
		
		
		
		
		
	/*panel 2*/
		panel2.setBackground(new Color(51, 102, 204));
		//frame.getContentPane().setForeground(Color.RED);
		panel2.setBounds(100, 100, 450, 328);
	
		//this.panel2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       this.panel2.setLayout(null);
		
		JLabel lblN_ccp=  new JLabel("N_Ccp :");
		lblN_ccp.setBounds(10, 77, 66, 14);
		panel2.add(lblN_ccp);
		
		JLabel lblNom =  new JLabel("Nom :");
		lblNom.setBounds(10, 107, 66, 14);
		panel2.add(lblNom);
		
		JLabel lblPasseWord = new JLabel("Password :");
		lblPasseWord.setBounds(10, 137, 66, 14);
		panel2.add(lblPasseWord);
		
		JLabel lblConffi = new JLabel("Confirm :");
		lblConffi.setBounds(263, 137, 97, 14);
		panel2.add(lblConffi);
		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setBounds(10, 194, 46, 14);
		panel2.add(lblPhone);
		
		JLabel lblGender= new JLabel("Gender :");
		lblGender.setBounds(10, 219, 66, 14);
		
		panel2.add(lblGender);
		
		JButton btnReg = new JButton("Registrer");
		
		//btnReg.setEnabled(false);
		
		
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String n_ccp=N_ccp.getText();
				String cle= Cle.getText();
				String preNom= prenom.getText();
				String nom= Nom.getText();
				String pass= Pass.getText();
				String Adresse= adresse.getText();
				String tlf= Phone.getText();
				String cho= choice.getSelectedItem().toString();
				if(N_ccp.getText().equals("") && nom.equals("") && pass.equals("") && Adresse.equals("") && tlf.equals("")) {
					
					 JOptionPane.showMessageDialog(frame,"Please.Enter your information");
					
				}else {
					 btnReg.setEnabled(true);
                 if(N_ccp.getText().equals("") || nom.equals("") || pass.equals("") || Adresse.equals("") || tlf.equals("")) {
                	 btnReg.setEnabled(true);
                	 JOptionPane.showMessageDialog(frame,"Your information is incomplete");
                 }else {
                	 btnReg.setEnabled(true);
                	 try {
                		 Connection con;JLabel last =new JLabel("Data inserted successfully");
                		 Class.forName("com.mysql.jdbc.Driver");
                		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ComptClient?useSSL=false","root","2301000ber");
						PreparedStatement ps=con.prepareStatement("Insert into Clientinf values(?,?,?,?,?,?,?,?)");
						
						PreparedStatement ps1=con.prepareStatement("Insert into carte values(?,default)");
						
						
						ps.setString(1,n_ccp);
						ps.setString(2,cle);
						ps.setString(3,nom);
						ps.setString(4,preNom);
						ps.setString(5,pass);
						ps.setString(6,Adresse);
						ps.setString(7,tlf);
						ps.setString(8,cho);
					
						ps1.setString(1,n_ccp);
						
						ps.executeUpdate();
						
						ps1.executeUpdate();
						
						N_ccp.setText("");
						Cle.setText("");
						Nom.setText("");
						prenom.setText("");
						Pass.setText("");
						adresse.setText("");
						Phone.setText("");
						configpass.setText("");
						
						JOptionPane.showMessageDialog(frame,"you are sucessfuly Registrer");
					
						frame.setContentPane(panel3);
					} catch (Exception e1) {
						N_ccp.setText("");
						Cle.setText("");
						Nom.setText("");
						prenom.setText("");
						Pass.setText("");
						adresse.setText("");
						Phone.setText("");
						configpass.setText("");
						JOptionPane.showMessageDialog(frame,"Error. Please try again");
						System.out.println("ERROR  "+e1);
						
					}
				    
                 }
				}}
		});
		btnReg.setBounds(245, 250, 125, 23);
		btnReg.setBackground(new Color(51, 204, 204));
		panel2.add(btnReg);
		
		N_ccp = new JTextField();
		N_ccp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   btnReg.setEnabled(false);
				if(N_ccp.getText().equals(" ")) {
					btnReg.setEnabled(true);
				}
			}
		});
		N_ccp.setBounds(128, 75, 125, 17);
		panel2.add(N_ccp);
		N_ccp.setColumns(10);
		
		Nom = new JTextField();
		Nom.setBounds(128, 105, 125, 17);
		panel2.add(Nom);
		Nom.setColumns(10);
		
		Pass= new JPasswordField();
		Pass.setBounds(128, 135, 125, 17);
		panel2.add(Pass);
		Pass.setColumns(10);
		
		adresse = new JTextField();
		adresse.setBounds(128, 164, 234, 17);
	    panel2.add(adresse);
	    adresse.setColumns(10);
		
		Phone = new JTextField();
		Phone.setBounds(128, 192, 234, 17);
		panel2.add(Phone);
		Phone.setColumns(10);
		
		//Choice choice = new Choice();
		String str[]={"Male","Female"};
	    choice = new JComboBox(str);
		//choice.setModel(new DefaultComboBoxModel(new String[] {"Male", "famme"}));
		choice.setBounds(128, 219, 88, 23);
		panel2.add(choice);
		
		JLabel lblCle = new JLabel("Cle :");
		lblCle.setBounds(263, 77, 46, 14);
		panel2.add(lblCle);
		
		Cle = new JTextField();
		Cle.setBounds(316, 73, 62, 18);
		panel2.add(Cle);
		Cle.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(316, 104, 108, 17);
		panel2.add(prenom);
		prenom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(263, 107, 46, 14);
		panel2.add(lblPrenom);
		
		configpass = new JPasswordField();
		configpass.setBounds(316, 134, 108, 17);
		panel2.add(configpass);
		configpass.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setBounds(10, 169, 46, 14);
		panel2.add(lblAdresse);
		
		JLabel lblRegestrer = new JLabel("  REGESTRER");
		lblRegestrer.setForeground(new Color(0, 0, 102));
		lblRegestrer.setBackground(new Color(102, 255, 204));
		lblRegestrer.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblRegestrer.setBounds(127, 11, 126, 23);
	    panel2.add(lblRegestrer);
		
	    JLabel lblNewLabel_1 = new JLabel(">>Already Have a Account ?Login !");
		lblNewLabel_1.setForeground(new Color(255, 51, 51));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Border label_border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.red);
				lblNewLabel_1.setBorder(label_border);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setBorder(null);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				 frame.setContentPane(panel1);
			        frame.revalidate();
			}
		});
		lblNewLabel_1.setBounds(142, 278, 195, 14);
		panel2.add(lblNewLabel_1);
		
	
		   /*panel 03*/
		setBounds(100, 100, 100, 100);
		panel3 = new JPanel();
		panel3.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel3);
		panel3.setLayout(null);
		Vector columnNames = new Vector();
		Vector data = new Vector();

		try {
		  Connection conn = connexion.getMySqlConnection();
		 // String us=N_ccp1.getText();
		
		//String sql = "Select * from Clientinf ";
		//int in=Integer.parseInt(N_ccp1.getText());
		st = conn.createStatement();
		
		rs = st.executeQuery("Select sold from carte where N_ccp "+N_ccp1.getText()+"");
		//rs = st.executeQuery("Select sold from carte where N_ccp =256987456");
	
		ResultSetMetaData md = rs.getMetaData();
	
		int columns = md.getColumnCount();
		for (int i = 1; i <= columns; i++) {
		columnNames.addElement( md.getColumnName(i) );
		}
		while (rs.next()) {
		 Vector row = new Vector(columns);
		for (int i = 1; i <= columns; i++) {
		row.addElement( rs.getObject(i) );
		}
		data.addElement( row );
		}
		rs.close();
		st.close();
		}
		catch(Exception e) {
		System.out.println( e );
		}
/*
		table = new JTable(data, columnNames);
		table.setBounds(678, 325, -637, -255);
		contentPane.add(table);*/
	
		JLabel lblUneTable = new JLabel("Une table");
		lblUneTable.setBounds(150, 11, 83, 14);
		panel3.add(lblUneTable);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		JLabel lblUne = new JLabel("You Sold: ");
		lblUne.setForeground(new Color(0, 102, 0));
		lblUne.setFont(new Font("Lucida Sans Typewriter", Font.BOLD | Font.ITALIC, 11));
		lblUne.setBounds(23, 40, 100, 14);
		
//		contentPane.add(lblUne);
		
		
		
		table = new JTable(data, columnNames);
		table.setBounds(150,50,70,40);
		panel3.add(table);
	 
		JTextField diposer=new JTextField();
		diposer.setBounds(50,50,50,50);
		panel3.add(diposer);
         
		JButton disp=new JButton("dipose");
		disp.setBounds(120,100,120,100);
		disp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
			
					 Connection conn = connexion.getMySqlConnection();
					 
					
						PreparedStatement ps=conn.prepareStatement("UPDATE carte set sold=? where N_ccp"+N_ccp.getText()+"");
						
						 ps.setString(1, diposer.getText());
				         ps.execute();
					   
					    ps.close();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			
			}});
		panel3.add(disp);
		
		
		
		frame.setContentPane(panel1);
		//frame.pack();
		//frame.setSize(250,200);
		frame.setBounds(100, 110, 450, 328);
	
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
}
	

  

       

	 public static void main(String[] args) throws Exception {
		 testpanel window = new testpanel();
		
}
	
	 }