# Simulador de Crédito

Este projeto é um simulador de crédito desenvolvido em Kotlin utilizando Spring Boot. Ele permite simular o valor das
parcelas de um empréstimo com base em diferentes taxas de juros e prazos.

## Requisitos

- JDK 17
- Gradle 7.5 ou superior
- IDE (IntelliJ IDEA recomendada)

## Configuração do Projeto

### Passos para Configuração

1. **Clone o repositório:**

   ```sh
   git clone https://github.com/Evandro-Alves-Dev/simulador-credito.git simulador-credito  

2. **Importe o projeto na IDE:**

    - Abra a IDE e clique em `Open or Import`.
    - Navegue até a pasta do projeto e selecione a pasta `simulador-credito`.
    - Clique em `Open as Project`.

3. **Preparar o projeto para rodar:**

    - Aguarde a IDE importar as dependências do projeto.
    - Vá até o gradle e digite o seguinte comando `gradle clean build`
    - Após buildar o projeto siga os passos abaixo para rodar o projeto.

## Como rodar o projeto

### Rodando o projeto

Rodar o projeto

```bash
mvn spring-boot:run
ou 
clicar no play no na classe SimulacaoCreditoApplication.kt

```

### Utilizando o projeto

Para usar a API e conseguir exceutar as requisições, é necessário utilizar um software de requisições HTTP, como Postman
ou Insomnia.
Deve-se chamar as rotas descritas no controller, passando os parametros necessários para a execução da mesma.
O endereço padrão é http://localhost:8080/simulador-credito/v1

## Endpoints

### POST /simulador-credito/v1/valor-parcela

POST http://localhost:8080/simulador-credito/v1/valor-parcela

Request body:
{
"valorEmprestimo": 1000.0,
"dataNascimento": "10-04-1987"
}

Response body:
[
{
"valorTotal": 19.33,
"valorTotalJuros": 13.33,
"valorParcela": 1.61,
"quantidadeParcelas": 12
},
{
"valorTotal": 36.17,
"valorTotalJuros": 30.17,
"valorParcela": 1.51,
"quantidadeParcelas": 24
},
{
"valorTotal": 54.02,
"valorTotalJuros": 48.02,
"valorParcela": 1.50,
"quantidadeParcelas": 36
},
{
"valorTotal": 72.00,
"valorTotalJuros": 66.00,
"valorParcela": 1.50,
"quantidadeParcelas": 48
},
{
"valorTotal": 90.00,
"valorTotalJuros": 84.00,
"valorParcela": 1.50,
"quantidadeParcelas": 60
},
{
"valorTotal": 126.00,
"valorTotalJuros": 120.00,
"valorParcela": 1.50,
"quantidadeParcelas": 84
}
]

### POST /simulador-credito/v1/data-nascimento

Request body:
{
"dataNascimento": "10-04-1987"
}

Response body:
[
{
"valorSolicitado": 1000.00,
"valorTotal": 3221.37,
"valorTotalJuros": 2221.37,
"valorParcela": 268.45,
"quantidadeParcelas": 12
},
{
"valorSolicitado": 2000.00,
"valorTotal": 6442.74,
"valorTotalJuros": 4442.74,
"valorParcela": 536.90,
"quantidadeParcelas": 12
},
{
"valorSolicitado": 3000.00,
"valorTotal": 9664.11,
"valorTotalJuros": 6664.11,
"valorParcela": 805.34,
"quantidadeParcelas": 12
},
{
"valorSolicitado": 4000.00,
"valorTotal": 12885.48,
"valorTotalJuros": 8885.48,
"valorParcela": 1073.79,
"quantidadeParcelas": 12
},
{
"valorSolicitado": 5000.00,
"valorTotal": 16106.85,
"valorTotalJuros": 11106.85,
"valorParcela": 1342.24,
"quantidadeParcelas": 12
},
{
"valorSolicitado": 10000.00,
"valorTotal": 32213.71,
"valorTotalJuros": 22213.71,
"valorParcela": 2684.48,
"quantidadeParcelas": 12
},
{
"valorSolicitado": 1000.00,
"valorTotal": 6028.47,
"valorTotalJuros": 5028.47,
"valorParcela": 251.19,
"quantidadeParcelas": 24
},
{
"valorSolicitado": 2000.00,
"valorTotal": 12056.94,
"valorTotalJuros": 10056.94,
"valorParcela": 502.37,
"quantidadeParcelas": 24
},
{
"valorSolicitado": 3000.00,
"valorTotal": 18085.41,
"valorTotalJuros": 15085.41,
"valorParcela": 753.56,
"quantidadeParcelas": 24
},
{
"valorSolicitado": 4000.00,
"valorTotal": 24113.87,
"valorTotalJuros": 20113.87,
"valorParcela": 1004.74,
"quantidadeParcelas": 24
},
{
"valorSolicitado": 5000.00,
"valorTotal": 30142.34,
"valorTotalJuros": 25142.34,
"valorParcela": 1255.93,
"quantidadeParcelas": 24
},
{
"valorSolicitado": 10000.00,
"valorTotal": 60284.69,
"valorTotalJuros": 50284.69,
"valorParcela": 2511.86,
"quantidadeParcelas": 24
},
{
"valorSolicitado": 1000.00,
"valorTotal": 9002.92,
"valorTotalJuros": 8002.92,
"valorParcela": 250.08,
"quantidadeParcelas": 36
},
{
"valorSolicitado": 2000.00,
"valorTotal": 18005.84,
"valorTotalJuros": 16005.84,
"valorParcela": 500.16,
"quantidadeParcelas": 36
},
{
"valorSolicitado": 3000.00,
"valorTotal": 27008.76,
"valorTotalJuros": 24008.76,
"valorParcela": 750.24,
"quantidadeParcelas": 36
},
{
"valorSolicitado": 4000.00,
"valorTotal": 36011.69,
"valorTotalJuros": 32011.69,
"valorParcela": 1000.32,
"quantidadeParcelas": 36
},
{
"valorSolicitado": 5000.00,
"valorTotal": 45014.61,
"valorTotalJuros": 40014.61,
"valorParcela": 1250.41,
"quantidadeParcelas": 36
},
{
"valorSolicitado": 10000.00,
"valorTotal": 90029.22,
"valorTotalJuros": 80029.22,
"valorParcela": 2500.81,
"quantidadeParcelas": 36
},
{
"valorSolicitado": 1000.00,
"valorTotal": 12000.27,
"valorTotalJuros": 11000.27,
"valorParcela": 250.01,
"quantidadeParcelas": 48
},
{
"valorSolicitado": 2000.00,
"valorTotal": 24000.54,
"valorTotalJuros": 22000.54,
"valorParcela": 500.01,
"quantidadeParcelas": 48
},
{
"valorSolicitado": 3000.00,
"valorTotal": 36000.80,
"valorTotalJuros": 33000.80,
"valorParcela": 750.02,
"quantidadeParcelas": 48
},
{
"valorSolicitado": 4000.00,
"valorTotal": 48001.07,
"valorTotalJuros": 44001.07,
"valorParcela": 1000.02,
"quantidadeParcelas": 48
},
{
"valorSolicitado": 5000.00,
"valorTotal": 60001.34,
"valorTotalJuros": 55001.34,
"valorParcela": 1250.03,
"quantidadeParcelas": 48
},
{
"valorSolicitado": 10000.00,
"valorTotal": 120002.68,
"valorTotalJuros": 110002.68,
"valorParcela": 2500.06,
"quantidadeParcelas": 48
},
{
"valorSolicitado": 1000.00,
"valorTotal": 15000.02,
"valorTotalJuros": 14000.02,
"valorParcela": 250.00,
"quantidadeParcelas": 60
},
{
"valorSolicitado": 2000.00,
"valorTotal": 30000.05,
"valorTotalJuros": 28000.05,
"valorParcela": 500.00,
"quantidadeParcelas": 60
},
{
"valorSolicitado": 3000.00,
"valorTotal": 45000.07,
"valorTotalJuros": 42000.07,
"valorParcela": 750.00,
"quantidadeParcelas": 60
},
{
"valorSolicitado": 4000.00,
"valorTotal": 60000.09,
"valorTotalJuros": 56000.09,
"valorParcela": 1000.00,
"quantidadeParcelas": 60
},
{
"valorSolicitado": 5000.00,
"valorTotal": 75000.11,
"valorTotalJuros": 70000.11,
"valorParcela": 1250.00,
"quantidadeParcelas": 60
},
{
"valorSolicitado": 10000.00,
"valorTotal": 150000.23,
"valorTotalJuros": 140000.23,
"valorParcela": 2500.00,
"quantidadeParcelas": 60
},
{
"valorSolicitado": 1000.00,
"valorTotal": 21000.00,
"valorTotalJuros": 20000.00,
"valorParcela": 250.00,
"quantidadeParcelas": 84
},
{
"valorSolicitado": 2000.00,
"valorTotal": 42000.00,
"valorTotalJuros": 40000.00,
"valorParcela": 500.00,
"quantidadeParcelas": 84
},
{
"valorSolicitado": 3000.00,
"valorTotal": 63000.00,
"valorTotalJuros": 60000.00,
"valorParcela": 750.00,
"quantidadeParcelas": 84
},
{
"valorSolicitado": 4000.00,
"valorTotal": 84000.00,
"valorTotalJuros": 80000.00,
"valorParcela": 1000.00,
"quantidadeParcelas": 84
},
{
"valorSolicitado": 5000.00,
"valorTotal": 105000.00,
"valorTotalJuros": 100000.00,
"valorParcela": 1250.00,
"quantidadeParcelas": 84
},
{
"valorSolicitado": 10000.00,
"valorTotal": 210000.00,
"valorTotalJuros": 200000.00,
"valorParcela": 2500.00,
"quantidadeParcelas": 84
}
]

### POST /simulador-credito/v1/quantidade-parcela

Request body:
{
"quantidadeParcelas": 12,
"dataNascimento": "10-04-1987"    
}

Response body:
[
{
"valorSolicitado": 1000.00,
"valorTotal": 3221.37,
"valorTotalJuros": 2221.37,
"valorParcela": 268.45,
"quantidadeParcelas": 12
},
{
"valorSolicitado": 2000.00,
"valorTotal": 6442.74,
"valorTotalJuros": 4442.74,
"valorParcela": 536.90,
"quantidadeParcelas": 12
},
{
"valorSolicitado": 3000.00,
"valorTotal": 9664.11,
"valorTotalJuros": 6664.11,
"valorParcela": 805.34,
"quantidadeParcelas": 12
},
{
"valorSolicitado": 4000.00,
"valorTotal": 12885.48,
"valorTotalJuros": 8885.48,
"valorParcela": 1073.79,
"quantidadeParcelas": 12
},
{
"valorSolicitado": 5000.00,
"valorTotal": 16106.85,
"valorTotalJuros": 11106.85,
"valorParcela": 1342.24,
"quantidadeParcelas": 12
},
{
"valorSolicitado": 10000.00,
"valorTotal": 32213.71,
"valorTotalJuros": 22213.71,
"valorParcela": 2684.48,
"quantidadeParcelas": 12
}
]

```