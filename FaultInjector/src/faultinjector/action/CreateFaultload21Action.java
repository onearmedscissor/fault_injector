package faultinjector.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.bean.FaultloadBean;

public class CreateFaultload21Action extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private FaultloadBean faultloadBean;

	private char hardwareFaultType;
	private boolean faultClass;
	private int memStart, memEnd, numberFaults, bitStart, bitEnd;

	public String execute()
	{
		if (!session.containsKey("faultloadBean"))
		{
			this.faultloadBean = new FaultloadBean();
			session.put("faultloadBean", faultloadBean);
		} else
			faultloadBean = (FaultloadBean) session.get("faultloadBean");

		faultloadBean.setHardwareFaultType(hardwareFaultType);
		faultloadBean.setMemoryFaultRangeStart(memStart);
		faultloadBean.setMemoryFaultRangeEnd(memEnd);
		faultloadBean.setNumberFaults(numberFaults);
		faultloadBean.setBitFlip(faultClass);
		faultloadBean.setBitsChangeStart(bitStart);
		faultloadBean.setBitsChangeEnd(bitEnd);

		System.out.println("NEW FAULTLOAD 2-------------------------------");
		System.out.println("New faultload NAME = " + faultloadBean.getName());
		System.out.println("New faultload DESCRIPTION = " + faultloadBean.getDescription());
		System.out.println("New faultload TIME INTERVAL = " + faultloadBean.getTimeInterval());

		System.out.println("New faultload HARDWARE FAULT TYPE = " + faultloadBean.getHardwareFaultType());
		System.out.println("New faultload MEMORY FAULT RANGE = " + faultloadBean.getMemoryFaultRangeStart() + " - " + faultloadBean.getMemoryFaultRangeEnd());
		System.out.println("New faultload NUMBER OF FAULTS = " + faultloadBean.getNumberFaults());
		System.out.println("New faultload 1.1 FAULT MODEL____________________________________");
		System.out.println("New faultload FAULT CLASS: IS BIT-FLIP? = " + faultloadBean.getBitFlip());
		System.out.println("New faultload BITS TO CHANGE = " + faultloadBean.getBitsChangeStart() + " - " + faultloadBean.getBitsChangeEnd());

		return SUCCESS;
	}

	public void validate()
	{
		if (memStart < 0)
			addFieldError("faultloadBean.memoryFaultRangeStart", "Faultload memory fault range start is required and can't be negative!");

		if (memEnd < 0)
			addFieldError("faultloadBean.memoryFaultRangeEnd", "Faultload memory fault range end is required and can't be negative!");

		if (numberFaults < 0)
			addFieldError("faultloadBean.numberFaults", "Faultload number of faults field is required and can't be negative!");

		if (bitStart < 0 || bitStart > 31)
			addFieldError("faultloadBean.bitsChangeStart", "Faultload bit(s) to change range is required and must be set between 0 and 31!");

		if (bitStart < 0 || bitStart > 31)
			addFieldError("faultloadBean.bitsChangeEnd", "Faultload bit(s) to change range is required and must be set between 0 and 31!");
	}

	public void setHardwareFaultType(char hardwareFaultType)
	{
		this.hardwareFaultType = hardwareFaultType;
	}

	public void setFaultClass(boolean faultClass)
	{
		this.faultClass = faultClass;
	}

	public void setMemStart(int memStart)
	{
		this.memStart = memStart;
	}

	public void setMemEnd(int memEnd)
	{
		this.memEnd = memEnd;
	}

	public void setNumberFaults(int numberFaults)
	{
		this.numberFaults = numberFaults;
	}

	public void setBitStart(int bitStart)
	{
		this.bitStart = bitStart;
	}

	public void setBitEnd(int bitEnd)
	{
		this.bitEnd = bitEnd;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
