package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.StatDAO;
import com.sprhib.model.Stat;

@Service
@Transactional
public class StatServiceImpl implements StatService {
	
	@Autowired
	private StatDAO statDAO;

	public void addStat(Stat stat) {
		statDAO.addStat(stat);		
	}

	public void updateStat(Stat stat) {
		statDAO.updateStat(stat);
	}

	public Stat getStat(int id) {
		return statDAO.getStat(id);
	}

	public void deleteStat(int id) {
		statDAO.deleteStat(id);
	}

	public List<Stat> getStats() {
		return statDAO.getStats();
	}

}
