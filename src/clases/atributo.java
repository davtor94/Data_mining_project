/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class atributo {

    private String nombre;
    private String dominio;
    private String tipoDato;
    private int numeroValoresFaltantes;
    private int numValoresErroneos;
    protected ArrayList<String> instancias;

    public atributo(String nombre, String dominio, String tipoDato) {
        this.nombre = nombre;
        this.dominio = dominio;
        this.tipoDato = tipoDato;
        this.numeroValoresFaltantes = 0;
        this.numValoresErroneos = 0;
        instancias = new ArrayList<String>();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    public void setInstancias(ArrayList<String> instancias) {
        this.instancias = instancias;
    }

    public void setValoresFaltantes(int numeroValoresFaltantes) {
        this.numeroValoresFaltantes = numeroValoresFaltantes;
    }

    public void setValoresErroneos(int numeroValores) {
        this.numValoresErroneos = numeroValores;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDominio() {
        return dominio;
    }

    public String getTipoDato() {
        return tipoDato;
    }

    public ArrayList<String> getInstancias() {
        return instancias;
    }

    public int getValoresFaltantes() {
        return numeroValoresFaltantes;
    }

    public int getNumeroValoresErroneos() {
        return numValoresErroneos;
    }

    public boolean sonInstanciasNoValidas() {
        boolean esValida = false;
        int numeroInstancias = this.getInstancias().size();
        for (int i = 0; i < numeroInstancias; i++) {
            if (Pattern.matches(this.dominio, this.getInstancias().get(i))) {
                esValida = true;
                break;
            }
        }
        return esValida;
    }

}
