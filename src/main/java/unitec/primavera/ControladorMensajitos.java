/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.primavera;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author T-107
 */

//contexto general 
@RestController
//comienza la uri (url unicas)
@RequestMapping("/api")
public class ControladorMensajitos {
    
    //inyeccion de dependencia de servicio
    @Autowired RepositorioMensajes mensa;
    
    //mi primer hola mundo desde rest api con spring
    @GetMapping(path="/hola")
    public String hola(){
        return "hola mundo";
    }
    
    //muestra todos los mensajes
    @GetMapping(path="/mensaje")
    public List<Mensaje> todos(){
        return mensa.findAll();
    }
    
    //busca por id, para indicar variables que agregamos desde la uri debe estar
    //entre { } 
    @GetMapping(path="/mensaje/{id}")
    //pathvariable variable de ruta de uri e indicamos su tipo y nombre
    public Mensaje buscasPorId(@PathVariable String id){
        return mensa.findById(id).get();
    }
}
