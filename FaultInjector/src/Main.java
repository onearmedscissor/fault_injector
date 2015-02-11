import java.util.List;

import faultinjector.entity.Experiment;
import faultinjector.service.ExperimentService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main
{
	public static void main(String[] args)
	{
	    ExperimentService service = new ExperimentService();
		
	    List <Experiment> experiments = service.findAll();
	    
	    for (Experiment e : experiments)
	    {
	    	System.out.println("experiment ID = "+e.getEid());
	    	System.out.println("experiment NAME = "+e.getName());
	    	System.out.println("experiment TARGET NAME = "+e.getTargetName());
	    	System.out.println("experiment CREATION DATE = "+e.getCreationDate());
	    	System.out.println("experiment CREATOR NAME = "+e.getCreatorName());
	    	System.out.println("experiment WORKLOAD NAME = "+e.getWorkloadName());
	    	System.out.println("experiment OUTPUT FILENAME = "+e.getOutputFilename());
	    	System.out.println("experiment DESCRIPTION = "+e.getDescription());
	    	System.out.println("experiment FAULTLOAD NAME = "+e.getFaultloadName());
	    }
	    
	    service.closeTransaction();
	}
}
