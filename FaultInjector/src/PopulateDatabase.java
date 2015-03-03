import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import faultinjector.entity.*;

public class PopulateDatabase 
{
   public static void main (String[] args) 
   {
	   	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
	   	EntityManager entitymanager = emfactory.createEntityManager();
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
	   	
	   	/*experiment.setEid(2);
	   	experiment.setName("Experiência_3_repetição");
	   	experiment.setTargetName("Intel i7 2.6 Ghz");
	   	experiment.setCreationDate("2015-02-02 12:00:41");
	   	experiment.setCreatorName("admin 1");
	   	experiment.setWorkloadName("CentOS + YCSB + VirtualBox");
	   	experiment.setOutputFilename("experiencia_3_2_repeticao.csv");
	   	experiment.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla velit justo, tristique sit amet vestibulum id, molestie in nunc. Maecenas blandit turpis non lectus sollicitudin aliquet. Integer scelerisque at mauris vel porta.");
	   	experiment.setFaultloadName("Spatial_read");*/
	   	
	   	PopulateDatabase.population.persistAll(entitymanager);
	   	entitymanager.getTransaction().commit();
	   	
	   	entitymanager.close();
	   	emfactory.close();
   }
   
   public static final PopulateDatabase population = new PopulateDatabase();

   private PopulateDatabase() {

   }
   
   public void persistAll(EntityManager em)
   {
       System.out.println("Persisting samples objects.");
       
       em.persist(experiment1());
       em.persist(experiment2());

       System.out.println("Flushing to database.");
       em.flush();
   }
   
   private Experiment experiment1()
   {
	   Experiment experiment = new Experiment();

	   experiment.setName("Experiment_3");
	   experiment.setCreation_date(getCurrentTimestamp());
	   experiment.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla velit justo, tristique sit amet vestibulum id, molestie in nunc. Maecenas blandit turpis non lectus sollicitudin aliquet. Integer scelerisque at mauris vel porta.");
	   
	   User user = new User();
	   user.setName("João Fernandes");
	   user.setEmail("blabla@bla.com");
	   user.setAdministrator(false);
	   user.setInstitution("DEI");
	   user.setUsername("jaff");
	   user.setPassword("faultinjector");
	   
	   //experiment.setUser(user);
	   user.addExperiment(experiment);
	   
	   Target target = new Target();
	   target.setName("Intel i7 2.6 Ghz + 8 GB");
	   target.setI386Arch(true);
	   target.setIp("127.0.0.1");
	   target.setOperating_system("CentOS 6.5 32 bit");

	   target.addExperiment(experiment);
	   /*experiment.setTarget(target);*/
	   
	   Workload workload = new Workload();
	   workload.setName("CentOS + YSCB");
	   workload.setApp_1_name("CentOS 6.5 32 bit");
	   workload.setApp_2_name("Yahoo Cloud Service Benchmark");
	   
	   //workload.setTarget(target);
	   target.addWorkload(workload);
	   
	   Faultload faultload = new Faultload();
	   faultload.setName("Faultload #1");
	   faultload.setCreation_date(getCurrentTimestamp());
	   faultload.setTime_interval(500);
	   faultload.setMem_range_beg(8000);
	   faultload.setMem_range_end(10000);
	   faultload.setN_faults(1000);
	   faultload.setDescription("Veni, vidi, vici");
	   
	   //faultload.setExperiment(experiment);
	   experiment.addFaultload(faultload);
	   
	   SoftwareFault softwareFault = new SoftwareFault();
	   softwareFault.setCreation_date(getCurrentTimestamp());
	   softwareFault.setTrigger_type("sc");
	   softwareFault.setKernel_mode(false);
	   softwareFault.setPid(6667);
	   softwareFault.setInjected(false);
	   softwareFault.setRead_address(true);
	   softwareFault.setMem_address(1234);
	   
	   //softwareFault.setFaultload(faultload);
	   faultload.addFault(softwareFault);
	   
	   Injection_Run injection_Run = new Injection_Run();
	   injection_Run.setOutput_filename("experiment_3_2.csv");
	   
	   //injection_Run.setWorkload(workload);
	   workload.addInjectionRun(injection_Run);
	   
	   //injection_Run.setFaultload(faultload);
	   faultload.addInjectionRun(injection_Run);
	   
	   //injection_Run.setFault(softwareFault);
	   softwareFault.addInjectionRun(injection_Run);

	   return experiment;
   }
   
   private Experiment experiment2()
   {
	   Experiment experiment = new Experiment();

	   experiment.setName("Nova experiência");
	   experiment.setCreation_date(getCurrentTimestamp());
	   experiment.setDescription("Descrição");
	   
	   User user = new User();
	   user.setName("Admin 1");
	   user.setEmail("admin@faultinjector.pt");
	   user.setAdministrator(false);
	   user.setInstitution("FCTUC - DEI");
	   user.setUsername("admin_1");
	   user.setPassword("pass");
	   
	   //experiment.setUser(user);
	   user.addExperiment(experiment);
	   
	   Target target = new Target();
	   target.setName("Vaio VGN-CS11Z 4GB Core 2 Duo 64 bits");
	   target.setI386Arch(true);
	   target.setIp("127.1.1.1");
	   target.setOperating_system("Elementary OS 64 bit");

	   target.addExperiment(experiment);
	   /*experiment.setTarget(target);*/
	   
	   Workload workload = new Workload();
	   workload.setName("Elementary + VirtualBox + YSCB");
	   workload.setApp_1_name("Elementary OS 64 bit");
	   workload.setApp_2_name("VirtualBox");
	   workload.setApp_3_name("Yahoo Cloud Service Benchmark");
	   
	   //workload.setTarget(target);
	   target.addWorkload(workload);
	   
	   Faultload faultload = new Faultload();
	   faultload.setName("Fault set 666 1234");
	   faultload.setCreation_date(getCurrentTimestamp());
	   faultload.setTime_interval(666);
	   faultload.setMem_range_beg(9600);
	   faultload.setMem_range_end(21833);
	   faultload.setN_faults(1234);
	   faultload.setDescription("Blue screen");
	   
	   //faultload.setExperiment(experiment);
	   experiment.addFaultload(faultload);
	   
	   HardwareFault hardwareFault = new HardwareFault();
	   hardwareFault.setCreation_date(getCurrentTimestamp());
	   hardwareFault.setTrigger_type("sd");
	   hardwareFault.setKernel_mode(true);
	   hardwareFault.setPid(3140);
	   hardwareFault.setInjected(false);
	   hardwareFault.setRead_address(false);
	   hardwareFault.setBit_flip(true);
	   hardwareFault.setBits(1001);
	   hardwareFault.setHw_fault_type('r');
	   hardwareFault.setN_bits(4);
	   hardwareFault.setRegister("eax");
	   
	   //softwareFault.setFaultload(faultload);
	   faultload.addFault(hardwareFault);
	   
	   Injection_Run injection_Run = new Injection_Run();
	   injection_Run.setOutput_filename("experiencia_nova_injeccao_67.txt");
	   
	   //injection_Run.setWorkload(workload);
	   workload.addInjectionRun(injection_Run);
	   
	   //injection_Run.setFaultload(faultload);
	   faultload.addInjectionRun(injection_Run);
	   
	   //injection_Run.setFault(softwareFault);
	   hardwareFault.addInjectionRun(injection_Run);

	   return experiment;
   }

   private Timestamp getCurrentTimestamp()
   {
	   Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());

	   return currentTimestamp;
   }
}