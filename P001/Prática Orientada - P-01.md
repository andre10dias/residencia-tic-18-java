# Prática Orientada – PO-01

## Questão 1:	
> Classes e Objetos

Classe é o modelo, é o bloco de construção, é o planejamento. É um tipo de dado definido pelo programador, que contém seus próprios membros de dados (atributos) e funções de membro (métodos), onde é definido onde é definido as características básicas e comportamentos que podem ser acessados e utilizados através de uma instância dessa classe (objeto).

Objeto é uma instância de uma classe através do qual todos os membros de dados e funções de membro podem ser acessados. Ao definirmos uma classe nenhuma memória é alocada, isso ocorre apenas quando ela é instanciada, quando um objeto é criado.

> Exemplos de classes em C++
##### Classe "Livro" com o atributo "numeroPaginas", construtores, destrutor e métodos "get" e "set".
```
class Livro
{
    private:
        int numeroPaginas;

    public:
        Livro(int _numeroPaginas);
        Livro(/* args */);
        ~Livro();
        int getNumeroPagianas();
        void setNumeroPagianas(int _numeroPagianas);
};

Livro::Livro(int _numeroPaginas)
{
    numeroPaginas = _numeroPaginas;
}

Livro::Livro(/* args */)
{
}

Livro::~Livro()
{
}

int Livro::getNumeroPagianas() {
    return numeroPaginas;
}

void Livro::setNumeroPagianas(int _numeroPagianas) {
    numeroPaginas = _numeroPagianas;
}
```
##### Classe "Dvd" com o atributo "duracao", construtores, destrutor e métodos "get" e "set".
```
class Dvd
{
    private:
        int duracao;

    public:
        Dvd(int _duracao);
        Dvd(/* args */);
        ~Dvd();
        int getDuracao();
        void setDuracao(int _duracao);
};

Dvd::Dvd(/* args */)
{
}

Dvd::Dvd(int _duracao)
{
    duracao = _duracao;
}

Dvd::~Dvd()
{
}

int  Dvd::getDuracao() {
    return duracao;
}

void Dvd::setDuracao(int _duracao) {
    duracao = _duracao;
}
```
##### Classe "Animal" com os atributos "nome" e "idade", construtor, destrutor e método "fazerSom".
```
class Animal
{
    private:
        string nome;
        int idade;

    public:
        Animal(/* args */);
        ~Animal();
        void fazerSom();
};

Animal::Animal(/* args */)
{
}

Animal::~Animal()
{
}

void Animal::fazerSom() 
{
}
```
##### Classe "Cachorro" extendendo a classe "Animal" e sua implementação do método "fazerSom" (Polimorfismo).
```
class Cachorro : Animal
{
    private:
        /* args */
    public:
        Cachorro(/* args */);
        ~Cachorro();
        void fazerSom();
};

Cachorro::Cachorro(/* args */)
{
}

Cachorro::~Cachorro()
{
}

void Cachorro::fazerSom() 
{
    cout << "\nAu, au!\n";
}
```
##### Classe "Gato" extendendo a classe "Animal" e sua implementação do método "fazerSom" (Polimorfismo).
```
class Gato: Animal
{
    private:
        /* args */
    public:
        Gato(/* args */);
        ~Gato();
        void fazerSom();
};

Gato::Gato(/* args */)
{
}

Gato::~Gato()
{
}

void Gato::fazerSom() 
{
    cout << "\nMiau, miau!\n";
}
```
> Exemplos de classe em Java
##### Classe "Livro" com o atributo "numeroPaginas", construtores e métodos "get" e "set".
```
public class Livro {
	
	private int numeroPaginas;

	public Livro() {
		// TODO Auto-generated constructor stub
	}
	
	public Livro(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(int numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

}
```
##### Classe "Dvd" com o atributo "duracao", construtores e métodos "get" e "set".
```
public class Dvd {
	
	private int duracao;

	public Dvd() {
		// TODO Auto-generated constructor stub
	}
	
	public Dvd(int duracao) {
		this.duracao = duracao;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

}
```
##### Classe "Animal" com os atributos "nome" e "idade", construtor e método "fazerSom".
```
public class Animal {
	
	private String nome;
	private int idade;

	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public Animal(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public void fazerSom() {
	}

}
```
##### Classe "Cachorro" extendendo a classe "Animal" e sua implementação do método "fazerSom" (Polimorfismo).
```
public class Cachorro extends Animal {

	public Cachorro() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fazerSom() {
		System.out.println("Au, au");
	}

}
```
##### Classe "Gato" extendendo a classe "Animal" e sua implementação do método "fazerSom" (Polimorfismo).
```
public class Gato extends Animal {

	public Gato() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void fazerSom() {
		System.out.println("Miau, miau");
	}

}
```
## Questão 2:

> Declarando variáveis em C++
```
private:
        string nome;
        int idade;
```
> Tipos de dados mais comuns em C++
```
int
long
bool
float
double
string
```
> Declarando variáveis em Java
```
private String nome;
private int idade;
```
> Tipos de dados mais comuns em Java
```
int
long
boolean
float
double
String
```
## Questão 3
> Herança

Herança é um conceito de Programação Orientada a Objeto (POO), através do qual é possível construir objetos especializados que herdam as características de objetos generalistas. Em outras palavas, ela permite que classes compartilhem métodos e atributos, possibilitando o reaproveitamento de código e/ou comportamentos.
> Exemplo de herança C++
##### Superclasse "Forma" e subclasses "Retangulo" e "Circulo"
```
class Forma
{
    private:
        /* data */

    public:
        Forma(/* args */);
        ~Forma();
        double calcularArea();
};

Forma::Forma(/* args */)
{
}

Forma::~Forma()
{
}
```
```
class Retangulo : public Forma
{
    private:
        double base, altura;

    public:
        Retangulo(double _base, double _altura);
        Retangulo(/* args */);
        ~Retangulo();
        double getBase();
        void setBase(double _base);
        double getAltura();
        void setAltura(double _altura);
        double calcularArea();
};

Retangulo::Retangulo(double _base, double _altura)
{
    base = _base;
    altura = _altura;
}

Retangulo::Retangulo(/* args */)
{
}

Retangulo::~Retangulo()
{
}

double Retangulo::getBase() {
    return base;
}

void Retangulo::setBase(double _base) {
    base = _base;
}

double Retangulo::getAltura() {
    return altura;
}

void Retangulo::setAltura(double _altura) {
    altura = _altura;
}

double Retangulo::calcularArea() {
    return base * altura;
}
```
```
class Circulo : public Forma
{
    private:
        double raio;

    public:
        const double PI = 3.14;
        Circulo(double raio);
        Circulo(/* args */);
        ~Circulo();
        double getRaio();
        void setRaio(double _raio);
        double calcularArea();
};

Circulo::Circulo(double _raio)
{
    raio = _raio;
}

Circulo::Circulo(/* args */)
{
}

Circulo::~Circulo()
{
}

double Circulo::getRaio() {
    return raio;
}

void Circulo::setRaio(double _raio) {
    raio = _raio;
}

double Circulo::calcularArea() {
    return PI * pow(raio, 2);
}
```
> Exemplo de herança Java
##### Superclasse "Automovel" e subclasses "Onibus" e "CarroPasseio"
```
public class Automovel {
	
	String marca;
	String modelo;

	public Automovel() {
		// TODO Auto-generated constructor stub
	}
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void tipoCombustivel() {
		
	}

}
```
```
public class Onibus extends Automovel {

	public Onibus() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMarca() {
		// TODO Auto-generated method stub
		return super.getMarca();
	}

	@Override
	public void setMarca(String marca) {
		// TODO Auto-generated method stub
		super.setMarca(marca);
	}

	@Override
	public String getModelo() {
		// TODO Auto-generated method stub
		return super.getModelo();
	}

	@Override
	public void setModelo(String modelo) {
		// TODO Auto-generated method stub
		super.setModelo(modelo);
	}

	@Override
	public void tipoCombustivel() {
		// TODO Auto-generated method stub
		super.tipoCombustivel();
	}

}
```
```
public class CarroPasseio extends Automovel {

	public CarroPasseio() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMarca() {
		// TODO Auto-generated method stub
		return super.getMarca();
	}

	@Override
	public void setMarca(String marca) {
		// TODO Auto-generated method stub
		super.setMarca(marca);
	}

	@Override
	public String getModelo() {
		// TODO Auto-generated method stub
		return super.getModelo();
	}

	@Override
	public void setModelo(String modelo) {
		// TODO Auto-generated method stub
		super.setModelo(modelo);
	}

	@Override
	public void tipoCombustivel() {
		// TODO Auto-generated method stub
		super.tipoCombustivel();
	}

}
```
## Questão 4

Ao declararmos uma variável em Java, estamos, na verdade, de forma implícita declarando ponteiros, pois toda alteração sofrida por ela será refletida em toda a aplicação. 
Já em C++, as variáveis podem ser modificadas no código, por valor ou por referência de forma explícita.