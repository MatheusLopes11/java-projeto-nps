import java.util.Scanner;

public class Metodos {

    public static void entradaNotas (Dados dados){
        Scanner entrada = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("MOTOR DE COLETA DE AVALIAÇÕES (NPS)\n");

        do{

            System.out.println("=================================================");
            System.out.println("Digite a sua avaliação entre 1-10 (-1 para sair): ");
            int entradaUsuario = entrada.nextInt();

            if (entradaUsuario < 0) break;

            if (entradaUsuario > 10){
                System.out.println();
                System.out.println("Digite um valor válido!\n");
            }
            else if (entradaUsuario >= 9 && entradaUsuario <= 10){
                dados.setPromotores(1);
                dados.setTotal(1);
            }
            else if (entradaUsuario >= 0 && entradaUsuario <= 6){
                dados.setDetratores(1);
                dados.setTotal(1);
            }
            else if (entradaUsuario == 7 || entradaUsuario == 8){
                dados.setTotal(1);
            }

        }while(true);

    }

    public static void calculaPorcentagem(Dados dados) {
        dados.setPorcentagemPromotores((dados.getPromotores() * 100.0) / dados.getTotal());
        dados.setPorcentagemDetratores((dados.getDetratores() * 100.0) / dados.getTotal());
    }

    public static void calculaNps(Dados dados){
        dados.setNpsFinal(dados.getPorcentagemPromotores() - dados.getPorcentagemDetratores());
    }

    public static void imprimeResultados(Dados dados){
        if (dados.getTotal() > 0) {
            System.out.println("Resumo dos Resultados:\n");
            System.out.printf("Total de clientes: %d", dados.getTotal());
            System.out.printf("Percentual de Promotores: %.2f%%\n", dados.getPorcentagemPromotores());
            System.out.printf("Percentual de Detratores: %.2f%%\n", dados.getPorcentagemDetratores());
            System.out.printf("Net Promoter Score (NPS): %.2f\n", dados.getNpsFinal());
        }
        else{
            System.out.println("\nNenhuma nota foi inserida.");
        }
    }
}
