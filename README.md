# Análise Comparativa de Algoritmos de Ordenação

**Disciplina:** Resolução de Problemas Estruturados em Computação  

**Período:** 4º Período  

**Instituição:** Pontifícia Universidade Católica do Paraná (PUCPR)

**Autor:** Danillo Gonçalves Camargo da Silva

**Professor:** Andrey Cabral Meira

---

## Objetivo

Implementar e comparar o desempenho de três algoritmos de ordenação nichados (Comb Sort, Gnome Sort e Bucket Sort) com três algoritmos padrão já estudados (Bubble Sort com flag, Selection Sort e Cocktail Sort).

---

## Algoritmos Implementados

### Algoritmos Clássicos

**1. Bubble Sort (com flag de parada)**
- Compara elementos adjacentes e troca se necessário
- Flag detecta quando vetor já está ordenado
- Complexidade: O(n) melhor caso, O(n²) pior caso

**2. Selection Sort**
- Seleciona o menor elemento e coloca na posição correta
- Sempre faz O(n) trocas
- Complexidade: O(n²) em todos os casos

**3. Cocktail Sort**
- Variação bidirecional do Bubble Sort
- Percorre da esquerda para direita e vice-versa
- Complexidade: O(n) melhor caso, O(n²) pior caso

### Algoritmos de Nicho

**4. Comb Sort**
- Melhoria do Bubble Sort usando gaps decrescentes (divisor 1.3)
- Elimina valores pequenos no final mais rapidamente
- Complexidade: O(n log n) melhor caso, O(n²) pior caso

**5. Gnome Sort**
- Algoritmo simples que avança ou retrocede baseado em comparações
- Similar a ordenar cartas de baralho
- Complexidade: O(n) melhor caso, O(n²) pior caso

**6. Bucket Sort**
- Algoritmo de distribuição que divide elementos em baldes
- Não usa comparações diretas entre elementos
- Implementação recursiva com baldes dinâmicos
- Complexidade: O(n + k) melhor caso, O(n²) pior caso

---

## Vetores de Teste

**Vetor 1 - Desordenado**
```
[12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28]
```

**Vetor 2 - Ordenado**
```
[5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32]
```

**Vetor 3 - Inversamente Ordenado**
```
[99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6]
```

---

## Resultados

### Tabela Completa de Métricas

| Vetor | Algoritmo | Comparações | Trocas | Iterações |
|-------|-----------|-------------|--------|-----------|
| Vetor 1 | Bubble Sort | 180 | 78 | 195 |
| Vetor 1 | Selection Sort | 190 | 18 | 209 |
| Vetor 1 | Cocktail Sort | 154 | 78 | 160 |
| Vetor 1 | **Comb Sort** | **129** | **22** | **138** |
| Vetor 1 | Gnome Sort | 174 | 78 | 176 |
| Vetor 1 | Bucket Sort | 0 | 78 | 277 |
| Vetor 2 | **Bubble Sort** | **19** | **0** | **20** |
| Vetor 2 | Selection Sort | 190 | 0 | 209 |
| Vetor 2 | **Cocktail Sort** | **19** | **0** | **20** |
| Vetor 2 | Comb Sort | 110 | 0 | 118 |
| Vetor 2 | **Gnome Sort** | **19** | **0** | **20** |
| Vetor 2 | Bucket Sort | 0 | 73 | 172 |
| Vetor 3 | Bubble Sort | 190 | 190 | 209 |
| Vetor 3 | Selection Sort | 190 | 10 | 209 |
| Vetor 3 | Cocktail Sort | 190 | 190 | 200 |
| Vetor 3 | **Comb Sort** | **129** | **18** | **138** |
| Vetor 3 | Gnome Sort | 380 | 190 | 400 |
| Vetor 3 | Bucket Sort | 0 | 75 | 194 |

### Ranking por Menor Número de Trocas

| Posição | Algoritmo | Vetor 1 | Vetor 2 | Vetor 3 | Total |
|---------|-----------|---------|---------|---------|-------|
| 1º | **Selection Sort** | 18 | 0 | 10 | **28** |
| 2º | **Comb Sort** | 22 | 0 | 18 | **40** |
| 3º | **Bucket Sort** | 78 | 73 | 75 | **226** |
| 4º | Bubble Sort | 78 | 0 | 190 | **268** |
| 4º | Cocktail Sort | 78 | 0 | 190 | **268** |
| 4º | Gnome Sort | 78 | 0 | 190 | **268** |

### Ranking por Menor Número de Iterações

| Posição | Algoritmo | Vetor 1 | Vetor 2 | Vetor 3 | Total |
|---------|-----------|---------|---------|---------|-------|
| 1º | **Cocktail Sort** | 160 | 20 | 200 | **380** |
| 2º | **Comb Sort** | 138 | 118 | 138 | **394** |
| 3º | **Bubble Sort** | 195 | 20 | 209 | **424** |
| 4º | **Gnome Sort** | 176 | 20 | 400 | **596** |
| 5º | Selection Sort | 209 | 209 | 209 | **627** |
| 6º | Bucket Sort | 277 | 172 | 194 | **643** |

---

## Análise Comparativa

### Comb Sort vs Bubble Sort

**Vantagens do Comb Sort:**
- Reduz significativamente comparações (129 vs 180 no Vetor 1)
- Muito menos trocas (22 vs 78 no Vetor 1)
- Menos iterações em todos os cenários (138 vs 195 no Vetor 1)
- Mantém excelente performance mesmo no pior caso (Vetor 3: 138 iterações)

**Quando Bubble Sort é melhor:**
- No melhor caso (Vetor 2 já ordenado), onde detecta rapidamente com flag (20 iterações vs 118 do Comb)

**Conclusão:** Comb Sort é superior ao Bubble Sort em dados desordenados. Bubble Sort é mais eficiente apenas em dados já ordenados.

### Gnome Sort vs Selection Sort

**Vantagens do Gnome Sort:**
- Excelente no melhor caso (20 iterações vs 209 do Selection no Vetor 2)
- Menos iterações em dados aleatórios (176 vs 209 no Vetor 1)
- Adaptável à ordem inicial dos dados

**Vantagens do Selection Sort:**
- Sempre faz poucas trocas (28 total vs 268 do Gnome)
- Desempenho estável e previsível
- Não degenera em pior caso (Vetor 3: 209 iterações vs 400 do Gnome)

**Conclusão:** Selection Sort é melhor quando trocas são custosas ou desempenho previsível é necessário. Gnome Sort é melhor para dados parcialmente ordenados.

### Bucket Sort vs Cocktail Sort

**Características do Bucket Sort:**
- Não faz comparações diretas
- Usa movimentações em vez de trocas (78, 73 e 75)
- Desempenho relativamente estável (172-277 iterações)
- Maior número total de iterações (643)

**Características do Cocktail Sort:**
- Adapta-se à ordem inicial dos dados
- Excelente no melhor caso (20 iterações)
- Consistente em casos médio e pior (160-200 iterações)
- **Menor total de iterações entre todos** (380)

**Conclusão:** Cocktail Sort é superior em todos os aspectos testados. Bucket Sort seria mais vantajoso com grandes volumes de dados ou quando comparações são muito custosas.

---

## Conclusões Gerais

### Melhor Algoritmo por Situação

**Dados Aleatórios (Vetor 1):**
- **Vencedor Geral:** Comb Sort (138 iterações, 22 trocas, 129 comparações)
- **Menos Trocas:** Selection Sort (18 trocas)
- **Menos Iterações:** Cocktail Sort (160 iterações)

**Dados Já Ordenados (Vetor 2):**
- **Vencedores Empatados:** Bubble Sort, Cocktail Sort e Gnome Sort (20 iterações, 0 trocas)
- Todos detectam ordenação rapidamente
- **Evitar:** Selection Sort (sempre faz 209 iterações)

**Dados Inversamente Ordenados (Vetor 3):**
- **Vencedor Geral:** Comb Sort (138 iterações, 18 trocas)
- **Menos Trocas:** Selection Sort (10 trocas)
- **Menos Iterações:** Comb Sort (138 iterações)
- **Evitar:** Gnome Sort (400 iterações - pior desempenho)

### Análise por Métrica

**Menor Número de Trocas:**
1. Selection Sort: Sempre faz poucas trocas (ideal quando trocas são custosas)
2. Comb Sort: Segundo melhor, com boa performance geral

**Menor Número de Iterações:**
1. Cocktail Sort: Melhor adaptabilidade e performance consistente
2. Comb Sort: Muito próximo, com excelente desempenho geral

**Menor Número de Comparações:**
1. Bucket Sort: 0 comparações (algoritmo de distribuição)
2. Comb Sort: Menos comparações entre algoritmos baseados em comparação

### Recomendaçãos Baseadas Nos Dados Coletados

1. **Uso Geral (dados variados):** **Comb Sort** - excelente balanço entre trocas, comparações e iterações
2. **Dados Quase Ordenados:** **Bubble Sort, Cocktail Sort ou Gnome Sort** - todos com O(n) no melhor caso
3. **Minimizar Trocas (trocas custosas):** **Selection Sort** - apenas 28 trocas no total
4. **Minimizar Iterações:** **Cocktail Sort** - 380 iterações totais (melhor geral)
5. **Evitar com dados inversamente ordenados:** **Gnome Sort** - degenera para O(n²) facilmente

### Observações Importantes

- **Bucket Sort** mostra 0 comparações porque é um algoritmo de distribuição, não de comparação
- **Selection Sort** é o único que mantém O(n²) iterações mesmo em dados ordenados
- **Comb Sort** apresentou o melhor equilíbrio geral entre todas as métricas
- **Cocktail Sort** Possui o menor número total de iterações

---

### Arquivos gerados:
- `resultados.csv` - Métricas completas
- `ranking_trocas.csv` - Ranking por número de trocas
- `ranking_iteracoes.csv` - Ranking por número de iterações

---

## Referências

- Comb Sort: **CALDERAN, Felipe Vaiano.** *An analysis of Comb Sort.* Federal University of São Paulo (UNIFESP).
- Gnome Sort: [Gnome Sort - The Simplest Sort Algorithm](https://www.geeksforgeeks.org/gnome-sort-a-stupid-one/)
- Bucket Sort: [DCC UChile - Bucket Sort Implementation](http://www.dcc.uchile.cl/~rbaeza/handbook/algs/4/423.sort.c.html)
