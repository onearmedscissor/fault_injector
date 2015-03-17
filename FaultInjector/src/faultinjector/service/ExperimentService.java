package faultinjector.service;

import faultinjector.entity.Experiment;
import faultinjector.entity.Faultload;
import faultinjector.entity.Target;
import faultinjector.entity.Workload;

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
	public List<Experiment> findAllExperiments()
	{
        Query query = getEntityManager().createQuery("select e FROM Experiment e");
        
        return query.getResultList();
    }
	
	public Experiment findExperiment(int id)
	{
		return this.em.find(Experiment.class, id);
	}
	
	public void deleteExperiment(int id)
	{
		this.getEt().begin();
		
		Experiment experiment=findExperiment(id);
		
		this.em.remove(experiment);
		
		this.getEt().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Target> findAllTargets()
	{
        Query query = getEntityManager().createQuery("select t FROM Target t");
        
        return query.getResultList();
    }
	
	public Target findTarget(int id)
	{
		return this.em.find(Target.class, id);
	}
	
	public void deleteTarget(int id)
	{
		this.getEt().begin();
		
		Target target=findTarget(id);
		
		this.em.remove(target);
		
		this.getEt().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Workload> findAllWorkloads()
	{
        Query query = getEntityManager().createQuery("select w FROM Workload w");
        
        return query.getResultList();
    }
	
	public Workload findWorkload(int id)
	{
		return this.em.find(Workload.class, id);
	}
	
	public void deleteWorkload(int id)
	{
		this.getEt().begin();
		
		Workload workload=findWorkload(id);
		
		this.em.remove(workload);
		
		this.getEt().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Faultload> findAllFaultloads()
	{
        Query query = getEntityManager().createQuery("select f FROM Faultload f");
        
        return query.getResultList();
    }
	
	public Faultload findFaultload(int id)
	{
		return this.em.find(Faultload.class, id);
	}
	
	public void deleteFaultload(int id)
	{
		this.getEt().begin();
		
		Faultload faultload=findFaultload(id);
		
		this.em.remove(faultload);
		
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
