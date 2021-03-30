/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaen;

//procedimiento ensayar (paso : TipoPaso)

import java.util.Scanner;

//  repetir
//  |  seleccionar_candidato
//  |  if aceptable then
//  |  begin
//  |    anotar_candidato
//  |    if solucion_incompleta then
//  |    begin
//  |      ensayar(paso_siguiente)
//  |      if no acertado then borrar_candidato
//  |    end
//  |    else begin
//  |      anotar_solucion
//  |      acertado <- cierto;
//  |  end
//  hasta que (acertado = cierto) o (candidatos_agotados)
//fin procedimiento

/**
 *
 * @author perex
 */
public class Main {   
    
    public static int buscarMax(char[][] mapa, int fila, int columna) {
               
        //si no es posible solución
        if (fila < 0 || columna < 0 || fila+1>mapa.length || columna+1 > mapa[0].length || mapa[fila][columna]== ' ') 
            return 0;
        else
        {
            mapa[fila][columna] = ' ';
            return 1
                    + buscarMax(mapa, fila-1, columna) 
                    + buscarMax(mapa, fila+1, columna) 
                    + buscarMax(mapa, fila, columna-1) 
                    + buscarMax(mapa, fila, columna+1);
        }        
    }
    
    public static int buscar(char[][] mapa) {        
        int actual, max = 0;
        for (int fila=0; fila<mapa.length; fila++) {
            for (int columna=0; columna<mapa.length;columna++) {                                
                if (mapa[fila][columna] == '#') {
                    actual = buscarMax(mapa, fila, columna);
                    if (actual > max)
                        max = actual;
                }                
            }
        }
        
        return max;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
         
        int filas, columnas, max;
        String linea;
        //leer linea   
        
        
        
        while (sc.hasNext()) {
            filas = sc.nextInt();
            columnas = sc.nextInt();
            char[][] mapa = new char[filas][columnas];
            
            for (int i=0; i<filas; i++) {
                linea = sc.nextLine();
                for (int j=0; j<linea.length();j++)
                    mapa[i][j]=linea.charAt(j);
            }           
            
            max = buscar(mapa);
            
        }
        
        
        
    }
    
}
