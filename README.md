# 📚 API de Gestão de Projetos Acadêmicos

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![H2 Database](https://img.shields.io/badge/H2-Database-orange)

## 📝 Descrição

Esta API foi desenvolvida para gerenciar **projetos acadêmicos**, **alunos**, **gestores** e **cursos**, permitindo:

* Criação, atualização e exclusão de **projetos**;
* Cadastro e atualização de **alunos**, vinculando-os a projetos;
* Criação e edição de **gestores**, associando-os aos cursos que orientam;
* Configuração de elementos do site (como textos e imagens do carrossel);
* Gestão de **cursos** e imagens relacionadas.

O banco de dados utilizado para testes é **H2**, facilitando o desenvolvimento local.

---

## ⚙️ Instalação e Execução

1. **Clone o repositório**

```bash
git clone https://github.com/usuario/api-projetos.git
cd api-projetos
```

2. **Compile e execute o projeto**

```bash
mvn spring-boot:run
```

3. **Acesse a API**

* Base URL: `http://localhost:8080`
* Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

4. **H2 Console**

* URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
* JDBC URL: `jdbc:h2:mem:testdb`
* Username: `sa`
* Password: (em branco)

---

## 🔗 Endpoints da API

### Projetos

| Método   | Rota                         | Descrição             |
| -------- | ---------------------------- | --------------------- |
| `POST`   | `/projetos/addprojetos`      | Criar projeto         |
| `GET`    | `/projetos/getprojetos`      | Listar todos projetos |
| `GET`    | `/projetos/getprojetos/{id}` | Buscar projeto por ID |
| `PUT`    | `/projetos/{id}`             | Atualizar projeto     |
| `DELETE` | `/projetos/{id}`             | Deletar projeto       |

### Alunos

| Método   | Rota                 | Descrição           |
| -------- | -------------------- | ------------------- |
| `POST`   | `/alunos/addalunos`  | Criar aluno         |
| `GET`    | `/alunos/alunos`     | Listar todos alunos |
| `GET`    | `/alunos/aluno/{ra}` | Buscar aluno por RA |
| `PUT`    | `/alunos/aluno/{ra}` | Atualizar aluno     |
| `DELETE` | `/alunos/aluno/{ra}` | Deletar aluno       |

### Gestores

| Método   | Rota                     | Descrição             |
| -------- | ------------------------ | --------------------- |
| `POST`   | `/gestores/addgestores`  | Criar gestor          |
| `GET`    | `/gestores/gestores`     | Listar todos gestores |
| `GET`    | `/gestores/gestore/{id}` | Buscar gestor por ID  |
| `PUT`    | `/gestores/gestore/{id}` | Atualizar gestor      |
| `DELETE` | `/gestores/gestore/{id}` | Deletar gestor        |

### Cursos

| Método   | Rota                | Descrição           |
| -------- | ------------------- | ------------------- |
| `POST`   | `/curso/curso`      | Criar curso         |
| `GET`    | `/curso/curso`      | Listar todos cursos |
| `GET`    | `/curso/curso/{id}` | Buscar curso por ID |
| `DELETE` | `/curso/curso/{id}` | Deletar curso       |

### Configurações do Site

| Método   | Rota                  | Descrição                  |
| -------- | --------------------- | -------------------------- |
| `POST`   | `/config/config`      | Criar configuração         |
| `GET`    | `/config/config`      | Listar todas configurações |
| `PUT`    | `/config/config/{id}` | Atualizar configuração     |
| `DELETE` | `/config/config/{id}` | Deletar configuração       |

### Carrossel de Imagens

| Método   | Rota                         | Descrição        |
| -------- | ---------------------------- | ---------------- |
| `POST`   | `/carrocel/addimagen`        | Adicionar imagem |
| `GET`    | `/carrocel/carrocel_imagens` | Listar imagens   |
| `PUT`    | `/carrocel/path/{id}`        | Atualizar imagem |
| `DELETE` | `/carrocel/path/{id}`        | Deletar imagem   |

---

## 📦 Modelos de Dados

### Projeto

```json
{
  "nomeDoProjeto": "Projeto A",
  "descricaoDoProjeto": "Descrição do projeto",
  "areaDeConhecimento": "TI",
  "dataDeInicioDoProjeto": "2025-10-10",
  "dataDoFimDoProjeto": "2025-12-10",
  "alunosParticipantesDoProjeto": ["RA123"],
  "profesorOrientador": ["Gestor1"],
  "linkGit": "https://github.com/projeto",
  "linkImage": "https://image.com/projeto.png"
}
```

### Aluno

```json
{
  "ra": "RA123",
  "emailInstitucional": "aluno@faculdade.com",
  "nome": "Aluno Exemplo",
  "curso": "ADS",
  "projetoSelecionado": "Projeto A",
  "motivoDaInscricao": "Interesse no projeto",
  "dataInscricao": "2025-10-10",
  "status": true
}
```

### Gestor

```json
{
  "name": "Prof. X",
  "descricao": "Orientador",
  "cursoResposavel": "ADS",
  "linkImagenGestor": "https://image.com/gestor.png",
  "projetos": ["Projeto A"]
}
```

### Curso

```json
{
  "nomeDoCurso": "Análise e Desenvolvimento de Sistemas"
}
```

### Configuração do Site

```json
{
  "nomeConfig": "Título do Site",
  "valorSalvo": "Meu Site Acadêmico"
}
```

### Carrossel de Imagens

```json
{
  "linkImagenCarrocel": "https://image.com/banner.png",
  "imagenAtivadaDesativada": true
}
```

---

## 🧪 Testando a API

* Utilize o **Postman** ou qualquer outro cliente REST;
* Configure o Header `Content-Type: application/json`;
* Teste cada endpoint conforme a tabela de rotas e métodos.

---

## 🧑‍💻 Autor

**Seu Nome**
Curso: **Análise e Desenvolvimento de Sistemas**
Faculdade: **Nome da Faculdade**
Email: [seu-email@faculdade.com](mailto:seu-email@faculdade.com)

---

## 🧾 Licença

MIT — Uso acadêmico e educacional.

---

## 📌 Observações

* Todos os endpoints estão protegidos para testes internos; não há autenticação implementada.
* O banco **H2** é volátil, portanto os dados não persistem após reiniciar a aplicação.
* Para produção, recomenda-se substituir o H2 por um banco relacional como **PostgreSQL** ou **MySQL**.
