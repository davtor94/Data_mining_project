/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juan_
 */
public class BiFrecuencias {

    private String name;
    private ArrayList<Long> listaFrecuencias;

    BiFrecuencias() {
        listaFrecuencias = new ArrayList<Long>();
        name = "";
    }

    public void setListaValores(ArrayList<Long> lista) {
        listaFrecuencias = lista;
    }

    public void setNombre(String name) {
        this.name = name;
    }

    public ArrayList<Long> getListaValores() {
        return listaFrecuencias;
    }

    public String getName() {
        return name;
    }
}
