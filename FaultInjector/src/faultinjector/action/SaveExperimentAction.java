package faultinjector.action;

import com.opensymphony.xwork2.ActionSupport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import faultinjector.model.Experiment;
import faultinjector.services.ExperimentService;

public class SaveExperimentAction extends ActionSupport
{
	private static final long serialVersionUID = 4L;
	
	private ExperimentService service;
	private Experiment experiment;
	
	private int id;
	
	@Override
	public String execute()
    {
		//System.out.println("Olá!");
		/*EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
	   	EntityManager entitymanager = emfactory.createEntityManager();
		service = new ExperimentService(entitymanager);
		
		this.experiment=service.findExperiment(id);*/
	   	
		System.out.println("-----------------------------------");
		System.out.println("Experiment ID = "+experiment.getEid());
		System.out.println("Experiment NAME = "+experiment.getName());
		System.out.println("Experiment TARGET NAME = "+experiment.getTargetName() );
		System.out.println("Experiment CREATION DATE = "+experiment.getCreationDate());
		System.out.println("Experiment CREATOR NAME = "+experiment.getCreatorName());
		System.out.println("Experiment WORKLOAD NAME = "+experiment.getWorkloadName());
		System.out.println("Experiment OUTPUT FILENAME = "+experiment.getOutputFilename());
		System.out.println("Experiment DESCRIPTION = "+experiment.getDescription());
		System.out.println("Experiment FAULTLOAD NAME = "+experiment.getFaultloadName());
		
        return SUCCESS;
	}

	public ExperimentService getService()
	{
		return service;
	}

	public void setService(ExperimentService service)
	{
		this.service = service;
	}
	
	public Experiment getExperiment()
	{
		return experiment;
	}

	public void setExperiment(Experiment experiment)
	{
		this.experiment=experiment;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
}
