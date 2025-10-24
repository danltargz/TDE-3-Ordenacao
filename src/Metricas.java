public class Metricas {
    private long comparacoes;
    private long trocas;
    private long iteracoes;

    public Metricas() {
        this.comparacoes = 0;
        this.trocas = 0;
        this.iteracoes = 0;
    }

    public long getComparacoes() {
        return comparacoes;
    }

    public void incrementarComparacoes() {
        this.comparacoes++;
    }

    public long getTrocas() {
        return trocas;
    }

    public void incrementarTrocas() {
        this.trocas++;
    }

    public long getIteracoes() {
        return iteracoes;
    }

    public void incrementarIteracoes() {
        this.iteracoes++;
    }
}