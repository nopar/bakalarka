package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Odber;

@Repository
public class OdberDAO implements EntityDAO<Odber> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addEntity(Odber odber) {
		getCurrentSession().save(odber);
	}

	public void updateEntity(Odber odber) {
		Odber odberToUpdate = getEntity(odber.getIdOdber());
                
		odberToUpdate.setDatum(odber.getDatum());
                odberToUpdate.setObjem(odber.getObjem());
                odberToUpdate.setPoznamka(odber.getPoznamka());
                odberToUpdate.setIdDarca(odber.getIdDarca());
                odberToUpdate.setIdLekar(odber.getIdLekar());
                
		getCurrentSession().update(odberToUpdate);		
	}

	public Odber getEntity(int id) {
		Odber odber = (Odber) getCurrentSession().get(Odber.class, id);
		return odber;
	}

	public void deleteEntity(int id) {
		Odber odber = getEntity(id);
		if (odber != null)
			getCurrentSession().delete(odber);
	}

	@SuppressWarnings("unchecked")
	public List<Odber> getEntites() {
		return getCurrentSession().createQuery("from Odber").list();
	}
        
        @SuppressWarnings("unchecked")
	public String getOdbery() {
		return getCurrentSession().createQuery("from count(*) Odber where id_darca = '2'").toString();
                //select count(*) from ODBER where id_darca = '2';
	}

}
