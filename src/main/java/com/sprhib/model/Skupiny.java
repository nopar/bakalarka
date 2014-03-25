package com.sprhib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SKUPINY")
public class Skupiny {
	
	@Id
	@GeneratedValue
	private Integer id_group;
	
	private String autorita;
	
	private Integer specialne;

    public Integer getIdGroup() {
        return id_group;
    }

    public void setIdGroup(Integer id_group) {
        this.id_group = id_group;
    }

    public String getAutorita() {
        return autorita;
    }

    public void setAutorita(String autorita) {
        this.autorita = autorita;
    }

    public Integer getSpecialne() {
        return specialne;
    }

    public void setSpecialne(Integer specialne) {
        this.specialne = specialne;
    }

   
        
	
        
        
        
        
        
       

}
