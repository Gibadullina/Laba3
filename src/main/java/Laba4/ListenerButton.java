package Laba4;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

// класс реализующий слушатель (ожидания нажатия кнопки)
public class ListenerButton implements ActionListener {

	subversion parent;
	
	public ListenerButton(subversion parent) {
		super();
		
		this.parent = parent;
	}
	
	@Override // ключевое слово, которое позволяет в дочернем классе заново создать реализацию метода родительского класса
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().getClass() == JButton.class && ((JButton)e.getSource()).getText() == "Выход" ) {
			System.exit(1);
		}
		if (e.getSource().getClass() == JButton.class && ((JButton)e.getSource()).getText() == "Информация" ) {
			JFrame information = new JFrame("Information");
			information.setTitle ("Information about students");
			information.setBounds(500,400,400,400);
			information.setResizable(false);
			
			JLabel user1 = new JLabel("Газин Д.Р., ПИ-221, зачетка номер: 339, 13/03/2021");
			JLabel user2 = new JLabel("Катасонов С.А., ПИ-221, зачетка номер: 167");
			JLabel user3 = new JLabel("Гибадуллина Э. Ю., ПИ-221, зачетка номер: 147");
			JLabel user4 = new JLabel("Рафиков Д.Р., ПИ-221, зачетка номер: 156, 13/03/2021");
			JLabel file_info = new JLabel("Данные из файла: ");
			JLabel test = new JLabel("");
			
			
			JTextArea area = new JTextArea();
			area.setText(subversion.text);
			area.setLineWrap(true);
			area.setWrapStyleWord(true);
			area.setBounds(20,220,400,70);
			information.add(area);
			

			user1.setBounds(20, 20, 400, 30);
			user2.setBounds(20, 60, 400, 30);
			user3.setBounds(20, 100, 400, 30);
			user4.setBounds(20, 140, 400, 30);
			file_info.setBounds(20, 180, 400, 30);
			test.setBounds(30,240,250,30);
			
			information.add(user1);
			information.add(user2);
			information.add(user3);
			information.add(user4);
			information.add(file_info);
			information.add(test);

			information.setVisible(true);
		}
		if (e.getSource().getClass() == JButton.class && ((JButton)e.getSource()).getText() == "Рассчитать") {
			if (parent.user_input_value != -1) {
				JOptionPane.showMessageDialog(null, "Площадь квадрата равняется "+Math.pow(parent.user_input_value, 2), "Вывод", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Введите нормальные данные!", "Вывод", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		//user4
		if (e.getSource().getClass() == JComboBox.class) { //Behaviour for JComboBox selector
			JComboBox box = (JComboBox)e.getSource();
			String item = box.getSelectedItem().toString();
			switch(item) {
				case "Переместить логотип УГАТУ в левый верхний угол":
					parent.imgIcon.setBounds(20, 40, 150, 80);
					break;
				
				case "Переместить логотип УГАТУ в середину":
					parent.imgIcon.setBounds(120, 40, 150, 80);
					break;
					
				case "Переместить логотип УГАТУ в правый верхний угол":
					parent.imgIcon.setBounds(220, 40, 150, 80);
					break;
					
				case "Отсортировать данные в проекте":
					int[] source = new RandomArray().getRandomArray();
					String str = "Исходный массив: ";
					for(int el : source) {
						str += el + ", ";
					}
					bubbleSort sorter = new bubbleSort(source);
					sorter.sortArray();	
					str += "\nОтсортированный массив: ";
					for(int el : sorter.array) {
						str += el + ", ";
					}
					JOptionPane.showMessageDialog(null, str, "Вывод", JOptionPane.INFORMATION_MESSAGE);
					break;
			}
		}
		
	}

	
}
