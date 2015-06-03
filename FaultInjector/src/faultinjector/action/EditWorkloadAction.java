package faultinjector.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Application;
import faultinjector.entity.Injection_Run;
import faultinjector.entity.Workload;
import faultinjector.service.ExperimentService;

public class EditWorkloadAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private Workload workload;

	private int id;
	private List<Injection_Run> injectionRuns;
	private List<Application> applications;

	@Override
	public String execute()
	{
		workload = this.getExperimentService().findWorkload(id);
		applications = workload.getApplications();

		System.out.println("EDIT WORKLOAD-------------------------------");
		System.out.println("Workload ID = " + workload.getWl_id());
		System.out.println("Workload NAME = " + workload.getName());

		injectionRuns = workload.getInjectionRuns();

		for (Injection_Run i : injectionRuns)
		{
			System.out.println("Workload FAULTLOAD NAME = " + i.getFaultload().getName());
			System.out.println("Workload OUTPUT FILENAME = " + i.getOutput_filename());
		}

		System.out.println("Workload TARGET NAME = " + workload.getTarget().getName());

		return SUCCESS;
	}

	public ExperimentService getExperimentService()
	{
		if (!session.containsKey("experimentService"))
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

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Workload getWorkload()
	{
		return workload;
	}

	public List<Application> getApplications()
	{
		return applications;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
