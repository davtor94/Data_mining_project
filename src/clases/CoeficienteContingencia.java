/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author juan_
 */
public class CoeficienteContingencia {

    ArrayList<String> listaNombres1;
    ArrayList<String> listaNombres2;
    ArrayList<BiFrecuencias> tablaFrecuencias;
    long[] totalesVertical;
    atributo atributo1;
    atributo atributo2;
    double equisCuadrada;
    double coeficienteTschuprow;

    public CoeficienteContingencia(atributo atributo1, atributo atributo2) {
        this.atributo1 = atributo1;
        this.atributo2 = atributo2;
        listaNombres1 = new ArrayList<String>();
        listaNombres2 = new ArrayList<String>();
        tablaFrecuencias = new ArrayList<BiFrecuencias>();
        coeficienteTschuprow = 0;
        equisCuadrada = 0;
        cargarListaNombres();
        long variable = 0;
        for (int i = 0; i < listaNombres1.size(); i++) {
            tablaFrecuencias.add(new BiFrecuencias());
            for (int j = 0; j < listaNombres2.size(); j++) {
                tablaFrecuencias.get(i).getListaValores().add(variable);
            }
        }
        String tabla = "";
        for (int i = 0; i < listaNombres1.size(); i++) {
            tabla += "|";
            for (int j = 0; j < listaNombres2.size(); j++) {
                tabla += tablaFrecuencias.get(i).getListaValores().get(j) + "|";
            }
            tabla += "\n";
        }
        JOptionPane.showMessageDialog(null, tabla);
    }

    public ArrayList<String> getListaNombresHorizontal() {
        return listaNombres1;
    }

    public ArrayList<String> getListaNombresVertical() {
        return listaNombres2;
    }

    public ArrayList<BiFrecuencias> getTablaFrecuencias() {
        return tablaFrecuencias;
    }

    public double getCoeficienteTschuprow() {
        return coeficienteTschuprow;
    }

    public void setCoeficienteTschuprow(double coeficiente) {
        this.coeficienteTschuprow = coeficiente;
    }

    public double getEquisCuadrada() {
        return equisCuadrada;
    }

    public void setEquisCuadrada(double equis) {
        this.equisCuadrada = equis;
    }

    public void cargarListaNombres() {
        int numeroInstancias = atributo1.getInstancias().size();
        String auxiliar = "";
        for (int i = 0; i < numeroInstancias; i++) {
            auxiliar = atributo1.getInstancias().get(i);
            if (!listaNombres1.contains(auxiliar)) {
                listaNombres1.add(auxiliar);
                JOptionPane.showMessageDialog(null, auxiliar);
            }

            auxiliar = atributo2.getInstancias().get(i);
            if (!listaNombres2.contains(auxiliar)) {
                listaNombres2.add(auxiliar);
                JOptionPane.showMessageDialog(null, auxiliar);
            }
        }
    }

    public void createTable() {
        //Calculamos las tabla y 
        int numeroInstancias = atributo1.getInstancias().size();
        String variable1 = "";
        String variable2 = "";
        for (int i = 0; i < numeroInstancias; i++) {
            for (int j = 0; j < listaNombres1.size(); j++) {
                variable1 = atributo1.getInstancias().get(i);
                for (int k = 0; k < listaNombres2.size(); k++) {
                    variable2 = atributo2.getInstancias().get(i);
                    if (listaNombres1.get(j).equals(variable1) && listaNombres2.get(k).equals(variable2)) {
                        tablaFrecuencias.get(j).aumentarContador(k);
                    }
                }
            }
        }

        totalesVertical = new long[tablaFrecuencias.get(0).getListaValores().size()];
        long total = 0;
        for (int i = 0; i < tablaFrecuencias.get(0).getListaValores().size(); i++) {
            total = 0;
            for (int j = 0; j < tablaFrecuencias.size(); j++) {
                total += tablaFrecuencias.get(j).getListaValores().get(i);
            }
            totalesVertical[i] = total;
        }
        for (int i = 0; i < tablaFrecuencias.size(); i++) {
            tablaFrecuencias.get(i).calcularTotal();
        }

        String tabla = "";
        for (int i = 0; i < listaNombres1.size(); i++) {
            tabla += "|";
            for (int j = 0; j < listaNombres2.size(); j++) {
                tabla += tablaFrecuencias.get(i).getListaValores().get(j) + "|";
            }
            tabla += tablaFrecuencias.get(i).getTotal() + " \n";
        }
        tabla += "|";
        for (int i = 0; i < totalesVertical.length; i++) {
            tabla += totalesVertical[i] + "|";
        }
        JOptionPane.showMessageDialog(null, tabla);
    }

    public void calcularFrecuenciaEsperada() {
        int numeroInstancias = atributo1.getInstancias().size();
        double frecuenciaEsperada = 0;
        double total1 = 0;
        double total2 = 0;
        for (int i = 0; i < tablaFrecuencias.size(); i++) {
            for (int j = 0; j < tablaFrecuencias.get(i).getListaValores().size(); j++) {
                total1 = tablaFrecuencias.get(i).getTotal();
                total2 = totalesVertical[j];
                JOptionPane.showMessageDialog(null, "(" + total1 + "+" + total2 + ")/" + numeroInstancias);
                frecuenciaEsperada = (total1 * total2) / numeroInstancias;
                JOptionPane.showMessageDialog(null, frecuenciaEsperada);
                tablaFrecuencias.get(i).getListaFrecuenciasEsperadas().add(frecuenciaEsperada);
            }
        }

        String tabla = "";
        for (int i = 0; i < listaNombres1.size(); i++) {
            tabla += "|";
            for (int j = 0; j < listaNombres2.size(); j++) {
                tabla += tablaFrecuencias.get(i).getListaFrecuenciasEsperadas().get(j) + "|";
            }
            tabla += "\n";
        }
        tabla += "|";
        JOptionPane.showMessageDialog(null, tabla);
    }

    public void calcularEquisCuadrada() {
        int numeroInstancias = atributo1.getInstancias().size();
        double equisCuadrada = 0;
        double total1 = 0;
        double total2 = 0;
        for (int i = 0; i < tablaFrecuencias.size(); i++) {
            for (int j = 0; j < tablaFrecuencias.get(i).getListaValores().size(); j++) {
                total1 = tablaFrecuencias.get(i).getListaValores().get(j);
                total2 = tablaFrecuencias.get(i).getListaFrecuenciasEsperadas().get(j);
                JOptionPane.showMessageDialog(null, "(" + total1 + "-" + total2 + ")/" + total2);
                equisCuadrada = Math.pow((total1 - total2), 2) / total2;
                JOptionPane.showMessageDialog(null, equisCuadrada);
                tablaFrecuencias.get(i).getListaEquisCuadrada().add(equisCuadrada);
            }
        }

        String tabla = "";
        for (int i = 0; i < listaNombres1.size(); i++) {
            tabla += "|";
            for (int j = 0; j < listaNombres2.size(); j++) {
                tabla += tablaFrecuencias.get(i).getListaEquisCuadrada().get(j) + "|";
            }
            tabla += "\n";
        }
        tabla += "|";
        JOptionPane.showMessageDialog(null, tabla);

    }

    public void calcularCoeficiente() {
        int numeroInstancias = atributo1.getInstancias().size();
        double equisCuadrada = 0;
        for (int i = 0; i < tablaFrecuencias.size(); i++) {
            for (int j = 0; j < tablaFrecuencias.get(i).getListaEquisCuadrada().size(); j++) {
                equisCuadrada += tablaFrecuencias.get(i).getListaEquisCuadrada().get(j);
            }
        }
        this.setEquisCuadrada(equisCuadrada);
        JOptionPane.showMessageDialog(null, equisCuadrada);
        double coeficienteTschuprow = 0;
        coeficienteTschuprow = Math.sqrt(equisCuadrada / (numeroInstancias * Math.sqrt((listaNombres1.size() - 1) * (listaNombres2.size() - 1))));
        this.setCoeficienteTschuprow(coeficienteTschuprow);
        JOptionPane.showMessageDialog(null, coeficienteTschuprow);
    }

}
