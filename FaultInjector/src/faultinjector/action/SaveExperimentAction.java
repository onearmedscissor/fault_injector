package faultinjector.action;

import java.util.Map;

import javax.persistence.EntityTransaction;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;

import faultinjector.entity.Experiment;
import faultinjector.service.ExperimentService;

public class SaveExperimentAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;
	
	private Map<String, Object> session;
	private Experiment experiment;
	private EntityTransaction et;
	
	//private int id;
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
		//System.out.println("Olá!");
		/*EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
	   	EntityManager entitymanager = emfactory.createEntityManager();
		service = new ExperimentService(entitymanager);
		
		this.experiment=service.findExperiment(id);*/
	   	
		//experiment.setCreatorName(creatorName);
		
		System.out.println("CREATOR NAME! -> "+creatorName);
		
		et = this.getExperimentService().getEt();
		//et.begin();
		
		experiment = (Experiment) session.get("experiment");
		
		//if(name.length()!=0)
			experiment.setName(name);
			
		//if(creatorName.length()!=0)
			experiment.setCreatorName(creatorName);
		
		//experiment.setCreationDate(creationDate);
		
		//if(targetName.length()!=0)
			experiment.setTargetName(targetName);
		
		//if(workloadName.length()!=0)
			experiment.setWorkloadName(workloadName);
		
		//if(faultloadName.length()!=0)
			experiment.setFaultloadName(faultloadName);
		
		//if(outputFilename.length()!=0)
			experiment.setOutputFilename(outputFilename);
		
		//if(description.length()!=0)
			experiment.setDescription(description);

		et.commit();

		System.out.println("SAVE-------------------------------");
		System.out.println("Experiment ID = "+experiment.getEid());
		System.out.println("Experiment NAME = "+experiment.getName());
		System.out.println("Experiment TARGET NAME = "+experiment.getTargetName() );
		System.out.println("Experiment CREATION DATE = "+experiment.getCreationDate());
		System.out.println("Experiment CREATOR NAME = "+experiment.getCreatorName());
		System.out.println("Experiment WORKLOAD NAME = "+experiment.getWorkloadName());
		System.out.println("Experiment OUTPUT FILENAME = "+experiment.getOutputFilename());
		System.out.println("Experiment DESCRIPTION = "+experiment.getDescription());
		System.out.println("Experiment FAULTLOAD NAME = "+experiment.getFaultloadName());
		
		//this.getExperimentService().closeTransaction();
		//session.clear();
		
        return SUCCESS;
	}
	
	public void validate()
	{
//		try
//		{
//			experiment = (Experiment) session.get("experiment");
//		
//			System.out.println("EXPERIMENT NAME -> "+experiment.getName());
//			
//			if (/*experiment.getName() == null ||*/ experiment.getName().length() == 0)
//				addFieldError("experiment.name", "Experience name is required!");
//			
//			if(/*experiment.getCreatorName() == null ||*/ experiment.getCreatorName().length() == 0)
//				addFieldError("experiment.creatorName", "Creator name is required!");
//			
//			if(/*experiment.getTargetName() == null ||*/ experiment.getTargetName().length() == 0)
//				addFieldError("experiment.targetName", "Target name is required!");
//			
//			if(/*experiment.getWorkloadName() == null ||*/ experiment.getWorkloadName().length() == 0)
//				addFieldError("experiment.workloadName", "Workload name is required!");
//			
//			if(/*experiment.getFaultloadName() == null ||*/ experiment.getFaultloadName().length() == 0)
//				addFieldError("experiment.faultloadName", "Faultload name is required!");
//			
//			if(/*experiment.getOutputFilename() == null ||*/ experiment.getOutputFilename().length() == 0)
//				addFieldError("experiment.outputFilename", "Output filename is required!");
//			
//			if(/*experiment.getDescription() == null ||*/ experiment.getDescription().length() == 0)
//				addFieldError("experiment.description", "Description is required!");
//		}
//		catch (NullPointerException npe)
//		{
//		}
		
		if (/*experiment.getName() == null ||*/ name.length() == 0)
			addFieldError("experiment.name", "Experience name is required!");
		
		if(/*experiment.getCreatorName() == null ||*/ creatorName.length() == 0)
			addFieldError("experiment.creatorName", "Creator name is required!");
		
		if(/*experiment.getTargetName() == null ||*/ targetName.length() == 0)
			addFieldError("experiment.targetName", "Target name is required!");
		
		if(/*experiment.getWorkloadName() == null ||*/ workloadName.length() == 0)
			addFieldError("experiment.workloadName", "Workload name is required!");
		
		if(/*experiment.getFaultloadName() == null ||*/ faultloadName.length() == 0)
			addFieldError("experiment.faultloadName", "Faultload name is required!");
		
		if(/*experiment.getOutputFilename() == null ||*/ outputFilename.length() == 0)
			addFieldError("experiment.outputFilename", "Output filename is required!");
		
		if(/*experiment.getDescription() == null ||*/ description.length() == 0)
			addFieldError("experiment.description", "Description is required!");
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
	
	/*public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}*/
	
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
