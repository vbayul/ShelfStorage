package shelfStorage;

import shelfDB.StorageFill;

public class PutGetDoc {
	private String barcode;
	private String articul;
	private String count;
	private String grow;
	private String row;
	private String columns;
	private int add;
	@SuppressWarnings("unused")
	private int idEmp;
	@SuppressWarnings("unused")
	private int idArt;
	
	public PutGetDoc(String barcode, String articul, String count, String grow, String row, String columns, int add) {
		this.barcode = barcode;
		this.articul = articul;
		this.count = count;
		this.grow = grow;
		this.row = row;
		this.columns = columns;
		this.add = add;
	}
	
	public String getCount() {
		return count;
	}

	public int getIdEmp() {
		// ����� ������ � ����, �������� ����� id
		String sql = "EXEC [dbo].[empVer]"
				+ " @input_emp_barcode = "+barcode;
		int idEmp = StorageFill.exist(sql);
		return idEmp;
	}

	public int getIdArt() {
		// ����� ������ � ����, �������� ����� id
		String sql = "EXEC [dbo].[articleVer]"
				+" @input_article_barcode = "+articul;
		int idArt = StorageFill.exist(sql);
		return idArt;
	}
	
	public int getAdd() {
		return add;
	}


	public int getShelfId() {
		String sql = "EXEC [dbo].[shelfVer]"
				+ " @input_grow = "+ grow +","
				+ "	@input_row = "+row +","
				+ "	@input_column = "+columns;
		int Shelfid = StorageFill.exist(sql);
		return Shelfid;
	}
	
	
	public String getGrow() {
		return grow;
	}

	public String getRow() {
		return row;
	}

	public String getColumns() {
		return columns;
	}
}