/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author David Torres
 */
public class dataSet {
    private String nombre;
    private int numInstancias;
    private int numAtributos;
    protected ArrayList<atributo> atributos = new ArrayList<>();
    
    //los datos los podemos manejar como string y que cada dato este separado con una coma,
    //y los descomponemos en la ventana donde se muestra el grid
    //esto nadamas para almacenar todo lo del archivo en memoria ram y trabajarlo desde aqui
    //y nos ayudaria a guardar los datos en un nuevo archivo de texto en caso de ser neceario

    public dataSet(String nombre, int numInstancias, int numAtributos) {
        this.nombre = nombre;
        this.numInstancias = numInstancias;
        this.numAtributos = numAtributos;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumInstancias(int numInstancias) {
        this.numInstancias = numInstancias;
    }

    public void setNumAtributos(int numAtributos) {
        this.numAtributos = numAtributos;
    }

    public void setAtributos(ArrayList<atributo> atributos) {
        this.atributos = atributos;
    }
    

    public String getNombre() {
        return nombre;
    }

    public int getNumInstancias() {
        return numInstancias;
    }

    public int getNumAtributos() {
        return numAtributos;
    }

    public ArrayList<atributo> getAtributos() {
        return atributos;
    }

   
}
