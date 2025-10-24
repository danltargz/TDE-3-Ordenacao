public class GnomeSort {

    public static Metricas gnomeSort(int[] vetor, int tamanho) {
        int i = 0;
        int auxiliar;
        Metricas metricas = new Metricas();

        while (i < tamanho) {
            metricas.incrementarIteracoes();

            if (i == 0) {
                i++;
            } else {
                metricas.incrementarComparacoes();

                if (vetor[i - 1] <= vetor[i]) {
                    i++;
                } else {
                    auxiliar = vetor[i];
                    vetor[i] = vetor[i - 1];
                    vetor[i - 1] = auxiliar;
                    metricas.incrementarTrocas();
                    i--;
                }
            }
        }

        return metricas;
    }
}