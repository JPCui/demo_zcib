package cn.zcib.util;

import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class PasswordAlg
{

	//密钥
	private static String SECRET = "zcib";
	//密码算法
	private static String CIPHER = "AES";
	//编码方式
	private static String CHARSET = "UTF-8";
	
	/**
	 * 加密解密入口
	 * @param content 要加密（解密）内容
	 * @param i 1=加密，2=解密
	 * @return 加密（解密）后的内容
	 */
	public static String crypt(String content,int i){
		try {
			KeyGenerator generator = KeyGenerator.getInstance(CIPHER);
			generator.init(new SecureRandom(SECRET.getBytes()));
			Key key = generator.generateKey();
			generator = null;
			if(i == 1){
				return getEncString(content,key);
			}
			else if(i == 2){
				return getDesString(content,key);
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	/**
	 * 加密String明文输入,String密文输出
	 * 
	 * @param strMing
	 * @return
	 */
	private static String getEncString(String strMing,Key key) {
		byte[] byteMi = null;
		byte[] byteMing = null;
		String strMi = "";
		BASE64Encoder base64en = new BASE64Encoder();
		try {
			byteMing = strMing.getBytes(CHARSET);
			byteMi = getEncCode(byteMing,key);
			strMi = base64en.encode(byteMi);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			base64en = null;
			byteMing = null;
			byteMi = null;
		}
		return strMi;
	}

	/**
	 * 解密 以String密文输入,String明文输出
	 * 
	 * @param strMi
	 * @return
	 */
	private static String getDesString(String strMi, Key key) {
		BASE64Decoder base64De = new BASE64Decoder();
		byte[] byteMing = null;
		byte[] byteMi = null;
		String strMing = "";
		try {
			byteMi = base64De.decodeBuffer(strMi);
			byteMing = getDesCode(byteMi,key);
			strMing = new String(byteMing, CHARSET);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			base64De = null;
			byteMing = null;
			byteMi = null;
		}
		return strMing;
	}

	/**
	 * 加密以byte[]明文输入,byte[]密文输出
	 * 
	 * @param byteS
	 * @return
	 */
	private static byte[] getEncCode(byte[] byteS,Key key) {
		byte[] byteFina = null;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance(CIPHER);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byteFina = cipher.doFinal(byteS);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	/**
	 * 解密以byte[]密文输入,以byte[]明文输出
	 * 
	 * @param byteD
	 * @return
	 */
	private static byte[] getDesCode(byte[] byteD,Key key) {
		Cipher cipher;
		byte[] byteFina = null;
		try {
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byteFina = cipher.doFinal(byteD);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}
	/**
	 * 密码加密算法(MD5)
	 * @param pwd
	 * @return
	 */
	public static String pwdEncode(String pwd)
	{
		//16进制
		char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       

		try {
			byte[] btInput = pwd.getBytes();
	        // 获得MD5摘要算法的 MessageDigest 对象
	        MessageDigest mdInst = MessageDigest.getInstance("MD5");
	        // 使用指定的字节更新摘要
	        mdInst.update(btInput);
	        // 获得密文
	        byte[] md = mdInst.digest();
	        // 把密文转换成十六进制的字符串形式
	        int j = md.length;
	        char str[] = new char[j * 2];
	        int k = 0;
	        for (int i = 0; i < j; i++) {
	            byte byte0 = md[i];
	            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
	            str[k++] = hexDigits[byte0 & 0xf];
	        }
	        return new String(str);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	/**
	 * url加密算法：非对称加密算法
	 * @param url
	 * @return
	 */
	public static String urlEncode(String s)
	{
		return s;
		
	}
	/**
	 * url解密算法:非对称加密算法
	 * @param url
	 * @return
	 */
	public static String urlDecode(String s)
	{
		return s                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     ;
	}

	public static void main(String[] args) {
		System.out.println(PasswordAlg.crypt("?name=网名", 1));
		System.out.println(PasswordAlg.crypt("hHvYr7X6m/yQ5K8fGt0Aqw==", 2));
		System.out.println(PasswordAlg.pwdEncode("?name=张文"));
		System.out.println(PasswordAlg.urlEncode("?name=张文"));
	}

}