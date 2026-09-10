import java.util.Scanner;

public class Main{

    public static void main (String[] args){

        Scanner entrada = new Scanner(System.in);

        System.out.println("MOTOR DE COLETA DE AVALIAÇÕES (NPS)\n");

        int total = 0;
        int promotores = 0;
        int detratores = 0;

        do{

            System.out.println("Digite a sua avaliação (-1 para sair): ");
            int entradaUsuario = entrada.nextInt();

            if (entradaUsuario < 0) break;
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

        entrada.close();

    }

}