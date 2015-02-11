package faultinjector.service;

import faultinjector.entity.Experiment;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ExperimentService implements Persistable
{
	private EntityManager em;
	private EntityManagerFactory emfactory;
	
	public ExperimentService()
	{
		emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
	   	em = emfactory.createEntityManager();
		
	   	this.em.getTransaction().begin();
	}
	
	/*public void beginTransaction()
	{
		
	}*/
	
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
	
	public EntityManager getEntityManager()
	{
        return this.em;
    }
}
