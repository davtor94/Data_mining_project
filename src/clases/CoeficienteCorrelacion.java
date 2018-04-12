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
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author juan_
 */
public class CoeficienteCorrelacion {

    //Representa la tabla de X, y, x^2, y^2, x*y
    ArrayList<Integer> listaX;
    ArrayList<Integer> listaY;
    ArrayList<BigDecimal> listaXY;
    ArrayList<BigDecimal> listaX2;
    ArrayList<BigDecimal> listaY2;
    //total de sumar cada arreglo
    BigDecimal totalX;
    BigDecimal totalY;
    BigDecimal totalXY;
    BigDecimal totalX2;
    BigDecimal totalY2;
    //coeficiente de correlacion
    private double coeficiente;
    //media
    private double mediaX;
    private double mediaY;
    //desviacion
    private double desviacionEstandarX;
    private double desviacionEstandarY;
    BigDecimal covarianzaXY;

    public CoeficienteCorrelacion(int indice1, int indice2, DataSet baseDatos) {
        //inicializacion de los datos
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
        int valorX = 0;
        int valorY = 0;
        String auxiliar1="";
        String auxiliar2="";
        String dominio1=baseDatos.getAtributos().get(indice1).getDominio();
        String dominio2=baseDatos.getAtributos().get(indice2).getDominio();
        for (int i = 0; i < baseDatos.getAtributos().get(indice1).getInstancias().size(); i++) {
            auxiliar1=baseDatos.getAtributos().get(indice1).getInstancias().get(i);
            auxiliar2=baseDatos.getAtributos().get(indice2).getInstancias().get(i);
            if (!auxiliar1.equals(baseDatos.getFaltante()) && !auxiliar2.equals(baseDatos.getFaltante())
                    && Pattern.matches(dominio1, auxiliar1) && Pattern.matches(dominio2, auxiliar2)) {
                valorX = Integer.parseInt(auxiliar1);
                valorY = Integer.parseInt(auxiliar2);
                listaX.add(valorX);
                listaY.add(valorY);
            }
        }
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
        //rellenamos los arreglos que representan nuestra tabla
        int cantidadInstancias = listaX.size();
        int valorX = 0;
        int valorY = 0;
        BigDecimal valorXY;
        BigDecimal valorX2;
        BigDecimal valorY2;
        for (int i = 0; i < cantidadInstancias; i++) {
            valorX = listaX.get(i);
            valorY = listaY.get(i);
            //rellenando x^2
            valorX2 = new BigDecimal(valorX);
            valorX2 = valorX2.multiply(valorX2);
            //rellenando y^2
            valorY2 = new BigDecimal(valorY);
            valorY2 = valorY2.multiply(valorY2);
            //rellenando x*y
            valorXY = new BigDecimal(valorX);
            valorXY = valorXY.multiply(new BigDecimal(valorY));
            listaXY.add(valorXY);
            listaX2.add(valorX2);
            listaY2.add(valorY2);
        }
    }

    public void calcularTotal() {
        //se calculan los totales de todos los arreglos
        int numeroInstancias = listaX.size();
        BigDecimal totalX = new BigDecimal("0");
        BigDecimal totalY = new BigDecimal("0");
        BigDecimal totalXY = new BigDecimal("0");
        BigDecimal totalX2 = new BigDecimal("0");
        BigDecimal totalY2 = new BigDecimal("0");
        //Un bucle que itera todas las instancias del arreglo y las va sumando
        for (int i = 0; i < numeroInstancias; i++) {
            totalX = totalX.add(new BigDecimal(listaX.get(i)));
            totalY = totalY.add(new BigDecimal(listaY.get(i)));
            totalXY = totalXY.add(listaXY.get(i));
            totalX2 = totalX2.add(listaX2.get(i));
            totalY2 = totalY2.add(listaY2.get(i));
        }
        //se actualiza el total
        this.setTotalX(totalX);
        this.setTotalY(totalY);
        this.setTotalXY(totalXY);
        this.setTotalX2(totalX2);
        this.setTotalY2(totalY2);
        //calculamos la media de X y Y
        BigDecimal promedioX = totalX.divide(new BigDecimal(numeroInstancias), MathContext.DECIMAL32);
        BigDecimal promedioY = totalY.divide(new BigDecimal(numeroInstancias), MathContext.DECIMAL32);
        this.setMediaX(promedioX.doubleValue());
        this.setMediaY(promedioY.doubleValue());
    }

    public void calcularDesviacion() {
        //Se calcula la desviacion estandar y la covarianza
        int numeroInstancias = listaX.size();
        double desviacionEstandarX = 0;
        double desviacionEstandarY = 0;
        BigDecimal covarianza;
        //Calculo de la desviacion estandar de X
        BigDecimal totalX = this.getTotalX2().divide(new BigDecimal(numeroInstancias), MathContext.DECIMAL32);
        desviacionEstandarX = (totalX.doubleValue() - Math.pow(this.getMediaX(), 2));
        desviacionEstandarX = Math.sqrt(desviacionEstandarX);
        //Calculo de la desviacion estandar de Y
        BigDecimal totalY = this.getTotalY2().divide(new BigDecimal(numeroInstancias), MathContext.DECIMAL32);
        desviacionEstandarY = (totalY.doubleValue() - Math.pow(this.getMediaY(), 2));
        desviacionEstandarY = Math.sqrt(desviacionEstandarY);
        //Calculo de la covarianza
        BigDecimal totalXY = this.getTotalXY().divide(new BigDecimal(numeroInstancias), MathContext.DECIMAL32);
        covarianza = totalXY.subtract(new BigDecimal(this.getMediaY() * this.getMediaX()));
        //actualizacion de los datos
        this.setDesviacionEstandarX(desviacionEstandarX);
        this.setDesviacionEstandarY(desviacionEstandarY);
        this.setCovarianzaXY(covarianza);
    }

    public void calcularCoeficienteCorrelacion() {
        //Calculo de la correlacion lineal
        double coeficiente = 0;
        coeficiente = this.getCovarianzaXY().doubleValue() / (this.getDesviacionEstandarX() * this.getDesviacionEstandarY());
        this.setCoeficienteCorrelacion(coeficiente);
    }

}
