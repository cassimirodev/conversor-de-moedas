# Conversor de Moedas - README

## Descrição

Este é um conversor de moedas desenvolvido em Java que utiliza a API da ExchangeRate para obter taxas de câmbio atualizadas.

## Requisitos

- Java 21 ou superior
- Chave de API da ExchangeRate

## Configuração

###  1. Clone o repositório:
   ```bash
   git clone https://github.com/cassimirodev/conversor-de-moedas.git
   cd conversor-de-moedas
   ```

### 2. Crie um arquivo `.env` na raiz do projeto com sua chave API:
   ```
   API_KEY=sua_chave_api_aqui
   ```

## Como obter uma chave API

1. Acesse o site [ExchangeRate-API](https://www.exchangerate-api.com/)
2. Registre-se gratuitamente
3. Copie a chave API fornecida

## Executando o projeto

### Usando o IntelliJ IDEA:

1. Abra o projeto no IntelliJ IDEA
2. Localize a classe `Main`
3. Clique com o botão direito e escolha "Run Main.main()"

### Usando linha de comando:

```bash
# Compilar as classes
javac -cp ".:./lib/*" -d ./out src/main/java/**/*.java

# Executar a aplicação
java -cp "./out:./lib/*" Main
```

## Recursos

- Conversão entre diferentes moedas
- Interface de usuário simples
- Taxas de câmbio atualizadas em tempo real

## Estrutura do projeto

- `src/main/java/` - Código-fonte da aplicação
- `src/main/java/utils/EnvUtils.java` - Utilitário para gerenciar a chave API
- `pom.xml` - Configuração das dependências do projeto

## Dependências

- Gson 2.13.1 - Para processamento de JSON
- dotenv-java 3.2.0 - Para gerenciamento de variáveis de ambiente

## Importante

- O arquivo `.env` com sua chave API é necessário para o funcionamento do aplicativo
- O arquivo `.env` está incluído no `.gitignore` para proteger sua chave API
- Mantenha sua chave API segura e não a compartilhe com terceiros 