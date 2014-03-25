package com.sprhib.service;

import com.sprhib.model.Skupiny;
import java.util.List;


public interface SkupinaService {
	
	public void addSkupina(Skupiny skupiny);
	public void updateSkupina(Skupiny kupiny);
	public Skupiny getSkupina(int id_group);
	public void deleteSkupina(int id_group);
	public List<Skupiny> getSkupiny();

}
