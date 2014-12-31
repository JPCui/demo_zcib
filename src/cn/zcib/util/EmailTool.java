package cn.zcib.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailTool {

	private static String QQ_SMTP = "smtp.qq.com";	//QQ的SMTP
	@SuppressWarnings("unused")
	private static String QQ_POP = "smtp.qq.com";	//QQ的POP
	private static String qqmail = "1367471019@qq.com";	//服务器的邮箱地址
	private static String qqpwd = "15238771688";		//服务器密码
	
	public static boolean mainto(String receiver,String title,String content) throws Exception {
		
		BodyPart messageBodyPart = new MimeBodyPart();		//内容格式
		Multipart multipart = new MimeMultipart();
		boolean flag = true;

		// 建立邮件会话
		Properties pro = new Properties();
		pro.put("mail.smtp.host", QQ_SMTP);// 存储发送邮件的服务器
		pro.put("mail.smtp.auth", "true"); // 通过服务器验证

		Session s = Session.getInstance(pro); // 根据属性新建一个邮件会话
		// s.setDebug(true);

		// 由邮件会话新建一个消息对象
		MimeMessage message = new MimeMessage(s);

		// 设置邮件
		InternetAddress fromAddr = null;
		InternetAddress toAddr = null;

		messageBodyPart.setContent(content, "text/html;charset=gbk");//给BodyPart对象设置内容和格式/编码方式
		
		try {
			fromAddr = new InternetAddress(qqmail); // 邮件发送地址
			message.setFrom(fromAddr); // 设置发送地址

			toAddr = new InternetAddress(receiver); // 邮件接收地址
			message.setRecipient(Message.RecipientType.TO, toAddr); // 设置接收地址

			message.setSubject(title); // 设置邮件标题
			messageBodyPart.setContent(content, "text/html;charset=utf-8");//给BodyPart对象设置内容和格式/编码方式 
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart); // 设置邮件正文
			message.setSentDate(new Date()); // 设置邮件日期
			message.saveChanges(); // 保存邮件更改信息

			Transport transport = s.getTransport("smtp");
			transport.connect("smtp.qq.com", qqmail, qqpwd); // 服务器地址，邮箱账号，邮箱密码
			transport.sendMessage(message, message.getAllRecipients()); // 发送邮件
			transport.close();// 关闭

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;// 发送失败
		}
		return flag;
	}

	public static void main(String[] args) throws Exception {
		boolean flag = EmailTool.mainto("624498030@qq.com","黎明用户注册通知","<h1>测试</h1><span style='font-weight: bold;'>阿德撒达到</span>");
		System.out.println(flag);
	}
}