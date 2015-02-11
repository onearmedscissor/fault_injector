package faultinjector.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;

import faultinjector.entity.Experiment;
import faultinjector.model.ExperimentBean;
import faultinjector.service.ExperimentService;

public class SaveExperimentAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;
	
	private Map<String, Object> session;
	private Experiment experiment;
	
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
		
		experiment = (Experiment) session.get("experiment");
		experiment.setName(name);
		experiment.setCreatorName(creatorName);
		experiment.setCreationDate(creationDate);
		experiment.setTargetName(targetName);
		experiment.setWorkloadName(workloadName);
		experiment.setFaultloadName(faultloadName);
		experiment.setOutputFilename(outputFilename);
		experiment.setDescription(description);
		
		this.getExperimentService().getEntityManager().getTransaction().commit();
		//this.getExperimentBean().getService().getEntityManager().getTransaction().commit();
		//experiment = this.getExperimentBean().getExperiment();
		
		System.out.println("ID! -> "+this.getExperimentBean().getId());
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
		
        return SUCCESS;
	}
	
	public ExperimentBean getExperimentBean()
	{
		if(!session.containsKey("experimentBean"))
			this.setExperimentBean(new ExperimentBean());
		return (ExperimentBean) session.get("experimentBean");
	}

	public void setExperimentBean(ExperimentBean experimentBean)
	{
		this.session.put("experimentBean", experimentBean);
	}
	
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

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session=session;
	}
}
