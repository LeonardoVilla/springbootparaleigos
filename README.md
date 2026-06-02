# Escola de Alunos - Sistema de CRUD com Spring Boot

Um projeto básico de Spring Boot para gerenciamento de alunos com autenticação e interface com Tailwind CSS.

## 📋 Pré-requisitos

- Java 17 ou superior ✅ (você tem Java 23.0.2)
- Maven 3.8.1 ou superior ✅ (Maven 3.9.6 instalado em C:\Maven)
- Git (opcional)

## 🚀 Como Executar

### Opção 1: Usar script batch (Windows - Mais Simples)

```bash
cd d:\repo\springboot
mvn.bat clean install
mvn.bat spring-boot:run
```

### Opção 2: Usar Maven com caminho completo

```bash
cd d:\repo\springboot
C:\Maven\apache-maven-3.9.6\bin\mvn.cmd clean install
C:\Maven\apache-maven-3.9.6\bin\mvn.cmd spring-boot:run
```

### Opção 3: Compilar e rodar JAR

```bash
cd d:\repo\springboot
mvn.bat clean package
java -jar target/escola-alunos-1.0.0.jar
```

**A aplicação será iniciada em:** 🌐 **http://localhost:8080**

**Dependências instaladas:**
- **Spring Boot 3.2.0** - Framework principal
- **Spring Data JPA** - Para manipulação de dados
- **Spring Security** - Para autenticação e autorização (BCrypt)
- **Thymeleaf** - Template engine para renderizar HTML com segurança
- **H2 Database** - Banco de dados em memória (ideal para desenvolvimento)
- **Lombok** - Para reduzir boilerplate de código (getters/setters automáticos)
- **Spring Boot DevTools** - Para reload automático durante desenvolvimento
- **Tailwind CSS** - Via CDN para estilos responsivos

## 🔑 Credenciais de Teste

O projeto cria um banco H2 em memória. Você pode:

1. **Cadastrar um novo usuário** em `/register`
2. **Fazer login** com o usuário cadastrado
3. **Gerenciar alunos** na dashboard

### Acessar Console H2

Você pode acessar o console do H2 em: **http://localhost:8080/h2-console**

- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Username:** `sa`
- **Password:** (deixar em branco)

## 📁 Estrutura do Projeto

```
src/main/java/com/escola/
├── config/              # Configurações (Security, UserDetails)
├── controller/          # Controllers (Auth, Alunos)
├── entity/             # Entidades JPA (Usuario, Aluno)
├── repository/         # Repositories (UsuarioRepository, AlunoRepository)
├── service/            # Serviços de negócio
└── EscolaAlumnosApplication.java  # Classe principal

src/main/resources/
├── templates/
│   ├── login.html      # Página de login
│   ├── register.html   # Página de cadastro
│   └── alunos/
│       ├── listar.html    # Lista de alunos
│       └── form.html      # Formulário de criar/editar
└── application.properties  # Configurações da aplicação
```

## 🎯 Funcionalidades

### Autenticação
- ✅ Registro de novo usuário
- ✅ Login com username/senha
- ✅ Logout
- ✅ Proteção de rotas (apenas usuários autenticados)

### CRUD de Alunos
- ✅ **Criar** - Cadastrar novo aluno
- ✅ **Ler/Listar** - Ver todos os alunos ativos
- ✅ **Atualizar** - Editar dados do aluno
- ✅ **Deletar** - Marcar aluno como inativo (soft delete)
- ✅ **Buscar** - Pesquisar aluno por nome

### Interface
- ✅ Responsiva com Tailwind CSS
- ✅ Validação de formulários
- ✅ Feedback visual (mensagens de sucesso/erro)

## 🔧 Tecnologias Utilizadas

| Tecnologia | Versão | Propósito |
|---|---|---|
| Java | 17+ | Linguagem principal |
| Spring Boot | 3.2.0 | Framework |
| Spring Data JPA | 3.2.0 | ORM |
| Spring Security | 3.2.0 | Autenticação |
| Thymeleaf | 3.1.1 | Template engine |
| Tailwind CSS | 3.x | CSS Framework (via CDN) |
| H2 | 2.1.214 | Banco de dados |
| Lombok | 1.18.30 | Redução de boilerplate |

## 📝 Variáveis de Ambiente

Você pode configurar via `application.properties`:

```properties
# Porta da aplicação
server.port=8080

# Banco de dados
spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true

# Thymeleaf
spring.thymeleaf.cache=false
```

## 🐛 Troubleshooting

### Erro: "Failed to start application"
```bash
mvn clean package
mvn spring-boot:run
```

### Erro: "Porta 8080 já em uso"
```bash
mvn spring-boot:run -Dserver.port=8090
```

### Dados não persistem após reiniciar
Isso é esperado! O H2 está em memória. Para usar banco permanente, mude para MySQL:

1. Instale: `spring-boot-starter-data-mysql`
2. Configure em `application.properties`

## 📚 Recursos Úteis

- [Spring Boot Docs](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Thymeleaf](https://www.thymeleaf.org/)
- [Tailwind CSS](https://tailwindcss.com/)

## 🤝 Próximos Passos

Para expandir este projeto:

1. **Adicionar validações** mais robustas
2. **Implementar paginação** na listagem
3. **Usar MySQL** ou PostgreSQL em produção
4. **Adicionar testes** unitários
5. **Adicionar relatórios** de alunos
6. **Implementar roles** de usuário (admin, professor, aluno)

---

**Criado para iniciantes em Spring Boot** 🎓
