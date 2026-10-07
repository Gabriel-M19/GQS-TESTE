package aula13;

public class Matematica {

    private final ServicoCambio servicoCambio;

    public Matematica(ServicoCambio servicoCambio) {
        this.servicoCambio = servicoCambio;
    }

    public int subtrair(int num1, int num2){
        return num1 - num2;
    }

    public int multiplicar(int num1, int num2){
        return num1 * num2;
    }

    public int dividir(int num1, int num2){
        return num1 / num2;
    }

    public int somar(int num1, int num2){
        return num1 + num2;
    }

    public int fatorial (int numero){
        return numero;
    }

    public double converterMoeda(double valorReais,
                                 String moeda){
        double taxa = servicoCambio.obterTaxa(moeda);

        return valorReais * taxa;
    }

}
