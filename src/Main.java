import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        int[] vetor1 = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int[] vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
        int[] vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};
        int tamanho = 20;

        Metricas[] v1 = testarTodos(vetor1, tamanho);
        Metricas[] v2 = testarTodos(vetor2, tamanho);
        Metricas[] v3 = testarTodos(vetor3, tamanho);

        gerarResultadosCompletos(v1, v2, v3);
        gerarRankingTrocas(v1, v2, v3);
        gerarRankingIteracoes(v1, v2, v3);

        System.out.println("Arquivos gerados:");
        System.out.println("- resultados.csv");
        System.out.println("- ranking_trocas.csv");
        System.out.println("- ranking_iteracoes.csv");
    }

    private static Metricas[] testarTodos(int[] vetor, int tamanho) {
        Metricas[] resultados = new Metricas[6];
        int[] copia;

        copia = copiar(vetor, tamanho);
        resultados[0] = BubbleSort.bubbleSort(copia, tamanho);

        copia = copiar(vetor, tamanho);
        resultados[1] = SelectionSort.selectionSort(copia, tamanho);

        copia = copiar(vetor, tamanho);
        resultados[2] = CocktailSort.cocktailSort(copia, tamanho);

        copia = copiar(vetor, tamanho);
        resultados[3] = CombSort.combSort(copia, tamanho);

        copia = copiar(vetor, tamanho);
        resultados[4] = GnomeSort.gnomeSort(copia, tamanho);

        copia = copiar(vetor, tamanho);
        resultados[5] = BucketSort.bucketSort(copia, tamanho);

        return resultados;
    }

    private static void gerarResultadosCompletos(Metricas[] v1, Metricas[] v2, Metricas[] v3) {
        try {
            FileWriter w = new FileWriter("resultados.csv");
            w.write("Vetor,Algoritmo,Comparacoes,Trocas,Iteracoes\n");

            String[] nomes = {"Bubble Sort", "Selection Sort", "Cocktail Sort", "Comb Sort", "Gnome Sort", "Bucket Sort"};

            for (int i = 0; i < 6; i++) {
                w.write("Vetor 1," + nomes[i] + "," + v1[i].getComparacoes() + "," + v1[i].getTrocas() + "," + v1[i].getIteracoes() + "\n");
            }

            for (int i = 0; i < 6; i++) {
                w.write("Vetor 2," + nomes[i] + "," + v2[i].getComparacoes() + "," + v2[i].getTrocas() + "," + v2[i].getIteracoes() + "\n");
            }

            for (int i = 0; i < 6; i++) {
                w.write("Vetor 3," + nomes[i] + "," + v3[i].getComparacoes() + "," + v3[i].getTrocas() + "," + v3[i].getIteracoes() + "\n");
            }

            w.close();
        } catch (IOException e) {
            System.out.println("Erro ao gerar arquivo");
        }
    }

    private static void gerarRankingTrocas(Metricas[] v1, Metricas[] v2, Metricas[] v3) {
        try {
            FileWriter w = new FileWriter("ranking_trocas.csv");
            w.write("Algoritmo,Vetor 1,Vetor 2,Vetor 3,Total\n");

            String[] nomes = {"Bubble Sort", "Selection Sort", "Cocktail Sort", "Comb Sort", "Gnome Sort", "Bucket Sort"};

            for (int i = 0; i < 6; i++) {
                long t1 = v1[i].getTrocas();
                long t2 = v2[i].getTrocas();
                long t3 = v3[i].getTrocas();
                long total = t1 + t2 + t3;
                w.write(nomes[i] + "," + t1 + "," + t2 + "," + t3 + "," + total + "\n");
            }

            w.close();
        } catch (IOException e) {
            System.out.println("Erro ao gerar arquivo");
        }
    }

    private static void gerarRankingIteracoes(Metricas[] v1, Metricas[] v2, Metricas[] v3) {
        try {
            FileWriter w = new FileWriter("ranking_iteracoes.csv");
            w.write("Algoritmo,Vetor 1,Vetor 2,Vetor 3,Total\n");

            String[] nomes = {"Bubble Sort", "Selection Sort", "Cocktail Sort", "Comb Sort", "Gnome Sort", "Bucket Sort"};

            for (int i = 0; i < 6; i++) {
                long it1 = v1[i].getIteracoes();
                long it2 = v2[i].getIteracoes();
                long it3 = v3[i].getIteracoes();
                long total = it1 + it2 + it3;
                w.write(nomes[i] + "," + it1 + "," + it2 + "," + it3 + "," + total + "\n");
            }

            w.close();
        } catch (IOException e) {
            System.out.println("Erro ao gerar arquivo");
        }
    }

    private static int[] copiar(int[] original, int tamanho) {
        int[] copia = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            copia[i] = original[i];
        }
        return copia;
    }
}