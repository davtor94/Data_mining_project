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
    private double mediaX;
    private double mediaY;
    private double totalX;
    private double totalY;
    private double totalXY;
    private double totalX2;
    private double totalY2;
    private double desviacionEstandarX;
    private double desviacionEstandarY;
    private double desviacionEstandarXY;

    public CoeficienteCorrelacion() {
        listaX = new ArrayList<Integer>();
        listaY = new ArrayList<Integer>();
        listaXY = new ArrayList<Integer>();
        listaX2 = new ArrayList<Integer>();
        listaY2 = new ArrayList<Integer>();
        coeficiente = 0;
        mediaX = 0;
        mediaY = 0;
        totalX = 0;
        totalY = 0;
        totalXY = 0;
        totalX2 = 0;
        totalY2 = 0;
        desviacionEstandarX = 0;
        desviacionEstandarY = 0;
        desviacionEstandarXY = 0;
    }

    public void setCoeficienteCorrelacion(double coeficiente) {
        this.coeficiente = coeficiente;
    }

    public void setDesviacionEstandarX(double desviacionEstandarX) {
        this.desviacionEstandarX = desviacionEstandarX;
    }

    public void setDesviacionEstandarY(double desviacionEstandarY) {
        this.desviacionEstandarY = desviacionEstandarY;
    }

    public void setDesviacionEstandarXY(double desviacionEstandarXY) {
        this.desviacionEstandarXY = desviacionEstandarXY;
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

    public void setTotalX(double totalX) {
        this.totalX = totalX;
    }

    public void setTotalY(double totalY) {
        this.totalY = totalY;
    }

    public void setTotalXY(double totalXY) {
        this.totalXY = totalXY;
    }

    public void setTotalX2(double totalX2) {
        this.totalX2 = totalX2;
    }

    public void setTotalY2(double totalY2) {
        this.totalY2 = totalY2;
    }

    public void setMediaX(double promedioX) {
        this.mediaX = promedioX;
    }

    public void setMediaY(double promedioY) {
        this.mediaY = promedioY;
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

    public double getTotalX() {
        return totalX;
    }

    public double getTotalY() {
        return totalY;
    }

    public double getTotalXY() {
        return totalXY;
    }

    public double getTotalX2() {
        return totalX2;
    }

    public double getTotalY2() {
        return totalY2;
    }

    public double getMediaX() {
        return mediaX;
    }

    public double getMediaY() {
        return mediaY;
    }

    public double getDesviacionEstandarY() {
        return desviacionEstandarY;
    }

    public double getDesviacionEstandarX() {
        return desviacionEstandarX;
    }

    public double getDesviacionEstandarXY() {
        return desviacionEstandarXY;
    }

    public double getCoeficienteCorrelacion() {
        return coeficiente;
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

    public void calcularTotal() {
        int numeroInstancias = listaX.size();
        double totalX = 0;
        double totalY = 0;
        double totalXY = 0;
        double totalX2 = 0;
        double totalY2 = 0;
        for (int i = 0; i < numeroInstancias; i++) {
            totalX += listaX.get(i);
            totalY += listaY.get(i);
            totalXY += listaXY.get(i);
            totalX2 += listaX2.get(i);
            totalY2 += listaY2.get(i);
        }
        this.setTotalX(totalX);
        this.setTotalY(totalY);
        this.setTotalXY(totalXY);
        this.setTotalX2(totalX2);
        this.setTotalY2(totalY2);
        double promedioX = totalX / numeroInstancias;
        double promedioY = totalY / numeroInstancias;
        this.setMediaX(promedioX);
        this.setMediaY(promedioY);
    }

    public void calcularDesviacion() {
        int numeroInstancias = listaX.size();
        double desviacionEstandarX = 0;
        double desviacionEstandarY = 0;
        double desviacionEstandarXY = 0;
        desviacionEstandarX = (this.getTotalX2() / numeroInstancias) - Math.pow(this.getMediaX(), 2);
        desviacionEstandarX = Math.sqrt(desviacionEstandarX);
        desviacionEstandarY = (this.getTotalY2() / numeroInstancias) - Math.pow(this.getMediaY(), 2);
        desviacionEstandarY = Math.sqrt(desviacionEstandarY);
        desviacionEstandarXY = (this.getTotalXY() / numeroInstancias) - (this.getMediaY() * this.getMediaX());
        this.setDesviacionEstandarX(desviacionEstandarX);
        this.setDesviacionEstandarY(desviacionEstandarY);
        this.setDesviacionEstandarXY(desviacionEstandarXY);
    }

    public void calcularCoeficienteCorrelacion() {
        double coeficiente = 0;
        coeficiente = this.getDesviacionEstandarXY() / (this.getDesviacionEstandarX() * this.getDesviacionEstandarY());
        this.setCoeficienteCorrelacion(coeficiente);
    }

}
