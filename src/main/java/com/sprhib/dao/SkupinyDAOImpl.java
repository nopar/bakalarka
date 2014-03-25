package com.sprhib.dao;

import com.sprhib.model.Skupiny;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SkupinyDAOImpl implements SkupinyDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addSkupina(Skupiny skupina) {
		getCurrentSession().save(skupina);
	}

	public void updateSkupina(Skupiny skupina) {
		Skupiny skupinyToUpdate = getSkupina(skupina.getIdGroup());
		skupinyToUpdate.setAutorita(skupina.getAutorita());
		skupinyToUpdate.setSpecialne(skupina.getSpecialne());
		getCurrentSession().update(skupinyToUpdate);
		
	}
    

	public Skupiny getSkupina(int id_group) {
		Skupiny skupina = (Skupiny) getCurrentSession().get(Skupiny.class, id_group);
		return skupina;
	}
        
      

	public void deleteSkupina(int id) {
		Skupiny skupina = getSkupina(id);
                if(skupina != null)
			getCurrentSession().delete(skupina);
	}

	@SuppressWarnings("unchecked")
	public List<Skupiny> getSkupiny() {
		return getCurrentSession().createQuery("from Skupiny").list();
	}

}
