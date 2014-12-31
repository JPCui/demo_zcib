package cn.zcib.action;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

import cn.zcib.bean.User;
import cn.zcib.service.RoleService;
import cn.zcib.service.StudentService;
import cn.zcib.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport
{
	@Resource private @Qualifier("userService") UserService userService;
	@Resource private @Qualifier("studentService") StudentService studentService;
	@Resource private @Qualifier("roleService") RoleService roleService;
	private String id;
	private String pwd;
	private String verifyCode;

	public String login()
	{
		if("".equals( id.trim() )){
			ActionUtil.saveRequest("ErrMsg","用户id为空");
			return ActionUtil.FAIL;
		}else if("".equals( pwd.trim() )){
			ActionUtil.saveRequest("ErrMsg","密码为空");
			System.out.println(1);
			return ActionUtil.FAIL;
		}else if("".equals( verifyCode.trim() )){
			ActionUtil.saveRequest("ErrMsg","验证码为空");
//			return ActionUtil.FAIL;
		}
		System.out.println(3);
		//2，进行验证码的验证
		String serverCode = (String)ActionUtil.getBySession("SERVER_VERIFY_CODE");
		if(!serverCode.equals(verifyCode))
		{
			ActionUtil.saveRequest("ErrMsg", "验证码错误");
//			return ActionUtil.FAIL;
		}
		//3，通过事务层进行验证登录
		User user = (User)userService.login(id, pwd);
		if( user == null)
		{
			ActionUtil.saveRequest("ErrMsg", "用户名或密码错误");
			return ActionUtil.FAIL;
		}

		ActionUtil.saveBySession("LoginId",user.getID().toString());
		ActionUtil.saveBySession("LoginName",user.getName());
		ActionUtil.saveBySession("LoginPwd",user.getPassword());
		ActionUtil.saveBySession("IsAdmin",1);
		ActionUtil.saveBySession("Role",roleService.getRoleByName(user.getRoleName()));
		
		return ActionUtil.SUCCESS;
	}
	
	public String getStusByClass()
	{
		String clazz = (String) ActionUtil.getRequest("Class");
		List<HashMap<String, String>> list = studentService.getStusByClass(clazz);
		ActionUtil.saveRequest(ActionUtil.LIST, list);
		return ActionUtil.LIST;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

}
