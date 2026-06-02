# Escola de Alunos - Spring Boot

Sistema CRUD de gerenciamento de alunos com autenticação, deploy no Render e banco PostgreSQL em produção.

## Tecnologias

| Tecnologia | Versão | Propósito |
|---|---|---|
| Java | 17 | Linguagem principal |
| Spring Boot | 3.2.0 | Framework |
| Spring Data JPA | 3.2.0 | ORM |
| Spring Security | 3.2.0 | Autenticação com BCrypt |
| Thymeleaf | 3.1.1 | Template engine |
| Tailwind CSS | 3.x | Estilos via CDN |
| H2 | 2.1.214 | Banco em memória (dev) |
| PostgreSQL | - | Banco de dados (prod) |
| Lombok | 1.18.30 | Redução de boilerplate |

## Funcionalidades

- Registro e login de usuários
- CRUD completo de alunos (criar, listar, editar, deletar)
- Soft delete (alunos marcados como inativos, não removidos do banco)
- Busca por nome
- Tratamento global de erros com `@ControllerAdvice`
- Interface responsiva com Tailwind CSS

## Perfis

O projeto usa dois perfis Spring:

| Perfil | Banco | Uso |
|---|---|---|
| `dev` (padrão) | H2 em memória | Desenvolvimento local |
| `prod` | PostgreSQL | Deploy no Render |

## Como Executar Localmente

Pré-requisitos: Java 17+, Maven 3.8+

```bash
mvn clean spring-boot:run
```

A aplicação sobe em **http://localhost:8080** com perfil `dev` (H2).

Console H2 disponível em `http://localhost:8080/h2-console`:
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (vazio)

## Estrutura do Projeto

```
src/main/java/com/escola/
├── config/
│   ├── SecurityConfig.java          # Spring Security
│   ├── CustomUserDetailsService.java
│   └── GlobalExceptionHandler.java  # Tratamento global de erros
├── controller/
│   ├── AuthController.java
│   └── AlunoController.java
├── entity/
│   ├── Usuario.java
│   └── Aluno.java
├── repository/
│   ├── UsuarioRepository.java
│   └── AlunoRepository.java
├── service/
│   └── AlunoService.java
└── EscolaAlumnosApplication.java

src/main/resources/
├── application.properties           # Config comum + perfil ativo
├── application-dev.properties       # H2, SQL visível, sem cache
├── application-prod.properties      # PostgreSQL via env vars
└── templates/
    ├── login.html
    ├── register.html
    ├── erro.html
    └── alunos/
        ├── listar.html
        └── form.html
```

## Deploy no Render

O projeto está configurado para deploy automático no Render via `render.yaml`.

Como o Render free tier não tem Java nativo, os scripts `render-build.sh` e `render-start.sh` instalam o OpenJDK 17 automaticamente durante o build e a inicialização.

### Variáveis de Ambiente (produção)

| Variável | Descrição |
|---|---|
| `DATABASE_URL` | URL JDBC do PostgreSQL (ex: `jdbc:postgresql://host/db`) |
| `DATABASE_USERNAME` | Usuário do banco |
| `DATABASE_PASSWORD` | Senha do banco |
| `SPRING_PROFILES_ACTIVE` | Deve ser `prod` |

### URL de Produção

https://escola-alunos-kefu.onrender.com

> O plano free "dorme" após inatividade — a primeira requisição pode demorar até 50s para acordar o serviço.

## Próximos Passos

1. Paginação na listagem de alunos
2. Roles de usuário (admin, professor)
3. Testes unitários e de integração
4. Validações mais robustas com Bean Validation
