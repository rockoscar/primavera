/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.primavera;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    
    //vamos a guardar que siempre usa el post
    //consumes le indica que vamos a usar un json
    @PostMapping(path="/mensaje", consumes="application/json")
    //le metemos el parametro que viene del body y le indicamos que viene en json
    public Status guardar(@RequestBody String json)throws Exception{
        //recibimos al json 
        //mapeado que convierte de un formato a otro mapeo
        
        //creamos el objeto del object mapper
        ObjectMapper maper=new ObjectMapper();
        //de la clase mensaje creamos un objeto que va a teneer el metodo del 
        //mapper readvalue y le metemos parametros que es un json de la clase mensaje
        Mensaje mensajito= maper.readValue(json, Mensaje.class);
        System.out.println(mensajito);
        Status estatus= new Status();
        estatus.setSuccess(true);
        estatus.setMensaje("mensajito guardado con exito");
        return estatus;
        
    }
    /*
    @PutMapping (path="/actualiza", consumes="application/json")
    public
    */
}
