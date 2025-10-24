public class BubbleSort {

    public static Metricas bubbleSort(int[] vetor, int tamanho) {
        Metricas metricas = new Metricas();
        boolean trocou;
        int temp;

        for (int i = 0; i < tamanho - 1; i++) {
            metricas.incrementarIteracoes();
            trocou = false;

            for (int j = 1; j < tamanho - i; j++) {
                metricas.incrementarIteracoes();
                metricas.incrementarComparacoes();

                if (vetor[j - 1] > vetor[j]) {
                    temp = vetor[j - 1];
                    vetor[j - 1] = vetor[j];
                    vetor[j] = temp;
                    metricas.incrementarTrocas();
                    trocou = true;
                }
            }

            if (!trocou) {
                break;
            }
        }

        return metricas;
    }
}