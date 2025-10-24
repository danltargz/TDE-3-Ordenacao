public class SelectionSort {

    public static Metricas selectionSort(int[] vetor, int tamanho) {
        Metricas metricas = new Metricas();

        for (int i = 0; i < tamanho - 1; i++) {
            metricas.incrementarIteracoes();
            int minIndex = i;

            for (int j = i + 1; j < tamanho; j++) {
                metricas.incrementarIteracoes();
                metricas.incrementarComparacoes();

                if (vetor[j] < vetor[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = vetor[i];
                vetor[i] = vetor[minIndex];
                vetor[minIndex] = temp;
                metricas.incrementarTrocas();
            }
        }

        return metricas;
    }
}