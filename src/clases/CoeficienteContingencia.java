/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author juan_
 */
public class CoeficienteContingencia {
    //Variable global que guardara el numero de instancias
    int numeroInstancias;
    DataSet baseDatos;
    //lista para saber los nombres de cada variable horizontal y vertical
    ArrayList<String> listaNombres1;
    ArrayList<String> listaNombres2;
    //Es la tabla de frecuencias que nos da las frecuencias observadas
    ArrayList<BiFrecuencias> tablaFrecuencias;
    //un arreglo de la suma de la tabla en vertical
    long[] totalesVertical;
    atributo atributo1;
    atributo atributo2;
    //chi cuadrada
    double equisCuadrada;
    double coeficienteTschuprow;

    public CoeficienteContingencia(int indice1, int indice2, DataSet baseDatos) {
        //inicializando valores
        this.baseDatos = baseDatos;
        this.atributo1 = baseDatos.getAtributos().get(indice1);
        this.atributo2 = baseDatos.getAtributos().get(indice2);
        listaNombres1 = new ArrayList<String>();
        listaNombres2 = new ArrayList<String>();
        tablaFrecuencias = new ArrayList<BiFrecuencias>();
        coeficienteTschuprow = 0;
        equisCuadrada = 0;
        numeroInstancias = atributo1.getInstancias().size();
        //Inicializamos la lista de nombres para saber los posibles valores a tomar
        cargarListaNombres();
        //Cargamos la tabla de frecuencias por defecto con valores de 0
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
        //iteramos el arreglo para encontrar todos los valores posibles
        String auxiliar1 = "";
        String auxiliar2 = "";
        String dominio1 = atributo1.getDominio();
        String dominio2 = atributo2.getDominio();
        for (int i = 0; i < atributo1.getInstancias().size(); i++) {
            auxiliar1 = atributo1.getInstancias().get(i);
            auxiliar2 = atributo2.getInstancias().get(i);
            //Validacion para comprobar que todos son validos de esa manera eliminamos
            //valores faltantes y los que no concuerden con la expresion regular
            if (!auxiliar1.equals(baseDatos.getFaltante()) && !auxiliar2.equals(baseDatos.getFaltante())
                    && Pattern.matches(dominio1, auxiliar1) && Pattern.matches(dominio2, auxiliar2)) {
                //Verificamos que el valor no este ya registrado en la lista de valores
                if (!listaNombres1.contains(auxiliar1)) {
                    listaNombres1.add(auxiliar1);
                    JOptionPane.showMessageDialog(null, auxiliar1);
                }
                //Verificamos que el valor no este ya registrado en la lista de valores
                if (!listaNombres2.contains(auxiliar2)) {
                    listaNombres2.add(auxiliar2);
                    JOptionPane.showMessageDialog(null, auxiliar2);
                }
            } else {
                //reducir el numero de instancias para cuando hagamos los calculos
                this.numeroInstancias--;
            }
        }
        JOptionPane.showMessageDialog(null, this.numeroInstancias);
    }

    public void createTable() {
        //Calculamos las tabla  
        String variable1 = "";
        String variable2 = "";
        //iteramos todas las instancias
        for (int i = 0; i < atributo1.getInstancias().size(); i++) {
            //iteramos la tabla para obtener los dos valores que buscamos que se repitan en cada iteracion
            for (int j = 0; j < listaNombres1.size(); j++) {
                variable1 = atributo1.getInstancias().get(i);
                for (int k = 0; k < listaNombres2.size(); k++) {
                    variable2 = atributo2.getInstancias().get(i);
                    //si los dos valores coinciden, llamamos un metodo para que aumente el contador de la variable frecuencia
                    if (listaNombres1.get(j).equals(variable1) && listaNombres2.get(k).equals(variable2)) {
                        tablaFrecuencias.get(j).aumentarContador(k);
                    }
                }
            }
        }
        //tras obtener todas las frecuencias calculamos el total de cada columna
        totalesVertical = new long[tablaFrecuencias.get(0).getListaValores().size()];
        long total = 0;
        for (int i = 0; i < tablaFrecuencias.get(0).getListaValores().size(); i++) {
            total = 0;
            for (int j = 0; j < tablaFrecuencias.size(); j++) {
                total += tablaFrecuencias.get(j).getListaValores().get(i);
            }
            totalesVertical[i] = total;
        }
        //calculando el total de cada fila
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
        //se calcula la frecuencia esperada
        double frecuenciaEsperada = 0;
        double total1 = 0;
        double total2 = 0;
        //se itera la tabla de frecuencias
        for (int i = 0; i < tablaFrecuencias.size(); i++) {
            for (int j = 0; j < tablaFrecuencias.get(i).getListaValores().size(); j++) {
                total1 = tablaFrecuencias.get(i).getTotal();
                total2 = totalesVertical[j];
                JOptionPane.showMessageDialog(null, "(" + total1 + "+" + total2 + ")/" + numeroInstancias);
                //usamos la formula la cual es frecuencia de b por frecuencia de a sobre el numero de instancias
                frecuenciaEsperada = (total1 * total2) / numeroInstancias;
                JOptionPane.showMessageDialog(null, frecuenciaEsperada);
                //añadimos la frencuencia a la tabla
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
        //Empezamos a calcular chi cuadrada en esta parte solo sacamos los valores de las sumatorias para posteriormente sumarlos
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
        //calculamos ahora si chi cuadrada haciendo la suma de todos los valores
        double equisCuadrada = 0;
        for (int i = 0; i < tablaFrecuencias.size(); i++) {
            for (int j = 0; j < tablaFrecuencias.get(i).getListaEquisCuadrada().size(); j++) {
                equisCuadrada += tablaFrecuencias.get(i).getListaEquisCuadrada().get(j);
            }
        }
        this.setEquisCuadrada(equisCuadrada);
        JOptionPane.showMessageDialog(null, equisCuadrada);
        //ahora siguiendo la formula lo que hacemos es sacar la raiz cuadrada de chi cuadrada sobre el numero de isntancias por la raiz de r-1 y c-1
        double coeficienteTschuprow = 0;
        coeficienteTschuprow = Math.sqrt(equisCuadrada / (numeroInstancias * Math.sqrt((listaNombres1.size() - 1) * (listaNombres2.size() - 1))));
        this.setCoeficienteTschuprow(coeficienteTschuprow);
        JOptionPane.showMessageDialog(null, coeficienteTschuprow);
    }

}
