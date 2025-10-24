public class CombSort {

    public static Metricas combSort(int[] vetor, int tamanho) {
        int ordenado = 0;
        int intervalo = tamanho;
        int i, indiceMaior, auxiliar;
        Metricas metricas = new Metricas();

        while (ordenado == 0) {
            metricas.incrementarIteracoes();
            intervalo = (int) Math.floor(intervalo / 1.3);

            if (intervalo <= 1) {
                intervalo = 1;
                ordenado = 1;
            }

            for (i = 0; i < tamanho - intervalo; i++) {
                metricas.incrementarIteracoes();
                indiceMaior = intervalo + i;

                metricas.incrementarComparacoes();
                if (vetor[i] > vetor[indiceMaior]) {
                    auxiliar = vetor[indiceMaior];
                    vetor[indiceMaior] = vetor[i];
                    vetor[i] = auxiliar;
                    metricas.incrementarTrocas();
                    ordenado = 0;
                }
            }
        }

        return metricas;
    }
}