import java.util.*;

public class Cadastro {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();
        Map<String, List<String>> grupos = new HashMap<>();

        // Inicializa os grupos no Map
        grupos.put("Feminino", new ArrayList<>());
        grupos.put("Masculino", new ArrayList<>());

        System.out.println("Digite o nome e o sexo (M ou F) ou digite 'sair' no nome para finalizar.");

        while (true) {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            // Verifica se digitou sair
            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Sexo (M/F): ");
            String sexo = scanner.nextLine().toUpperCase();

            // Verifica se digitou M ou F
            if (!sexo.equals("M") && !sexo.equals("F")) {
                System.out.println("Sexo inválido. Digite 'M' para masculino ou 'F' para feminino.");
                continue;
            }

            // Adicionado
            pessoas.add(new Pessoa(nome, sexo));
        }

        // Separa as pessoas por sexo
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getSexo().equals("F")) {
                grupos.get("Feminino").add(pessoa.getNome());
            } else {
                grupos.get("Masculino").add(pessoa.getNome());
            }
        }


        System.out.println("Grupo Feminino: ");
        for (String nome : grupos.get("Feminino")) {
            System.out.println(nome);
        }

        System.out.println("Grupo Masculino: ");
        for (String nome : grupos.get("Masculino")) {
            System.out.println(nome);
        }

        scanner.close();
    }
}

class Pessoa {
    private String nome;
    private String sexo;

    public Pessoa(String nome, String sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }
}