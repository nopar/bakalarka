package com.sprhib.service;

import java.util.List;

import com.sprhib.model.Stat;

public interface StatService {
	
	public void addStat(Stat stat);
	public void updateStat(Stat stat);
	public Stat getStat(int id);
	public void deleteStat(int id);
	public List<Stat> getStats();

}
