/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author juan_
 */
public class CoeficienteContingencia {

    String[] arregloNombres;
    ArrayList<BiFrecuencias> tablaFrecuencias;
    atributo atributo1;
    atributo atributo2;

    CoeficienteContingencia(atributo atributo1, atributo atributo2) {
        this.atributo1 = atributo1;
        this.atributo2 = atributo2;
        arregloNombres = new String[2];
        arregloNombres[0] = "yes";
        arregloNombres[1] = "no";
        tablaFrecuencias = new ArrayList<BiFrecuencias>();
        tablaFrecuencias.add(new BiFrecuencias());
        tablaFrecuencias.add(new BiFrecuencias());
        tablaFrecuencias.add(new BiFrecuencias());
        tablaFrecuencias.get(0).setNombre("overcast");
        tablaFrecuencias.get(1).setNombre("rainy");
        tablaFrecuencias.get(2).setNombre("sunny");
    }

    public void createTable() {
        int numeroInstancias = atributo1.getInstancias().size();
        int contador=0;
        for (int j=0; j<numeroInstancias; j++) {
            
        }
    }
}
