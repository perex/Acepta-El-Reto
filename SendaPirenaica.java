import java.util.Scanner;

public class Main {

  public static void main(String[] args)
    {
        int numEtapas, suma;
        Scanner sc = new Scanner(System.in);
        
        do
        {
            numEtapas = sc.nextInt();
            if (numEtapas > 0)
            {
                int distancias[] = new int[numEtapas];
                suma = 0;
                for (int i=0; i<numEtapas; i++) {
                    distancias[i] = sc.nextInt();
                    suma += distancias[i];
                }
                
                for (int i=0; i<numEtapas;i++) {
                    System.out.print(suma);
                    if (i < numEtapas - 1)
                        System.out.print(" ");
                    suma -= distancias[i];
                }
                System.out.println();
            }
        }
        while (numEtapas > 0);
    }  

}
