Resolução de Problemas Estruturados em Computação TDE-2 Atividades:
Árvore Binária — Código Morse:
Implementação em Java de uma árvore binária que representa o código Morse. Cada letra do alfabeto (A–Z) e cada número (0–9) ocupa uma posição na árvore definida pela sua sequência de pontos e traços.

Trabalho da disciplina de Estrutura de Dados — PUCPR.

A ideia:
O código Morse é naturalmente binário, já que cada símbolo é um ponto ou um traço. Isso permite que a sequência de um caractere seja lida como um caminho dentro de uma árvore binária: o ponto desce pela esquerda e o traço desce pela direita.

A raiz representa a sequência vazia e por isso nunca guarda letra nenhuma, pois nenhum caractere tem código Morse vazio. A partir dela, cada nível descido consome um símbolo do código. Para a letra S, cujo código é três pontos, o percurso parte da raiz e desce três vezes pela esquerda; o nó onde o caminho termina é onde o S fica guardado.

Duas consequências dessa estrutura merecem destaque:
A primeira é que a árvore não é ordenada. Diferente de uma árvore binária de busca, a posição de um nó não vem da comparação de valores, não existindo a regra de que o maior vai para a direita. Quem dita a posição é a própria String do código, e a árvore funciona como um mapa de caminhos.

A segunda é que existem nós sem letra. Algumas sequências não correspondem a caractere nenhum, mas precisam existir para que o caminho continue até um nó mais profundo. Esses nós são criados com o valor VAZIO e funcionam apenas como degraus. Um exemplo é a sequência de quatro traços, que não é letra, mas é atravessada para se chegar ao número 9.

Estrutura do projeto:
O projeto é composto por três arquivos. NodoMorse.java define o nó da árvore, contendo um caractere e os ponteiros para os filhos esquerdo e direito. ArvoreBinariaMorse.java contém a árvore e suas operações de inicialização, inserção, busca, decodificação, codificação e exibição. Main.java implementa o menu de interação com o usuário por meio da classe Scanner.

Classe NodoMorse:
O atributo simbolo guarda o caractere que o nó representa, ou o valor VAZIO quando o nó é apenas um degrau de caminho. A constante VAZIO corresponde ao caractere nulo e serve como marcador de nó sem letra, pois nunca colide com um símbolo real. Os atributos esquerda e direita armazenam os filhos correspondentes ao ponto e ao traço. O método temSimbolo retorna verdadeiro quando o nó carrega uma letra de verdade.

Classe ArvoreBinariaMorse:
inicializar:
Cria a raiz com o valor VAZIO. É o ponto de partida obrigatório, pois sem ela o método inserir não tem de onde começar a caminhar.

inserir:
Percorre o código símbolo por símbolo com um laço, descendo um nível a cada passo. Quando o filho necessário não existe, um nó VAZIO é criado no lugar para servir de degrau. Ao terminar de percorrer o código inteiro, o nó onde o caminho parou recebe a letra.

Esse nó pode já existir, tendo sido criado como degrau por uma inserção anterior. Nesse caso a operação apenas preenche o que estava vazio.

buscar:
Realiza o mesmo caminhar da inserção, porém sem criar nada. Retorna o caractere encontrado ou o valor VAZIO em três situações: quando o caminho não existe, quando o nó final é um degrau sem letra e quando o código contém caractere inválido.

O teste de referência nula fica dentro do laço. Sem ele, a próxima iteração chamaria o método getEsquerda em uma referência nula e lançaria uma NullPointerException.

codigoDe:
Executa o caminho inverso, devolvendo a representação em Morse a partir da letra. Como a letra não informa o caminho dela, não há como descer diretamente e é preciso varrer a árvore.

O método é recursivo e carrega um parâmetro que acumula os pontos e traços percorridos da raiz até o nó atual. Ao encontrar a letra, esse caminho acumulado é o código dela. A busca tenta a subárvore esquerda primeiro, acrescentando um ponto ao caminho, e só segue para a direita, acrescentando um traço, caso a esquerda falhe. Retorna uma String vazia quando a letra não é encontrada.

decodificar:
Traduz uma mensagem inteira em Morse para texto. A entrada é quebrada nos espaços por meio de uma expressão que aceita um ou mais espaços, de modo que espaços duplicados digitados pelo usuário não gerem pedaços vazios, e o método buscar é chamado para cada código resultante.

Duas convenções foram adotadas: a barra separa palavras e um código inexistente na árvore é convertido em um ponto de interrogação, em vez de desaparecer silenciosamente do resultado.

codificar:
Operação inversa da anterior. Utiliza o método codigoDe letra por letra e monta a mensagem em Morse, separando os códigos por espaço e as palavras por barra.

exibir:
Responsável pela exibição hierárquica da árvore. O percurso é feito em pré-ordem, imprimindo o nó e descendo em seguida pela esquerda e pela direita, com recuo proporcional ao nível. Cada linha apresenta o caminho acumulado e o caractere correspondente, sendo os nós de passagem representados por um ponto de interrogação.

carregarAlfabeto:
Realiza o preenchimento automático dos trinta e seis caracteres a partir de dois arrays paralelos, nos quais a posição de um corresponde à mesma posição do outro.

Como executar:
É necessário ter o JDK instalado e manter os três arquivos na mesma pasta. A compilação é feita pelo comando javac seguido dos arquivos fonte, e a execução pelo comando java seguido do nome da classe Main.

Ao iniciar, o programa carrega o alfabeto completo, executa o teste previsto no enunciado e abre o menu, que oferece as opções de exibir a árvore, decodificar uma mensagem em Morse, codificar um texto para Morse, buscar a letra correspondente a um código, buscar o código correspondente a uma letra e encerrar o programa.

Teste do enunciado:
O exemplo de teste previsto no enunciado é executado automaticamente ao iniciar o programa, em uma árvore separada montada apenas com as letras S e O. São inseridas as duas letras, buscadas individualmente pelos seus códigos e, por fim, decodificada a mensagem completa, que resulta em SOS.

O terceiro caso utiliza o método decodificar em vez do método buscar porque este último resolve um único código e retorna um caractere. Uma mensagem com vários caracteres separados por espaço exige que a entrada seja quebrada antes da consulta à árvore.