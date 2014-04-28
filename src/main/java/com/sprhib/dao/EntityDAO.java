package com.sprhib.dao;

import java.util.List;


public interface EntityDAO<T> {
	
	void addEntity(T entity);
	void updateEntity(T entity);
	T getEntity(int id);
	void deleteEntity(int id);
	List<T> getEntites();
//      public List getListJSON();

}
