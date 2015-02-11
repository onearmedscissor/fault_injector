package faultinjector.action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import faultinjector.entity.Experiment;
import faultinjector.service.ExperimentService;

public class LoadExperimentsAction extends ActionSupport
{
	private static final long serialVersionUID = 4L;
	
	private ExperimentService service;
	private List <Experiment> experiments;
	
	//private ExperimentBean experimentBean;
	
	@Override
	public String execute()
    {
		//System.out.println("Olá!");
		service = new ExperimentService();
		
		this.experiments=service.findAll();
	   	
		for (Experiment e : this.experiments)
		{
			System.out.println("Experiment ID = "+e.getEid());
			System.out.println("Experiment NAME = "+e.getName());
		}
		
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
	
	public List<Experiment> getExperiments()
	{
		return experiments;
	}

	public void setExperiments(List<Experiment> experiments)
	{
		this.experiments = experiments;
	}
	
	/*public ExperimentBean getExperimentBean()
	{
		return experimentBean;
	}

	public void setExperimentBean(ExperimentBean ExperimentBean)
	{
		this.experimentBean=ExperimentBean;
	}*/
}
