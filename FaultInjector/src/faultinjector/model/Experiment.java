package faultinjector.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Experiment
{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int eid;
	private String name;
	private String targetName;
	private String creationDate;
	private String creatorName;
	private String workloadName;
	private String outputFilename;
	private String description;
	private String faultloadName;
	
	public Experiment(int eid, String name, String targetName, String creationDate, String creatorName, String workloadName, String outputFilename, String description, String faultloadName)
	{
		super();
		this.eid=eid;
		this.name=name;
		this.targetName=targetName;
		this.creationDate=creationDate;
		this.creatorName=creatorName;
		this.workloadName=workloadName;
		this.outputFilename=outputFilename;
		this.description=description;
		this.faultloadName=faultloadName;
	}
	
	public Experiment()
	{
		super();
	}

	public int getEid()
	{
		return eid;
	}

	public void setEid(int eid)
	{
		this.eid = eid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getTargetName() {
		return targetName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getWorkloadName() {
		return workloadName;
	}

	public void setWorkloadName(String workloadName) {
		this.workloadName = workloadName;
	}

	public String getOutputFilename() {
		return outputFilename;
	}

	public void setOutputFilename(String outputFilename) {
		this.outputFilename = outputFilename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFaultloadName() {
		return faultloadName;
	}

	public void setFaultloadName(String faultloadName) {
		this.faultloadName = faultloadName;
	}

	@Override
	public String toString()
	{
		return "Experiment [eid=" + eid + ", name=" + name + ", targetName=" + targetName + ", creationDate=" + creationDate + ", creatorName=" + creatorName + ", workloadName=" + workloadName + ", outputFilename=" + outputFilename + ", description=" + description + ", faultloadName=" + faultloadName + "]";
	}
}
