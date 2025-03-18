import java.util.*;

public class CadastroNomesSexo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> nomesMasculinos = new HashSet<>(); // Para nomes do sexo masculino
        Set<String> nomesFemininos = new HashSet<>(); // Para nomes do sexo feminino

        System.out.println("Digite os nomes no formato 'nome - sexo' (ex: Pedro - M) ou digite 'sair' para encerrar:");

        while (true) {
            String entrada = scanner.nextLine();

            // Verifica se o usuário digitou "sair"
            if (entrada.equalsIgnoreCase("sair")) {
                break;
            }

            // divide utilizando o split
            String[] partes = entrada.split(" - ");
            if (partes.length == 2) { // Verifica se tem nome e sexo
                String nome = partes[0].trim(); // remove os espaços
                String sexo = partes[1].trim().toUpperCase(); // remove espaços e converte para maiúsculas

                // adiciona o nome ao grupo F ou M
                if (sexo.equals("M")) {
                    if (nomesMasculinos.add(nome)) {
                        System.out.println("Nome adicionado: " + nome);
                    } else {
                        System.out.println("O nome '" + nome + "' já está na lista.");
                    }
                } else if (sexo.equals("F")) {
                    if (nomesFemininos.add(nome)) {
                        System.out.println("Nome adicionado: " + nome);
                    } else {
                        System.out.println("O nome '" + nome + "' já está na lista.");
                    }
                } else {
                    System.out.println("Sexo inválido! Use 'M' para masculino ou 'F' para feminino.");
                }
            } else {
                System.out.println("Formato inválido! Use o formato 'nome - sexo' (ex: Igor - M).");
            }
        }

        // ordem alfabetica dos masculinos
        List<String> masculinosOrdenados = new ArrayList<>(nomesMasculinos);
        Collections.sort(masculinosOrdenados);

        // ordem alfabetica feminino
        List<String> femininosOrdenados = new ArrayList<>(nomesFemininos);
        Collections.sort(femininosOrdenados);

        // Printa na tela de forma ordenada M
        System.out.println("Nomes masculinos (em ordem alfabética):");
        for (String nome : masculinosOrdenados) {
            System.out.println(nome);
        }

        // Printa na tela de forma ordenada F
        System.out.println("Nomes femininos (em ordem alfabética):");
        for (String nome : femininosOrdenados) {
            System.out.println(nome);
        }

        scanner.close();
    }
}