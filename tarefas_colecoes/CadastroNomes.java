import java.util.*;

public class CadastroNomes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> nomes = new HashSet<>();

        System.out.println("Digite os nomes separados por vírgula ou digite 'sair' para finalizar.");
        System.out.println("Ao final digite sair para exibir os nomes em ordem alfabética");
        while (true) {
            String entrada = scanner.nextLine();

            // Verifica se o usuário digitou "sair"
            if (entrada.equalsIgnoreCase("sair")) {
                break; // Sai do loop
            }

            // Divide usando split
            String[] nomesDigitados = entrada.split(",");

            // Adiciona cada nome ao Set para evitar repeticao
            for (String nome : nomesDigitados) {
                nome = nome.trim(); //limpa espaços em branco
                if (!nome.isEmpty()) { //verifica se esta vazio
                    if (nomes.add(nome)) {
                        System.out.println("Nome adicionado: " + nome);
                    } else {
                        System.out.println("O nome '" + nome + "' já está na lista, tente outro.");
                    }
                }
            }
        }

        // Ordena os nomes em ordem alfabética
        List<String> nomesAlfabetica = new ArrayList<>(nomes);
        Collections.sort(nomesAlfabetica);

        // Exibe os nomes ordenados
        System.out.println("Nomes digitados (em ordem alfabética):");
        for (String nome : nomesAlfabetica) {
            System.out.println(nome);
        }

        scanner.close();
    }
}