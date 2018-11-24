package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.ConcreteUserDAO;
import model.MySqlConnection;
import model.User;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Point;
import java.awt.Cursor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginWindow extends JFrame {

	private JPanel contentPane;
	private JPasswordField EnterUserPassword;
	static int Type=1;
	private JLabel EnterUserIDMess;
	private JLabel EnterUserPasswordMess;
	private JLabel TypeSelectMess;
	private JLabel SignInMess;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MySqlConnection.getConnection();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public LoginWindow() {
		setUndecorated(true);
		setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		setTitle("\u767B\u9646\u754C\u9762");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(431, 626);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel SystemLogo = new JLabel("GDUFE");
		SystemLogo.setBounds(5, 30, 421, 150);
		SystemLogo.setFont(new Font("Bauhaus 93", Font.BOLD, 80));
		SystemLogo.setHorizontalAlignment(SwingConstants.CENTER);
		SystemLogo.setForeground(Color.BLACK);
		contentPane.add(SystemLogo);
		
		JPanel EnterData = new JPanel();
		EnterData.setBounds(5, 170, 421, 450);
		EnterData.setFocusTraversalPolicyProvider(true);
		EnterData.setBackground(Color.WHITE);
		EnterData.setForeground(new Color(0, 128, 128));
		contentPane.add(EnterData);
		
		JLabel UserType = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		UserType.setBounds(120, 25, 106, 24);
		UserType.setForeground(Color.BLACK);
		UserType.setFont(new Font("Ó×Ô²", Font.BOLD, 18));
		
		JLabel UserID_1 = new JLabel("\u7528\u6237\u8D26\u53F7\uFF1A");
		UserID_1.setBounds(120, 110, 106, 21);
		UserID_1.setForeground(Color.BLACK);
		UserID_1.setFont(new Font("Ó×Ô²", Font.BOLD, 18));
		
		JLabel UserPassword_1 = new JLabel("\u7528\u6237\u5BC6\u7801\uFF1A");
		UserPassword_1.setBounds(120, 195, 106, 21);
		UserPassword_1.setForeground(Color.BLACK);
		UserPassword_1.setFont(new Font("Ó×Ô²", Font.BOLD, 18));
		
		JComboBox TypeSelect = new JComboBox();
		TypeSelect.setBounds(120, 55, 182, 30);
		TypeSelect.setForeground(Color.BLACK);
		TypeSelect.setBackground(Color.WHITE);
		TypeSelect.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				TypeSelectMess.setVisible(false);
				if(TypeSelect.getSelectedItem().toString().equals("¶ÁÕß"))
					Type=1;
				else if(TypeSelect.getSelectedItem().toString().equals("Í¼Êé¹ÜÀíÔ±"))
					Type=2;
				else if(TypeSelect.getSelectedItem().toString().equals("³¬¹Ü"))
					Type=3;
					

			}
		});
		TypeSelect.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		TypeSelect.setModel(new DefaultComboBoxModel(new String[] {"\u8BFB\u8005", "\u56FE\u4E66\u7BA1\u7406\u5458", "\u8D85\u7BA1"}));
		
		JFormattedTextField EnterUserID = new JFormattedTextField();
		EnterUserID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(EnterUserID.getText().toString().length()>11||EnterUserID.getText().toString().length()<5){
					EnterUserIDMess.setVisible(true);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				EnterUserIDMess.setVisible(false);
			}
		});
		EnterUserID.setBounds(120, 140, 182, 30);
		EnterUserID.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		EnterUserPassword = new JPasswordField();
		EnterUserPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(EnterUserPassword.getText().toString().length()<6||EnterUserPassword.getText().toString().length()>16){
					EnterUserPasswordMess.setVisible(true);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				EnterUserPasswordMess.setVisible(false);
			}
		});
		EnterUserPassword.setBounds(120, 225, 182, 30);
		EnterUserPassword.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		JButton LoginButton = new JButton("Sign in");
		LoginButton.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				SignInMess.setVisible(false);
			}
		});
		LoginButton.setBounds(120, 300, 182, 40);
		LoginButton.setFocusPainted(false);
		LoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String UserID=EnterUserID.getText().toString();
				String UserPassword=EnterUserPassword.getText().toString();
				ConcreteUserDAO UserDAO=new ConcreteUserDAO();
				User user=UserDAO.findUser(UserID);
				
				if(user.getUserStatus()==-1){
					SignInMess.setVisible(true);
				}
				else{
					if(user.getUserType()==Type){
						if(user.getUserPassword().equals(UserPassword)){
							
							switch(user.getUserType()){
								case 1:
									break;
								case 2:
									BookManager bookManager=new BookManager();
									bookManager.setVisible(true);
									dispose();
									break;
									
								case 3:
									SuperManagerWindow superManager = new SuperManagerWindow();
									superManager.setVisible(true);
									dispose();
									break;
			
							}
						}
					}else{
						TypeSelectMess.setVisible(true);
					}
				}
			}
		});
		LoginButton.setForeground(Color.WHITE);
		LoginButton.setBackground(Color.BLACK);
		LoginButton.setFont(new Font("Bauhaus 93", Font.BOLD, 24));
		EnterData.setLayout(null);
		EnterData.add(UserType);
		EnterData.add(TypeSelect);
		EnterData.add(UserPassword_1);
		EnterData.add(EnterUserPassword);
		EnterData.add(UserID_1);
		EnterData.add(EnterUserID);
		EnterData.add(LoginButton);
		
		JLabel exit = new JLabel("<html><u>ÍË³öÏµÍ³</u></html>");
		exit.setFont(new Font("Ó×Ô²", Font.PLAIN, 12));
		exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		exit.setFocusTraversalPolicyProvider(true);
		exit.setBounds(353, 406, 58, 24);
		EnterData.add(exit);
		
		JLabel lblNewLabel = new JLabel("<html><u>ÖØÖÃ</u></html>");
		lblNewLabel.setFont(new Font("Ó×Ô²", Font.PLAIN, 12));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EnterUserID.setText("");
				EnterUserPassword.setText("");
			}
		});
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setBounds(310, 406, 37, 24);
		EnterData.add(lblNewLabel);
		
		EnterUserIDMess = new JLabel("\u8D26\u53F7\u5E94\u4E3A5-11\u4F4D\u7531\u6570\u5B57\u3001\u5B57\u6BCD\u7EC4\u6210\u7684\u5B57\u7B26\u4E32");
		EnterUserIDMess.setVisible(false);
		EnterUserIDMess.setForeground(Color.RED);
		EnterUserIDMess.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		EnterUserIDMess.setBounds(120, 175, 247, 15);
		EnterData.add(EnterUserIDMess);
		
		EnterUserPasswordMess = new JLabel("\u5BC6\u7801\u5E94\u4E3A6-16\u4F4D\u7531\u6570\u5B57\u3001\u5B57\u6BCD\u7EC4\u6210\u7684\u5B57\u7B26\u4E32");
		EnterUserPasswordMess.setVisible(false);
		EnterUserPasswordMess.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		EnterUserPasswordMess.setForeground(Color.RED);
		EnterUserPasswordMess.setBounds(120, 260, 247, 15);
		EnterData.add(EnterUserPasswordMess);
		
		TypeSelectMess = new JLabel("\u7528\u6237\u7C7B\u578B\u9519\u8BEF");
		TypeSelectMess.setVisible(false);
		TypeSelectMess.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		TypeSelectMess.setForeground(Color.RED);
		TypeSelectMess.setBounds(120, 90, 182, 15);
		EnterData.add(TypeSelectMess);
		
		SignInMess = new JLabel("\u7528\u6237\u4E0D\u5B58\u5728");
		SignInMess.setVisible(false);
		SignInMess.setForeground(Color.RED);
		SignInMess.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		SignInMess.setBounds(120, 350, 90, 15);
		EnterData.add(SignInMess);
		
		JLabel SystemName = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		SystemName.setHorizontalAlignment(SwingConstants.CENTER);
		SystemName.setFont(new Font("Ó×Ô²", Font.BOLD, 20));
		SystemName.setBounds(5, 140, 421, 25);
		contentPane.add(SystemName);
	}
}
