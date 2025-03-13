import java.util.Scanner;

public class Medias {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double[] notas = new double[4];
        double soma = 0;

        // Passa pelas 4 notas do aluno
        for (int i = 0; i < 4; i++) {
            while (true) {
                System.out.print("Digite a " + (i + 1) +"ª nota" + ": ");
                try {
                    String input = s.nextLine().replace(",", "."); // Substitui vírgula por ponto para não dar erro de input
                    notas[i] = Double.parseDouble(input); // Converte a string para double
                    if (notas[i] >= 0 && notas[i] <= 10) { // Vê se a nota está entre 0 e 10
                        break;
                    } else {
                        System.out.println("Nota inválida! Digite uma nota entre 0 e 10.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida! Digite um número válido.");
                }
            }
            soma += notas[i];
        }

        // Calcula a média
        double media = soma / 4;

        // Arredonda a média para o int acima ou abaixo
        long mediaArredondada = Math.round(media);

        // Printa a media arredondada
        System.out.println("A média do aluno é: " + mediaArredondada);

        // Verifica se ele foi aprovado/reprovado
        getNota(mediaArredondada);
    }

    public static void getNota(double notaAluno) {
        if (notaAluno >= 7) {
            System.out.println("O aluno foi aprovado");
        } else if (notaAluno >= 5 && notaAluno < 7) {
            System.out.println("O aluno está em recuperação");
        } else {
            System.out.println("O aluno foi reprovado");
        }
    }
}