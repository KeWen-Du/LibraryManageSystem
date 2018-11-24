package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class BookManager extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BookManager frame = new BookManager();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public BookManager() {
		setResizable(false);
		setTitle("\u56FE\u4E66\u7BA1\u7406\u5458\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(0, 128, 128));
		menuBar.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menuBar.add(menu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u65B0\u4E66\u5165\u5E93");
		menu.add(mntmNewMenuItem);
		
		JMenuItem menuItem = new JMenuItem("\u56FE\u4E66\u9500\u5E93\u5904\u7406");
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u4FE1\u606F\u4FEE\u6539");
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u70ED\u95E8\u501F\u9605");
		menu.add(menuItem_2);
		
		JMenu menu_1 = new JMenu("\u56FE\u4E66\u6D41\u901A\u7BA1\u7406");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u8F6C\u79FB");
		menu_1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u56FE\u4E66\u6682\u505C");
		menu_1.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u56FE\u4E66\u50AC\u8FD8");
		menu_1.add(menuItem_5);
		
		JMenu menu_2 = new JMenu("\u8BFB\u8005\u7BA1\u7406");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_6 = new JMenuItem("\u6CE8\u518C\u501F\u9605\u8BC1");
		menu_2.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("\u6682\u505C\u501F\u9605\u8BC1");
		menu_2.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("\u6CE8\u9500\u501F\u9605\u8BC1");
		menu_2.add(menuItem_8);
		
		JMenu menu_3 = new JMenu("\u7EDF\u8BA1\u67E5\u8BE2");
		menuBar.add(menu_3);
		
		JMenuItem menuItem_9 = new JMenuItem("\u8BFB\u8005\u67E5\u8BE2");
		menu_3.add(menuItem_9);
		
		JMenuItem menuItem_10 = new JMenuItem("\u501F\u9605\u8BC1\u67E5\u8BE2");
		menu_3.add(menuItem_10);
		
		JMenuItem menuItem_11 = new JMenuItem("\u7F5A\u6B3E\u5386\u53F2\u67E5\u8BE2");
		menu_3.add(menuItem_11);
		
		JMenu menu_4 = new JMenu("\u4FEE\u6539\u5BC6\u7801");
		menuBar.add(menu_4);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblGdufe = new JLabel("GDUFE");
		lblGdufe.setBackground(new Color(0, 0, 0));
		lblGdufe.setForeground(new Color(0, 128, 128));
		lblGdufe.setHorizontalAlignment(SwingConstants.CENTER);
		lblGdufe.setFont(new Font("Bauhaus 93", Font.BOLD, 80));
		contentPane.add(lblGdufe, BorderLayout.CENTER);
	}

}
