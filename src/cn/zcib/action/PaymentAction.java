package cn.zcib.action;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;

import cn.zcib.service.PaymentService;

import com.opensymphony.xwork2.ActionSupport;

public class PaymentAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	@Resource private @Qualifier("paymentService") PaymentService paymentService;
	private String Clazz;
	private String Session;
	
	public String getPaymentByClass()
	{
		int year;
		try {
			//若为空，默认为本年
			year = Integer.parseInt(Session);
		} catch (Exception e) {
			year = Calendar.getInstance().get(Calendar.YEAR);
		}
		List<HashMap<String, String>> list = paymentService.getPaymentByClass(Clazz,year);
		int DebtNum = paymentService.getDebtNumByClass(Clazz,year);
		ActionUtil.saveRequest(ActionUtil.LIST, list);
		ActionUtil.saveRequest("DebtNum", DebtNum);
		return ActionUtil.LIST;
	}

	public PaymentService getPaymentService() {
		return paymentService;
	}

	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public String getClazz() {
		return Clazz;
	}

	public void setClazz(String clazz) {
		Clazz = clazz;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSession() {
		return Session;
	}

	public void setSession(String session) {
		Session = session;
	}
}
