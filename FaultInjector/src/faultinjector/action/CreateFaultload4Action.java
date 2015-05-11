package faultinjector.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.bean.FaultloadBean;
import faultinjector.entity.Faultload;
import faultinjector.entity.HardwareFault;
import faultinjector.entity.Register;
import faultinjector.service.ExperimentService;

public class CreateFaultload4Action extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private FaultloadBean faultloadBean;
	private boolean faultMode;
	private int processId, timeStart, timeEnd, codeAddress, dataAddress;
	private String triggerType, accessCode, accessData;

	public String execute()
	{
		if (!session.containsKey("faultloadBean"))
		{
			this.faultloadBean = new FaultloadBean();
			session.put("faultloadBean", faultloadBean);
		} else
			faultloadBean = (FaultloadBean) session.get("faultloadBean");

		
		
		
		faultloadBean.setKernelMode(faultMode);
		faultloadBean.setProcessId(processId);
		faultloadBean.setTriggerType(triggerType);

		switch (triggerType)
		{
			case "tp":
			{
				faultloadBean.setTemporalTriggerStart(timeStart);
				faultloadBean.setTemporalTriggerEnd(timeEnd);
			}
				break;
			case "sc":
			{
				if (accessCode.equals("write"))
					faultloadBean.setReadAddress(false);
				else
					faultloadBean.setReadAddress(true);

				faultloadBean.setMemoryAddress(codeAddress);
			}
				break;
			case "sd":
			{
				if (accessData.equals("write"))
					faultloadBean.setReadAddress(false);
				else
					faultloadBean.setReadAddress(true);

				faultloadBean.setMemoryAddress(dataAddress);
			}
				break;
		}

		Faultload faultload = new Faultload();

		faultload.setName(faultloadBean.getName());
		faultload.setDescription(faultloadBean.getDescription());
		faultload.setTime_interval(faultloadBean.getTimeInterval());

		if (faultloadBean.getHardwareFaultType() == 'm')
		{
			faultload.setMem_range_beg(faultloadBean.getMemoryFaultRangeStart());
			faultload.setMem_range_end(faultloadBean.getMemoryFaultRangeEnd());
		}

		faultload.setN_faults(faultloadBean.getNumberFaults());

		String[] registers = faultloadBean.getRegisterIds();
		List<Register> regs = new ArrayList<Register>();

		for (String s : registers)
		{
			Register r = this.getExperimentService().findRegister(Integer.parseInt(s));

			// faultload.addRegister(r);

			regs.add(r);
		}

		faultload.setRegisters(regs);
		// faultload.setExperiment(experiment);

		HardwareFault hardwareFault = new HardwareFault();
		hardwareFault.setHw_fault_type(faultloadBean.getHardwareFaultType());
		hardwareFault.setBit_flip(faultloadBean.getBitFlip());
		hardwareFault.setBitStart(faultloadBean.getBitsChangeStart());
		hardwareFault.setBitEnd(faultloadBean.getBitsChangeEnd());
		hardwareFault.setKernel_mode(faultloadBean.getKernelMode());
		hardwareFault.setPid(faultloadBean.getProcessId());

		switch (faultloadBean.getTriggerType())
		{
			case "tp":
			{
				hardwareFault.setTime_start(faultloadBean.getTemporalTriggerStart());
				hardwareFault.setTime_end(faultloadBean.getTemporalTriggerEnd());
			}
				break;
			case "sc":
			{
				if (faultloadBean.getReadAddress().equals("write"))
					hardwareFault.setRead_address(false);
				else
					hardwareFault.setRead_address(true);

				hardwareFault.setMem_address(faultloadBean.getMemoryAddress());
			}
				break;
			case "sd":
			{
				if (accessData.equals("write"))
					faultloadBean.setReadAddress(false);
				else
					faultloadBean.setReadAddress(true);

				hardwareFault.setMem_address(faultloadBean.getMemoryAddress());
			}
				break;
		}

		faultload.addFault(hardwareFault);

		// this.getExperimentService().createFaultload(faultload);

		System.out.println("NEW FAULTLOAD 4-------------------------------");
		System.out.println("New faultload NAME = " + faultloadBean.getName());
		System.out.println("New faultload DESCRIPTION = " + faultloadBean.getDescription());
		System.out.println("New faultload TIME INTERVAL = " + faultloadBean.getTimeInterval());

		System.out.println("New faultload HARDWARE FAULT TYPE = " + faultloadBean.getHardwareFaultType());
		System.out.println("New faultload MEMORY FAULT RANGE = " + faultloadBean.getMemoryFaultRangeStart() + " - " + faultloadBean.getMemoryFaultRangeEnd());
		System.out.println("New faultload NUMBER OF FAULTS = " + faultloadBean.getNumberFaults());
		System.out.println("New faultload 1.1 FAULT MODEL____________________________________");
		System.out.println("New faultload FAULT CLASS: IS BIT-FLIP? = " + faultloadBean.getBitFlip());
		System.out.println("New faultload BITS TO CHANGE = " + faultloadBean.getBitsChangeStart() + " - " + faultloadBean.getBitsChangeEnd());
		System.out.println("New faultload SELECTED REGISTER(S) ID(S) = " + Arrays.toString(faultloadBean.getRegisterIds()));

		System.out.println("New faultload 2.1 FAULT TRIGGER____________________________________");
		System.out.println("New faultload MODE: KERNEL? = " + faultloadBean.getKernelMode());
		System.out.println("New faultload PROCESS ID = " + faultloadBean.getProcessId());
		System.out.println("New faultload 2.2 FAULT TRIGGER TYPE____________________________________");
		System.out.println("New faultload TRIGGER TYPE = " + faultloadBean.getTriggerType());

		switch (faultloadBean.getTriggerType())
		{
			case "tp":
				System.out.println("New faultload TEMPORAL BETWEEN = " + faultloadBean.getTemporalTriggerStart() + " AND " + faultloadBean.getTemporalTriggerEnd());
				break;
			case "sc":
				System.out.println("New faultload SPATIAL (CODE SEGMENT) = " + faultloadBean.getReadAddress() + " ON ADDRESS " + faultloadBean.getMemoryAddress());
				break;
			case "sd":
				System.out.println("New faultload SPATIAL (DATA SEGMENT) = " + faultloadBean.getReadAddress() + " ON ADDRESS " + faultloadBean.getMemoryAddress());
				break;
		}

		return SUCCESS;
	}

	public void validate()
	{
		if (processId <= 0)
			addFieldError("faultloadBean.processId", "Faultload process ID is required and must be positive!");

		if (timeStart < 0 || timeEnd <= timeStart)
			addFieldError("faultloadBean.memoryFaultRangeStart", "Faultload temporal trigger time start is required and must be positive! Also, time start must be greater than time end!");

		if (timeEnd < 0 || timeEnd <= timeStart)
			addFieldError("faultloadBean.memoryFaultRangeEnd", "Faultload temporal trigger time end is required and must be positive! Also, time start must be greater than time end!");
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

	public void setFaultMode(boolean faultMode)
	{
		this.faultMode = faultMode;
	}

	public void setProcessId(int processId)
	{
		this.processId = processId;
	}

	public void setTimeStart(int timeStart)
	{
		this.timeStart = timeStart;
	}

	public void setTimeEnd(int timeEnd)
	{
		this.timeEnd = timeEnd;
	}

	public void setCodeAddress(int codeAddress)
	{
		this.codeAddress = codeAddress;
	}

	public void setDataAddress(int dataAddress)
	{
		this.dataAddress = dataAddress;
	}

	public void setTriggerType(String triggerType)
	{
		this.triggerType = triggerType;
	}

	public void setAccessCode(String accessCode)
	{
		this.accessCode = accessCode;
	}

	public void setAccessData(String accessData)
	{
		this.accessData = accessData;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
