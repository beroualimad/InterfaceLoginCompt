package gncompt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class registercompte {

	private JFrame frame;
	private JTextField FulName;
	private JTextField UserName;
	private JPasswordField Pass;
	private JPasswordField ConPass;
	private JTextField Phone;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registercompte window = new registercompte();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	/*public registercompte() {
		initialize1();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize1() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 102, 204));
		//frame.getContentPane().setForeground(Color.RED);
		frame.setBounds(100, 100, 450, 328);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFullName = new JLabel("N_Ccp :");
		lblFullName.setBounds(10, 77, 66, 14);
		frame.getContentPane().add(lblFullName);
		
		JLabel lblUserName = new JLabel("Nom :");
		lblUserName.setBounds(10, 107, 66, 14);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPasseWord = new JLabel("Password :");
		lblPasseWord.setBounds(10, 137, 66, 14);
		frame.getContentPane().add(lblPasseWord);
		
		JLabel lblConffi = new JLabel("Confirm :");
		lblConffi.setBounds(263, 137, 97, 14);
		frame.getContentPane().add(lblConffi);
		
		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setBounds(10, 194, 46, 14);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblNewLabel = new JLabel("Gender :");
		lblNewLabel.setBounds(10, 219, 66, 14);
		
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnReg = new JButton("Registrer");
		btnReg.setEnabled(false);
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String funame=FulName.getText();
				 
				String usname= UserName.getText();
				String pass= Pass.getText();
				String conpass= ConPass.getText();
				String tlf= Phone.getText();
				if(FulName.getText().equals("") && usname.equals("") && pass.equals("") && conpass.equals("") && tlf.equals("")) {
					// btnReg.setEnabled(false);
					 JOptionPane.showMessageDialog(frame,"Please.Enter your information");
					// btnReg.setEnabled(true);
				}else
					 btnReg.setEnabled(true);
                 if(FulName.getText().equals("") || usname.equals("") || pass.equals("") || conpass.equals("") || tlf.equals("")) {
                	 btnReg.setEnabled(true);
                	 JOptionPane.showMessageDialog(frame,"Your information is incomplete");
                 }else {
                	 btnReg.setEnabled(true);
				     JOptionPane.showMessageDialog(frame,"you are sucessfuly Registrer");
                 }
			}
		});
		btnReg.setBounds(247, 258, 125, 23);
		btnReg.setBackground(new Color(51, 204, 204));
		frame.getContentPane().add(btnReg);
		
		FulName = new JTextField();
		FulName.addActionListener(new ActionListener() {
			
			JButton btnReg =null;
			public void actionPerformed(ActionEvent e) {
			   btnReg.setEnabled(true);
				if(FulName.getText().equals(" ")) {
					btnReg.setEnabled(true);
				}
			}
		});
		FulName.setBounds(128, 75, 125, 17);
		frame.getContentPane().add(FulName);
		FulName.setColumns(10);
		
		UserName = new JTextField();
		UserName.setBounds(128, 105, 125, 17);
		frame.getContentPane().add(UserName);
		UserName.setColumns(10);
		
		Pass= new JPasswordField();
		Pass.setBounds(128, 135, 125, 17);
		frame.getContentPane().add(Pass);
		Pass.setColumns(10);
		
		ConPass = new JPasswordField();
		ConPass.setBounds(128, 164, 234, 17);
		frame.getContentPane().add(ConPass);
		ConPass.setColumns(10);
		
		Phone = new JTextField();
		Phone.setBounds(128, 192, 234, 17);
		frame.getContentPane().add(Phone);
		Phone.setColumns(10);
		
		
		JLabel lblRegestrer = new JLabel("  REGESTRER");
		lblRegestrer.setForeground(new Color(0, 0, 102));
		lblRegestrer.setBackground(new Color(102, 255, 204));
		lblRegestrer.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblRegestrer.setBounds(127, 11, 126, 23);
		frame.getContentPane().add(lblRegestrer);
		
		JLabel lblCle = new JLabel("Cle :");
		lblCle.setBounds(263, 77, 46, 14);
		frame.getContentPane().add(lblCle);
		
		textField = new JTextField();
		textField.setBounds(316, 73, 62, 18);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
		});
		textField_1.setBounds(316, 104, 108, 17);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(263, 107, 46, 14);
		frame.getContentPane().add(lblPrenom);
		
		textField_2 = new JTextField();
		textField_2.setBounds(316, 134, 108, 17);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setBounds(10, 169, 46, 14);
		frame.getContentPane().add(lblAdresse);
		
		Choice choice = new Choice();
		choice.setBounds(128, 219, 100, 20);
		frame.getContentPane().add(choice);
	}
}
