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
	
	public void closeFactory()
	{
		this.emfactory.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Experiment> findAllExperiments()
	{
		this.em = this.getEntityManagerFactory().createEntityManager();
		
		Query query = this.em.createQuery("select e FROM Experiment e");
        
        return query.getResultList();
    }
	
	public Experiment findExperiment(int id)
	{
		return this.em.find(Experiment.class, id);
	}
	
	public void updateExperiment(int id, Experiment e)
	{
		this.em = this.getEntityManagerFactory().createEntityManager();
		
		this.et=this.em.getTransaction();
				
		this.et.begin();
		
		Experiment experiment=findExperiment(id);
		
		experiment = e;
		
		//this.em.remove(experiment);
		
		this.et.commit();
		
		//this.getEt().commit();
		
		this.em.close();
	}
	
	public void deleteExperiment(int id)
	{
		this.em = this.getEntityManagerFactory().createEntityManager();
		
		this.et=this.em.getTransaction();
				
		this.et.begin();
		
		Experiment experiment=findExperiment(id);
		
		this.em.remove(experiment);
		
		this.getEt().commit();
		
		this.em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Target> findAllTargets()
	{
		this.em = this.getEntityManagerFactory().createEntityManager();
		
		Query query = this.em.createQuery("select t FROM Target t");
        
        return query.getResultList();
    }
	
	public Target findTarget(int id)
	{
		return this.em.find(Target.class, id);
	}
	
	public void deleteTarget(int id)
	{
		this.em = this.getEntityManagerFactory().createEntityManager();
		
		this.et=this.em.getTransaction();
				
		this.et.begin();
		
		Target target=findTarget(id);
		
		this.em.remove(target);
		
		this.getEt().commit();
		
		this.em.close();
	}
	
	public void createTarget(Target t)
	{
		this.em=this.getEntityManagerFactory().createEntityManager();
		
		this.et=this.em.getTransaction();
		
		this.em.persist(t);
		
		this.et.commit();
		
		this.em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Workload> findAllWorkloads()
	{
		this.em = this.getEntityManagerFactory().createEntityManager();
		
		Query query = this.em.createQuery("select w FROM Workload w");
        
        return query.getResultList();
    }
	
	public Workload findWorkload(int id)
	{
		return this.em.find(Workload.class, id);
	}
	
	public void deleteWorkload(int id)
	{
		this.em = this.getEntityManagerFactory().createEntityManager();
		
		this.et=this.em.getTransaction();
				
		this.et.begin();
		
		Workload workload=findWorkload(id);
		
		this.em.remove(workload);
		
		this.getEt().commit();
		
		this.em.close();
	}
	
	public void createWorkload(Workload w)
	{
		this.em=this.getEntityManagerFactory().createEntityManager();
		
		this.et=this.em.getTransaction();
		
		this.em.persist(w);
		
		this.et.commit();
		
		this.em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Faultload> findAllFaultloads()
	{
		this.em = this.getEntityManagerFactory().createEntityManager();
		
		Query query = this.em.createQuery("select f FROM Faultload f");
        
        return query.getResultList();
    }
	
	public Faultload findFaultload(int id)
	{
		return this.em.find(Faultload.class, id);
	}
	
	public void deleteFaultload(int id)
	{
		this.em = this.getEntityManagerFactory().createEntityManager();
		
		this.et=this.em.getTransaction();
				
		this.et.begin();
		
		Faultload faultload=findFaultload(id);
		
		this.em.remove(faultload);
		
		this.et.commit();
		
		this.em.close();
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
}
