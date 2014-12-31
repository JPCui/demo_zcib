package cn.zcib.action;

import cn.zcib.util.VerifyCode;
import cn.zcib.util.VerifyCode.SecurityCodeLevel;
import cn.zcib.util.VerifyImage;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.ByteArrayInputStream;
import java.util.Map;


/**
 * @name 验证码类
 * @package cn.zcib.util
 * @author REAL
 * @version 2013.12.24
 */
@SuppressWarnings("unused")
public class VerifyCodeAction extends ActionSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	//Struts2中Map类型的session
//    @SuppressWarnings("unchecked")
//	private Map<String, Object> session = ActionContext.getContext().getSession();
    
    //图片流
    private ByteArrayInputStream imageStream;

    public ByteArrayInputStream getImageStream() {
        return imageStream;
    }

    public void setImageStream(ByteArrayInputStream imageStream) {
        this.imageStream = imageStream;
    }

    
	public String execute() throws Exception {
        //如果开启Hard模式，可以不区分大小写
        //String securityCode = VerifyCode.getSecurityCode(4,SecurityCodeLevel.Hard, false).toLowerCase();
        
        //获取默认难度和长度的验证码
        String verifyCode = VerifyCode.getSecurityCode();
        imageStream = VerifyImage.getImageAsInputStream(verifyCode);
        //放入session中
        Map<String,Object> session = ActionContext.getContext().getSession();
        session.put("SERVER_VERIFY_CODE", verifyCode);
        System.out.println("verifyCode : "+verifyCode);
        return SUCCESS;
    }

}
