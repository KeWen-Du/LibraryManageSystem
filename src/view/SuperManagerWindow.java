package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.Component;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.CardLayout;

public class SuperManagerWindow extends JFrame {
	private CardLayout card=new CardLayout(0, 0);//´´½¨¿¨Æ¬²¼¾Ö¶ÔÏó
	private int NowDisplay=1;//¼ÇÂ¼µ±Ç°¼ÓÔØµÄ¿¨Æ¬
	private JPanel contentPane;
	private JButton AdminInfo;
	private JButton AddManager;
	private JButton FindUserPassword;
	private JButton UpdatePassword;
	private JPanel Content;
	private JPanel Menu;
	private JPanel Function;
	private AdminMess AdminMessDisplay=new AdminMess();
	private JLabel label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuperManagerWindow frame = new SuperManagerWindow();
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
	public SuperManagerWindow() {
		setUndecorated(true);
		
		
		setResizable(false);
		setTitle("\u8D85\u7BA1\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 768);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Content = new JPanel();
		Content.setBackground(Color.WHITE);
		Content.setForeground(Color.LIGHT_GRAY);
		Content.setBounds(199, 0, 684, 768);
		contentPane.add(Content);

		Content.setLayout(card);
		Content.add(AdminMessDisplay,"1");
		
		Menu = new JPanel();
		Menu.setBackground(Color.BLACK);
		Menu.setBounds(0, 0, 200, 768);
		contentPane.add(Menu);
		Menu.setLayout(null);
		
		AdminInfo = new JButton("\u4E2A\u4EBA\u4FE1\u606F");
		AdminInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminInfo.setBackground(Color.WHITE);
				AdminInfo.setForeground(Color.BLACK);
				
				AddManager.setBackground(Color.BLACK);
				AddManager.setForeground(Color.WHITE);
				
				FindUserPassword.setBackground(Color.BLACK);
				FindUserPassword.setForeground(Color.WHITE);
				
				UpdatePassword.setBackground(Color.BLACK);
				UpdatePassword.setForeground(Color.WHITE);
				
				Content.add(new AdminMess(),"1");
				card.show(Content,"1");
				NowDisplay=1;
			}
		});
		AdminInfo.setHorizontalAlignment(SwingConstants.LEFT);
		AdminInfo.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		AdminInfo.setBackground(Color.WHITE);
		AdminInfo.setBorderPainted(false);
		AdminInfo.setFocusPainted(false);
		AdminInfo.setBounds(0, 203, 199, 40);
		Menu.add(AdminInfo);
		
		AddManager = new JButton("\u6DFB\u52A0\u7BA1\u7406\u5458");
		AddManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddManager.setBackground(Color.WHITE);
				AddManager.setForeground(Color.BLACK);
				
				AdminInfo.setBackground(Color.BLACK);
				AdminInfo.setForeground(Color.WHITE);
				
				FindUserPassword.setBackground(Color.BLACK);
				FindUserPassword.setForeground(Color.WHITE);
				
				UpdatePassword.setBackground(Color.BLACK);
				UpdatePassword.setForeground(Color.WHITE);
				
				Content.add(new AddManager(),"2");
				card.show(Content,"2");
				NowDisplay=2;
			}
		});
		AddManager.setForeground(Color.WHITE);
		AddManager.setHorizontalAlignment(SwingConstants.LEFT);
		AddManager.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		AddManager.setBackground(Color.BLACK);
		AddManager.setBorderPainted(false);
		AddManager.setFocusPainted(false);
		AddManager.setBounds(0, 243, 199, 40);
		Menu.add(AddManager);
		
		FindUserPassword = new JButton("\u67E5\u770B\u7528\u6237\u5BC6\u7801");
		FindUserPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FindUserPassword.setBackground(Color.WHITE);
				FindUserPassword.setForeground(Color.BLACK);
				
				AdminInfo.setBackground(Color.BLACK);
				AdminInfo.setForeground(Color.WHITE);
				
				AddManager.setBackground(Color.BLACK);
				AddManager.setForeground(Color.WHITE);
				
				UpdatePassword.setBackground(Color.BLACK);
				UpdatePassword.setForeground(Color.WHITE);
				
				Content.add(new FindUserPassword(),"3");
				card.show(Content,"3");
				NowDisplay=3;
			}
		});
		FindUserPassword.setHorizontalAlignment(SwingConstants.LEFT);
		FindUserPassword.setForeground(Color.WHITE);
		FindUserPassword.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		FindUserPassword.setFocusPainted(false);
		FindUserPassword.setBorderPainted(false);
		FindUserPassword.setBackground(Color.BLACK);
		FindUserPassword.setBounds(0, 283, 199, 40);
		Menu.add(FindUserPassword);
		
		UpdatePassword = new JButton("\u4FEE\u6539\u5BC6\u7801");
		UpdatePassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdatePassword.setBackground(Color.WHITE);
				UpdatePassword.setForeground(Color.BLACK);
				
				AdminInfo.setBackground(Color.BLACK);
				AdminInfo.setForeground(Color.WHITE);
				
				AddManager.setBackground(Color.BLACK);
				AddManager.setForeground(Color.WHITE);
				
				FindUserPassword.setBackground(Color.BLACK);
				FindUserPassword.setForeground(Color.WHITE);
				
				Content.add(new UpdatePassword(),"4");
				card.show(Content,"4");
				NowDisplay=4;
			}
		});
		UpdatePassword.setHorizontalAlignment(SwingConstants.LEFT);
		UpdatePassword.setForeground(Color.WHITE);
		UpdatePassword.setFont(new Font("Ó×Ô²", Font.PLAIN, 18));
		UpdatePassword.setFocusPainted(false);
		UpdatePassword.setBorderPainted(false);
		UpdatePassword.setBackground(Color.BLACK);
		UpdatePassword.setBounds(0, 323, 199, 40);
		Menu.add(UpdatePassword);
		
		JLabel SystemLogo = new JLabel("GDUFE");
		SystemLogo.setFont(new Font("Bauhaus 93", Font.PLAIN, 56));
		SystemLogo.setHorizontalAlignment(SwingConstants.CENTER);
		SystemLogo.setForeground(Color.WHITE);
		SystemLogo.setBounds(0, 20, 199, 103);
		Menu.add(SystemLogo);
		
		JLabel SystemName = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		SystemName.setFont(new Font("Ó×Ô²", Font.BOLD, 15));
		SystemName.setHorizontalAlignment(SwingConstants.RIGHT);
		SystemName.setForeground(Color.WHITE);
		SystemName.setBounds(47, 109, 131, 23);
		Menu.add(SystemName);
		
		label = new JLabel("\u2014\u2014\u8D85\u7BA1\u754C\u9762");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Ó×Ô²", Font.BOLD, 15));
		label.setBounds(80, 131, 98, 23);
		Menu.add(label);
		
		Function = new JPanel();
		Function.setBackground(Color.WHITE);
		Function.setBounds(882, 0, 136, 768);
		contentPane.add(Function);
		Function.setLayout(null);
		
		JLabel ExitSystem = new JLabel("<html><u>ÍË³öÏµÍ³</u></html>");
		ExitSystem.setFont(new Font("Ó×Ô²", Font.PLAIN, 12));
		ExitSystem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		ExitSystem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ExitSystem.setBounds(10, 10, 73, 26);
		Function.add(ExitSystem);
		
		JLabel SignOut = new JLabel("<html><u>\u6CE8\u9500\u767B\u9646</u></html>");
		SignOut.setFont(new Font("Ó×Ô²", Font.PLAIN, 12));
		SignOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginWindow loginWindow=new LoginWindow();
				loginWindow.setVisible(true);
				dispose();
			}
		});
		SignOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SignOut.setBounds(10, 46, 73, 26);
		Function.add(SignOut);
		
		JLabel Reset = new JLabel("<html><u>\u7ACB\u5373\u91CD\u7F6E</u></html>");
		Reset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Reset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switch(NowDisplay) {
				case 1:
					Content.add(new AdminMess(),"1");
					card.show(Content,"1");
					break;
				case 2:
					Content.add(new AddManager(),"2");
					card.show(Content,"2");
					break;
				case 3:
					Content.add(new FindUserPassword(),"3");
					card.show(Content, "3");
					break;
				case 4:
					Content.add(new UpdatePassword(),"4");
					card.show(Content, "4");
					break;
				}	
			}
		});
		Reset.setFont(new Font("Ó×Ô²", Font.PLAIN, 12));
		Reset.setBounds(10, 82, 73, 26);
		Function.add(Reset);
		
		

		
		

	}
}
