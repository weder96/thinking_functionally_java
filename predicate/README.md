### 7. The Predicate Interface

Predicate é uma interface funcional cujo método funcional, denominado como   boolean test (T t), esse metodo tem como caracteristica 
avaliar uma condição em uma variável de entrada de um **tipo genérico**. 
O método de teste retorna verdadeiro se o condição é verdadeira e falsa caso contrário.


```
@FunctionalInterface
public interface Predicate<T>
{
    boolean test(T t);
   
    // some static and default methods
    ...
}
```

**Como usar um predicate?**

Um predicate sempre recebe um tipo, lembrando que tipos genericos não podem ser primitivos(int, long, float, double ...), somente Objetos, então se queremos 
declarar um predicate do tipo Integer façamos a seguinte forma: 

```    
 Predicado<Integer> pred1;
```

O método funcional da interface de teste do predicate pred1 aceitará um argumento do tipo inteiro e retornará verdadeiro se
sua condição resulta em verdadeiro.

O predicate pred1 pode ser usado para verificar se um número inteiro é maior que 20. Neste caso devemos adicionar a seguinte
instrução que usa uma **expressão lambda** para representar esta condição:

```     
pred1 = x -> x > 20;
if (pred1.test(23))
    System.out.println("Predicate x > 20 is true for x==23.");
```

desta forma vemos como o predicate se comporta, isto em exemplo simples, vamos detalhar o mesmo com niveis maiores de complexidade.

Abaixo um codigo completo de validação, nota que quando declaramos o **Predicate<Integer> pred1 = x -> x > value** , neste caso referenciamos um verificação em um numero do tipo Inteiro, neste caso estamos referenciando o Predicate, se voce estiver usando um sonarlint, ele vai acusar pra voce usar a interface Funcional mais especifica do pacote **java.util.function** que e a **IntPredicate** que e uma interface Funcional , porem não carrega um tipo Generico.

```
import lombok.extern.slf4j.Slf4j;
import java.util.function.Predicate;

@Slf4j
public class PredicateSimple {

    public static void main(String[] args) {
        Integer num1=23;
        Integer num2=5;
        Integer value=20;
        
        Predicate<Integer> pred1 = x -> x > value;
        
        if (pred1.test(num1))
            log.info("Predicate x > {} is true for x=={}.", value, num1);
        else
            log.info("Predicate x > {} is false for x=={}.", value, num1);

        if (pred1.test(num2))
            log.info("Predicate x > {} is true for x=={}.", value, num2);
        else
            log.info("Predicate x > {} is false for x=={}.", value, num2);
    }
}
```

**Passing a Predicate to a Method**

Mas quando estamos trabalhando em um projeto, em que temos que manipular dados e seguirmos as boas praticas de desenvolvimento como o S.O.L.I.D, 
neste caso na maiorias das vezes temos que passar parametros para um metodo e podemos então passar para um metodo um Predicate  e o método de teste do objeto Predicate é chamado dentro do método, assim qualquer condição associada ao Predicate será executada. 


Portanto, podemos ter um metodos que testar vários objetos Predicate forem definidos, pois todos possuem a mesma lógica pode ser aplicado a cada condição passando cada Predicate para um método.

Observer que no codigo abaixo passamos o Predicate de duas formas, a primeira o predicate depois depois de ser criado **(IntPredicate pred1 = x -> x == 5;)**, mas na segunda passamos a função lambda da teste **(y -> y%2 == 0)** que será realizado, outro ponto e que estamos usando a versão mais especializada porem você na assinatura do metodo pode passar Interface Funcional de mais Generica no caso **(Predicate<Integer> pred)**.

```
@Slf4j
public class PredicateArgMethods {
    public static void checkPredicate(IntPredicate pred, Integer num) {
        if (pred.test(num))
            log.info("The Predicate is true for {} " , num);
        else
            log.info("The Predicate is false for " + num);
    }
    public static void main(String[] args) {
        IntPredicate pred1 = x -> x == 5;
        checkPredicate(pred1, 5);
        checkPredicate(y -> y%2 == 0, 5);
    }
}
```

Saida Console:
INFO com.wsousa.functional.features.predicate.PredicateArgMethods - The Predicate is true for 5 
INFO com.wsousa.functional.features.predicate.PredicateArgMethods - The Predicate is false for 5


Mas sempre vem aquela questão se estou trabalhando com algo generico será que posso especializar até o meu metodo?
Sim, pois este e a missão do Generics, deixar algo que possa ser reutilizado não importa o tipo que será passado exemplo:

```
public static <T> void checkPredicate(Predicate<T> pred, T arg)
```

Porém neste caso não podemos declarar a especifica pois o metodo precisa saber qual o tipo que foi declarado.

```
@Slf4j
public class PredicateArgGenerics {
    public static <T> void checkPredicate(Predicate<T> pred, T arg) {
        if (pred.test(arg))
            log.info("The Predicate is true for {} " , arg);
        else
            log.info("The Predicate is false for " + arg);
    }
    public static void main(String[] args) {
        Predicate<Integer> pred1 = x -> x == 5;
        Predicate<String> pred2 = s -> s.startsWith("W");
        checkPredicate(pred1,5);
        checkPredicate(pred2, "Weder");
    }
}

```

Outro ponto a ser observado nesta abordagem e que podemos passar o proprio lambda do teste, no caso se passarmos um lambda de checagem de string e passarmos um numero e mesmo será lanaçado um erro.


### **Creates Complex Logical Expressions**

Vamos evoluir nossos exemplos, criamos para facilitar 

no meu [github](https://github.com/weder96) , criei um [repositorio](https://github.com/weder96/thinking_functionally_java/tree/main/functional/src/main/java/com/wsousa/functional/features/repo), com dados que serão manipulados, lembrando que a dados mais completos no git aqui somente uma definição base:


|name (String) |qtyEmployee(Integer) |marketValue (BigDecimal) | positionRanking(Integer) | branch(boolean) | location (String) | departament (List<String>) | address(Address)|
|--------------|---------------------|-------------------------|--------------------------|-----------------|-------------------|----------------------------|-----------------|
|Apple | 92600 | 2200000000000.00 | 1 | false | USA | "Streaming", "Personal Computer", "Smartphones", "System Operational Mac", "System Operational IOS" | |
|Microsoft  | 166000 | 1865000000000.00 | 2 | false | USA | "System Operational Windows", "Cloud Computing", "Social Network Linkedin" | |
|Amazon | 613000  | 1591000000000.00 | 3 | false | USA | "Cloud Computing", "e-commerce", "Invest Startups"||
|Alphabet Inc| 85050|1505000000000.00| 4|false|USA|"Search Web Google", "System Operational Android", "Cloud Computing"||
|Facebook |48000|852000000000.00| 5| false|USA|"Social Network Facebook", "Social Network Instagram", "Social Network WhatsApp"||
|Tencent|54309|731000000000.00| 6|false|CHI|"Games League of Legends", "Games Fortnite", "Network Chineses", "Web Services","Smartphones"||
|Alibaba| 34985| 636000000000.00| 7|false| CHI|"e-commerce", "digital midia"||
|Samsung| 17400| 320.000.00|  8|  false| KOR| "Eletronic", "Personal Computer", "Smartphones"| | 


Os dados se referem as maiores empresas de tecnologias do mundo, contendo dados que nos ajudará a entender como a programação funcional, pode nos ajudar em cada caso, então vamos ao primeiro:

Queremos listar as empresas que possuem 140.000 funcionarios ou mais, usando um Predicate, criado abaixo.


```
static Predicate<Company> predQtyEmployee = comp -> comp.getQtyEmployee() >= 140000;

```

Entendendo o mesmo , neste caso a um atributo no nossoObjeto Company que trata a quantidade de Funcionarios de cada empresa, assim definimos a expressão lambda do teste.

Abaixo o codigo total do teste **test**:

```
@Slf4j
public class PredicateFilterCompany {
	
	static Predicate<Company> predQtyEmployee = comp -> comp.getQtyEmployee() >= 140000;

	public static void main(String[] args) {
		List<Company> companies = CompanyRepository.getAllCompanies();
		List<Company> companiesFilters =
				companies.stream()
				.filter(predQtyEmployee)
				.collect(Collectors.toList());

		companiesFilters.forEach(company -> log.info("filter Stream {}", company));
	}
}

```

Primeiro buscamos todos as empresas criada no nosso repositorio, depois criamos desta lista um **stream**, dentro do package java.util.stream; tem um metodo chamado filter, abaixo a assinatura dele , no qual recebe um Predicate, o legal e que dentro do filter ele proprio sabe que tem que chamar o **test**

```
 Stream<T> filter(Predicate<? super T> predicate);
```

e posteriormente a variavel **companiesFilters** recebe essa lista e logo percorremos essa lista com o metodo forEach da Lista.

Saida Console:

INFO com.wsousa.functional.features.predicate.PredicateFilterCompany - filter Stream Company(name=Microsoft, creationDate=1975-04-04, qtyEmployee=166000,..
INFO com.wsousa.functional.features.predicate.PredicateFilterCompany - filter Stream Company(name=Amazon, creationDate=1994-07-05, qtyEmployee=613000, ...

Observação: devido ao tamanho do log o mesmo foi abreviado entenda que possui mais dados


Outro exercicio para entender, vamos agora buscar as empresas que possui mais de 140.000 funcionarios, mas estão entre as 2 mais bem colocadas no ranking.
Neste caso vou criar um processo que pode ser feito mas não fica 100% legal. mas funciona:

```
@Slf4j
public class PredicateFilterFilterCompany {
	static Predicate<Company> predQtyEmployee = per -> per.getQtyEmployee() >= 140000;
	static Predicate<Company> predPositionRanking = per -> per.getPositionRanking() <= 2;

	public static void main(String[] args) {
		List<Company> companies = CompanyRepository.getAllCompanies();
		List<Company> companiesFilters =
				companies.stream()
						.filter(predQtyEmployee)
						.filter(predPositionRanking)
						.collect(Collectors.toList());

		companiesFilters.forEach(company -> log.info("filter(F) Stream {}", company));
	}
}
```
Saida Console:
INFO com.wsousa.functional.features.predicate.PredicateFilterFilterCompany - filter(F) Stream Company(name=Microsoft, creationDate=1975-04-04, ...


Note que depois do Stream, chamos dois filtros , um para **predQtyEmployee** e outro **predPositionRanking**, dois predicates , que nos retornam somente uma empresa como visto na saida do console.

Outras formas de resolver o mesmo problema:
Solução 01:

```
List<Company> companiesFilters =
				companies.stream()
				         .filter(predQtyEmployee.and(predPositionRanking)::test)
						 .collect(Collectors.toList());

```

Na solução 1, dentro do Filter chamamos o **and** do predicate passando o outro Predicate e chamando o metodo **test**.

Solução 02:

```
companies.forEach(company -> {
			if(predQtyEmployee.and(predPositionRanking).test(company))
				log.info("filter(F3) Stream {}", company);
		});
```

Lembrando que aqui somente estamos detalhando formas de usar o Predicate, o que importa no caso e o **test**.

Outro ponto e que podemos ter mais de uma checagem exemplo:

pred1.and(pred2)   // second
     .and(pred3)   // third
     .and(pred4)   // fourth
     .test(5);     // first


Sabendo que o **Predicate** tem um metodo **and**, penso que também tem um metodo **or** e a resposta e sim , sendo usado da mesma forma que detalhamos o **and**,sendo os dois metodos defaults desta Interface Funcional. 

Assim chegamos a outro ponto e negar uma condição usando o Predicate, Oh! existe um  metodos defaults chamado **negate**, que detalharemos abaixo.


### Negate the ! Operation

O método negate padrão da interface Predicate reverte o resultado do atual predicado:

```
default Predicate<T> negate();
```

Um exemplo simples:

```
@Slf4j
public class PredicateNegateSimple {

	static Predicate<Integer> pred1 = num -> num > 25;

	public static void main(String[] args) {
		log.info("{} ", pred1.negate().test(30));
	}
}
```

Saida console:
INFO com.wsousa.functional.features.predicate.PredicateNegateSimple - false

Neste caso ao analisar o numero 30 e maior que 25, porem a negativa, faz com que a resposta no console, seja **false**.

Usando o **negate**, na empresa, queremos todas as empresas que não são localizadas nos **USA**, desta forma ja temos um Predicate, especifico para essa
checagem, então no filter você so precisa negar o Predicate como visto no codig abaixo:

```
@Slf4j
public class PredicateNegateCompany {

	static Predicate<Company> predLocationUSA = per -> per.getLocation().contains("USA");
	public static void main(String[] args) {
		List<Company> companies = CompanyRepository.getAllCompanies();
		List<Company> companiesFilters = companies.stream()
												  .filter(predLocationUSA.negate())
												  .collect(Collectors.toList());

		companiesFilters.forEach(company -> log.info("filter location {}", company));
	}
}
```
Saida console:

INFO com.wsousa.functional.features.predicate.PredicateNegateCompany - filter location Company(name=Tencent, creationDate=1998-11-11, qtyEmployee=54309, ...
INFO com.wsousa.functional.features.predicate.PredicateNegateCompany - filter location Company(name=Alibaba, creationDate=1999-06-28, qtyEmployee=34985, ...

A mais achei esse codigo com muitas variaveis, não da pra reduzir esse codigo nâo, vamos tentar:

```
@Slf4j
public class PredicateNegateCompany {

	static Predicate<Company> predLocationUSA = per -> per.getLocation().contains("USA");
	public static void main(String[] args) {
		CompanyRepository.getAllCompanies()
						 .stream()
						 .filter(predLocationUSA.negate())
						 .forEach(company -> log.info("filter location {}", company));
	}
}
```

Os dois codigo funcionam, da mesma forma, somente retiramos as variaveis, gosto da forma com variaveis para aqueles que são iniciantes, compreenderem, cada etapa, isso facilita o aprendizado e logo consegue entender que pode aglutinar todos os passos em um só processo.
Na Interface Funcional Predicate ainda temos outros dois metodos static que são **isEqual**, e o **not** o not não iremos detalhar o mesmo pois ele chama o **negate** por debaixo dos panos que sabemos que por sua ver e nada mais que **!test()**;
Então o isEqual tem no corpo do metodo:

```
static <T> Predicate<T> isEqual(Object targetRef) {
        return (null == targetRef)
                ? Objects::isNull
                : object -> targetRef.equals(object);
}
```

Lembrando que **isEqual**, e o **not**, são metodos estaticos, o que dificulta o uso, no caso do isEquals no modo simples e tranquilo e mesmo assim acho muito codigo:

```
@Slf4j
public class PredicateIsEqualsSimple {
	public static void main(String[] args) {
		Predicate<Integer> p2 = Predicate.isEqual(25);
		if (p2.test(25))
			System.out.println("The Predicate is true");
	}
}
```

Podemos usar uma aglutinação entre os metodos **and** e **not**, fazendo, que nos da a dimensão de como usar o **not**,

```
@Slf4j
public class PredicateAndNotExample {
	public static void main(String[] args) {
		Predicate<Integer> pred1 = num -> num > 25;
		log.info("{} ", pred1.and(Predicate.not(num -> num%2 == 1)).test(30) );
	}
}
```
saida console:

INFO com.wsousa.functional.features.predicate.PredicateAndNotExample - true

No codigo primeiro verificamos se o numero e maior que 25 e no segundo Predicate se o mesmo e impar, porem o not inverte a resposta, no caso.


E no caso se o objeto e aser testado for null?

```
@Slf4j
public class PredicateTestNullExample {
	static Predicate<String> startPosition = str -> str.length() > 4;
	static Predicate<String> endPosition = str ->str.length() < 10;
	public static void main(String[] args) {
		try {
			log.info(" {}",startPosition.and(endPosition).test(null));
		}
		catch (NullPointerException e) {
			log.info("catch NullPointerException");
		}
	}
}
```
saida console:

INFO com.wsousa.functional.features.predicate.PredicateTestNullExample - catch NullPointerException


### 8. Especializações dos Predicates

A API java.util.function fornece IntPredicate, LongPredicate e LongPredicate, sendo um diferencial como mostrado anteriormente não possui genérico.

se olharmos a documentação da API esta descrito abaixo:

Represents a predicate (boolean-valued function) of one int-valued argument. This is the int-consuming primitive type specialization of Predicate.
This is a functional interface whose functional method is test(int).
Since: 1.8
See Also: Predicate

Porem as Interfaces DoublePredicate conseguem testar outros tipos com(Integers, Longs e Doubles) respectivamente. 

Essas interfaces fornecem versões especializadas do Predicado genérico interface, uma vez que especificam test, or, and, e negate métodos que se comportam da mesma forma forma como Predicado, neste caso elas não possuem os metodos estaticos, somente os metodos defaults e seu metodo funcional(**test**);

```
IntPredicate predInt = numInt -> numInt > 25;
LongPredicate predLong = numLong -> numLong%2 == 10;
DoublePredicate predDouble = numDouble -> numDouble > 18.0;
```


### 9. Binary Predicates (BiPredicate) 

Geralmente é útil criar um único predicado de dois tipos diferentes, porem prefiro criar dois Predicate e usar os mesmo com o and do mesmo, pois somente podemos criar um predicate com um unico tipo e no caso do BiPredicate temos outra opção. 
O BiPredicado interface especifica dois parâmetros (Genericos) que podemos definir com tipos iguais ou diferentes(tanto faz), falamos nisto na parte de Generics.

```
@FunctionalInterface
public interface BiPredicate<T, U>
{
    boolean test(T t, U u);
    // other default methods
    ...
}
```

Abaixo um exemplo simples:

```
@Slf4j
public class BiPredicateSimple {
	static BiPredicate<String, Integer> biPred = (str, num) -> str.equals("Developer") && num > 80000;
	public static void main(String[] args) {
		String position = "Developer";
		int salary = 100000;
		log.info("test: {} ",biPred.test(position,salary));
	}
}
```

Um exemplo mais complexo usando nosso modelo de Empresas:

```
@Slf4j
public class BiPredicateCompany {
	static BiPredicate<Company, Company> biPredQtyEmployeePositionRanking  = (comp1, comp2) -> comp1.getQtyEmployee() >= 140000 && comp2.getPositionRanking() <= 2;
	public static void main(String[] args) {
		CompanyRepository.getAllCompanies()
				.stream()
				.filter(company -> biPredQtyEmployeePositionRanking.test(company, company))
				.forEach(company -> log.info("filter(BiPredicate) {}", company));
	}
}

```

Saida console:

INFO com.wsousa.functional.features.bipredicate.BiPredicateCompany - filter(BiPredicate) Company(name=Microsoft, creationDate=1975-04-04, qtyEmployee=166000, ...










