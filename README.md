# ProjetoPessoal-Curso-DIO-HealthStatus
Projeto para construir uma api e entregar no bootcamp da DEAL pela DIO, porém vou ser ousado!!!
#### Aplicação onde é realizado registro de informações básicas sobre a saúde do:
- Paciente
- Aluno de academia
- Aluno de natação
- etc...

# Fluxo de Branchs e Commits

<body>
    <p>A branch <span class="highlight">main</span> irá conter as seguintes branches:</p>
    <ul>
        <li><span class="highlight">frontend</span></li>
        <li><span class="highlight">backend</span></li>
    </ul>
    <p>Dentro das branches, haverá o <span class="highlight">first commit</span> das suas respectivas tecnologias.</p>
    <p>Para o desenvolvimento da aplicação, serão criadas duas branches a partir da branch existente <span class="highlight">frontend</span> e <span class="highlight">backend</span> com os nomes:</p>
    <ul>
        <li><span class="highlight">frontend-develop</span></li>
        <li><span class="highlight">backend-develop</span></li>
    </ul>
    <p>A partir das branches criadas da sua respectiva tecnologia, serão criadas as features necessárias para o desenvolvimento do projeto. No final da feature, quando pronta, será realizado um <span class="highlight">pull request</span> para a branch principal da sua respectiva tecnologia (<span class="highlight">backend</span> ou <span class="highlight">frontend</span>).</p>
    <p>Quando a tecnologia estiver pronta para testes, será feito um <span class="highlight">pull request</span> para a branch de <span class="highlight">homologation</span>, e, em seguida, quando estiver pronto e sem bugs, para a branch de <span class="highlight">produção</span>.</p>
</body>

```mermaid
graph TD

    A[Main]
    A --> AA[Branch frontend] --> AA1[First commit Frontend]
    A --> BB[Branch backend] --> BB1[First Commit Backend]

    AA1 --> B[Branch frontend-develop]
    B --> BBF[Commit project develop]
    BBF --> BBF1[Commits feature A]
    BBF --> BBF2[Commits feature B]
    BBF --> BBF3[Commits feature C]

    BB1 --> C[Branch backend-develop]
    C --> CCF[Commit project develop]
    CCF --> CCF1[Commits feature A]
    CCF --> CCF2[Commits feature B]
    CCF --> CCF3[Commits feature C]

    B --> HF[Homologation Frontend]
    C --> HB[Homologation Backend]
    HF --> PF[Production Frontend]
    HB --> PB[Production Backend]

```

--------------------------------------

# Abaixo está o diagrama do projeto que será utilizado para a construção da api e modelagem do banco de dados.

```mermaid
erDiagram
    PACIENTE {
        int id PK
        string nome
        date data_nascimento
        string sexo
        string endereco
        string telefone
    }

    PRONTUARIO {
        int id PK
        int paciente_id FK
        date data_criacao
        int responsavel_id FK
    }

    EXAME_MEDICO {
        int id PK
        int prontuario_id FK
        date data_exame
        string tipo_exame
        string resultado
    }

    GRUPO_FAMILIAR {
        int id PK
        int paciente_id FK
        string nome_familiar
        string relacao
    }

    REFERENCIAS {
        int id PK
        int paciente_id FK
        string nome
        string telefone
        string relacao
    }

    ESTILO_VIDA {
        int id PK
        int paciente_id FK
        string habitos_alimentares
        string atividade_fisica
        bool fumante
    }

    INFORMACOES_SAUDE {
        int id PK
        int paciente_id FK
        string historico_medico
        string alergias
    }

    USUARIO {
        int id PK
        string nome
        string tipo_usuario
        string login
        string senha
    }

    PACIENTE ||--o{ PRONTUARIO : "possui"
    PRONTUARIO ||--o{ EXAME_MEDICO : "contém"
    PACIENTE ||--o{ GRUPO_FAMILIAR : "tem"
    PACIENTE ||--o{ REFERENCIAS : "tem"
    PACIENTE ||--o{ ESTILO_VIDA : "tem"
    PACIENTE ||--o{ INFORMACOES_SAUDE : "tem"
    USUARIO ||--o{ PRONTUARIO : "registra"
```
# Em seguida está o fluxo do usuário do sistema para a construção e planejamento no Figma(EM CONSTRUÇÃO).

