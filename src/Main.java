import java.util.Scanner;

public class Main{

    public static void main (String[] args){

        Scanner entrada = new Scanner(System.in);

        System.out.println("MOTOR DE COLETA DE AVALIAÇÕES (NPS)\n");

        int total = 0;
        int promotores = 0;
        int detratores = 0;

        do{

            System.out.println("Digite a sua avaliação entre 1-10 (-1 para sair): ");
            int entradaUsuario = entrada.nextInt();

            if (entradaUsuario < 0) break;

            if (entradaUsuario > 10){
                System.out.println();
                System.out.println("Digite um valor válido!\n");
            }
            else if (entradaUsuario >= 9 && entradaUsuario <= 10){
                promotores ++;
                total ++;
            }
            else if (entradaUsuario >= 0 && entradaUsuario <= 6){
                detratores++;
                total++;
            }
            else if (entradaUsuario == 7 || entradaUsuario == 8){
                total++;
            }

        }while(true);

        double pPromotores = (promotores * 100.0) / total;
        double pDetratores = (detratores * 100.0) / total;

        double npsFinal = pPromotores - pDetratores;


        if (total > 0) {
            System.out.println("Resumo dos Resultados:\n");
            System.out.printf("Total de clientes: %d", total);
            System.out.printf("Percentual de Promotores: %.2f%%%n", pPromotores);
            System.out.printf("Percentual de Detratores: %.2f%%%n", pDetratores);
            System.out.printf("Net Promoter Score (NPS): %.2f%n", npsFinal);
        }
        else{
            System.out.println("\nNenhuma nota foi inserida.");
        }

        entrada.close();

    }

}