package cn.zcib.service;

import java.util.List;
import java.util.Map;

import cn.zcib.bean.Config;

/**
 * @author REAL
 * @param <T>
 */
public interface ConfigService{

	List<Config> getAllConfig();

	List<Map<String, Object>> getAllConfigJson();
}