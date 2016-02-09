package shelfStorageFrame;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Date;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

import shelfDB.TableFill;

public class HistoryFrame extends JFrame {
	
	JDateChooser cal1;
	JDateChooser cal2;
	JTextField article;
	JTable historyTable;
	String[] columnNames = new String[11];
	SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
	
	private static final long serialVersionUID = 1L;

	public HistoryFrame()
	{
		columnNames[0] = "�����";
		columnNames[1] = "��������";
		columnNames[2] = "����";
		columnNames[3] = "�����";
		columnNames[4] = "�������";
		columnNames[5] = "��������";
		columnNames[6] = "����������";
		columnNames[7] = "������";
		columnNames[8] = "���";
		columnNames[9] = "�������";
		columnNames[10] = "���";	
		
		// ��������� ����������
		cal1 = new JDateChooser();
		cal1.setDate(new Date());
		cal2 = new JDateChooser();
		cal2.setDate(new Date());
		article = new JTextField();
		historyTable = new JTable(){
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
				}
			};
		JButton searchHistory = new JButton("�����");
		JPanel settingPanel = new JPanel();
		settingPanel.setLayout( new GridBagLayout());
		GridBagConstraints GBC = new GridBagConstraints();
		
		// ���������� �� �����
		GBC.fill = GridBagConstraints.HORIZONTAL;
		GBC.weightx = 0.5;
		GBC.gridx = 0;
		GBC.gridy = 0;
		settingPanel.add(new JLabel("������ � "),GBC);
		GBC.fill = GridBagConstraints.HORIZONTAL;
		GBC.weightx = 0.5;
		GBC.gridx = 1;
		GBC.gridy = 0;
		settingPanel.add(cal1,GBC);
		GBC.fill = GridBagConstraints.HORIZONTAL;
		GBC.weightx = 0.5;
		GBC.gridx = 2;
		GBC.gridy = 0;
		settingPanel.add(new JLabel(" �� "),GBC);	
		GBC.fill = GridBagConstraints.HORIZONTAL;
		GBC.weightx = 0.5;
		GBC.gridx = 3;
		GBC.gridy = 0;
		settingPanel.add(cal2,GBC);
		GBC.fill = GridBagConstraints.HORIZONTAL;
		GBC.weightx = 0.5;
		GBC.gridx = 0;
		GBC.gridy = 1;
		settingPanel.add(new JLabel("�������"), GBC);		
		GBC.fill = GridBagConstraints.HORIZONTAL;
		GBC.gridwidth = 3;
		GBC.gridx = 1;
		GBC.gridy = 1;
		settingPanel.add(article, GBC);
		GBC.fill = GridBagConstraints.HORIZONTAL;
		GBC.gridwidth = 4;
		GBC.gridx = 0;
		GBC.gridy = 2;
		settingPanel.add(searchHistory, GBC);		

		// �������� ������
		searchHistory.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String sql = "SELECT [dep] ,[nameMove] ,[date] ,[time] ,[article] ,[name] ,[count] ,[global_rows] ,[rows] ,[columns] ,[name_ru] "
						+ "FROM [docsView] WHERE [date] >= '" + format1.format(cal1.getDate()) + "' and [date] <= '" + format1.format(cal2.getDate())+"'" ;
				historyTable.setModel(TableFill.tableModel(sql, columnNames));
			}
		});
		
		add(settingPanel, BorderLayout.NORTH);		
		add(new JScrollPane(historyTable), BorderLayout.CENTER);

		pack();
	}
}