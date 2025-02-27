public class Aluno {

    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;

    // Construtor da classe (inicializa as notas)
    public Aluno(double nota1, double nota2, double nota3, double nota4) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
    }

    public double calcularMedia() {
        return (this.nota1 + this.nota2 + this.nota3 + this.nota4) / 4;
    }

    public void exibirMedia() {
        double media = this.calcularMedia(); // Calcula a média
        System.out.println("A média das notas é: " + media);
    }
}