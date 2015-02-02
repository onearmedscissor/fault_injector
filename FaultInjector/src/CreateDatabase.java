import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import faultinjector.model.Experiment;

public class CreateDatabase 
{
   public static void main( String[ ] args ) 
   {
   	EntityManagerFactory emfactory = Persistence.
   			createEntityManagerFactory( "Eclipselink_JPA" );
   	EntityManager entitymanager = emfactory.
   			createEntityManager();
   	entitymanager.getTransaction().begin();
   	
   	Experiment experiment = new Experiment(); 
   	/*experiment.setEid(17);
   	experiment.setName("Experiment_3");
   	experiment.setTarget_name("CentOS 6.5 32 bit");
   	experiment.setCreation_date("2014-12-08 00:00:00");
   	experiment.setCreator_name("jaff");
   	experiment.setWorkload_name("CentOS + YSCB");
   	experiment.setOutput_filename("experiment_3_2.csv");
   	experiment.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla velit justo, tristique sit amet vestibulum id, molestie in nunc. Maecenas blandit turpis non lectus sollicitudin aliquet. Integer scelerisque at mauris vel porta.");
   	experiment.setFaultload_name("Faultload #1");*/
   	
   	experiment.setEid(2);
   	experiment.setName("Experiência_3_repetição");
   	experiment.setTargetName("Intel i7 2.6 Ghz");
   	experiment.setCreationDate("2015-02-02 12:00:41");
   	experiment.setCreatorName("admin 1");
   	experiment.setWorkloadName("CentOS + YCSB + VirtualBox");
   	experiment.setOutputFilename("experiencia_3_2_repeticao.csv");
   	experiment.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla velit justo, tristique sit amet vestibulum id, molestie in nunc. Maecenas blandit turpis non lectus sollicitudin aliquet. Integer scelerisque at mauris vel porta.");
   	experiment.setFaultloadName("Spatial_read");

   	entitymanager.persist(experiment);
   	entitymanager.getTransaction().commit();
   	
   	entitymanager.close();
   	emfactory.close();
   }
}