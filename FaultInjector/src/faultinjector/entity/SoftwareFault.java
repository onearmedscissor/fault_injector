package faultinjector.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the SoftwareFault database table.
 * 
 */
@Entity
@Table(name="Software")
@DiscriminatorValue("Software")
@NamedQuery(name="SoftwareFault.findAll", query="SELECT s FROM SoftwareFault s")
public class SoftwareFault extends Fault implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Column(name="Mem_address")
	private int mem_address;

	//bi-directional many-to-one association to Fault
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="Fault_id")
	private Fault fault;

	public SoftwareFault() {
	}

	public int getMem_address() {
		return this.mem_address;
	}

	public void setMem_address(int mem_address) {
		this.mem_address = mem_address;
	}

	public Fault getFault() {
		return this.fault;
	}

	public void setFault(Fault fault) {
		this.fault = fault;
	}

}