# Desafio 8: Programação Orientada a Objetos (POO)

Este diretório contém a implementação de uma hierarquia de classes simples em Java, demonstrando os conceitos fundamentais da Programação Orientada a Objetos (POO), como classes, objetos, atributos, métodos e herança.

## Domínio Escolhido: Animais

Para este desafio, escolhemos o domínio "Animais" para modelar uma hierarquia de classes clara e intuitiva. Temos uma classe base geral `Animal` e subclasses mais específicas como `Cachorro` e `Gato`.

## Conceitos de POO Demonstrados

* **Classes:** `Animal`, `Cachorro`, `Gato`, e `AnimalMain` são os moldes para criar objetos.
* **Objetos:** Instâncias das classes, como um `gato` e um `cachorro` na classe `AnimalMain`.
* **Atributos:** Características que descrevem os objetos (ex: `nome`, `raca` em `Animal`).
* **Métodos:** Comportamentos que os objetos podem executar (ex: `caminhar()` em `Animal`, `late()` em `Cachorro`, `mia()` em `Gato`).
* **Herança:** `Cachorro` e `Gato` estendem `Animal`, o que significa que eles automaticamente herdam os atributos (`nome`, `raca`) e métodos (`caminhar()`) da classe `Animal`, promovendo reuso de código e estabelecendo uma relação "é um tipo de".

## Estrutura das Classes

### 1. `Animal.java` (Classe Base / Superclasse)

Representa um animal genérico.

```java
public class Animal {
    private String nome;
    private String raca;

    public Animal(){

    }
    
    public Animal(String nome){
        this.nome = nome;
    }

    public void caminhar(){
        System.out.println("Caminhando...");
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }    
}
```
### 2. Cachorro.java (Subclasse de Animal)
Representa um cachorro, que é um tipo de Animal. Adiciona um comportamento específico de latir.
```java
public class Cachorro extends Animal {
    public void late(){
        System.out.println("AU AU AU...");
    }
}
```
### 3. Gato.java (Subclasse de Animal)
Representa um gato, que é um tipo de Animal. Adiciona um comportamento específico de miar.
```java
public class Gato extends Animal {
    public void mia(){
        System.out.println("Miau Miau...");
    }
}
```
### 4. AnimalMain.java (Classe Principal com Método main)
Demonstra a criação de objetos e a interação com eles, chamando métodos herdados e específicos.
```java
public class AnimalMain {
    public static void main(String[] args) {
        Gato gato = new Gato();
        Cachorro cachorro = new Cachorro();

        cachorro.setNome("Paçoca");

        cachorro.caminhar();
        gato.caminhar();

        cachorro.late();
        gato.mia();
    }
}
```
# Conclusão
Este desafio ilustra a simplicidade e a eficácia da Programação Orientada a Objetos para organizar o código, promover o reuso e modelar entidades do mundo real em sistemas computacionais através de hierarquias de classes e o conceito de herança.
