public class CocktailSort {

    public static Metricas cocktailSort(int[] vetor, int tamanho) {
        Metricas metricas = new Metricas();
        boolean trocou = true;
        int inicio = 0;
        int fim = tamanho - 1;
        int temp;

        while (trocou) {
            metricas.incrementarIteracoes();
            trocou = false;

            for (int i = inicio; i < fim; i++) {
                metricas.incrementarIteracoes();
                metricas.incrementarComparacoes();

                if (vetor[i] > vetor[i + 1]) {
                    temp = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = temp;
                    metricas.incrementarTrocas();
                    trocou = true;
                }
            }

            if (!trocou) {
                break;
            }

            trocou = false;
            fim--;

            for (int i = fim; i > inicio; i--) {
                metricas.incrementarIteracoes();
                metricas.incrementarComparacoes();

                if (vetor[i] < vetor[i - 1]) {
                    temp = vetor[i];
                    vetor[i] = vetor[i - 1];
                    vetor[i - 1] = temp;
                    metricas.incrementarTrocas();
                    trocou = true;
                }
            }
            inicio++;
        }

        return metricas;
    }
}