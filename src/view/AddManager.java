package view;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.ConcreteUserDAO;
import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AddManager extends JPanel {
	private int OK=1;
	private JTextField userID;
	private JPasswordField userPassword;
	private JPasswordField confirmPassword;
	private JTextField userName;
	private JTextField userStatus;
	private JTextField monthBorrowNum;
	private JTextField borrowSum;
	private JLabel userMess;
	private JLabel userMess2;
	private JLabel confirmMess;
	private JLabel passwordMess;
	private JLabel addSuccess;
	private JLabel addFail;
	private JTextField userType;
	/**
	 * Create the panel.
	 */
	public AddManager() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(684, 768);
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u8D26\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel.setBounds(50, 100, 95, 21);
		add(lblNewLabel);
		
		JLabel label = new JLabel("\u7528\u6237\u5BC6\u7801\uFF1A");
		label.setFont(new Font("Dialog", Font.PLAIN, 18));
		label.setBounds(50, 150, 95, 21);
		add(label);
		
		JLabel label_1 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		label_1.setBounds(50, 200, 95, 21);
		add(label_1);
		
		JLabel label_2 = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 18));
		label_2.setBounds(50, 250, 95, 21);
		add(label_2);
		
		JLabel label_3 = new JLabel("\u7528\u6237\u59D3\u540D\uFF1A");
		label_3.setFont(new Font("Dialog", Font.PLAIN, 18));
		label_3.setBounds(300, 100, 95, 21);
		add(label_3);
		
		JLabel label_4 = new JLabel("\u7528\u6237\u72B6\u6001\uFF1A");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 18));
		label_4.setBounds(300, 150, 95, 21);
		add(label_4);
		
		JLabel label_5 = new JLabel("\u6708\u501F\u9605\u91CF\uFF1A");
		label_5.setFont(new Font("Dialog", Font.PLAIN, 18));
		label_5.setBounds(300, 200, 95, 21);
		add(label_5);
		
		JLabel label_6 = new JLabel("\u603B\u501F\u9605\u91CF\uFF1A");
		label_6.setFont(new Font("Dialog", Font.PLAIN, 18));
		label_6.setBounds(300, 250, 95, 21);
		add(label_6);
		
		JButton addButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(OK==1){
					User user=new User();
					user.setUserID(userID.getText().toString());
					user.setUserPassword(userPassword.getText().toString());
					user.setUserType(2);
					user.setUserName(userName.getText().toString());
					user.setUserStatus(1);;
					user.setMonthBorrowNum(0);
					user.setBorrowSum(0);
					ConcreteUserDAO dao=new ConcreteUserDAO();
					dao.addUser(user);
					addSuccess.setVisible(true);
					userID.setEditable(false);
					userPassword.setEditable(false);
					confirmPassword.setEditable(false);
					userName.setEditable(false);
					addButton.setEnabled(false);
				}else{
					addFail.setVisible(true);
				}
			}
		});
		addButton.setBorderPainted(false);
		addButton.setFocusPainted(false);
		addButton.setBackground(Color.BLACK);
		addButton.setForeground(Color.WHITE);
		addButton.setFont(new Font("Ó×Ô²", Font.BOLD, 24));
		addButton.setBounds(50, 302, 220, 50);
		add(addButton);
		
		JLabel Function = new JLabel("\u6DFB\u52A0\u7BA1\u7406\u5458");
		Function.setFont(new Font("Ó×Ô²", Font.PLAIN, 30));
		Function.setBounds(50, 20, 233, 40);
		add(Function);
		
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
				if(user.getUserStatus()!=-1){
					userMess2.setVisible(true);
					OK=0;
				}else if(userID.getText().toString().length()<5||userID.getText().toString().length()>16){
					userMess.setVisible(true);
					OK=0;
				}
			}
		});
		userID.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		userID.setBounds(150, 100, 120, 25);
		add(userID);
		userID.setColumns(10);
		
		userPassword = new JPasswordField();
		userPassword.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		userPassword.setColumns(10);
		userPassword.setBounds(150, 150, 120, 25);
		add(userPassword);
		userPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordMess.setVisible(false);
				OK=1;
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(userPassword.getText().toString().length()<6||userPassword.getText().toString().length()>16)
					passwordMess.setVisible(true);
					OK=0;
			}
		});
		
		
		confirmPassword = new JPasswordField();
		confirmPassword.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		//confirmPassword.setColumns(10);
		confirmPassword.setBounds(150, 200, 120, 25);
		add(confirmPassword);
		confirmPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(userPassword.getText().toString().equals(confirmPassword.getText().toString())){
					confirmMess.setVisible(false);
				}else{
					confirmMess.setVisible(true);
					OK=0;
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				confirmMess.setVisible(false);
				OK=1;
			}
		});
		
		
		userName = new JTextField();
		userName.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		userName.setColumns(10);
		userName.setBounds(400, 100, 120, 25);
		add(userName);
		
		userStatus = new JTextField();
		userStatus.setEditable(false);
		userStatus.setText("1");
		userStatus.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		userStatus.setColumns(10);
		userStatus.setBounds(400, 150, 120, 25);
		add(userStatus);
		
		monthBorrowNum = new JTextField();
		monthBorrowNum.setEditable(false);
		monthBorrowNum.setText("0");
		monthBorrowNum.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		monthBorrowNum.setColumns(10);
		monthBorrowNum.setBounds(400, 200, 120, 25);
		add(monthBorrowNum);
		
		borrowSum = new JTextField();
		borrowSum.setEditable(false);
		borrowSum.setText("0");
		borrowSum.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		borrowSum.setColumns(10);
		borrowSum.setBounds(400, 250, 120, 25);
		add(borrowSum);
		
		userMess = new JLabel("\u8D26\u53F7\u5E94\u4E3A5-11\u4F4D\u7531\u5B57\u7B26\u548C\u6570\u5B57\u7EC4\u6210\u7684\u5B57\u7B26\u4E32");
		userMess.setFont(new Font("Ó×Ô²", Font.PLAIN, 12));
		userMess.setVisible(false);
		userMess.setForeground(Color.RED);
		userMess.setBounds(50, 125, 253, 15);
		add(userMess);
		
		passwordMess = new JLabel("\u5BC6\u7801\u5E94\u4E3A6-16\u4F4D\u7684\u5B57\u7B26\u4E32");
		passwordMess.setFont(new Font("Ó×Ô²", Font.PLAIN, 12));
		passwordMess.setVisible(false);
		passwordMess.setForeground(Color.RED);
		passwordMess.setBounds(50, 175, 240, 15);
		add(passwordMess);
		
		confirmMess = new JLabel("\u4E24\u6B21\u8F93\u5165\u7684\u5BC6\u7801\u4E0D\u4E00\u81F4");
		confirmMess.setFont(new Font("Ó×Ô²", Font.PLAIN, 12));
		confirmMess.setVisible(false);
		confirmMess.setForeground(Color.RED);
		confirmMess.setBounds(50, 225, 240, 15);
		add(confirmMess);
		
		userMess2 = new JLabel("\u8D26\u6237\u5DF2\u5B58\u5728");
		userMess2.setFont(new Font("Ó×Ô²", Font.PLAIN, 12));
		userMess2.setVisible(false);
		userMess2.setForeground(Color.RED);
		userMess2.setBounds(50, 125, 240, 15);
		add(userMess2);
		
		addSuccess = new JLabel("\u6DFB\u52A0\u6210\u529F\uFF0C\u7EE7\u7EED\u6DFB\u52A0\u8BF7\u70B9\u51FB\u53F3\u8FB9\u91CD\u7F6E\u6309\u94AE");
		addSuccess.setVisible(false);
		addSuccess.setFont(new Font("Ó×Ô²", Font.PLAIN, 12));
		addSuccess.setBounds(50, 362, 220, 15);
		add(addSuccess);
		
		addFail = new JLabel("\u6DFB\u52A0\u5931\u8D25");
		addFail.setVisible(false);
		addFail.setFont(new Font("Ó×Ô²", Font.PLAIN, 12));
		addFail.setBounds(50, 362, 54, 15);
		add(addFail);
		
		userType = new JTextField();
		userType.setText("\u7BA1\u7406\u5458");
		userType.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		userType.setEditable(false);
		userType.setColumns(10);
		userType.setBounds(150, 248, 120, 25);
		add(userType);
		
		
		
	}
}
