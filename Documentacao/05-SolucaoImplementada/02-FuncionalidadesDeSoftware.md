# Funcionalidades de Software

Descrição com imagens de tela das principais funcionalidades de software do projeto e como utilizá-las.\
Para visualizar os testes de software das mesmas funcionalidades que serão descritas a seguir, clique [aqui](https://github.com/ICEI-PUC-Minas-PPLCC-TI/tiaw-ppl-cc-m-20212-aulas-particulares-2/blob/master/Documentacao/TestesUsabilidade/TestesDeSoftware.md) <br>


# Sprint 2 - Funcionalidade de Criação de Usuário e Login do Sistema
### Funcionalidade que permite a realização do login de um usuário cadastrado na plataforma
- Em qualquer página. clique no link de inscreva-se localizado na header para ser direcionado à página de cadastro
- Insira todos os seus dados nos campos de input e clique no botão de cadastrar
![Cadastro2](https://user-images.githubusercontent.com/79855405/145930745-8f9595d9-4f79-4736-9cba-63dff545f14e.png)<br>

- Após ser redirecionado para a página principal, clique no link de Login para abrir a janela PopUp
- Preencha os dados e realize o login
![cadastro2](https://user-images.githubusercontent.com/79855405/145931319-47086569-f34f-43a8-b9ea-dcf34a1df454.png) <br>

- Após logar com sucesso, você poderá ver um link para seu perfil pessoal
![cadastro 3](https://user-images.githubusercontent.com/79855405/145931393-fc1fb3dc-34a1-410b-b4f0-621972cde0f2.png) <br>

### Requisitos atendidos:
- RF-00 <br>

### Artefatos da Funcionalidade:
- index.html
- style.css
- cadastro.html
- cadastro.css
- validaemail.js
- login.js
- login.css <br> <br> <br>

# Sprint 2 - Funcionalidade de Visualização dos Perfis de Professores Cadastrados
### Funcionalidade que permite a visualização de uma lista com todos os professores cadastrados na plataforma
- Em qualquer página, clique no menu hambúrguer localizado no header e depois em "Professores"
![prof1](https://user-images.githubusercontent.com/79855405/145932406-7c4fd375-3d7c-42cb-9d98-d0a51bcc46f7.png) <br>

- Redirecionamento para página de Professores feito com sucesso
![prof2](https://user-images.githubusercontent.com/79855405/145932461-28cd007d-3b71-46be-87da-08e8ec9958f9.png) <br>

### Requisitos atendidos:
- RF-02.1 <br>

### Artefatos da Funcionalidade:
- index.html
- style.css
- professores.html (JavaScript da página imbutido dentro do HTML) <br> <br> <br>

# Sprint 3 - Funcionalidade de Edição e Exclusão do Perfil de Usuário
### Funcionalidade que permite a edição e exclusão de um perfil pessoal cadastrado na plataforma
- Em qualquer lugar do site, clique no link do seu perfil pessoal, localizado no header
![perfil1](https://user-images.githubusercontent.com/79855405/145934280-21876276-6db6-48f6-acef-a45b335880ce.png) <br>

- Será redirecionado para a página de perfil pessoal, aqui a opção de editar perfil já pode ser vista
![perfil2](https://user-images.githubusercontent.com/79855405/145934315-a0ab7e96-aecf-4db5-9447-685e6bfbb7cd.png) <br>

- Abaixo é possível visualizar a opção de apagar perfil
![perfil3apagar](https://user-images.githubusercontent.com/79855405/145934973-c9843e6b-db4c-4792-8554-333b67bc080f.png)<br>

- Clicando em Editar, o usuário é redirecionado para a página de edição do perfil
![Perfil4](https://user-images.githubusercontent.com/79855405/145934506-ac9c6104-489d-4ea7-a591-8eb92c837b55.png)
![perfil5](https://user-images.githubusercontent.com/79855405/145934520-29295930-6b39-4101-9cac-30f1a94bcaa0.png) <br>

- Após a edição, basta clicar em Concluir, e o usuário será redirecionado de volta para a nova página de perfil editada
![perfil6](https://user-images.githubusercontent.com/79855405/145934589-dd9d532b-66ec-48dd-a8fd-fb9acb940d9e.png)
![perfilfinal](https://user-images.githubusercontent.com/79855405/145934889-7a5dc2fc-5885-48c4-85cd-68b04d5e9e86.png)<br>

### Requisitos atendidos:
- RF-01 <br>

### Artefatos da Funcionalidade:
- index.html
- style.css
- login.js
- login.css
- profile.html
- profile_edit.html
- profile_edit.js <br> <br> <br>

# Sprint 3 - Funcionalidade de Busca de Perfis e Visualização de Perfil de Professor
### Funcionalidade que permite a busca de professores cadastrados na plataforma por nome, e visualização do perfil de um professor selecionado
- Em qualquer página, clique no menu hambúrguer localizado no header e depois em "Professores"
![prof1](https://user-images.githubusercontent.com/79855405/145932406-7c4fd375-3d7c-42cb-9d98-d0a51bcc46f7.png) <br>

- Redirecionamento para página de Professores feito com sucesso
- Agora o usuário deve digitar o nome do professor que deseja e realizar a busca
![busca1](https://user-images.githubusercontent.com/79855405/145936177-66e2336a-6269-41ec-8f03-2090af81f0ab.png) <br>
- A busca apresentará os resultados
![busca2](https://user-images.githubusercontent.com/79855405/145936209-89c27ee9-a113-45a3-80b1-03d00acae5c0.png) <br>
- Clicar no botão "Contratar", levará o usuário para a página de perfil do professor selecionado
![pedro1](https://user-images.githubusercontent.com/79855405/145936269-66cd88f7-6292-4be2-9c8c-000603a0e4dc.png)
![pedro2](https://user-images.githubusercontent.com/79855405/145936276-ae196308-b9df-48c6-aa67-1a1860b8c139.png) <br>
- Clicar no ícone de chat permite que o usuário seja redirecionado para um chat privado com o professor no aplicativo do WhatsApp <br>

### Requisitos atendidos:
- RF-02, RF-04 <br>

### Artefatos da Funcionalidade:
- index.html
- style.css
- login.js
- login.css
- professores.html
- perfilprofessor.html
- styleProfile.css
- Cpesquisa.js
- script.js
 <br> <br> <br>

# Sprint 3 - Funcionalidade de Cadastro de Aluno no Perfil do Professor
### Funcionalidade para inserir perfis se alunos que são ou já foram alunos de determinado professor 
- No perfil pessoal, clique em "Cadastar Aluno"
![aluno1](https://user-images.githubusercontent.com/79855405/145937189-7a2b03fd-1085-4a18-82ea-49c5b28e56ed.png) <br>
- Preencha os dados do aluno e clique em "Salvar"
![aluno2](https://user-images.githubusercontent.com/79855405/145937233-5bd66d78-0d52-446d-adf9-5634bbfbb019.png) <br>
- Aluno salvo com sucesso
![Aluno3](https://user-images.githubusercontent.com/79855405/145937253-fcd8eeef-0e22-42a2-b2f0-4d733bb28ed3.png) <br>


### Requisitos atendidos:
- RF-19 <br>

### Artefatos da Funcionalidade:
- index.html
- style.css
- login.js
- login.css
- profile.html <br> <br> <br>


# Sprint 3 - Funcionalidade de Busca de Professor por Matéria e Localização
### Realiza busca de professor utilizando como critério a matéria e a localização informados pelo usuário
- Para, realizar a busca, os campos de busca devem ser preenchidos
![buscaprof](https://user-images.githubusercontent.com/79855405/145943644-a923beb5-25bd-4cd0-9d53-0169f2113a39.png) <br>
- Os professores que atendem aos critérios da busca serão exibidos na página de busca de perfis
![buscaprof2](https://user-images.githubusercontent.com/79855405/145943728-3e0f9209-7de2-4aba-b237-b725535da927.png) <br>

### Requisitos atendidos:
- RF-03, RF-04 <br>

### Artefatos da Funcionalidade:
- index.html
- style.css
- login.js
- login.css 
- professores.html
- Cpesquisa.js <br> <br> <br>



# Sprint 3 - Funcionalidade de Dark Mode com JavaScript
### Ativa o DarkMode da página
- Para ativar, basta clicar no botão swift no canto superior direito da página
![dark1](https://user-images.githubusercontent.com/79855405/145937744-4bd8b397-1cb6-4bab-8ffc-b4fe1826a9fc.png) <br>
![dark2](https://user-images.githubusercontent.com/79855405/145937765-04390801-6533-4352-9a18-fcc6d94616f2.png) <br>


### Requisitos atendidos:
- RF-17 <br>

### Artefatos da Funcionalidade:
- index.html
- style.css
- login.js
- login.css 
- darkmode.js <br> <br> <br>


