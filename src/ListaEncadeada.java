public class ListaEncadeada {
    private Node lista;
    private Node ultimo;

    public ListaEncadeada() {
        lista = null;
        ultimo = null;
    }

    public boolean vazia() {
        return lista == null;
    }

    public Node getPrimeiro() {
        return lista;
    }

    public Node getUltimo() {
        return ultimo;
    }

    public void inserePrimeiro(int valor) {
        Node novo = new Node(valor);
        novo.setProximo(lista);
        lista = novo;
        if (ultimo == null) {
            ultimo = novo;
        }
    }

    public void insereUltimo(int valor) {
        Node novo = new Node(valor);
        if (vazia()) {
            lista = novo;
            ultimo = novo;
        } else {
            ultimo.setProximo(novo);
            ultimo = novo;
        }
    }

    public int removerPrimeiro() {
        if (vazia()) {
            return -1;
        }
        int valor = lista.getValor();
        lista = lista.getProximo();
        if (lista == null) {
            ultimo = null;
        }
        return valor;
    }

    public int tamanho() {
        int contador = 0;
        Node atual = lista;
        while (atual != null) {
            contador++;
            atual = atual.getProximo();
        }
        return contador;
    }

    public void concatenar(ListaEncadeada outra) {
        if (outra == null || outra.vazia()) {
            return;
        }
        if (vazia()) {
            lista = outra.lista;
            ultimo = outra.ultimo;
        } else {
            ultimo.setProximo(outra.lista);
            ultimo = outra.ultimo;
        }
    }
}