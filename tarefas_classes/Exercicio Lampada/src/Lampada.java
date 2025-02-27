// Classe Lâmpada
public class Lampada {

    // Atributos (propriedades da lâmpada)
    private boolean ligada;
    private int potencia;   // Potência da lâmpada em watts

    public Lampada(int potencia) {
        this.ligada = false; // A lâmpada começa desligada
        this.potencia = potencia; // Define a potência da lâmpada
    }

    // Método para ligar a lâmpada
    public void ligar() {
        if (!this.ligada) { // Verifica se a lâmpada já está ligada
            this.ligada = true;
            System.out.println("Lâmpada ligada.");
        } else {
            System.out.println("A lâmpada já está ligada.");
        }
    }

    // Método para desligar a lâmpada
    public void desligar() {
        if (this.ligada) { // Verifica se a lâmpada já está desligada
            this.ligada = false;
            System.out.println("Lâmpada desligada.");
        } else {
            System.out.println("A lâmpada já está desligada.");
        }
    }

    // Método para verificar o estado da lâmpada
    public void verificarEstado() {
        if (this.ligada) {
            System.out.println("A lâmpada está ligada.");
        } else {
            System.out.println("A lâmpada está desligada.");
        }
    }

    // Método para exibir informações da lâmpada
    public void exibirInformacoes() {
        System.out.println("Potência da lâmpada: " + this.potencia + "W");
        this.verificarEstado();
    }
}