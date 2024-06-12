# 🏗️ Padrões de Projeto em Java

Este repositório contém implementações de exercícios utilizando padrões de projeto em Java. Cada exercício está organizado em uma pasta específica, seguindo uma estrutura clara e fácil de navegar.

## 📁 Estrutura de Pastas

```plaintext
padroes-de-projeto
├── AbstractFactory
│   ├── Exercicio1_1
│   │   └── HelloWorld.java
│   └── Exercicio1_2
│       └── Pizzaria.java
├── Builder
│   ├── Exercicio2_1
│   │   ├── FastFood.java
│   │   └── Pedido.java
│   └── Exercicio2_2
│       └── ClienteContato.java
├── FactoryMethod
│   ├── Exercicio3_1
│   │   └── GeradorDeNomes.java
│   ├── Exercicio3_2
│   │   └── SistemaDeInformacao.java
│   └── Exercicio3_3
│       └── Contador.java
└── Singleton
    └── Exercicio4_1
        └── TesteIncremental.java
```

## 🚀 Como Rodar os Exercícios

### Pré-requisitos

- Java Development Kit (JDK) instalado
- Editor de texto ou IDE (recomendado: Visual Studio Code)

### Passos para Compilar e Executar

1. **Clone o repositório:**

   ```sh
   git clone https://github.com/seu-usuario/padroes-de-projeto.git
   cd padroes-de-projeto
   ```

2. **Abra o projeto no VS Code:**

   ```sh
   code .
   ```

3. **Navegue até o diretório do exercício que você deseja rodar.**

### Exemplos de Compilação e Execução

#### Abstract Factory - Exercicio 1.1

1. **Navegue até o diretório:**

   ```sh
   cd AbstractFactory/Exercicio1_1
   ```

2. **Compile e execute:**

   ```sh
   javac HelloWorld.java
   java HelloWorld
   ```

#### Builder - Exercicio 2.1

1. **Navegue até o diretório:**

   ```sh
   cd Builder/Exercicio2_1
   ```

2. **Compile e execute:**

   ```sh
   javac Pedido.java FastFood.java
   java FastFood
   ```

#### Factory Method - Exercicio 3.1

1. **Navegue até o diretório:**

   ```sh
   cd FactoryMethod/Exercicio3_1
   ```

2. **Compile e execute:**

   ```sh
   javac GeradorDeNomes.java
   java GeradorDeNomes "McNealy, Scott" "James Gosling" "Naughton, Patrick"
   ```

#### Singleton - Exercicio 4.1

1. **Navegue até o diretório:**

   ```sh
   cd Singleton/Exercicio4_1
   ```

2. **Compile e execute:**

   ```sh
   javac TesteIncremental.java
   java TesteIncremental
   ```

## 📚 Padrões Implementados

- **Abstract Factory**
  - Exercicio 1.1: Hello World
  - Exercicio 1.2: Pizzaria
- **Builder**
  - Exercicio 2.1: Fast-Food
  - Exercicio 2.2: Contato
- **Factory Method**
  - Exercicio 3.1: Construção de Nomes
  - Exercicio 3.2: Provedoras de Informação
  - Exercicio 3.3: Ferramenta de Log
- **Singleton**
  - Exercicio 4.1: Incremental

## 📝 Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---
