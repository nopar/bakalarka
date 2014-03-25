package com.sprhib.dao;

import com.sprhib.model.Skupiny;
import java.util.List;

import com.sprhib.model.Team;

public interface SkupinyDAO {
	
	public void addSkupina(Skupiny skupiny);
	public void updateSkupina(Skupiny kupiny);
	public Skupiny getSkupina(int id_group);
	public void deleteSkupina(int id_group);
	public List<Skupiny> getSkupiny();

}
