# Residência TIC 18 - P003

### Questão 1
> É um evento que pode ocorrer em tempo de execução, ocasionando numa interrupção o fluxo normal das instruções, com o propósito de tratar erros ou condições singulares de forma controlada, fornecendo uma forma mais robusta e amigável ao usuário para lidar com erros, ao invés de simplesmente imterroper o programa.

### Questão 2
> Exceções verificadas são aquelas onde o programador é obrigado a tratar pelo compilador através do bloco "try-catch" ou da cláusura "throws".

```
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExcecaoTratada {
    public static void main(String[] args) {
        try {
            // Código que pode lançar uma exceção verificada
            BufferedReader reader = new BufferedReader(new FileReader("arquivo.txt"));
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
            reader.close();
        } catch (IOException e) {
            // Tratamento da exceção
            System.err.println("Erro de leitura do arquivo: " + e.getMessage());
        }
    }
}
```

> Exceções não verificadas são subclasses de "RuntimeException" onde não precisam ser tratadas obrigatoriamente pelo programador, podendo ou não serem capturadas através do bloco "try-catch".

```
public class ExcecaoNaoTratada {
    public static void main(String[] args) {
        // Código que pode lançar uma exceção não verificada
        int resultado = dividir(10, 0);
        System.out.println(resultado);
    }

    static int dividir(int a, int b) {
        // Possível exceção não verificada (ArithmeticException)
        return a / b;
    }
}
```

### Questão 3
> O tratamento de exceções em Java é feito através das palavras-chaves try, catch, finally e throws.

###### Bloco try-catch-finally:
> O bloco "try" é onde colocamos o código que pode ocasionar uma exceção, e após ele podemos utilizar um ou mais blocos "catch" para capturar exceções inerentes, onde cada um deles individualiza os tipos de exceção. Já bloco "finally" é opcional e executado independente da ocorrência de uma exceção.

###### Bloco throws:
> A palavra-chave "throws" é utilizada para declarar que determinado método pode lançar uma exceção.

### Questão 4
> Em resumo, o bloco "try-catch" é utilizado para o tratamento de exceções de forma controlada. Onde dentro do bloco "try" deve ser colocado o código que pode gerar exceções e no bloco "catch", é onde podemos especificar o tipo de exceção que se deseja capturar.

###### Importância do uso:
* Tratamento de exceções - Ajuda a evitar o encerramento do programa de forma inesperada, através de seu mecanismo estruturado.

* Controle de fluxo - Mesmo na ocorrência de uma exceção é possível controlar o fluxo do programa, dando continuidade em sua excução.

* Melhor experiência do usuário - Proporciona uma melhor exériência para o usuário em caso de erro, fornecendo um retorno mais amigável.

### Questão 5
> Exceções personalizadas são apropriadas para representar situações específicas tornando o código mais legível e facilitando o tratamento de forma mais distintiva.

###### Exemplo:
```
// Exceção personalizada para indicar que um livro está indisponível para empréstimo
class LivroIndisponivelException extends Exception {
    public LivroIndisponivelException() {
        super("O livro está indisponível para empréstimo no momento.");
    }

    public LivroIndisponivelException(String mensagem) {
        super(mensagem);
    }
}

// Classe que representa um livro na biblioteca
class Livro {
    private boolean disponivel;

    public Livro(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void emprestar() throws LivroIndisponivelException {
        if (!disponivel) {
            throw new LivroIndisponivelException();
        }
        disponivel = false;
        System.out.println("Livro emprestado com sucesso.");
    }
}

// Classe que simula um usuário tentando emprestar um livro
public class ExemploExcecaoPersonalizada {
    public static void main(String[] args) {
        Livro livro = new Livro(false); // Livro indisponível para empréstimo

        try {
            livro.emprestar();
        } catch (LivroIndisponivelException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
```