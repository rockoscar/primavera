package unitec.primavera;

//se importa para el implements commandlinerunnner
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//se implementa el command
public class PrimaveraApplication implements CommandLineRunner {
        
    @Autowired RepositorioPagos repoPagos;
    @Autowired RepositorioMensajes repoMensa;
    //se debe ´poner static para poder usarlo en los metodos
     int x;
	public static void main(String[] args) {
		SpringApplication.run(PrimaveraApplication.class, args);
           
	}

     //se crear el metodo para el commandlinerunner
    @Override
    public void run(String... args) throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("que onda");
        repoPagos.servicioPagar();
        repoMensa.save(new Mensaje("hola", "Puerco", LocalDate.now()));
        
        //libro
        //https://docs.spring.io/spring/docs/5.0.x/spring-framework-reference/core.html#beans-annotation-config
    }
    
    
        
}
