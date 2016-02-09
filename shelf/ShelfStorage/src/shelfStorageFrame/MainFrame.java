package shelfStorageFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import shelfDB.TableFill;

public class MainFrame extends JFrame {


	private static final long serialVersionUID = 1L;
	PutGetFrame putGetFrame;
	HistoryFrame historyFrame; 
	JTable mainTable;
	String[] columnNames = new String[7];
	String sql;
	JTextField findText;
	
	public MainFrame(int depName)
	{		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		columnNames[0] = "������";
		columnNames[1] = "������";
		columnNames[2] = "���";
		columnNames[3] = "�������";
		columnNames[4] = "�������";
		columnNames[5] = "��������";
		columnNames[6] = "����������";
		
		// �������� ���� ���������
		JPanel manPanel = new JPanel(); 
		JPanel findPanel = new JPanel();
		JButton putButton = new JButton("��������");
		JButton findButton = new JButton("�����");
		JButton findClear = new JButton("��������");
		JButton historyButton = new JButton("�������");
		JButton getButton = new JButton("�����");
		findText = new JTextField(13);
		mainTable = new JTable();
		
		// �������� ���� �������
		putButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				putGetFrame = new PutGetFrame(1);
				putGetFrame.setVisible(true);
			}
		});

		getButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				putGetFrame = new PutGetFrame(0);
				putGetFrame.setVisible(true);
			}
		});

		historyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				historyFrame = new HistoryFrame();
				historyFrame.setVisible(true);
			}
		});
	
		findButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!findText.getText().equals(""))
				{	
					// TODO ������� ��������� ������
					String sql = "SELECT [dep],[global_rows],[rows],[columns],[article],[name],[count] "
							+ "FROM storageView "
							+ " WHERE article = " + findText.getText();
					mainTable.setModel(TableFill.tableModel(sql, columnNames));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "������� ������ �������. ������� �������.");
				}
			}
		});
		
		findClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				findText.setText("");
				mainTable.setModel(null);
			}
		});
		
		// ���������� �� ������
		manPanel.add(putButton);
		manPanel.add(getButton);
		manPanel.add(historyButton);
		findPanel.add(new JLabel("�������� ������� ��� ������ - "));
		findPanel.add(findText);
		findPanel.add(findButton);
		findPanel.add(findClear);
		
		// ���������� �� ������ ���� �������
		add(manPanel, BorderLayout.NORTH);
		add( new JScrollPane(mainTable), BorderLayout.CENTER);		
		add(findPanel, BorderLayout.SOUTH);
						
	}
}