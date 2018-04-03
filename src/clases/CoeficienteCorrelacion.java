/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author juan_
 */
public class CoeficienteCorrelacion {

    ArrayList<Integer> listaX;
    ArrayList<Integer> listaY;
    ArrayList<Integer> listaXY;
    ArrayList<Integer> listaX2;
    ArrayList<Integer> listaY2;
    private double coeficiente;
    private double cantidadInstancias;

    public CoeficienteCorrelacion() {
        listaX = new ArrayList<Integer>();
        listaY = new ArrayList<Integer>();
        listaXY = new ArrayList<Integer>();
        listaX2 = new ArrayList<Integer>();
        listaY2 = new ArrayList<Integer>();
        coeficiente = 0;
    }

    public void setListaX(ArrayList<Integer> listaX) {
        this.listaX = listaX;
    }

    public void setListaY(ArrayList<Integer> listaY) {
        this.listaY = listaY;
    }

    public void setListaXY(ArrayList<Integer> listaXY) {
        this.listaXY = listaXY;
    }

    public void setListaX2(ArrayList<Integer> listaX2) {
        this.listaX2 = listaX2;
    }

    public void setListaY2(ArrayList<Integer> listaY2) {
        this.listaY2 = listaY2;
    }

    public ArrayList<Integer> getListaX() {
        return listaX;
    }

    public ArrayList<Integer> getListaY() {
        return listaY;
    }

    public ArrayList<Integer> getListaXY() {
        return listaXY;
    }

    public ArrayList<Integer> getListaX2() {
        return listaX2;
    }

    public ArrayList<Integer> getListaY2() {
        return listaY2;
    }

    public void calcularVariables() {
        int cantidadInstancias = listaX.size();
        int valorX = 0;
        int valorY = 0;
        int valorXY = 0;
        int valorX2 = 0;
        int valorY2 = 0;
        for (int i = 0; i < cantidadInstancias; i++) {
            valorX = listaX.get(i);
            valorY = listaY.get(i);
            valorX2 = valorX * valorX;
            valorY2 = valorY * valorY;
            valorXY = valorX * valorY;
            listaXY.add(valorXY);
            listaX2.add(valorX2);
            listaY2.add(valorY2);
        }
    }
}
