package faultinjector.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the Fault database table.
 * 
 */
@Entity
@Table(name="Fault")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="Fault_type")
@NamedQuery(name="Fault.findAll", query="SELECT f FROM Fault f")
public class Fault implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Fault_id")
	private int fault_id;

	@Column(name="Creation_date")
	private Timestamp creation_date;
	
	@Column(name="Fault_type")
	private String fault_type;

	@Column(name="Injected")
	private boolean injected;

	@Column(name="Injection_date")
	private Timestamp injection_date;

	@Column(name="Kernel_mode")
	private boolean kernel_mode;

	@Column(name="Pid")
	private int pid;

	@Column(name="Read_address")
	private boolean read_address;

	@Column(name="Trigger_type")
	private String trigger_type;

	//bi-directional many-to-one association to Faultload
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="Fl_id")
	private Faultload faultload;

	//bi-directional many-to-one association to HardwareFault
	@OneToMany(mappedBy="fault", cascade = CascadeType.PERSIST)
	private List<HardwareFault> hardwares;

	//bi-directional many-to-one association to Injection_Run
	@OneToMany(mappedBy="fault", cascade = CascadeType.PERSIST)
	private List<Injection_Run> injectionRuns;

	//bi-directional many-to-one association to SoftwareFault
	@OneToMany(mappedBy="fault", cascade = CascadeType.PERSIST)
	private List<SoftwareFault> softwares;

	public Fault() {
	}

	public int getFault_id() {
		return this.fault_id;
	}

	public void setFault_id(int fault_id) {
		this.fault_id = fault_id;
	}

	public Timestamp getCreation_date() {
		return this.creation_date;
	}

	public void setCreation_date(Timestamp creation_date) {
		this.creation_date = creation_date;
	}

	public String getFault_type()
	{
		return fault_type;
	}

	public void setFault_type(String fault_type)
	{
		this.fault_type = fault_type;
	}

	public boolean getInjected() {
		return this.injected;
	}

	public void setInjected(boolean injected) {
		this.injected = injected;
	}

	public Timestamp getInjection_date() {
		return this.injection_date;
	}

	public void setInjection_date(Timestamp injection_date) {
		this.injection_date = injection_date;
	}

	public boolean getKernel_mode() {
		return this.kernel_mode;
	}

	public void setKernel_mode(boolean kernel_mode) {
		this.kernel_mode = kernel_mode;
	}

	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public boolean getRead_address() {
		return this.read_address;
	}

	public void setRead_address(boolean read_address) {
		this.read_address = read_address;
	}

	public String getTrigger_type() {
		return this.trigger_type;
	}

	public void setTrigger_type(String trigger_type) {
		this.trigger_type = trigger_type;
	}

	public Faultload getFaultload() {
		return this.faultload;
	}

	public void setFaultload(Faultload faultload) {
		this.faultload = faultload;
	}

	public List<HardwareFault> getHardwares() {
		return this.hardwares;
	}

	public void setHardwares(List<HardwareFault> hardwares) {
		this.hardwares = hardwares;
	}

	public HardwareFault addHardware(HardwareFault hardware) {
		getHardwares().add(hardware);
		hardware.setFault(this);

		return hardware;
	}

	public HardwareFault removeHardware(HardwareFault hardware) {
		getHardwares().remove(hardware);
		hardware.setFault(null);

		return hardware;
	}

	public List<Injection_Run> getInjectionRuns()
	{
		if(this.injectionRuns==null)
			this.injectionRuns = new ArrayList<Injection_Run>();
		
		return this.injectionRuns;
	}

	public void setInjectionRuns(List<Injection_Run> injectionRuns) {
		this.injectionRuns = injectionRuns;
	}

	public Injection_Run addInjectionRun(Injection_Run injectionRun) {
		getInjectionRuns().add(injectionRun);
		injectionRun.setFault(this);

		return injectionRun;
	}

	public Injection_Run removeInjectionRun(Injection_Run injectionRun) {
		getInjectionRuns().remove(injectionRun);
		injectionRun.setFault(null);

		return injectionRun;
	}

	public List<SoftwareFault> getSoftwares() {
		return this.softwares;
	}

	public void setSoftwares(List<SoftwareFault> softwares) {
		this.softwares = softwares;
	}

	public SoftwareFault addSoftware(SoftwareFault software) {
		getSoftwares().add(software);
		software.setFault(this);

		return software;
	}

	public SoftwareFault removeSoftware(SoftwareFault software) {
		getSoftwares().remove(software);
		software.setFault(null);

		return software;
	}
}