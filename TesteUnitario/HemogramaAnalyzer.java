public class HemogramaAnalyzer {

    // Método para calcular a Hemoglobina Média
    public double calcularHb(double hemoglobina, double hematocrito) {
        if (hematocrito == 0) {
            throw new IllegalArgumentException("Hematocrito não pode ser zero.");
        }
        return hemoglobina / hematocrito;
    }

    // Método para calcular o Volume Corpuscular Médio (VCM)
    public double calcularVCM(double hematocrito, int numeroEritrocitos) {
        if (numeroEritrocitos == 0) {
            throw new IllegalArgumentException("Número de eritrócitos não pode ser zero.");
        }
        return (hematocrito / numeroEritrocitos) * 10;
    }

    // Método para entrada de dados
    public String analisarHemograma(double hemoglobina, double hematocrito, int numeroEritrocitos) {
        double hb = calcularHb(hemoglobina, hematocrito);
        double vcm = calcularVCM(hematocrito, numeroEritrocitos);
        return String.format("Hemoglobina Média: %.2f, VCM: %.2f", hb, vcm);
    }
}
