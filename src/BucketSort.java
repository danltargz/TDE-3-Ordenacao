public class BucketSort {

    private static final int NUMERO_BALDES = 10;

    public static Metricas bucketSort(int[] vetor, int tamanho) {
        Metricas metricas = new Metricas();

        if (tamanho == 0) {
            return metricas;
        }

        int minimo = vetor[0];
        int maximo = vetor[0];
        for (int i = 1; i < tamanho; i++) {
            metricas.incrementarIteracoes();
            if (vetor[i] < minimo) minimo = vetor[i];
            if (vetor[i] > maximo) maximo = vetor[i];
        }

        ListaEncadeada lista = new ListaEncadeada();
        for (int i = 0; i < tamanho; i++) {
            metricas.incrementarIteracoes();
            lista.insereUltimo(vetor[i]);
            metricas.incrementarTrocas();
        }

        ListaEncadeada listaOrdenada = bucketSortRecursivo(lista, minimo, maximo, metricas);

        Node atual = listaOrdenada.getPrimeiro();
        int indice = 0;
        while (atual != null) {
            metricas.incrementarIteracoes();
            vetor[indice] = atual.getValor();
            metricas.incrementarTrocas();
            indice++;
            atual = atual.getProximo();
        }

        return metricas;
    }

    private static ListaEncadeada bucketSortRecursivo(ListaEncadeada lista, int minimo, int maximo, Metricas metricas) {
        if (lista == null || lista.vazia()) {
            return lista;
        }

        if (maximo == minimo) {
            Node temp = lista.getPrimeiro();
            while (temp != null && temp.getProximo() != null) {
                metricas.incrementarIteracoes();
                temp = temp.getProximo();
            }
            return lista;
        }

        int divisor = (maximo - minimo) / NUMERO_BALDES;
        if (divisor == 0) divisor = 1;

        ListaEncadeada[] baldes = new ListaEncadeada[NUMERO_BALDES];
        int[] minimoBaldes = new int[NUMERO_BALDES];
        int[] maximoBaldes = new int[NUMERO_BALDES];

        for (int i = 0; i < NUMERO_BALDES; i++) {
            metricas.incrementarIteracoes();
            baldes[i] = new ListaEncadeada();
            minimoBaldes[i] = Integer.MAX_VALUE;
            maximoBaldes[i] = Integer.MIN_VALUE;
        }

        Node atual = lista.getPrimeiro();
        while (atual != null) {
            metricas.incrementarIteracoes();
            int valor = atual.getValor();
            int indiceBalde = (valor - minimo) / divisor;

            if (indiceBalde < 0) indiceBalde = 0;
            else if (indiceBalde >= NUMERO_BALDES) indiceBalde = NUMERO_BALDES - 1;

            baldes[indiceBalde].insereUltimo(valor);
            metricas.incrementarTrocas();

            if (valor < minimoBaldes[indiceBalde]) {
                minimoBaldes[indiceBalde] = valor;
            }
            if (valor > maximoBaldes[indiceBalde]) {
                maximoBaldes[indiceBalde] = valor;
            }

            atual = atual.getProximo();
        }

        ListaEncadeada resultado = new ListaEncadeada();

        for (int i = 0; i < NUMERO_BALDES; i++) {
            metricas.incrementarIteracoes();
            if (!baldes[i].vazia()) {
                ListaEncadeada baldeOrdenado = bucketSortRecursivo(baldes[i], minimoBaldes[i], maximoBaldes[i], metricas);
                resultado.concatenar(baldeOrdenado);
            }
        }

        return resultado;
    }
}