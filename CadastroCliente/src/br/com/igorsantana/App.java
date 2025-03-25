package br.com.igorsantana;

import br.com.igorsantana.dao.ClienteMapDAO;
import br.com.igorsantana.dao.IClienteDAO;
import br.com.igorsantana.domain.Cliente;
import javax.swing.*;



// O CPF CADASTRADO UMA VEZ NAO PODE SER MODIFICADO, A MENOS QUE O USUÁRIO SEJA EXCLUIDO E CADASTRADO NOVAMENTE COM O CPF CORRETO



public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        while(true) {
            String opcao = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE);

            if(opcao == null || "5".equals(opcao)) {
                sair();
            }

            if(!isOpcaoValida(opcao)) {
                JOptionPane.showMessageDialog(null,
                        "Opção inválida!",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
                continue;
            }

            if("1".equals(opcao)) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vírgula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                        "Cadastro",
                        JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            }
            else if("2".equals(opcao)) {
                String cpf = JOptionPane.showInputDialog(null,
                        "Digite o CPF",
                        "Consultar",
                        JOptionPane.INFORMATION_MESSAGE);
                consultar(cpf);
            }
            else if("3".equals(opcao)) {
                String cpf = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente a ser excluído",
                        "Excluir",
                        JOptionPane.INFORMATION_MESSAGE);
                if(cpf != null) {
                    confirmarExclusao(cpf);
                }
            }
            else if("4".equals(opcao)) {
                String cpf = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente a ser alterado",
                        "Alteração",
                        JOptionPane.INFORMATION_MESSAGE);
                if(cpf != null) {
                    prepararAlteracao(cpf);
                }
            }
        }
    }

    private static void consultar(String dados) {
        if(dados == null || dados.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "CPF não pode estar vazio!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(!dados.matches("\\d+")) {
            JOptionPane.showMessageDialog(null,
                    "Digite apenas números para o CPF!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
            if(cliente != null) {
                String mensagem = "Nome: " + cliente.getNome() + "\n" +
                        "CPF: " + cliente.getCpf() + "\n" +
                        "Telefone: " + cliente.getTel() + "\n" +
                        "Endereço: " + cliente.getEnd() + "\n" +
                        "Número: " + cliente.getNumero() + "\n" +
                        "Cidade: " + cliente.getCidade() + "\n" +
                        "Estado: " + cliente.getEstado();
                JOptionPane.showMessageDialog(null,
                        mensagem,
                        "Dados do Cliente",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Cliente não encontrado!",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "CPF inválido!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void confirmarExclusao(String cpf) {
        if(!cpf.matches("\\d+")) {
            JOptionPane.showMessageDialog(null,
                    "Digite apenas números para o CPF!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Long cpfLong = Long.parseLong(cpf);
            Cliente cliente = iClienteDAO.consultar(cpfLong);

            if(cliente != null) {
                int confirmacao = JOptionPane.showConfirmDialog(null,
                        "Tem certeza que deseja excluir o cliente:\n" +
                                cliente.getNome() + " - CPF: " + cliente.getCpf(),
                        "Confirmar Exclusão",
                        JOptionPane.YES_NO_OPTION);

                if(confirmacao == JOptionPane.YES_OPTION) {
                    iClienteDAO.excluir(cpfLong);
                    JOptionPane.showMessageDialog(null,
                            "Cliente excluído com sucesso!",
                            "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Cliente não encontrado!",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "CPF inválido!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void prepararAlteracao(String cpf) {
        if(!cpf.matches("\\d+")) {
            JOptionPane.showMessageDialog(null,
                    "Digite apenas números para o CPF!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Long cpfLong = Long.parseLong(cpf);
            Cliente cliente = iClienteDAO.consultar(cpfLong);

            if(cliente != null) {
                String dados = JOptionPane.showInputDialog(null,
                        "Digite os novos dados do cliente separados por vírgula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado\n" +
                                "Atuais: " + cliente.getNome() + "," + cliente.getCpf() + "," +
                                cliente.getTel() + "," + cliente.getEnd() + "," +
                                cliente.getNumero() + "," + cliente.getCidade() + "," +
                                cliente.getEstado(),
                        "Alteração",
                        JOptionPane.INFORMATION_MESSAGE);

                if(dados != null) {
                    alterar(cpfLong, dados);
                }
            } else {
                JOptionPane.showMessageDialog(null,
                        "Cliente não encontrado!",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "CPF inválido!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void alterar(Long cpf, String dados) {
        String[] dadosSeparados = dados.split(",");
        try {
            Cliente clienteAtualizado = new Cliente(
                    dadosSeparados[0].trim(),
                    cpf,
                    dadosSeparados[2].trim(),
                    dadosSeparados[3].trim(),
                    Integer.parseInt(dadosSeparados[4].trim()),
                    dadosSeparados[5].trim(),
                    dadosSeparados[6].trim()
            );

            iClienteDAO.alterar(clienteAtualizado);
            JOptionPane.showMessageDialog(null,
                    "Cliente alterado com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Erro no formato dos dados numéricos (CPF ou Número)",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } catch(ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null,
                    "Dados incompletos. Forneça todos os campos necessários.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        try {
            Cliente cliente = new Cliente(
                    dadosSeparados[0].trim(),
                    Long.parseLong(dadosSeparados[1].trim()),
                    dadosSeparados[2].trim(),
                    dadosSeparados[3].trim(),
                    Integer.parseInt(dadosSeparados[4].trim()),
                    dadosSeparados[5].trim(),
                    dadosSeparados[6].trim()
            );

            boolean cadastradoComSucesso = iClienteDAO.cadastrar(cliente);

            if(cadastradoComSucesso) {
                JOptionPane.showMessageDialog(null,
                        "Cliente cadastrado com sucesso!",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Cliente já cadastrado no banco de dados",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Erro no formato dos dados numéricos (CPF ou Número)",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } catch(ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null,
                    "Dados incompletos. Forneça todos os campos necessários.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private static boolean isOpcaoValida(String opcao) {
        return "1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao);
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo", "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
} 