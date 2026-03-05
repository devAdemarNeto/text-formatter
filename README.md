# 🛠️ Agente de Formatação N2

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Multi--Stage-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Render](https://img.shields.io/badge/Deploy-Render-46E3B7?style=for-the-badge&logo=render&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI%203-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)

---

## 📋 Sobre o Projeto

O **Agente de Formatação N2** é uma aplicação web desenvolvida para resolver uma **dor real do dia a dia** de um analista de suporte Help Desk no **Tribunal de Justiça do Estado do Pará (TJPA)**.

No cotidiano do suporte N2, a equipe precisa redigir chamados técnicos com formatação padronizada para escalonamento a equipes N3, substituição de equipamentos e gerenciamento de ativos no Active Directory. O processo manual é **repetitivo, propenso a erros e consome tempo** que poderia ser investido na resolução de problemas.

Esta ferramenta **automatiza a geração de textos padronizados**, garantindo consistência, agilidade e rastreabilidade em cada solicitação.

---

## 🏗️ Arquitetura — O Coração do Projeto

A aplicação segue boas práticas de mercado com uma **arquitetura em camadas** bem definida:

```
┌──────────────┐     ┌──────────┐     ┌──────────┐     ┌────────────┐     ┌──────┐
│  Controller  │────▶│   DTO    │────▶│  Mapper  │────▶│  Service   │────▶│  DB  │
│ (Thymeleaf)  │     │ (@Valid) │     │ (Manual) │     │ (Lógica)   │     │ (H2) │
└──────────────┘     └──────────┘     └──────────┘     └────────────┘     └──────┘
                                                              │
                                                       ┌──────┴──────┐
                                                       │ Repository  │
                                                       │   (JPA)     │
                                                       └─────────────┘
```

### 🗃️ Entidades JPA + Banco H2

Cada tipo de chamado é uma **entidade persistida** no banco de dados H2 em memória, com `@Id`, `@GeneratedValue` e registro automático de `dataCriacao` (`LocalDateTime`). Isso permite consultar o **histórico completo** de chamados gerados durante a sessão.

### 🔄 Camada DTO + Mappers

A aplicação **nunca expõe as entidades diretamente** nos formulários. Os dados de entrada são recebidos via **DTOs (Data Transfer Objects)**, validados e então convertidos para entidades através da classe `ChamadoMapper`, garantindo:

- **Desacoplamento** entre camada de apresentação e persistência
- **Segurança** ao não expor campos internos (como `id` e `dataCriacao`)
- **Flexibilidade** para evoluir entidades sem quebrar formulários

### ✅ Spring Validation

Todos os campos obrigatórios possuem anotações `@NotBlank` com mensagens em português nos DTOs. O controller utiliza `@Valid` + `BindingResult` para interceptar erros **antes** de qualquer processamento, exibindo feedback visual em vermelho diretamente nos formulários.

### 📖 Swagger / OpenAPI 3

A API é totalmente documentada com **SpringDoc OpenAPI**. Cada endpoint possui anotações `@Operation` e `@Tag`, gerando documentação interativa acessível via Swagger UI.

---

## 🚀 Endpoints Principais

| Método | Rota | Descrição |
|--------|------|-----------|
| `GET`  | `/` | Página inicial com menu de ferramentas |
| `GET`  | `/pje` | Formulário de escalonamento PJe |
| `POST` | `/pje/gerar` | Gera texto formatado para chamado N3 |
| `GET`  | `/monitor` | Formulário de substituição de monitor |
| `POST` | `/monitor/gerar` | Gera texto de solicitação de troca |
| `GET`  | `/remover-ad` | Formulário de remoção do Active Directory |
| `POST` | `/remover-ad/gerar` | Gera texto de remoção de equipamento |
| `GET`  | `/devolucao` | Formulário de devolução de equipamento |
| `POST` | `/devolucao/gerar` | Gera texto de devolução e retirada de inventário |
| `GET`  | `/historico` | Tabela unificada com todos os chamados gerados |

### 📚 Documentação e Ferramentas

| Recurso | URL |
|---------|-----|
| Swagger UI | `/swagger-ui/index.html` |
| OpenAPI JSON | `/v3/api-docs` |
| H2 Console | `/h2-console` |

---

## 📈 Evolução do Projeto

Este projeto **não nasceu assim**. Ele começou como um formulário HTML simples que concatenava strings — e evoluiu intencionalmente para demonstrar **maturidade técnica e domínio do ecossistema Spring**.

```
v1.0  ➜  Formulário básico com Thymeleaf + concatenação de strings
v2.0  ➜  Múltiplos módulos (PJe, Monitor, Remoção AD, Devolução)
v3.0  ➜  Validação com Spring Validation + feedback visual
v4.0  ➜  Persistência JPA + H2 + DTOs + Mapper + Histórico
v5.0  ➜  Swagger/OpenAPI + Dockerização + Deploy no Render
```

Cada versão reflete uma etapa da minha evolução como desenvolvedor — de Help Desk resolvendo problemas do dia a dia a **engenheiro de software construindo soluções com arquitetura profissional**.

---

## 🐳 Guia de Execução

### Pré-requisitos

- **Java 17** (ou superior)
- **Maven 3.8+**
- **Docker** (opcional, para build conteinerizado)

### ▶️ Rodando com Maven

```bash
# Compilar o projeto
mvn clean package -DskipTests

# Executar a aplicação
java -jar target/*.jar
```

Acesse: `http://localhost:8080`

### 🐳 Rodando com Docker

```bash
# Build da imagem
docker build -t text-formatter .

# Executar o container
docker run -p 8080:8080 text-formatter
```

Acesse: `http://localhost:8080`

### ☁️ Deploy no Render

O projeto utiliza **Multi-stage Build** no Dockerfile para otimizar o tamanho da imagem:

1. **Estágio 1 (Build):** `maven:3.9-eclipse-temurin-17` — compila o projeto
2. **Estágio 2 (Runtime):** `eclipse-temurin:17-jre-alpine` — executa apenas o JAR (~150MB)

> Configure a variável de ambiente `PORT=8080` no painel do Render.

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Finalidade |
|------------|------------|
| Java 17 | Linguagem principal |
| Spring Boot 3.4 | Framework web |
| Spring Data JPA | Persistência de dados |
| H2 Database | Banco de dados em memória |
| Thymeleaf | Template engine (SSR) |
| Spring Validation | Validação de formulários |
| SpringDoc OpenAPI | Documentação Swagger |
| Bootstrap 5 | Estilização (Dark Mode) |
| Docker | Conteinerização |
| Render | Cloud deploy |
| Maven | Gerenciamento de dependências |

---

## 👨‍💻 Autor

Desenvolvido por **Ademar Neto** — Help Desk N2 no TJPA, em transição para Desenvolvedor Java.

> *"Este projeto é a prova de que problemas reais geram as melhores soluções técnicas."*
