
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import clases.atributo;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author David Torres
 */

public class analisisUnivariable extends javax.swing.JFrame {

    private atributo atr;
    private double media;
    ArrayList<Double> lista = new  ArrayList<>();
   
    /**
     * Creates new form analisisUnivariable
     * @param a
     */
    public analisisUnivariable(atributo a) {
        initComponents();
        atr = a;
        //Transformamos las instancias en un arreglo de doubles
        for (int i = 0; i < atr.getInstancias().size();i++){
            try{
                lista.add(Double.parseDouble(atr.getInstancias().get(i)));
            }
            catch(NumberFormatException e){
                //cae aqui cuando es un valor no numerico, y despues prosigue con las iteraciones
                 JOptionPane.showMessageDialog(null,
                            "Se ha omitido la instancia # "+i+" devido a que es un valor no numerico.",
                            "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
            }
            
        }
         media = calcularMedia();
        labelNombre.setText(atr.getNombre()); 
        jLabelMedia.setText(String.valueOf(media));
        jLabelMediana.setText(String.valueOf(calcularMediana()));
        jLabelModa.setText(String.valueOf(calcularModa()));
        jLabelDesvE.setText(String.valueOf(calcularDesv()));
    }
    
    public double calcularMedia(){
        double sumatoria =0;
        for(int i =0;i<lista.size();i++){
            
            sumatoria+=lista.get(i);
        }
        sumatoria = sumatoria/lista.size();
        return sumatoria;
    }
    public double calcularMediana(){
        double mediana=0;
        ArrayList<Double> listaAuxiliar;
        listaAuxiliar = lista;
        Collections.sort(listaAuxiliar);
        int mitad = listaAuxiliar.size()/2;
        if(listaAuxiliar.size()%2==0){
            double aux;
            aux =  lista.get(mitad);
            aux +=  lista.get(mitad+1);
            mediana = aux/2;
         jLabelMinimo.setText(String.valueOf(listaAuxiliar.get(0)));
        jLabelMaximo.setText(String.valueOf(listaAuxiliar.get(listaAuxiliar.size()-1)));
        }else{
        mediana = lista.get(mitad);
         jLabelMinimo.setText(String.valueOf(listaAuxiliar.get(0)));
        jLabelMaximo.setText(String.valueOf(listaAuxiliar.get(listaAuxiliar.size()-1)));
        }
        return mediana;
        
    }
    
    public double calcularModa(){
        double moda=0;
        //se crea una variable auxilar en caso de retorno inesperado
        double mod=0;
        int repeticiones;
        int repeticionesMax=0;
        for(int i =0; i<lista.size();i++){
            repeticiones =0;
            
             for(int j =0; j<lista.size();j++){
                 if(lista.get(i).equals(lista.get(j))){
                     repeticiones++;
                 }
             }
             if(repeticiones>repeticionesMax){
                 mod = lista.get(i);
                 repeticionesMax = repeticiones;
             }
        }
        moda =mod;
        return moda;
    }
    public double calcularDesv(){
        double desv;
        double sumatoria;
        sumatoria =0;
        for(int i =0; i<lista.size();i++){
            sumatoria +=Math.pow(lista.get(i)-media,2);
        }
        sumatoria = sumatoria / (lista.size()-1);
        desv = Math.sqrt(sumatoria);
        return desv;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {


        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelDesvE = new javax.swing.JLabel();
        jLabelModa = new javax.swing.JLabel();
        jLabelMediana = new javax.swing.JLabel();
        jLabelMedia = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelMinimo = new javax.swing.JLabel();
        jLabelMaximo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre");

        jLabel2.setText("Media");

        jLabel3.setText("Mediana");

        jLabel4.setText("Moda");

        jLabel5.setText("Desv EStd.");

        jLabelDesvE.setText("Desv EStd.");

        jLabelModa.setText("Moda");

        jLabelMediana.setText("Mediana");

        jLabelMedia.setText("Media");

        labelNombre.setText("Nombre");

        jLabel6.setText("Minimo");

        jLabel7.setText("Maximo");

        jLabelMinimo.setText("jLabel8");

        jLabelMaximo.setText("jLabel9");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelDesvE, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                        .addComponent(jLabelModa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelMediana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelMedia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMinimo)
                    .addComponent(jLabelMaximo))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMedia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMediana)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelModa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelDesvE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelMinimo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabelMaximo))
                .addGap(0, 32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelDesvE;
    private javax.swing.JLabel jLabelMaximo;
    private javax.swing.JLabel jLabelMedia;
    private javax.swing.JLabel jLabelMediana;
    private javax.swing.JLabel jLabelMinimo;
    private javax.swing.JLabel jLabelModa;
    private javax.swing.JLabel labelNombre;
    // End of variables declaration//GEN-END:variables
}
