package cn.zcib.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author REAL
 * @param <T>
 */
public interface PaymentService{

	List<HashMap<String, String>> getPaymentByClass(String clazz, int year);

	Map<String, Float> getAmountByClass(String clazz, int year);

	int getDebtNumByClass(String clazz, int year);

}