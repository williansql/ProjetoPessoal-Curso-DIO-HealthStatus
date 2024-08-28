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
     PATIENT {
        Long id PK
        string nome
        date dateOfBirth
        string gender
        string address
        string phone
        string email
        string document
        boolean isActive
        int family_group_id fk
        int references_id fk
        int lifestyle_id fk
    }

    PRONTUARY {
        int id PK
        int patient_id fk
        date createDate
    }

     MEDICAL_EXAMINATION{
        int id PK
        int prontuary_id fk
        date examinationDate
        string typeExamination
        string result
    }

    FAMILY_GROUP {
        int id PK
        int patient_id FK
        string responsibleName
        string responsibleDocument
        string relationship
    }

    REFERENCES {
        int id PK
        int patient_id fk
        string comercialReferencedName
        string phoneComercialReferenced
        string relationshipReferencedComercial
    }

    LIFESTYLE {
        int id PK
        int patient_id fk
        string eatingHabits
        string physicalActivity
        bool smoker
    }

    USERS {
        int id PK
        string name
        role typeUser
        string login
        string password
        int prontuary_id fk
    }

    USERS ||--o{ PRONTUARY : "have"
    PRONTUARY ||--o{ MEDICAL_EXAMINATION : "have"
    PATIENT ||--o{ PRONTUARY : "have"
    PATIENT ||--o{ FAMILY_GROUP : "have"
    PATIENT ||--o{ REFERENCES : "have"
    PATIENT ||--o{ LIFESTYLE : "have"

```
# Em seguida está o fluxo do usuário do sistema para a construção e planejamento no Figma(EM CONSTRUÇÃO).

