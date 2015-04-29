package faultinjector.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;

import faultinjector.bean.ExperimentBean;
import faultinjector.service.ExperimentService;

public class CreateExperiment1Action extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;
		
	private Map<String, Object> session;
	private ExperimentBean experimentBean;

	private String name, description;
	
	@Override
	public String execute()
    {		
		if(!session.containsKey("experimentBean"))
		{
			this.experimentBean = new ExperimentBean();
			session.put("experimentBean", experimentBean);
		}
		else
			experimentBean = (ExperimentBean) session.get("experimentBean");
	   	
		experimentBean.setName(name);
		experimentBean.setDescription(description);
		
		System.out.println("NEW EXPERIMENT 1-------------------------------");
		System.out.println("New experiment NAME = "+experimentBean.getName());
		System.out.println("New experiment DESCRIPTION = "+experimentBean.getDescription());
		
        return SUCCESS;
	}
	
	public void validate()
	{	
		if (name==null || name.length()==0 || name.length()>50)
			addFieldError("experimentBean.name", "Experiment name is required and can't have more than 50 characters!");
		
		if(description==null || description.length()==0 || description.length()>300)
			addFieldError("experimentBean.description", "Experiment description is required  and can't have more than 300 characters!");
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

	public void setName(String name)
	{
		this.name=name;
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