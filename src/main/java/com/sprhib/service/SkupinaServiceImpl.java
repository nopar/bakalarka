package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.SkupinyDAO;
import com.sprhib.model.Skupiny;


@Service
@Transactional
public class SkupinaServiceImpl implements SkupinaService {
	
	@Autowired
	private SkupinyDAO skupinaDAO;

	public void addSkupina(Skupiny skupina) {
		skupinaDAO.addSkupina(skupina);		
	}

	public void updateSkupina(Skupiny skupina) {
		skupinaDAO.updateSkupina(skupina);
	}

	public Skupiny getSkupina(int id_group) {
		return skupinaDAO.getSkupina(id_group);
	}

	public void deleteSkupina(int id_group) {
		skupinaDAO.deleteSkupina(id_group);
	}

	public List<Skupiny> getSkupiny() {
		return skupinaDAO.getSkupiny();
	}

}
