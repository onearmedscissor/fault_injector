package faultinjector.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;

import faultinjector.entity.Experiment;
import faultinjector.service.ExperimentService;

public class EditExperimentAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;
	
	private Map<String, Object> session;
	private Experiment experiment;
	//private ExperimentService service;
	private int id;
	
	@Override
	public String execute()
    {
		//System.out.println("Olá!");
		//this.getExperimentBean().setId(this.id); // FUNCIONA DO OUTRO LADO (SAVE)
		//this.getExperimentBean().setExperiment(experiment);
		
		//session.put("id", id);
		
		//experiment = this.getExperimentBean().getService().findExperiment(id);
		
		this.experiment = this.getExperimentService().findExperiment(id);
		
		session.put("experiment", experiment);
		
		//this.experiment=service.findExperiment(id);
	   	
		System.out.println("ID -> "+id);
		System.out.println("EDIT-------------------------------");
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

	public void validate()
	{
		
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
	
	public Experiment getExperiment()
	{
		return experiment;
	}

	public void setExperiment(Experiment experiment)
	{
		this.experiment=experiment;
	}
	
	/*public ExperimentBean getExperimentBean()
	{
		if(!session.containsKey("experimentBean"))
			this.setExperimentBean(new ExperimentBean());
		return (ExperimentBean) session.get("experimentBean");
	}

	public void setExperimentBean(ExperimentBean experimentBean)
	{
		this.session.put("experimentBean", experimentBean);
	}*/
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session=session;
	}
}
