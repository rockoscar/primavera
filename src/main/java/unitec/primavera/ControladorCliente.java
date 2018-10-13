/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.primavera;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author T-107
 */

@RestController

@RequestMapping("/cliente")


public class ControladorCliente {
    
    @Autowired RepositorioClientes cli;
    
    @GetMapping(path="/hello")
    public String hello(){
        return "hello back";
    }
    
    @PostMapping(path="/guarda", consumes="application/json")
    
    public Status guardar(@RequestBody String json) throws Exception{
        
        ObjectMapper map= new ObjectMapper();
        
        Cliente clin= map.readValue(json, Cliente.class);
        System.out.println(clin);
        cli.save(clin);
        Status estatus= new Status();
        estatus.setSuccess(true);
        estatus.setMensaje("cliente guardado");
        return estatus;
    }
}
