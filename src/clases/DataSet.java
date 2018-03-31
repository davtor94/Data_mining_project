/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author David Torres
 */
public class DataSet {

    private String nombre;
    private int numInstancias;
    private int numAtributos;
    private String faltante;

    ArrayList<atributo> atributos = new ArrayList<>();

    public DataSet() {
    }

    public DataSet(String nombre, int numInstancias, int numAtributos) {
        this.nombre = nombre;
        this.numInstancias = numInstancias;
        this.numAtributos = numAtributos;
        
    }

    public void setFaltante(String faltante) {
        this.faltante = faltante;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumInstancias(int numInstancias) {
        this.numInstancias = numInstancias;
    }

    public void updateNumInstancias() {
        this.numInstancias = atributos.get(0).getInstancias().size();
    }

    public void setNumAtributos(int numAtributos) {
        this.numAtributos = numAtributos;
    }

    public void updateNumAtributos() {
        this.numAtributos = atributos.size();
    }

    public void setAtributos(ArrayList<atributo> atributos) {
        this.atributos = atributos;
    }

    public String getFaltante() {
        return faltante;
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

    public void calcularValoresFaltantes() {
        int contador = 0;
        for (int i = 0; i < atributos.size(); i++) {
            contador = 0;
            for (int j = 0; j < this.getNumInstancias(); j++) {
                if (atributos.get(i).getInstancias().get(j).equals(this.getFaltante())) {
                    contador++;
                }
            }
            this.getAtributos().get(i).setValoresFaltantes(contador);
        }
    }

}
