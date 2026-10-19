Resolução de Problemas Estruturados em Computação TDE-2 Atividades:
Fila Circular — Merge de Filas:
Implementação em Java de um TAD Fila com representação circular sobre um array de inteiros, acompanhada de um método que realiza o merge entre duas filas ordenadas, gerando uma terceira fila também ordenada.

Trabalho da disciplina de Estrutura de Dados — PUCPR.

A ideia:
Uma fila segue a regra de que o primeiro elemento a entrar é o primeiro a sair. Os elementos entram sempre pelo fim e saem sempre pelo início. Em um array comum, cada remoção deixaria uma posição livre no começo que nunca mais seria usada, e a fila acabaria "andando" até o fim do array mesmo com espaço sobrando.

A representação circular resolve isso tratando o array como se suas pontas estivessem ligadas. Quando um índice chega à última posição, o próximo avanço o leva de volta para a posição zero. Esse retorno é feito com o resto da divisão pelo tamanho do array, de modo que as posições liberadas no começo pelas remoções são reaproveitadas pelas inserções seguintes.

Duas decisões dessa implementação merecem destaque:
A primeira é que todo o estado da fila fica em atributos do próprio objeto, sem nenhuma variável global, como pede o enunciado. Isso permite criar várias filas independentes no mesmo programa, o que é necessário para o merge, que trabalha com três filas ao mesmo tempo.

A segunda é o uso de um contador de elementos. Usando apenas os índices de início e fim, a fila cheia e a fila vazia terminariam com os dois índices na mesma situação e não haveria como diferenciá-las. Com o contador, vazia e cheia passam a ser uma simples comparação.

Estrutura do projeto:
O projeto é composto por três arquivos. FilaCircular.java define o TAD Fila Circular, contendo o array e as operações pedidas no enunciado. MergeFilas.java contém o método que realiza o merge entre duas filas. MainFila.java executa os testes das operações, da circularidade e do merge.

Classe FilaCircular:
O atributo dados é o array de inteiros que guarda os elementos. O atributo inicio guarda o índice do primeiro elemento, fim guarda o índice do último e quantidade guarda quantos elementos existem na fila naquele momento. O construtor recebe a capacidade, cria o array com esse tamanho e começa com inicio em zero, quantidade em zero e fim em menos um, já que ainda não existe último elemento. Na primeira inserção o fim avança para zero, que é a posição correta.

vazia:
Retorna verdadeiro quando a quantidade de elementos é zero.

cheia:
Retorna verdadeiro quando a quantidade de elementos é igual ao tamanho do array.

insere:
Insere o elemento sempre no fim da fila. Primeiro verifica se a fila está cheia e, nesse caso, lança uma exceção. Caso contrário, avança o índice fim uma posição usando o resto da divisão pelo tamanho do array, guarda o elemento nessa posição e incrementa a quantidade.

É o resto da divisão que fecha o círculo: quando o fim está na última posição do array, o avanço resulta em zero e a inserção volta para o começo.

remove:
Remove o elemento do início da fila e o devolve. Verifica primeiro se a fila está vazia e, nesse caso, lança uma exceção. Caso contrário, guarda o elemento da posição inicio, avança o índice inicio da mesma forma circular e decrementa a quantidade.

A posição removida não é apagada. O valor antigo continua no array, mas passa a estar fora da fila e será sobrescrito por uma inserção futura.

primeiro:
Retorna o elemento da posição inicio sem alterar a fila. Lança uma exceção se a fila estiver vazia.

ultimo:
Retorna o elemento da posição fim sem alterar a fila. Lança uma exceção se a fila estiver vazia.

tamanho e capacidade:
Métodos auxiliares que retornam, respectivamente, a quantidade de elementos na fila e o tamanho do array. O método tamanho é usado pelo merge para dimensionar a fila resultado.

toString:
Monta a representação da fila em texto para exibição. Percorre os elementos do início até o fim seguindo a ordem lógica da fila, e não a ordem física do array, calculando cada posição a partir do início com o mesmo resto da divisão usado nas outras operações.

Classe MergeFilas:
merge:
Recebe duas filas já ordenadas e devolve uma terceira fila ordenada com todos os elementos das duas, utilizando apenas as operações do TAD. A fila resultado é criada com capacidade igual à soma dos tamanhos das duas filas, para que caiba tudo.

Enquanto as duas filas têm elementos, o método compara o primeiro de cada uma e remove apenas o menor, inserindo-o no resultado. Por isso o resultado sai ordenado: o menor elemento ainda disponível é sempre a frente de uma das duas filas. Em caso de empate, o elemento da fila A entra primeiro.

Quando uma das filas acaba, a outra ainda pode ter elementos, e todos eles já são maiores do que tudo o que entrou no resultado. Basta então transferi-los na ordem em que estão. Dos dois laços finais, apenas um chega a executar.

O merge consome as filas A e B. Como a única forma de consultar um elemento é o método primeiro e a única forma de avançar é o método remove, as duas filas terminam vazias ao final da operação.

Como executar:
É necessário ter o JDK instalado e manter os três arquivos na mesma pasta. A compilação é feita pelo comando javac seguido dos arquivos fonte, e a execução pelo comando java seguido do nome da classe MainFila.

Ao iniciar, o programa executa três testes em sequência. O primeiro demonstra as seis operações do TAD, inserindo, consultando e removendo elementos até a fila ficar cheia. O segundo demonstra a circularidade: enche uma fila de capacidade quatro, remove dois elementos e insere outros dois, que reaproveitam as posições liberadas no começo do array, mostrando que a ordem lógica da fila continua correta. O terceiro executa o merge.

Teste do enunciado:
O exemplo da figura do enunciado é reproduzido no teste do merge. A fila A recebe os elementos 12, 35, 52 e 64, e a fila B recebe 5, 15, 23, 55 e 75. Após o merge, a fila C resulta em 5, 12, 15, 23, 35, 52, 55, 64 e 75, e as filas A e B terminam vazias.