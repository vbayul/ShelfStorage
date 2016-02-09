package shelfDB;

import java.sql.*;

public class ExecProc {

	public static void exec(String sql)
	{
		Connection con = null;
		try
		{
			con = GetConnetion.getConnection();
			try
			{
				Statement st = con.createStatement();
				st.execute(sql);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally {
				con.close();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
