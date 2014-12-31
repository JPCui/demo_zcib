package cn.zcib.service;

import java.io.Serializable;
import java.util.List;

import cn.zcib.bean.Department;

/**
 * @author REAL
 * @param <T>
 */
public interface DepartService{

	List<Department> getDepartments();

	String updateDepartment(Department department);

	String delDepartment(Serializable id);

	String addDepartment(Department department);

}