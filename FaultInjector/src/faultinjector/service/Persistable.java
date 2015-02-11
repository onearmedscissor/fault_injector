package faultinjector.service;

import java.util.List;

import javax.persistence.EntityManager;

import faultinjector.entity.Experiment;

public interface Persistable
{
	//public void beginTransaction();
	
	public void closeTransaction();
	
	public List <Experiment> findAll();
	
	public Experiment findExperiment(int id);
	
	public EntityManager getEntityManager();
}
