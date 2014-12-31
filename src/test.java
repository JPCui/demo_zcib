
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Calendar;

import cn.zcib.action.ActionUtil;
import cn.zcib.dao.DB;
import cn.zcib.util.CharsetUtil;
import cn.zcib.util.MessageResource;

public class test {

	/**
	 * @param args
	 * @throws ParseException 
	 * @throws UnsupportedEncodingException 
	 * @throws Exception
	 */
	public static void main(String[] args) throws ParseException, UnsupportedEncodingException {
		System.out.println(CharsetUtil.UTF8_ISO8859("大家好"));
	}

	public static void testMR()
	{
		System.out.println(MessageResource.getZH_CN("path_stu_photo"));
	}
	
	@SuppressWarnings("unused")
	private void dropTable()
	{
		DB db = new DB("jdbc:mysql://localhost/postbar");
		db.getLink("root", "real");

		char ch = '0';
		db.exeSql("drop table index_word_"+ch);
		for (ch = 'a'; ch <= 'z'; ch++) {
			db.exeSql("drop table index_word_"+(char)ch);
		}
	}
	
}
