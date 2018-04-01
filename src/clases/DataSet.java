/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author David Torres
 */
public class DataSet {

    private String nombre;
    private int numInstancias;
    private int numAtributos;
    private String faltante;
    private String comentarios;

    ArrayList<atributo> atributos = new ArrayList<>();

    //los datos los podemos manejar como string y que cada dato este separado con una coma,
    //y los descomponemos en la ventana donde se muestra el grid
    //esto nadamas para almacenar todo lo del archivo en memoria ram y trabajarlo desde aqui
    //y nos ayudaria a guardar los datos en un nuevo archivo de texto en caso de ser neceario
    public DataSet() {
    }

    public DataSet(String nombre, int numInstancias, int numAtributos) {
        this.nombre = nombre;
        this.numInstancias = numInstancias;
        this.numAtributos = numAtributos;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
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

    public void setNumAtributos(int numAtributos) {
        this.numAtributos = numAtributos;
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

    public String getComentarios() {
        return comentarios;
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

    public void updateNumAtributos() {
        this.numAtributos = atributos.size();
    }

    public void updateNumInstancias() {
        this.numInstancias = atributos.get(0).getInstancias().size();
    }

    public void calcularErrores() {
        int contadorErrores = 0;
        int contadorFaltantes = 0;
        for (int i = 0; i < atributos.size(); i++) {
            contadorErrores = 0;
            contadorFaltantes = 0;
            String regexp = this.getAtributos().get(i).getDominio();
            for (int j = 0; j < this.getNumInstancias(); j++) {
                if (atributos.get(i).getInstancias().get(j).equals(this.getFaltante())) {
                    contadorFaltantes++;
                }

                String cadena = this.getAtributos().get(i).getInstancias().get(j);
                if (!Pattern.matches(regexp, cadena)) {
                    contadorErrores++;
                }
            }
            this.getAtributos().get(i).setValoresFaltantes(contadorFaltantes);
            this.getAtributos().get(i).setValoresErroneos(contadorErrores);
        }
    }
    
}
