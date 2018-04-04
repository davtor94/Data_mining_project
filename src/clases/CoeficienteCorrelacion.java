/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.math.BigDecimal;
import java.math.MathContext;
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
    ArrayList<BigDecimal> listaXY;
    ArrayList<BigDecimal> listaX2;
    ArrayList<BigDecimal> listaY2;
    private double coeficiente;
    private double mediaX;
    private double mediaY;
    BigDecimal totalX;
    BigDecimal totalY;
    BigDecimal totalXY;
    BigDecimal totalX2;
    BigDecimal totalY2;
    private double desviacionEstandarX;
    private double desviacionEstandarY;
    BigDecimal covarianzaXY;

    public CoeficienteCorrelacion() {
        listaX = new ArrayList<Integer>();
        listaY = new ArrayList<Integer>();
        listaXY = new ArrayList<BigDecimal>();
        listaX2 = new ArrayList<BigDecimal>();
        listaY2 = new ArrayList<BigDecimal>();
        coeficiente = 0;
        mediaX = 0;
        mediaY = 0;
        totalX = new BigDecimal("0");
        totalY = new BigDecimal("0");
        totalXY = new BigDecimal("0");
        totalX2 = new BigDecimal("0");
        totalY2 = new BigDecimal("0");
        desviacionEstandarX = 0;
        desviacionEstandarY = 0;
        covarianzaXY = new BigDecimal("0");
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

    public void setCovarianzaXY(BigDecimal covarianzaXY) {
        this.covarianzaXY = covarianzaXY;
    }

    public void setListaX(ArrayList<Integer> listaX) {
        this.listaX = listaX;
    }

    public void setListaY(ArrayList<Integer> listaY) {
        this.listaY = listaY;
    }

    public void setListaXY(ArrayList<BigDecimal> listaXY) {
        this.listaXY = listaXY;
    }

    public void setListaX2(ArrayList<BigDecimal> listaX2) {
        this.listaX2 = listaX2;
    }

    public void setListaY2(ArrayList<BigDecimal> listaY2) {
        this.listaY2 = listaY2;
    }

    public void setTotalX(BigDecimal totalX) {
        this.totalX = totalX;
    }

    public void setTotalY(BigDecimal totalY) {
        this.totalY = totalY;
    }

    public void setTotalXY(BigDecimal totalXY) {
        this.totalXY = totalXY;
    }

    public void setTotalX2(BigDecimal totalX2) {
        this.totalX2 = totalX2;
    }

    public void setTotalY2(BigDecimal totalY2) {
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

    public ArrayList<BigDecimal> getListaXY() {
        return listaXY;
    }

    public ArrayList<BigDecimal> getListaX2() {
        return listaX2;
    }

    public ArrayList<BigDecimal> getListaY2() {
        return listaY2;
    }

    public BigDecimal getTotalX() {
        return totalX;
    }

    public BigDecimal getTotalY() {
        return totalY;
    }

    public BigDecimal getTotalXY() {
        return totalXY;
    }

    public BigDecimal getTotalX2() {
        return totalX2;
    }

    public BigDecimal getTotalY2() {
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

    public BigDecimal getCovarianzaXY() {
        return covarianzaXY;
    }

    public double getCoeficienteCorrelacion() {
        return coeficiente;
    }

    public void calcularVariables() {
        int cantidadInstancias = listaX.size();
        int valorX = 0;
        int valorY = 0;
        BigDecimal valorXY;
        BigDecimal valorX2;
        BigDecimal valorY2;
        for (int i = 0; i < cantidadInstancias; i++) {
            valorX = listaX.get(i);
            valorY = listaY.get(i);
            valorX2 = new BigDecimal(valorX);
            valorX2 = valorX2.multiply(valorX2);
            valorY2 = new BigDecimal(valorY);
            valorY2 = valorY2.multiply(valorY2);
            valorXY = new BigDecimal(valorX);
            valorXY = valorXY.multiply(new BigDecimal(valorY));
            listaXY.add(valorXY);
            listaX2.add(valorX2);
            listaY2.add(valorY2);
        }
    }

    public void calcularTotal() {
        int numeroInstancias = listaX.size();
        BigDecimal totalX = new BigDecimal("0");
        BigDecimal totalY = new BigDecimal("0");
        BigDecimal totalXY = new BigDecimal("0");
        BigDecimal totalX2 = new BigDecimal("0");
        BigDecimal totalY2 = new BigDecimal("0");
        for (int i = 0; i < numeroInstancias; i++) {
            totalX = totalX.add(new BigDecimal(listaX.get(i)));
            totalY = totalY.add(new BigDecimal(listaY.get(i)));
            totalXY = totalXY.add(listaXY.get(i));
            totalX2 = totalX2.add(listaX2.get(i));
            totalY2 = totalY2.add(listaY2.get(i));
        }
        this.setTotalX(totalX);
        this.setTotalY(totalY);
        this.setTotalXY(totalXY);
        this.setTotalX2(totalX2);
        this.setTotalY2(totalY2);
        BigDecimal promedioX = totalX.divide(new BigDecimal(numeroInstancias), MathContext.DECIMAL32);
        BigDecimal promedioY = totalY.divide(new BigDecimal(numeroInstancias), MathContext.DECIMAL32);
        this.setMediaX(promedioX.doubleValue());
        this.setMediaY(promedioY.doubleValue());
    }

    public void calcularDesviacion() {
        int numeroInstancias = listaX.size();
        double desviacionEstandarX = 0;
        double desviacionEstandarY = 0;
        BigDecimal desviacionEstandarXY;
        BigDecimal totalX = this.getTotalX2().divide(new BigDecimal(numeroInstancias), MathContext.DECIMAL32);
        desviacionEstandarX = (totalX.doubleValue() - Math.pow(this.getMediaX(), 2));
        desviacionEstandarX = Math.sqrt(desviacionEstandarX);
        BigDecimal totalY = this.getTotalY2().divide(new BigDecimal(numeroInstancias), MathContext.DECIMAL32);
        desviacionEstandarY = (totalY.doubleValue() - Math.pow(this.getMediaY(), 2));
        desviacionEstandarY = Math.sqrt(desviacionEstandarY);
        BigDecimal totalXY = this.getTotalXY().divide(new BigDecimal(numeroInstancias), MathContext.DECIMAL32);
        desviacionEstandarXY = totalXY.subtract(new BigDecimal(this.getMediaY() * this.getMediaX()));
        this.setDesviacionEstandarX(desviacionEstandarX);
        this.setDesviacionEstandarY(desviacionEstandarY);
        this.setCovarianzaXY(desviacionEstandarXY);
    }

    public void calcularCoeficienteCorrelacion() {
        double coeficiente = 0;
        coeficiente = this.getCovarianzaXY().doubleValue() / (this.getDesviacionEstandarX() * this.getDesviacionEstandarY());
        this.setCoeficienteCorrelacion(coeficiente);
    }

}
