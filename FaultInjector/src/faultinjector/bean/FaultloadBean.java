package faultinjector.bean;

public class FaultloadBean
{
	private String name, description;
	private int timeInterval, memoryFaultRangeStart, memoryFaultRangeEnd, numberFaults, bitsChangeStart, bitsChangeEnd;
	private boolean faultType, hardwareFaultType, faultClass;
	
	public FaultloadBean()
	{
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getTimeInterval()
	{
		return timeInterval;
	}

	public void setTimeInterval(int timeInterval)
	{
		this.timeInterval = timeInterval;
	}

	public int getMemoryFaultRangeStart()
	{
		return memoryFaultRangeStart;
	}

	public void setMemoryFaultRangeStart(int memoryFaultRangeStart)
	{
		this.memoryFaultRangeStart = memoryFaultRangeStart;
	}

	public int getMemoryFaultRangeEnd()
	{
		return memoryFaultRangeEnd;
	}

	public void setMemoryFaultRangeEnd(int memoryFaultRangeEnd)
	{
		this.memoryFaultRangeEnd = memoryFaultRangeEnd;
	}

	public int getNumberFaults()
	{
		return numberFaults;
	}

	public void setNumberFaults(int numberFaults)
	{
		this.numberFaults = numberFaults;
	}

	public int getBitsChangeStart()
	{
		return bitsChangeStart;
	}

	public void setBitsChangeStart(int bitsChangeStart)
	{
		this.bitsChangeStart = bitsChangeStart;
	}

	public int getBitsChangeEnd()
	{
		return bitsChangeEnd;
	}

	public void setBitsChangeEnd(int bitsChangeEnd)
	{
		this.bitsChangeEnd = bitsChangeEnd;
	}

	public boolean isFaultType()
	{
		return faultType;
	}

	public void setFaultType(boolean faultType)
	{
		this.faultType = faultType;
	}

	public boolean isHardwareFaultType()
	{
		return hardwareFaultType;
	}

	public void setHardwareFaultType(boolean hardwareFaultType)
	{
		this.hardwareFaultType = hardwareFaultType;
	}

	public boolean isFaultClass()
	{
		return faultClass;
	}

	public void setFaultClass(boolean faultClass)
	{
		this.faultClass = faultClass;
	}
}
