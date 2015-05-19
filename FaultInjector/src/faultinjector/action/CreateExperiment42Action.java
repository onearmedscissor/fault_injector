package faultinjector.action;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.bean.ExperimentBean;
import faultinjector.entity.Experiment;
import faultinjector.entity.Faultload;
import faultinjector.service.ExperimentService;

public class CreateExperiment42Action extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private ExperimentBean experimentBean;
	private Experiment experiment;
	private String[] fids;

	private EntityManager em;
	private EntityTransaction et;

	@Override
	public String execute()
	{
		if (!session.containsKey("experimentBean"))
		{
			this.experimentBean = new ExperimentBean();
			session.put("experimentBean", experimentBean);
		}
		else
			experimentBean = (ExperimentBean) session.get("experimentBean");

		fids = experimentBean.getFaultloadIds();

		em = this.getExperimentService().getEntityManager();
		et = em.getTransaction();
		et.begin();

		experiment = this.getExperimentService().findExperiment(experimentBean.getId());

		for (int n = 0; n < fids.length; n++)
		{
			Faultload f = this.getExperimentService().findFaultload(Integer.parseInt(fids[n]));

			experiment.addFaultload(f);
		}

		et.commit();
		em.close();

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

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}