package faultinjector.service;

import faultinjector.entity.Experiment;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ExperimentService implements Persistable
{
	private EntityManager em;
	private EntityManagerFactory emfactory;
	private EntityTransaction et;
	
	public ExperimentService()
	{
		emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
	   	em = emfactory.createEntityManager();
	   	et = em.getTransaction();
	}
	
	public void closeTransaction()
	{
		this.em.close();
		this.emfactory.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Experiment> findAll()
	{
        Query query = getEntityManager().createQuery("select e FROM Experiment e");
        
        System.out.println("Olá");
        
        return query.getResultList();
    }
	
	public Experiment findExperiment(int id)
	{
		return this.em.find(Experiment.class, id);
	}
	
	public void deleteExperiment(int id)
	{
		this.getEt().begin();
		
		Experiment experiment= findExperiment(id);
		
		this.em.remove(experiment);
		
		this.getEt().commit();
	}
	
	public EntityManager getEntityManager()
	{
        return this.em;
    }
	
	public EntityManagerFactory getEntityManagerFactory()
	{
        return this.emfactory;
    }

	public EntityTransaction getEt()
	{
		return et;
	}

	public void setEt(EntityTransaction et)
	{
		this.et = et;
	}
}
