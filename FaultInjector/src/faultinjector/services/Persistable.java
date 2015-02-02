package faultinjector.services;

import java.util.List;

import faultinjector.model.Experiment;

public interface Persistable
{
	public List <Experiment> findAll();
	
	public Experiment findExperiment(int id);
}
