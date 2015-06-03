package faultinjector.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Application;
import faultinjector.entity.Injection_Run;
import faultinjector.entity.Workload;
import faultinjector.service.ExperimentService;

public class ShowWorkloadAction extends ActionSupport /* implements SessionAware */
{
	private static final long serialVersionUID = 4L;

	/* private Map<String, Object> session; */

	private ExperimentService service;
	private Workload workload;
	private List<Injection_Run> injectionRuns;
	private List<Application> applications;

	private int id;

	@Override
	public String execute()
	{
		service = new ExperimentService();

		this.workload = service.findWorkload(id);
		applications = workload.getApplications();

		System.out.println("SHOW WORKLOAD-------------------------------");
		System.out.println("Workload ID = " + workload.getWl_id());
		System.out.println("Workload NAME = " + workload.getName());

		injectionRuns = workload.getInjectionRuns();

		for (Injection_Run i : injectionRuns)
		{
			System.out.println("Workload FAULTLOAD NAME = " + i.getFaultload().getName());
			System.out.println("Workload OUTPUT FILENAME = " + i.getOutput_filename());
		}

		for (Application a : applications)
		{
			System.out.println("Workload APPLICATION #" + applications.indexOf(a) + 1 + " NAME = " + a.getName());
		}

		System.out.println("Workload TARGET NAME = " + workload.getTarget().getName());

		return SUCCESS;
	}

	/*
	 * @Override public void setSession(Map<String, Object> session) {
	 * this.session = session; }
	 */

	public Workload getWorkload()
	{
		return workload;
	}

	public List<Application> getApplications()
	{
		return applications;
	}

	public void setId(int id)
	{
		this.id = id;
	}
}
