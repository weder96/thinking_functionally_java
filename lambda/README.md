### 5. Conhecendo Lambda Expressões


Sim agora um ponto importante entender como funciona a definição Lambda Expressões:

Uma expressão lambda é usada para representar uma instrução. 
Eles foram introduzidos em Java 8 para suportar a programação funcional. A forma básica de uma expressão lambda é a seguinte:

```  
lambda_argument_list -> lambda_body
```


Isso pode ser representado pela seguinte expressão lambda:

O argumento fornecido em x, ou seja, x, torna-se o argumento para o processo do método funcional. 
Como Lambda_body contém um único expressão, diz-se que é especificada na forma de expressão. 
A expressão é avaliada e então retornado como o resultado int do processo do método. 
Neste exemplo, o Lambda_body é explicitamente especificado como a variável int x

```
x -> x
```

Vamos criar uma Interface Funcional para testar o lambda: 

```
@FunctionalInterface
public interface ProcessorLamba {
    void methodOne(int x);
}
```

Criando classe para testear o lambda:

```
@Slf4j
public class MyExecuteTestLambda {
    public static void main(String[] args) {
        ProcessorLamba lambdaAdd = x -> log.info("execute:  {}", x);
        lambdaAdd.methodOne(5);
    }
}
```

Saida console:

INFO com.wsousa.functional.features.post.MyExecuteTestLambda - execute:  5


### 6. A java.util.function


O pacote java.util.function fornece um conjunto de definições de interfaces funcionais comuns reutilizáveis (e seu lambda correspondente) que podem ser usadas pelos programadores em seu código em vez de criar novas interfaces funcionais.

As interfaces funcionais fornecem tipos de destino para expressões lambda e referências de método. 

Cada interface funcional tem um único método abstrato, chamado de método funcional para aquela interface funcional.

No Java 8, o pacote java.util.function foi incluído na API Java. Ele contém muitas interfaces funcionais projetadas para auxiliar na programação funcional. 
Esses interfaces funcionais seguem um dos quatro modelos básicos:


|Model      | Has Arguments    |Returns a Value          |Description |
|-----------|------------------|-------------------------|------------|
|Predicate  |yes               |boolean                  |Tests argument and returns true or false.|
|Function   |yes               |yes                      |Maps one type to another.|
|Consumer   |yes               |no                       |Consumes input (returns nothing).|
|Supplier   |no                |yes                      |Generates output (using no input).|



O que deixa esse pacote mais eficiente e que muitas das interfaces no pacote java.util.function são genéricas, mas em várias especializações estão disponíveis.


Vamos passar por cada uma delas além de trabalhar com outras pontos com outras interfaces Funcionais do Pacote java.util.function, exemplo UnaryOperator e todas as variações (BiConsumer, BiPredicate, BiFunction).

Cada um deles serão detalhados e terão varios exemplos reais, de como utilizar de forma ampla em um conjunto de dados a ser manipulado.


