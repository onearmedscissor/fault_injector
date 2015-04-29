package faultinjector.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the Experiment database table.
 * 
 */
@Entity
@Table(name="Experiment")
@NamedQuery(name="Experiment.findAll", query="SELECT e FROM Experiment e")
public class Experiment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Exp_id")
	private int exp_id;

	@Column(name="Description")
	private String description;

	@Column(name="Creation_date")
	private Timestamp creation_date;
	
	@Column(name="Injection_date")
	private Timestamp injection_date;

	@Column(name="Name")
	private String name;

	//bi-directional many-to-one association to User
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Creator_id", referencedColumnName="User_id")
	private User user;

	//bi-directional many-to-one association to Target
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="Target_id")
	private Target target;

	//bi-directional many-to-one association to Faultload
	@OneToMany(mappedBy="experiment", cascade = CascadeType.PERSIST)
	private List<Faultload> faultloads;

	public Experiment() {
	}

	public int getExp_id() {
		return this.exp_id;
	}

	public void setExp_id(int exp_id) {
		this.exp_id = exp_id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreation_date() {
		return this.creation_date;
	}

	public void setCreation_date(Timestamp creation_date) {
		this.creation_date = creation_date;
	}
	
	public Timestamp getInjection_date() {
		return this.injection_date;
	}

	public void setInjection_date(Timestamp injection_date) {
		this.injection_date = injection_date;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Target getTarget() {
		return this.target;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

	public List<Faultload> getFaultloads()
	{
		if(this.faultloads==null)
			this.faultloads = new ArrayList<Faultload>();
		
		return this.faultloads;
	}

	public void setFaultloads(List<Faultload> faultloads)
	{	
		this.faultloads = faultloads;
	}

	public Faultload addFaultload(Faultload faultload) {
		getFaultloads().add(faultload);
		faultload.setExperiment(this);

		return faultload;
	}

	public Faultload removeFaultload(Faultload faultload) {
		getFaultloads().remove(faultload);
		faultload.setExperiment(null);

		return faultload;
	}

}