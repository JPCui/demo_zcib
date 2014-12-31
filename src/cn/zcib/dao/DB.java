package cn.zcib.dao;

import java.sql.*;
@SuppressWarnings("unused")
public class DB
{
	private String dbUrl;
	private String dbId;
	private String dbPsd;
	private String dbDriver;
	private Connection conn;
	private Statement stmt;
	private ResultSet res;
	public DB(String dbUrl)
	{
		this.dbUrl = dbUrl;
	}
	public void getLink(String dbId, String dbPwd)
	{
		try
		{
			//加载Connector/J驱动
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//建立到MySQL的连接
			conn =DriverManager.getConnection(dbUrl,dbId, dbPwd);
			stmt = conn.createStatement();
		}
		catch (Exception e)
		{
			System.out.println("Exception...连接失败");
			e.printStackTrace();
		}
	}
	public void insert(String sql)
	{
		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			if(e.getMessage().startsWith("Duplicate entry"))
			{
				//有重复值
			}
			else
			{
				e.printStackTrace();
			}
		}
	}
	public void exeSql(String sql)
	{
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void delete(String sql)throws Exception
	{
		if(stmt.executeUpdate(sql) == 1)
		{
			System.out.println("delete ok");
		}
		else
		{
			System.out.println("delete 0");
		}
	}
	public int update(String sql)
	{
		try
		{
			stmt.executeUpdate(sql);
		}
		catch (Exception e)
		{
			System.out.println("update err");
			e.printStackTrace();
		}
		return 1;
	}
	public ResultSet search(String sql)throws Exception
	{
		//执行SQL语句
		res = stmt.executeQuery(sql);
		/*以后用容器接受结果集里的值,处理结果集*/
		return res;
	}

	public static void main(String arg[])
	{
		DB db = new DB("jdbc:mysql://localhost/spider_test");
		ResultSet res;

		db.getLink("root","real");

		String sql = "";
		try
		{
			sql = "insert into test (id,name) values("+
					"1"+","+"'cjp'"+")";
			//------------------增------------------
			db.insert(sql);
		}
		catch (Exception e)
		{
			System.out.println("insert err:"+sql);
			e.printStackTrace();
		}
		try
		{
			//------------------删------------------
//			db.delete("delete from test where name = 'haha'");
		}
		catch (Exception e)
		{
			System.out.println("delete err");
		}
		try
		{
		//------------------改------------------
		db.update("update test set name='asd' where id=1");
		}
		catch (Exception e)
		{
			System.out.println("update err");
		}
		try
		{
			//----------------查-----------------
			res = db.search("select * from test");//接受结果集
			while(res.next())
			{
				String name = res.getString("name");
				String age = res.getString("age");
				System.out.println(name+"..."+age);
			}
			res.close();
		}
		catch (Exception e)
		{
			System.out.println("search err");
		}
	}
}