package faultinjector.action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.struts2.interceptor.SessionAware;

import faultinjector.entity.Experiment;
import faultinjector.service.ExperimentService;

public class LoadExperimentsAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;
	
	private Map<String, Object> session;
	private List <Experiment> experiments;
	
	@Override
	public String execute()
    {	
		this.experiments=this.getExperimentService().findAll();
	   	
		for (Experiment e : this.experiments)
		{
			System.out.println("Experiment ID = "+e.getEid());
			System.out.println("Experiment NAME = "+e.getName());
		}
		
        return SUCCESS;
	}
	
	public ExperimentService getExperimentService()
	{
		if(!session.containsKey("experimentService"))
		{
			ExperimentService experimentService = new ExperimentService();
			
			this.setExperimentService(experimentService);
		}
		
		return (ExperimentService) session.get("experimentService");
	}
	
	public void setExperimentService(ExperimentService experimentService)
	{
		this.session.put("experimentService", experimentService);
	}
	
	public List<Experiment> getExperiments()
	{
		return experiments;
	}

	public void setExperiments(List<Experiment> experiments)
	{
		this.experiments = experiments;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session=session;
	}
}
