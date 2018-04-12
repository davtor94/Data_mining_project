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

    private ArrayList<Long> listaFrecuencias;
    private long total;
    private ArrayList<Double> listaFrecuenciaEsperada;
    private ArrayList<Double> listaEquisCuadrada;

    BiFrecuencias() {
        listaFrecuencias = new ArrayList<Long>();
        listaFrecuenciaEsperada = new ArrayList<Double>();
        listaEquisCuadrada = new ArrayList<Double>();
        total = 0;
    }

    public void aumentarContador(int indice) {
        long contador = listaFrecuencias.get(indice);
        contador++;
        listaFrecuencias.set(indice, contador);
    }

    public void setListaValores(ArrayList<Long> lista) {
        listaFrecuencias = lista;
    }

    public void setListaFrecuencias(ArrayList<Double> lista) {
        listaFrecuenciaEsperada = lista;
    }

    public void setListaEquisCuadrada(ArrayList<Double> lista) {
        listaEquisCuadrada = lista;
    }

    public ArrayList<Long> getListaValores() {
        return listaFrecuencias;
    }

    public ArrayList<Double> getListaFrecuenciasEsperadas() {
        return listaFrecuenciaEsperada;
    }

    public ArrayList<Double> getListaEquisCuadrada() {
        return listaEquisCuadrada;
    }
    
    public long getTotal(){
        return total;
    }

    public void calcularTotal() {
        total = 0;
        for (int i = 0; i < listaFrecuencias.size(); i++) {
            total += listaFrecuencias.get(i);
        }
    }

}
