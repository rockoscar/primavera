/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.primavera;

import java.util.ArrayList;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author T-107
 */
//se hereda el repo de mongo , la clase y el tipo de dato que es el id de dicha clase
public interface RepositorioMensajes extends MongoRepository<Mensaje, String> {
    //queremos un arraylist de la clase mensaje creamos el metodo e ingresamos que le vamos a meter
    ArrayList<Mensaje> findByTitulo(String titulo);
}
