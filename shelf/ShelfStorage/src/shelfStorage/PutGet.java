package shelfStorage;

import shelfDB.ExecProc;

public class PutGet {

	private static PutGetDoc doc2;

	public static void PG(PutGetDoc doc1)
	{
		// ����������� ������� ���������� ��������� � �����
		doc2 = doc1;
		
		String sql = "EXEC	[dbo].[moveGoods]"
		+ "	@input_id_shelf = "+doc2.getShelfId()+","
		+ "	@input_id_emp = "+doc2.getIdEmp()+","
		+ "	@input_id_art = "+doc2.getIdArt()+","
		+ "	@input_count = "+doc2.getCount()+","
		+ "	@input_move = "+doc2.getAdd();
		ExecProc.exec(sql);
	}
}
