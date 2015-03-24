package faultinjector.action;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;

import faultinjector.entity.Experiment;
import faultinjector.entity.Faultload;
import faultinjector.entity.Injection_Run;
import faultinjector.service.ExperimentService;

public class SaveExperimentAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;
	
	private Map<String, Object> session;
	private Experiment experiment;
	private EntityManager em;
	private EntityTransaction et;
	private List <Faultload> faultloads;
	private Faultload faultload;
	private List <Injection_Run> injectionRuns;
	private Injection_Run injectionRun;
	
	private String id;
	private String name;
	private String creatorName;
	private String creationDate;
	private String targetName;
	private String workloadName;
	private String faultloadName;
	private String outputFilename;
	private String description;
	
	@Override
	public String execute()
    {  	
		//experiment.setCreatorName(creatorName);
		
		System.out.println("SAVE EXPERIMENT ID HIDDEN FORM VALUE FIELD -> "+id);
		
		em = this.getExperimentService().getEntityManager();
		et = em.getTransaction();
		et.begin();
		
		//experiment = (Experiment) session.get("experiment "+id);
		
		experiment = this.getExperimentService().findExperiment(Integer.parseInt(id));
		
		//if(name.length()!=0)
			experiment.setName(name);
			
		//if(!creatorName.isEmpty())
			experiment.getUser().setName(creatorName);
		
		//experiment.setCreationDate(creationDate);
		
		//if(targetName.length()!=0)
			experiment.getTarget().setName(targetName);
		
		//if(workloadName.length()!=0)
			faultloads=experiment.getFaultloads();
			if(!faultloads.isEmpty())
			{
				faultload = faultloads.get(0);
				injectionRuns = faultload.getInjectionRuns();
				if(!injectionRuns.isEmpty())
				{
					injectionRun = injectionRuns.get(0);
					injectionRun.getWorkload().setName(workloadName);
					
					injectionRun.setOutput_filename(outputFilename);
	    		}
				
				faultload.setName(faultloadName);
			}
			
		//if(faultloadName.length()!=0)
			
		
		//if(outputFilename.length()!=0)
			
		
		//if(description.length()!=0)
			experiment.setDescription(description);

		et.commit();
		em.close();
		
		System.out.println("SAVE EXPERIMENT-------------------------------");
		System.out.println("Experiment ID = "+experiment.getExp_id());
		System.out.println("Experiment NAME = "+experiment.getName());
		System.out.println("Experiment TARGET NAME = "+experiment.getTarget().getName());
		System.out.println("Experiment CREATION DATE = "+experiment.getCreation_date());
		
		if(experiment.getUser()!=null)
			System.out.println("Experiment CREATOR NAME = "+experiment.getUser().getName());
		
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
		
		//this.getExperimentService().closeTransaction();
		//session.clear();
		
        return SUCCESS;
	}
	
	public void validate()
	{		
		System.out.println("SAVE EXPERIMENT VALIDADE ID -> "+id);
		
		if (name == null || name.length() == 0)
			addFieldError("experiment.name", "Experience name is required!");
		
		if(creatorName == null || creatorName.length() == 0)
			addFieldError("experiment.creatorName", "Creator name is required!");
		
		if(targetName == null || targetName.length() == 0)
			addFieldError("experiment.targetName", "Target name is required!");
//		
//		if(experiment.getFaultloads()!=null)
//		{
			if(workloadName == null || workloadName.length() == 0)
				addFieldError("experiment.workloadName", "Workload name is required!");
		
			if(outputFilename == null || outputFilename.length() == 0)
				addFieldError("experiment.outputFilename", "Output filename is required!");
//		}
		
		if(faultloadName == null || faultloadName.length() == 0)
			addFieldError("experiment.faultloadName", "Faultload name is required!");
		
		if(description == null || description.length() == 0)
			addFieldError("experiment.description", "Description is required!");
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
		this.experiment = experiment;
	}
	
	public void setId(String id)
	{
		this.id=id;
	}
	
	public String getId()
	{
		return id;
	}

	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setCreatorName(String creatorName)
	{
		this.creatorName=creatorName;
	}

	public void setCreationDate(String creationDate)
	{
		this.creationDate = creationDate;
	}

	public void setTargetName(String targetName)
	{
		this.targetName = targetName;
	}

	public void setWorkloadName(String workloadName)
	{
		this.workloadName = workloadName;
	}

	public void setFaultloadName(String faultloadName)
	{
		this.faultloadName = faultloadName;
	}

	public void setOutputFilename(String outputFilename)
	{
		this.outputFilename = outputFilename;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getName()
	{
		return name;
	}

	public String getCreatorName()
	{
		return creatorName;
	}

	public String getCreationDate()
	{
		return creationDate;
	}

	public String getTargetName()
	{
		return targetName;
	}

	public String getWorkloadName()
	{
		return workloadName;
	}

	public String getFaultloadName()
	{
		return faultloadName;
	}

	public String getOutputFilename()
	{
		return outputFilename;
	}

	public String getDescription()
	{
		return description;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session=session;
	}
}
