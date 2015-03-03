package faultinjector.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import faultinjector.entity.Experiment;
import faultinjector.entity.Target;

public interface Persistable
{
	//public void beginTransaction();
	
	public void closeTransaction();
	
	public List <Experiment> findAllExperiments();
	
	public Experiment findExperiment(int id);
	
	public void deleteExperiment(int id);
	
	public List <Target> findAllTargets();
	
	public Target findTarget(int id);
	
	public void deleteTarget(int id); 
	
	public EntityManager getEntityManager();
	
	public EntityManagerFactory getEntityManagerFactory();
	
	public EntityTransaction getEt();
	
	public void setEt(EntityTransaction et);
}
