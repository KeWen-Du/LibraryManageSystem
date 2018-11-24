package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import model.ConcreteUserDAO;
import model.User;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FindUserPassword extends JPanel {
	private JTextField userID;
	private JTextField userPassword;
	private JLabel userMess;
	private int OK=1;
	private JLabel userMess2;
	/**
	 * Create the panel.
	 */
	public FindUserPassword() {
		setBackground(Color.WHITE);
		setSize(684, 768);
		setLayout(null);
		
		JLabel Function = new JLabel("\u67E5\u627E\u7528\u6237\u5BC6\u7801");
		Function.setFont(new Font("свт╡", Font.PLAIN, 30));
		Function.setBounds(50, 20, 233, 40);
		add(Function);
		
		JLabel label = new JLabel("\u7528\u6237\u8D26\u53F7\uFF1A");
		label.setFont(new Font("свт╡", Font.PLAIN, 18));
		label.setBounds(50, 100, 95, 23);
		add(label);
		
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
				if(userID.getText().toString().length()<5||userID.getText().toString().length()>16){
					userMess.setVisible(true);
					OK=0;
				}
			}
		});
		userID.setFont(new Font("свт╡", Font.PLAIN, 18));
		userID.setColumns(10);
		userID.setBounds(150, 100, 120, 25);
		add(userID);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("свт╡", Font.PLAIN, 18));
		label_1.setBounds(50, 150, 95, 23);
		add(label_1);
		
		userPassword = new JTextField();
		userPassword.setEditable(false);
		userPassword.setFont(new Font("свт╡", Font.PLAIN, 18));
		userPassword.setColumns(10);
		userPassword.setBounds(150, 150, 120, 25);
		add(userPassword);
		
		JButton findButton = new JButton("\u786E\u8BA4\u67E5\u627E");
		findButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(OK==1) {
					ConcreteUserDAO dao=new ConcreteUserDAO();
					User user=dao.findUser(userID.getText().toString());
					if(user.getUserStatus()==-1) {
						userMess2.setVisible(true);
					}else {
					userPassword.setText(user.getUserPassword());
					}
				}
			}
		});
		findButton.setForeground(Color.WHITE);
		findButton.setFont(new Font("свт╡", Font.BOLD, 24));
		findButton.setFocusPainted(false);
		findButton.setBorderPainted(false);
		findButton.setBackground(Color.BLACK);
		findButton.setBounds(50, 200, 220, 50);
		add(findButton);
		
		userMess = new JLabel("\u8D26\u53F7\u5E94\u4E3A5-11\u4F4D\u7531\u5B57\u7B26\u548C\u6570\u5B57\u7EC4\u6210\u7684\u5B57\u7B26\u4E32");
		userMess.setVisible(false);
		userMess.setForeground(Color.RED);
		userMess.setFont(new Font("свт╡", Font.PLAIN, 12));
		userMess.setBounds(50, 125, 248, 15);
		add(userMess);
		
		userMess2 = new JLabel("\u8D26\u53F7\u4E0D\u5B58\u5728");
		userMess2.setVisible(false);
		userMess2.setFont(new Font("свт╡", Font.PLAIN, 12));
		userMess2.setForeground(Color.RED);
		userMess2.setBounds(50, 125, 112, 15);
		add(userMess2);

	}
}
