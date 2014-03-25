package com.sprhib.dao;

import com.sprhib.model.Stat;
import java.util.List;


public interface StatDAO {
	
	public void addStat(Stat stat);
	public void updateStat(Stat stat);
	public Stat getStat(int id);
	public void deleteStat(int id);
	public List<Stat> getStats();

}
