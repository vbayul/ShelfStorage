package shelfStorage;

import shelfDB.StorageFill;

public class PutGetDocVer {


	public static boolean empVer(String emp)
	{
		boolean ret = false;
		// �������� ���������� ���� �� ���������� ����, ����� ����������� ������� ������ ��������� � ����
		if (emp.length() == 13) 
		{
			String sql = "EXEC	[dbo].[empVer]"
				+ "	@input_emp_barcode =  " + emp;
			int a = StorageFill.exist(sql);
			if (a != 0) ret = true;
			else ret = false;
		}
		return ret;
	}
		
	public static boolean articleVer(String art)
	{
		boolean ret = false;
		// ���������� ������� ������������ ����������� ���� � �������� � ����� ������� ������ �������� � ����
		if (art.length() == 8) 
		{
			String sql = "EXEC [dbo].[articleVer]"
				+ "	@input_article_barcode =  " + art;
			int a = StorageFill.exist(sql);
			if (a != 0) ret = true;
			else ret = false;
		}
		return ret;
	}
		
	public static boolean shelfVer(String grow, String row, String columns)
	{
		// ����������� ������� ����� ����� � ����
		boolean ret = false;
		if (!grow.equals("")&!row.equals("")&!columns.equals(""))
		{
			String sql = "EXEC [dbo].[shelfVer]"
					+ " @input_grow = "+ grow +","
					+ "	@input_row = "+row +","
					+ "	@input_column = "+columns;
			int a = StorageFill.exist(sql);
			if (a != 0) ret = true;
			else ret = false;
		}
		return ret;
	}
	
	public static boolean countVer(String art, String count, int mv)
	{
		boolean ret = false;
		if (mv == 1)
		{
			if (!count.equals("")) ret = true;
		}
		else
		{
			if (!count.equals(""))
			{
				// ������ � ����
			}
		}
		return ret;
	}
}
