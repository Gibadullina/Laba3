package Laba4; //����� Java �������

import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //���������� ��� ������� ���������
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*; // ���������� ��� GUI (��������� �� ������ awt)

public class subversion {

	public static String text = "";
	public JLabel imgIcon = null;
	JTextField sideInput;
	JLabel wrongSideInput_label;
	JPanel main_panel;
	double user_input_value = -1; // ��������� ������ ��������
	
	public subversion() {
	JFrame main_GUI = new JFrame("subversion");	// �������� ������������ ����
	main_GUI.setTitle ("Using subversion for developers");
	main_GUI.setBounds(500,400,400,400);
	main_GUI.setResizable(false); // ������������� ������ ����
	
	
	main_panel = new JPanel(); // ������ - ������������ ��� ����������� ����������� � ����
	main_panel.setLayout(null);
	main_GUI.add(main_panel);
	
	JLabel laba_info = new JLabel("������������ ������ �4"); // ����������� ������ ��� �����������
	laba_info.setBounds(120,0,180,30);
	main_panel.add(laba_info);
	
	JButton button_exit = new JButton("�����"); // ��������� ������
	button_exit.setBounds(270,300,100,40);
	ActionListener actionListener = new ListenerButton(this); //������� ���������
	button_exit.addActionListener(actionListener); // ��������� ��������� � ������
	main_panel.add(button_exit);
	
	JButton button_info = new JButton("����������");
	button_info.setBounds(20, 300, 150, 40);
	ActionListener actionListener2 = new ListenerButton(this);
	button_info.addActionListener(actionListener2);
	main_panel.add(button_info);
	

	
	//user3 side
	JLabel side_label = new JLabel("������� ��������:"); // ����������� ������ ��� �����������
	side_label.setBounds(20,200,130,30);
	main_panel.add(side_label);
	
	// �������� ��������� �����
    sideInput = new JTextField();
    sideInput.setBounds(132,200,50,30);
    sideInput.setToolTipText("������� ������� ��������");
    sideInput.setHorizontalAlignment(JTextField.LEFT);
    // ���������  �����
    sideInput.addKeyListener(new KeyAdapter() {
        public void keyReleased(KeyEvent e) {
        	if(stringCanBeDouble(sideInput.getText()))
        	{
        		inputIsCorrect();
        	}else {
        		inputIsWrong();
        	}
        	//if(sideInput.getText().matches("\\d+")) //�������� ������� �� ������ �����
        }
    });
    main_panel.add(sideInput);
	try {
		// ��������� ��������, ��������� �� �� ������ � ������
		BufferedImage imgBuff = ImageIO.read(new URL ("http://xn--e1afhkfagivn.xn--p1ai/media/foto/logo.jpg"));
	    imgIcon = new JLabel(new ImageIcon(imgBuff.getScaledInstance(150, 80, imgBuff.SCALE_DEFAULT)));
	    imgIcon.setBounds(220, 40, 150, 80); // ������������� ��������� �������� �� ���������
	    main_panel.add(imgIcon);
	    imgIcon.setVisible(false);
	 
	} catch(IOException ex) {
		ex.printStackTrace();
	}
	
	JMenuBar menuBar = new JMenuBar(); // ������� ������� ����, ��� �������� ��������� ����
	
	JMenu menu = new JMenu("����"); // ������� ���� 
    menuBar.add(menu);
    
    JMenuItem logoMenuItem = new JMenuItem("���������� �������"); // ������� ������ ���� 
    JMenuItem importMenuItem = new JMenuItem("��������� ���� � ������1");
    JMenuItem exitMenuItem = new JMenuItem("�����");
    
    logoMenuItem.addActionListener(new ActionListener() { // ��������� ��������� ������ ������ ����
		@Override
		public void actionPerformed(ActionEvent e) {
			imgIcon.setVisible(true);
		}
    });
    exitMenuItem.addActionListener(new ActionListener() { // ��������� ��������� ������ ������
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(1);
		}
    });
    importMenuItem.addActionListener(new ActionListener() { // ��������� ��������� ������ �������� �����
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser();
			
			int response = fileChooser.showOpenDialog(null);
			if (response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
					String line;
					try {
					while ((line = br.readLine()) != null) {
					text+=line+"\n";
					}
					} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
					} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				
				
			}
		}
    });
    menu.add(logoMenuItem); // ��������� ������ � ����
    menu.add(importMenuItem);
    menu.add(exitMenuItem);
    
    main_GUI.setJMenuBar(menuBar); // ��������� ���� ��� � ���� ����
    //user3 end side
    
	//user4 side
	String[] items = { //Our content for JComboBox
			"����������� ������� ����� � ����� ������� ����",
			"����������� ������� ����� � ��������",
			"����������� ������� ����� � ������ ������� ����",
			"������������� ������ � �������"
		};
	
	JComboBox box = new JComboBox(items); //Initialize JComboBox
	box.setBounds(20,150,250,40);
	box.setFont(new Font("Arial", Font.BOLD, 10));
	box.addActionListener(actionListener);
	
	
	main_panel.add(box);
	//user4 end side
	
	//user4 side
	JButton calcButton = new JButton("����������");
	calcButton.addActionListener(actionListener);
	calcButton.setBounds(new Rectangle(200,200,130,30));
	main_panel.add(calcButton);
	//end
	
	
	
	main_GUI.setVisible(true);
	
	main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �������� ���� JFrame � �������� Java
	}
	
	public void calculateSquare() {
		
	}
	
	
	public boolean stringCanBeDouble(String str) //�������� �������� �� ������ ��������������� � double
	{
		if(str.length()==0) return false;
		char[] validChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	    boolean dotFound = false;
	    
	    for (int i = 0; i < str.length(); i++) {
	    	char ckeckChar = str.charAt(i);
	    	boolean isFound = false;
	    	
        	for (int k = 0; k < validChars.length; k++) {
     	       if (ckeckChar == validChars[k])
     	       {
     	           isFound = true;
     	           break;
     	       }
	        }
        	
        	if(isFound) continue;
        	
        	if(str.charAt(i) == '.')
        	{
        		if(dotFound)
    			{
        			return false;
    			}
        		dotFound = true;
        		continue;
        	}
        	return false;
	    }
	   
	    return true;
	}
	public void inputIsCorrect()//���������� ����� ������� �������� ������� ���������
	{
		if(wrongSideInput_label!=null)
		{
			wrongSideInput_label.setVisible(false);
		}
		user_input_value = Double.parseDouble(sideInput.getText());
	}
	public void inputIsWrong() //���������� ��� �������� ����� ������� ��������
	{
		user_input_value = -1;
		if(wrongSideInput_label==null)
		{
			wrongSideInput_label = new JLabel("�������� ����");
			wrongSideInput_label.setBounds(132,220,130,30);
			main_panel.add(wrongSideInput_label);
		} else
		{
			wrongSideInput_label.setVisible(true);
		}
	}
	
	
	public static void main(String[] args) { // ���������� �������: http://www.mstu.edu.ru/study/materials/java/
		subversion student= new subversion();
		
	}

}
