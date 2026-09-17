import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {

    public static void menuInterativo (Dados dados){
        Scanner entrada = new Scanner(System.in);

        boolean continua = true;

        do {
            System.out.println("MOTOR DE COLETA DE AVALIAÇÕES (NPS)\n");
            System.out.println("1 - Inserir nota");
            System.out.println("2 - Ver histórico");
            System.out.println("3 - Sair e Calcular\n");

            int opcaoMenu = entrada.nextInt();

            int indiceAtual = 0;

            switch (opcaoMenu) {

                case 1:

                    do {
                        System.out.println();
                        System.out.println("Digite a sua avaliação entre 1-10 (-1 para sair): ");
                        int nota = entrada.nextInt();

                        if (nota < 0 || indiceAtual > 99) break;

                        if (nota > 10) {
                            System.out.println();
                            System.out.println("Digite um valor válido!\n");
                        } else if (nota >= 9 && nota <= 10) {
                            dados.historicoNotas[indiceAtual] = nota;
                            indiceAtual++;
                            dados.setPromotores(1);
                            dados.setTotal(1);
                        } else if (nota >= 0 && nota <= 6) {
                            dados.historicoNotas[indiceAtual] = nota;
                            indiceAtual++;
                            dados.setDetratores(1);
                            dados.setTotal(1);
                        } else if (nota == 7 || nota == 8) {
                            dados.historicoNotas[indiceAtual] = nota;
                            indiceAtual++;
                            dados.setTotal(1);
                        }
                    } while (true);

                    break;

                case 2:

                    int totalIndices = indiceAtual;

                    System.out.println("HISTÓRICO\n");
                    int posicao = 1;
                    for (int nota : dados.historicoNotas) {
                        if(nota != 0) {
                            System.out.printf("%dª Nota - %d \n", posicao, nota);
                            posicao++;
                        }
                    }
                    System.out.println();
                    break;
                case 3:

                    calculaPorcentagem(dados);
                    calculaNps(dados);
                    imprimeResultados(dados);

                    continua = false;

                    break;

                default:
                    System.out.println("Digite um valor válido!");
            }

        }while(continua);
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
            System.out.printf("Total de clientes: %d\n", dados.getTotal());
            System.out.printf("Percentual de Promotores: %.2f%%\n", dados.getPorcentagemPromotores());
            System.out.printf("Percentual de Detratores: %.2f%%\n", dados.getPorcentagemDetratores());
            System.out.printf("Net Promoter Score (NPS): %.2f\n", dados.getNpsFinal());
        }
        else{
            System.out.println("\nNenhuma nota foi inserida.");
        }
    }
}
