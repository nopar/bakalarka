package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Stat;

@Repository
public class StatDAOImpl implements StatDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addStat(Stat stat) {
		getCurrentSession().save(stat);
	}

	public void updateStat(Stat stat) {
		Stat statToUpdate = getStat(stat.getIdStat());
		statToUpdate.setStat(stat.getStat());
		statToUpdate.setSkratka(stat.getSkratka());
		getCurrentSession().update(statToUpdate);		
	}

	public Stat getStat(int id) {
		Stat stat = (Stat) getCurrentSession().get(Stat.class, id);
		return stat;
	}

	public void deleteStat(int id) {
		Stat stat = getStat(id);
		if (stat != null)
			getCurrentSession().delete(stat);
	}

	@SuppressWarnings("unchecked")
	public List<Stat> getStats() {
		return getCurrentSession().createQuery("from Stat").list();
	}

}
