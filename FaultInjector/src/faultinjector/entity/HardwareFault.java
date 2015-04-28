package faultinjector.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the HardwareFault database table.
 * 
 */
@Entity
@Table(name="Hardware")
@DiscriminatorValue("Hardware")
@NamedQuery(name="HardwareFault.findAll", query="SELECT h FROM HardwareFault h")
public class HardwareFault extends Fault implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Column(name="Bit_flip")
	private boolean bit_flip;

	@Column(name="Bits")
	private int bits;

	@Column(name="N_bits")
	private int n_bits;

	@Column(name="Register")
	private String register;
	
	@Column(name="Hw_fault_type")
	private char hw_fault_type;

	//bi-directional many-to-one association to Fault
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="Fault_id")
	private Fault fault;

	public HardwareFault() {
	}

	public boolean getBit_flip() {
		return this.bit_flip;
	}

	public void setBit_flip(boolean bit_flip) {
		this.bit_flip = bit_flip;
	}

	public int getBits() {
		return this.bits;
	}

	public void setBits(int bits) {
		this.bits = bits;
	}

	public int getN_bits() {
		return this.n_bits;
	}

	public void setN_bits(int n_bits) {
		this.n_bits = n_bits;
	}

	public String getRegister() {
		return this.register;
	}

	public void setRegister(String register) {
		this.register = register;
	}
	
	public char getHw_fault_type()
	{
		return hw_fault_type;
	}

	public void setHw_fault_type(char hw_fault_type)
	{
		this.hw_fault_type = hw_fault_type;
	}

	public Fault getFault() {
		return this.fault;
	}

	public void setFault(Fault fault) {
		this.fault = fault;
	}

}