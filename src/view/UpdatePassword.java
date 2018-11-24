package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import model.ConcreteUserDAO;
import model.User;

import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdatePassword extends JPanel {
	private JTextField userID;
	private JPasswordField oldPassword;
	private JPasswordField newPassword;
	private JPasswordField confirmPassword;
	private JLabel userMess;
	private JLabel userMess2;
	private JLabel passwordMess;
	private JLabel passwordMess2;
	private JLabel passwordMess3;
	private JButton updateButton;
	private int OK=1;
	private JLabel passwordMess4;
	private JLabel updateSuccess;
	/**
	 * Create the panel.
	 */
	public UpdatePassword() {
		setVisible(false);
		setBackground(Color.WHITE);
		setSize(684, 768);
		setLayout(null);
		
		JLabel label = new JLabel("\u4FEE\u6539\u5BC6\u7801");
		label.setFont(new Font("свт╡", Font.PLAIN, 30));
		label.setBounds(50, 20, 233, 40);
		add(label);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u8D26\u53F7\uFF1A");
		label_1.setFont(new Font("свт╡", Font.PLAIN, 18));
		label_1.setBounds(50, 100, 95, 23);
		add(label_1);
		
		passwordMess4 = new JLabel("\u5BC6\u7801\u9519\u8BEF");
		passwordMess4.setVisible(false);
		passwordMess4.setForeground(Color.RED);
		passwordMess4.setFont(new Font("свт╡", Font.PLAIN, 12));
		passwordMess4.setBounds(50, 174, 220, 15);
		add(passwordMess4);
		
		updateSuccess = new JLabel("\u4FEE\u6539\u6210\u529F");
		updateSuccess.setVisible(false);
		updateSuccess.setFont(new Font("свт╡", Font.PLAIN, 12));
		updateSuccess.setBounds(50, 371, 54, 15);
		add(updateSuccess);
		
		userID = new JTextField();
		userID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				userMess.setVisible(false);
				userMess2.setVisible(false);
				OK=1;
			}
			@Override
			public void focusLost(FocusEvent e) {
				User user=new User();
				ConcreteUserDAO dao=new ConcreteUserDAO();
				user=dao.findUser(userID.getText().toString());
				if(user.getUserStatus()==-1){
					userMess2.setVisible(true);
					OK=0;
				}else if(userID.getText().toString().length()<5||userID.getText().toString().length()>16){
					userMess.setVisible(true);
					OK=0;
				}
			}
		});
		userID.setFont(new Font("свт╡", Font.PLAIN, 18));
		userID.setColumns(10);
		userID.setBounds(150, 100, 120, 25);
		add(userID);
		
		JLabel label_2 = new JLabel("\u65E7\u7684\u5BC6\u7801\uFF1A");
		label_2.setFont(new Font("свт╡", Font.PLAIN, 18));
		label_2.setBounds(50, 150, 95, 23);
		add(label_2);
		
		JLabel label_3 = new JLabel("\u65B0\u7684\u5BC6\u7801\uFF1A");
		label_3.setFont(new Font("свт╡", Font.PLAIN, 18));
		label_3.setBounds(50, 200, 95, 23);
		add(label_3);
		
		JLabel label_4 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_4.setFont(new Font("свт╡", Font.PLAIN, 18));
		label_4.setBounds(50, 250, 95, 23);
		add(label_4);
		
		oldPassword = new JPasswordField();
		oldPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordMess.setVisible(false);
				passwordMess4.setVisible(false);
				OK=1;
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(oldPassword.getText().toString().length()<6||oldPassword.getText().toString().length()>16) {
					passwordMess.setVisible(true);
					OK=0;
				}
			}
		});
		oldPassword.setBounds(150, 150, 120, 25);
		add(oldPassword);
		
		newPassword = new JPasswordField();
		newPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordMess2.setVisible(false);
				OK=1;
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(newPassword.getText().toString().length()<6||newPassword.getText().toString().length()>16)
					passwordMess2.setVisible(true);
					OK=0;
			}
		});
		newPassword.setBounds(150, 200, 120, 25);
		add(newPassword);
		
		confirmPassword = new JPasswordField();
		confirmPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordMess3.setVisible(false);
				OK=1;
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(newPassword.getText().toString().equals(confirmPassword.getText().toString())){
					passwordMess3.setVisible(false);
					OK=1;
				}else{
					passwordMess3.setVisible(true);
					OK=0;
				}
			}
		});
		confirmPassword.setBounds(150, 250, 120, 25);
		add(confirmPassword);
		
		userMess = new JLabel("\u8D26\u53F7\u5E94\u4E3A5-11\u4F4D\u7531\u5B57\u7B26\u548C\u6570\u5B57\u7EC4\u6210\u7684\u5B57\u7B26\u4E32");
		userMess.setFont(new Font("свт╡", Font.PLAIN, 12));
		userMess.setVisible(false);
		userMess.setForeground(Color.RED);
		userMess.setBounds(50, 125, 274, 15);
		add(userMess);
		
		userMess2 = new JLabel("\u7528\u6237\u4E0D\u5B58\u5728");
		userMess2.setForeground(Color.RED);
		userMess2.setFont(new Font("свт╡", Font.PLAIN, 12));
		userMess2.setVisible(false);
		userMess2.setBounds(50, 125, 220, 15);
		add(userMess2);
		
		passwordMess = new JLabel("\u5BC6\u7801\u5E94\u4E3A6-16\u4F4D\u7684\u5B57\u7B26\u4E32");
		passwordMess.setVisible(false);
		passwordMess.setForeground(Color.RED);
		passwordMess.setFont(new Font("свт╡", Font.PLAIN, 12));
		passwordMess.setBounds(50, 175, 274, 15);
		add(passwordMess);
		
		passwordMess2 = new JLabel("\u5BC6\u7801\u5E94\u4E3A6-16\u4F4D\u7684\u5B57\u7B26\u4E32");
		passwordMess2.setVisible(false);
		passwordMess2.setFont(new Font("свт╡", Font.PLAIN, 12));
		passwordMess2.setForeground(Color.RED);
		passwordMess2.setBounds(50, 225, 220, 15);
		add(passwordMess2);
		
		passwordMess3 = new JLabel("\u4E24\u6B21\u7684\u5BC6\u7801\u4E0D\u4E00\u81F4");
		passwordMess3.setVisible(false);
		passwordMess3.setForeground(Color.RED);
		passwordMess3.setFont(new Font("свт╡", Font.PLAIN, 12));
		passwordMess3.setBounds(50, 275, 220, 15);
		add(passwordMess3);
		
		updateButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		updateButton.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				updateSuccess.setVisible(false);
				OK=1;
			}
		});
		updateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(OK);
				if(OK==1) {
					ConcreteUserDAO dao=new ConcreteUserDAO();
					User user=dao.findUser(userID.getText().toString());
					if(oldPassword.getText().toString().equals(user.getUserPassword().toString())) {
						user.setUserPassword(newPassword.getText().toString());
						dao.updateUser(user);
						updateSuccess.setVisible(true);
						
					}else {
						passwordMess4.setVisible(true);
					}
				}
			}
		});
		updateButton.setForeground(Color.WHITE);
		updateButton.setFont(new Font("свт╡", Font.BOLD, 24));
		updateButton.setFocusPainted(false);
		updateButton.setBorderPainted(false);
		updateButton.setBackground(Color.BLACK);
		updateButton.setBounds(50, 311, 220, 50);
		add(updateButton);
		
		passwordMess4 = new JLabel("\u5BC6\u7801\u9519\u8BEF");
		passwordMess4.setVisible(false);
		passwordMess4.setForeground(Color.RED);
		passwordMess4.setFont(new Font("свт╡", Font.PLAIN, 12));
		passwordMess4.setBounds(50, 174, 220, 15);
		add(passwordMess4);
		
		updateSuccess = new JLabel("\u4FEE\u6539\u6210\u529F");
		updateSuccess.setVisible(false);
		updateSuccess.setFont(new Font("свт╡", Font.PLAIN, 12));
		updateSuccess.setBounds(50, 371, 54, 15);
		add(updateSuccess);
	}
}
