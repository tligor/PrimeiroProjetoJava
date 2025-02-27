public class Main {
    public static void main(String[] args) {
        // Criando uma instância da lâmpada com 60W de potência
        Lampada minhaLampada = new Lampada(60);

        // Exibindo informações iniciais da lâmpada
        minhaLampada.exibirInformacoes();

        // Ligando a lâmpada
        minhaLampada.ligar();

        // Exibindo informações após ligar
        minhaLampada.exibirInformacoes();

        // Tentando ligar novamente (já está ligada)
        minhaLampada.ligar();

        // Desligando a lâmpada
        minhaLampada.desligar();

        // Exibindo informações após desligar
        minhaLampada.exibirInformacoes();
    }
}