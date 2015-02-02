package faultinjector.services;

import faultinjector.model.Experiment;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ExperimentService implements Persistable
{
	private EntityManager em;
	
	public ExperimentService(EntityManager em)
	{
		this.em=em;
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
		return getEntityManager().find(Experiment.class, id);
	}
	
	private EntityManager getEntityManager()
	{
        return em;
    }
}
