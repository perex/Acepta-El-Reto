import java.util.Scanner;

/**
 *
 * @author perex
 */
public class Reto283 {   
    
    public static int buscarMax(char[][] mapa, int fila, int columna) {
               
        //casos base
        if (fila < 0 || columna < 0 || fila+1>mapa.length || columna+1 > mapa[0].length || mapa[fila][columna]== ' ') 
            return 0;
        else
        {
            //marcamos el paso
            mapa[fila][columna] = ' ';
            //import
            return 1 + buscarMax(mapa, fila-1, columna) + buscarMax(mapa, fila+1, columna) + buscarMax(mapa, fila, columna-1) + buscarMax(mapa, fila, columna+1);
        }        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
         
        int filas, columnas, max, actual;
        String linea;
        
        while (sc.hasNext()) 
        {
            filas = sc.nextInt();
            columnas = sc.nextInt();
            sc.nextLine();

            char[][] mapa = new char[filas][columnas];

            for (int i = 0; i < filas; i++)
            {
                    linea = sc.nextLine();
                    for (int j = 0; j < columnas; j++)
                    {
                            mapa[i][j] = linea.charAt(j);
                    }
            }                  
            max = 0;
            for (int i=0; i<filas; i++) {
                for (int j=0; j<columnas; j++) {                                
                    if (mapa[i][j] == '#') {
                        actual = buscarMax(mapa, i, j);
                        if (actual > max)
                            max = actual;
                    }
                }                
            }           
            System.out.println(max);
            }           
    }    
}

