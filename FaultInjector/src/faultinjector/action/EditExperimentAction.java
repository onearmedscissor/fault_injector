package faultinjector.action;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityTransaction;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;

import faultinjector.entity.Experiment;
import faultinjector.entity.Faultload;
import faultinjector.entity.Injection_Run;
import faultinjector.service.ExperimentService;

public class EditExperimentAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;
	
	private Map<String, Object> session;
	private Experiment experiment;
	private EntityTransaction et;
	//private ExperimentService service;
	private int id;
	private List <Faultload> faultloads;
	public List<Faultload> getFaultloads()
	{
		return faultloads;
	}

	private List <Injection_Run> injectionRuns;
	
	@Override
	public String execute()
    {
		et = this.getExperimentService().getEt();
		
		if(!et.isActive())
		{
			et.begin();
			this.getExperimentService().setEt(et);
			
			this.experiment = this.getExperimentService().findExperiment(id);
			session.put("experiment", experiment);
		}
		else
			experiment = (Experiment) session.get("experiment");

		//this.experiment=service.findExperiment(id);
	   	
		System.out.println("ID -> "+id);
		System.out.println("EDIT-------------------------------");
		System.out.println("Experiment ID = "+experiment.getExp_id());
		System.out.println("Experiment NAME = "+experiment.getName());
		System.out.println("Experiment TARGET NAME = "+experiment.getTarget().getName());
		System.out.println("Experiment CREATION DATE = "+experiment.getCreation_date());
		System.out.println("Experiment CREATOR NAME = "+experiment.getUser().getName());
		
		faultloads=experiment.getFaultloads();
		
		for (Faultload f : faultloads)
		{
			injectionRuns = f.getInjectionRuns();
			
			System.out.println("Experiment FAULTLOAD NAME = "+f.getName());
			
			for(Injection_Run i : injectionRuns)
			{
				System.out.println("Faultload WORKLOAD NAME = "+i.getWorkload().getName());
				System.out.println("Faultload OUTPUT FILENAME = "+i.getOutput_filename());
			}
		}
			
		System.out.println("Experiment DESCRIPTION = "+experiment.getDescription());
		
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

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session=session;
	}
}
