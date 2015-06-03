package faultinjector.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the Workload database table.
 * 
 */
@Entity
@Table(name = "Workload")
@NamedQuery(name = "Workload.findAll", query = "SELECT w FROM Workload w")
public class Workload implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Wl_id")
	private int wl_id;

	@Column(name = "Name")
	private String name;

	// bi-directional many-to-many association to Register
	@ManyToMany
	@JoinTable(name = "Rel_workload_application", joinColumns = { @JoinColumn(name = "Wl_id") }, inverseJoinColumns = { @JoinColumn(name = "App_id") })
	private List<Application> applications;

	// bi-directional many-to-one association to Injection_Run
	@OneToMany(mappedBy = "workload", cascade = CascadeType.PERSIST)
	private List<Injection_Run> injectionRuns;

	// bi-directional many-to-one association to Target
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Target_id")
	private Target target;

	public Workload()
	{
	}

	public int getWl_id()
	{
		return this.wl_id;
	}

	public void setWl_id(int wl_id)
	{
		this.wl_id = wl_id;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Application> getApplications()
	{
		if (this.applications == null)
			this.applications = new ArrayList<Application>();

		return this.applications;
	}

	public void setApplications(List<Application> applications)
	{
		this.applications = applications;
	}

	public List<Injection_Run> getInjectionRuns()
	{
		if (this.injectionRuns == null)
			this.injectionRuns = new ArrayList<Injection_Run>();

		return this.injectionRuns;
	}

	public void setInjectionRuns(List<Injection_Run> injectionRuns)
	{
		this.injectionRuns = injectionRuns;
	}

	public Injection_Run addInjectionRun(Injection_Run injectionRun)
	{
		getInjectionRuns().add(injectionRun);
		injectionRun.setWorkload(this);

		return injectionRun;
	}

	public Injection_Run removeInjectionRun(Injection_Run injectionRun)
	{
		getInjectionRuns().remove(injectionRun);
		injectionRun.setWorkload(null);

		return injectionRun;
	}

	public Target getTarget()
	{
		return this.target;
	}

	public void setTarget(Target target)
	{
		this.target = target;
	}

}