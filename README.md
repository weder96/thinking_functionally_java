Functional programming for Java developers


Eu começo este post com uma frase de John Hughes:

Os programas funcionais não contêm instruções de atribuição, portanto, as variáveis, uma vez dado um valor,
nunca mude. De forma mais geral, os programas funcionais não contêm nenhum efeito colateral. Uma função
chamada não pode ter nenhum efeito além de calcular seu resultado. Isso elimina uma grande fonte de bugs,
e também torna irrelevante a ordem de execução - já que nenhum efeito colateral pode alterar uma expressão
valor da missão, ela pode ser avaliada a qualquer momento. Isso alivia o programador do fardo de pré-
descrevendo o fluxo de controle. Como as expressões podem ser avaliadas a qualquer momento, pode-se livremente
substituir variáveis por seus valores e vice-versa – isto é, os programas são “referencialmente transparentes”.
ent.” Essa liberdade ajuda a tornar os programas funcionais mais tratáveis matematicamente do que seus
congêneres convencionais.
—John Hughes


A primeira pergunta que fazemos sempre, What is functional programming?

Estudando o assunto, entendo que a Programação funcional não se opoem a Orientação a Objetos, fato,
mas entendo que há algo mais importante do que concordar ou não, na area de programação temos muito isso discordar de algo, ok e sempre devemos respeitar a opinião e as vezes até concordamos com um ponto de vista que ainda não tinhamos pensado.

Então se a Programação funcional difere em pontos, penso que existe outros paradigmas de programação, sim 
desta forma podemos dizer que a programação funcional é considerada um conjunto de técnicas que
complementa ou substitui técnicas encontradas em outros paradigmas de programação.

Uma das maiores diferença entre programação imperativa e programação funcional é que na programação funcional não existem efeitos colaterais. Isso significa, entre outras coisas:

- Nenhuma mutação de variáveis
- Nenhuma impressão no console ou em qualquer dispositivo
- Nenhuma gravação em arquivos, bancos de dados, redes ou qualquer outro
- Sem lançamento de exceção

1: Functional Interfaces in Java

Antes de evoluirmos devemos voltar em alguns conceitos, vamos falar de Functional Interfaces, mas vamos definir o que interface.

O que é Interface em Java?

Em Java, uma interface especifica um ou mais métodos. A interface é um contrato que deve ser honrado por todas as classes de implementação. A interface definida


```
interface MyInterface
{
    void method1();
    String method2(String name);
}
```


Como a interface é um contrato qualquer classe que implementa uma interface deve fornecer implementações para todos os
métodos declarados na interface (ou a classe deve ser declarada como abstrata).

```
class MyClass implements MyInterface
{
    @Override
    public void method1() {}
    @Override
    public String method2(String name) { return name; }
}
```


Mas quando houve as melhorias para interfaces em Java ? 

Sim lá no Java 8, as interfaces podiam ter métodos estáticos e padrão. 

Então sabemos que um método estático tem uma única instância associada à interface. 
outro ponto e que um método estático pode ser chamado sem criação de um objeto(new).

Um método padrão é uma implementação fornecida pela interface que não precisa ser substituído por uma classe de implementação. 
Métodos padrão ajudam em a compilação do código legado.


Porem no Java 9, as interfaces podiam ter **métodos privados**. Métodos privados são útil para chamar de métodos padrão. 
Veja abaixo o codigo abaixo:

```
public interface MyInterfaceJava9 {
    private int getNumber() { return (new Random()).nextInt(100); }
    default String concatNumber(String s) { return s + getNumber();}
}
```

Implementando a Interface criada em uma classe concreta:

```
public class MyCLass3 implements MyInterfaceJava9 {
}
```

Note que não necessita criar nenhuma implementação, pois temos um metodo default e um privado.
Criando uma classe para execução:

```
public class MyExecute2 {
    public static void main(String[] args)
    {
        MyInterfaceJava9 objJava9 = new MyCLass3();
        System.out.println(objJava9.concatNumber("Hello "));
    }
}
```

Saida execução:

Hello 74


2. Definição de Functional Interfaces

Desta modelo ao validarmos como a interfaces funcionam no Java8 e Java9, criou um mecanismo a interface funcional que é uma interface com um único método abstrato, chamado de funcional método. 
O código abaixo define a interface funcional NumberProcessor, que
especifica o processo do método funcional que recebe um argumento de Number e retorna um Number.
A anotação @FunctionalInterface instrui o compilador a verificar se a interface tem apenas um método abstrato.

```
@FunctionalInterface
public interface IntegerProcessor {
    Integer process(Integer x);
}
```

Se NumberProcessor contiver mais de um método abstrato, o A anotação @FunctionalInterface causaria a geração de um erro de compilação.
Neste caso a IDEs como Intellij, ja acusa um erro, No target method Found.

Mas então onde isto pode me ajudar?
A questão aqui e o poder que uma interface Funcional pode ter, pois ela alem de ter seus metodos que serão implementados, ela pode ter metodos privados e pode ter metodos default e ainda ter metodos estaticos, que pode processar algo dentro da propria interface, sem precisar pedir ajuda a meios da Herança ou poliformismo da POO.

Outro ponto interessante são que uma functional interface também pode ser implementado por uma classe anônima que fornece o método funcional. 
O código a seguir define uma classe anônima que implementa NumberProcessor. 
A implementação anônima é referenciada pela variável anonNumberProcess.

```
IntegerProcessor anonNumberProcess = new IntegerProcessor() {
    @Override
    public Integer process(Integer x)
    {
        return x * x;
    }
};

log.info(" {}",anonNumberProcess.process(10));
```

3. Static Methods in Functional Interfaces

Uma interface funcional também pode ter métodos estáticos. Métodos estáticos são úteis para definir
métodos auxiliares que não devem ser substituídos pela implementação de classes.

3.1 Implementando Interface Funcional com metodos estaticos. 

```
@FunctionalInterface
public interface IntegerProcessor {
    Integer process(Integer x);
    static Integer add(Integer x) {
        return x+x;
    }
    static Integer mult(Integer x) {
        return x*x;
    }
}

```

Testando com uma classe anonima e usando metodos estaticos.

```
@Slf4j
public class MyExecuteStaticMethod {
    public static void main(String[] args) {
        IntegerProcessor toAdd = new IntegerProcessor() {
            @Override
            public Integer process(Integer x) {
                return x + x;
            }
        };
        log.info(" {}", toAdd.process(20));

        IntegerProcessor toMult = new IntegerProcessor() {
            @Override
            public Integer process(Integer y)
            {
                return y * y;
            }
        };
        log.info(" {}", toMult.process(20));

        log.info(" {}", IntegerProcessor.add(40));
        log.info(" {}", IntegerProcessor.mult(50));
    }
}
```

Saida Console:

INFO com.wsousa.functional.features.post.MyExecuteStaticMethod -  40
INFO com.wsousa.functional.features.post.MyExecuteStaticMethod -  400
INFO com.wsousa.functional.features.post.MyExecuteStaticMethod -  80
INFO com.wsousa.functional.features.post.MyExecuteStaticMethod -  2500


4. Generic Functional Interfaces

Sabemos como funciona uso o Generic e muitas das interfaces funcionais definidas na API Java são genéricas para um ou mais tipos. 
Suponha que um programa precise de métodos que recebam dois argumentos de um tipo e retorne um resultado do mesmo tipo, mas tanto o tipo quanto a operação executada podem variar.

Pode-se definir uma interface funcional que seja genérica para o tipo N e tenha um método que aceita dois argumentos do tipo N e retorna um valor do tipo N.

```
@FunctionalInterface
public interface TwoArgsGenericsProcessor<N> {
        N process(N arg1, N arg2);
}
```

testando como usar dois argumentos em com uma interface funcional:

```
@Slf4j
public class TwoArgsGenericsProcessorTest {
    public static void main(String[] args) {
        TwoArgsGenericsProcessor<Integer> multiplyInts = new TwoArgsGenericsProcessor<>() {
            @Override
            public Integer process(Integer arg1, Integer arg2) {
                return arg1 * arg2;
            }
        };
        log.info(" {}", multiplyInts.process(12, 20));
    }
}
```

saida console:

INFO com.wsousa.functional.features.post.TwoArgsGenericsProcessorTest -  240
