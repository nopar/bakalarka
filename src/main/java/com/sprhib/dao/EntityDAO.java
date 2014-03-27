package com.sprhib.dao;

import java.util.List;


public interface EntityDAO<T> {
	
	public void addEntity(T entity);
	public void updateEntity(T entity);
	public T getEntity(int id);
	public void deleteEntity(int id);
	public List<T> getEntites();
//        public List getListJSON();

}
