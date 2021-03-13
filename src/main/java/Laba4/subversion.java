package Laba4; //пакет Java классов

import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //библиотека для события слушателя
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
import javax.swing.*; // Библиотека для GUI (построена на основе awt)

public class subversion {

	public static String text = "";
	public JLabel imgIcon = null;
	JTextField sideInput;
	JLabel wrongSideInput_label;
	JPanel main_panel;
	double user_input_value = -1; // введенная юзером величина
	
	public subversion() {
	JFrame main_GUI = new JFrame("subversion");	// создание графического окна
	main_GUI.setTitle ("Using subversion for developers");
	main_GUI.setBounds(500,400,400,400);
	main_GUI.setResizable(false); // фиксированный размер окна
	
	
	main_panel = new JPanel(); // Панель - используется для организации компонентов в окне
	main_panel.setLayout(null);
	main_GUI.add(main_panel);
	
	JLabel laba_info = new JLabel("Лабораторная работа №4"); // Отображение текста или изображения
	laba_info.setBounds(120,0,180,30);
	main_panel.add(laba_info);
	
	JButton button_exit = new JButton("Выход"); // добавляем кнопку
	button_exit.setBounds(270,300,100,40);
	ActionListener actionListener = new ListenerButton(this); //создаем слушатель
	button_exit.addActionListener(actionListener); // добавляем слушатель к кнопке
	main_panel.add(button_exit);
	
	JButton button_info = new JButton("Информация");
	button_info.setBounds(20, 300, 150, 40);
	ActionListener actionListener2 = new ListenerButton(this);
	button_info.addActionListener(actionListener2);
	main_panel.add(button_info);
	

	
	//user3 side
	JLabel side_label = new JLabel("Сторона квадрата:"); // Отображение текста или изображения
	side_label.setBounds(20,200,130,30);
	main_panel.add(side_label);
	
	// Создание текстовых полей
    sideInput = new JTextField();
    sideInput.setBounds(132,200,50,30);
    sideInput.setToolTipText("Введите сторону квадрата");
    sideInput.setHorizontalAlignment(JTextField.LEFT);
    // Слушатель  ввода
    sideInput.addKeyListener(new KeyAdapter() {
        public void keyReleased(KeyEvent e) {
        	if(stringCanBeDouble(sideInput.getText()))
        	{
        		inputIsCorrect();
        	}else {
        		inputIsWrong();
        	}
        	//if(sideInput.getText().matches("\\d+")) //проверка введены ли только цифры
        }
    });
    main_panel.add(sideInput);
	try {
		// Загружаем картинку, добавляем ее на панель и прячем
		BufferedImage imgBuff = ImageIO.read(new URL ("http://xn--e1afhkfagivn.xn--p1ai/media/foto/logo.jpg"));
	    imgIcon = new JLabel(new ImageIcon(imgBuff.getScaledInstance(150, 80, imgBuff.SCALE_DEFAULT)));
	    imgIcon.setBounds(220, 40, 150, 80); // устанавливаем положение логотипа по умолчанию
	    main_panel.add(imgIcon);
	    imgIcon.setVisible(false);
	 
	} catch(IOException ex) {
		ex.printStackTrace();
	}
	
	JMenuBar menuBar = new JMenuBar(); // Создаем главное меню, где хранятся остальные меню
	
	JMenu menu = new JMenu("Меню"); // Создаем меню 
    menuBar.add(menu);
    
    JMenuItem logoMenuItem = new JMenuItem("Отобразить логотип"); // Создаем пункты меню 
    JMenuItem importMenuItem = new JMenuItem("Загрузить файл в проект1");
    JMenuItem exitMenuItem = new JMenuItem("Выход");
    
    logoMenuItem.addActionListener(new ActionListener() { // Добавляем поведение кнопки показа лого
		@Override
		public void actionPerformed(ActionEvent e) {
			imgIcon.setVisible(true);
		}
    });
    exitMenuItem.addActionListener(new ActionListener() { // Добавляем поведение кнопки выхода
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(1);
		}
    });
    importMenuItem.addActionListener(new ActionListener() { // Добавляем поведение кнопки загрузки файла
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
    menu.add(logoMenuItem); // Добавляем пункты в меню
    menu.add(importMenuItem);
    menu.add(exitMenuItem);
    
    main_GUI.setJMenuBar(menuBar); // Добавляем меню бар в наше окно
    //user3 end side
    
	//user4 side
	String[] items = { //Our content for JComboBox
			"Переместить логотип УГАТУ в левый верхний угол",
			"Переместить логотип УГАТУ в середину",
			"Переместить логотип УГАТУ в правый верхний угол",
			"Отсортировать данные в проекте"
		};
	
	JComboBox box = new JComboBox(items); //Initialize JComboBox
	box.setBounds(20,150,250,40);
	box.setFont(new Font("Arial", Font.BOLD, 10));
	box.addActionListener(actionListener);
	
	
	main_panel.add(box);
	//user4 end side
	
	//user4 side
	JButton calcButton = new JButton("Рассчитать");
	calcButton.addActionListener(actionListener);
	calcButton.setBounds(new Rectangle(200,200,130,30));
	main_panel.add(calcButton);
	//end
	
	
	
	main_GUI.setVisible(true);
	
	main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрытие окна JFrame и процесса Java
	}
	
	public void calculateSquare() {
		
	}
	
	
	public boolean stringCanBeDouble(String str) //проверка является ли строка конрвертируемой в double
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
	public void inputIsCorrect()//вызывается когда сторона квадрата введена корректно
	{
		if(wrongSideInput_label!=null)
		{
			wrongSideInput_label.setVisible(false);
		}
		user_input_value = Double.parseDouble(sideInput.getText());
	}
	public void inputIsWrong() //вызывается при неверном вводе стороны квадрата
	{
		user_input_value = -1;
		if(wrongSideInput_label==null)
		{
			wrongSideInput_label = new JLabel("Неверный ввод");
			wrongSideInput_label.setBounds(132,220,130,30);
			main_panel.add(wrongSideInput_label);
		} else
		{
			wrongSideInput_label.setVisible(true);
		}
	}
	
	
	public static void main(String[] args) { // интересные заметки: http://www.mstu.edu.ru/study/materials/java/
		subversion student= new subversion();
		
	}

}
