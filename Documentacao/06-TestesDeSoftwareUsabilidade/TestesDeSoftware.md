# Testes de software

#### Requisitos para realização do teste:

- Aparelho desktop ou mobile com acesso à internet
- Site publicado na Internet
- Navegador de Internet - Preferencialmente, Chrome, Edge ou Firefox

#### Os testes a seguir tem como finalidade testar o funcionamento dos principais requisitos funcionais do projeto <br><br>

## Funcionalidade de Login do Sistema

| # | Cenário                    | Requisito Funcional | Ações                                                                                                                                                                                                    | Resultados Esperados                                                                                                                                                                                                              |
|---|----------------------------|---------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1 | Registro de usuário OK     | RF-00               | ⦁	Clicar no botão de Inscreva-se<br> ⦁	Informar os dados de usuário conforme orientações da tela<br>  ⦁	Confirmar o registro do usuário<br>  ⦁	Efetuar o login com as informações registradas                           | ⦁	Os dados do usuário devem ser registrados no Local Storage<br>  ⦁	Usuário encaminhado para página principal<br>  ⦁	Após a confirmação de cadastro, o sistema deve apresentar uma tela informando que o usuário foi cadastrado com sucesso. |
| 2 | Registro de usuário NÂO OK | RF-00               | ⦁	Clicar no botão de Inscreva-se<br>  ⦁	Informar os dados de usuário, mas não informar senhas e e-mail<br>  ⦁	Confirmar o registro do usuário                                                                       | ⦁	Após a confirmação de cadastro,  o sistema deve apresentar uma tela de erro informando que é obrigatório informar no mínimo, senhas e e-mail para a realização do cadastro.                                                      |
| 3 | Registro de usuário NÂO OK | RF-00               | ⦁	Clicar no botão de Inscreva-se<br>  ⦁	Informar os dados de usuário conforme orientações da tela<br>  ⦁	Informar senhas diferentes nos campos “senha” e “Insira senha novamente”<br>  ⦁	Confirmar o registro do usuário | ⦁	Após a confirmação de cadastro,  o sistema deve apresentar uma tela de erro informando que as senhas informadas não conferem.                                                                                                    |
| 4 | Login OK                   | RF-00               | ⦁	Acessar opção de login popup<br>  ⦁	Informar um login e senha corretos<br>  ⦁	Confirmar a validação<br>  ⦁	Aguardar o resultado                                                                                        | ⦁	Os dados do usuário corrente devem ser registrados no Session Storage<br>  ⦁	Após a confirmação de login, o sistema deverá direcionar o usuário para uma página inicial de usuário logado.                                            |
| 5 | Login NÂO OK               | RF-00               | ⦁	Acessar tela de login<br>  ⦁	Informar login e/ou senha incorretos<br>  ⦁	Confirmar a validação<br>  ⦁	Aguardar o resultado                                                                                             | ⦁	Após a confirmação de login, o sistema deve apresentar uma tela informando que a senha do usuário está incorreta.                                                                                                                |
| 6 | Login NÂO OK               | RF-00               | ⦁	Acessar tela de login<br>  ⦁	Deixar campos de login e/ou senha em branco<br>  ⦁	Confirmar a validação<br>  ⦁	Aguardar o resultado                                                                                      | ⦁	Após a confirmação de login, o sistema deve apresentar uma tela informando que as senhas informadas não conferem.                                                                                                                |
| 7 | Controle de Sessão         | RF-00               | ⦁	Efetuar o login de um usuário cadastrado<br>  ⦁	Acessar as outras páginas da plataforma<br>  ⦁	Atualizar a página via refresh do browser (F5)                                                                     | ⦁        A página deve apresentar o nome do usuário logado logo após o processo de login e também após o refresh da página, além disso, a página também deve mostrar uma opção de logout.                                         |
| 8 | Logout                     | RF-00               | ⦁	Efetuar o login de um usuário cadastrado<br>  ⦁	Acessar opção de logout em qualquer uma das páginas                                                                                                          | ⦁	Os dados do usuário corrente devem ser retirados no Session Storage<br>  ⦁	Após a confirmação do logout, o sistema deve deslogar o usuário da plataforma e retornar para a página principal.                                          |


## Funcionalidade Template da Página Principal

| # | Cenário          | Requisito Funcional | Ações                                                                                                                                                                                                                           | Resultados Esperados                                                                                                 |
|---|------------------|---------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------|
| 1 | Tela Inicial OK  | RF-18, RF-03               | ⦁        Checar Menu no canto superior esquerdo<br> ⦁        Checar apresentação das principais matérias oferecidas<br> ⦁        Apresentar localizações<br> ⦁        Checar instruções das diferentes formas de como contatar um professor | ⦁        Todas as ações checadas devem estar disponíves, e a página deve estar completamente responsiva e interativa |
| 2 | Tela Contatos OK | RF-18               | ⦁        Acessar Tela de Contato pela barra de navegação<br> ⦁        Checar se as instruções de contato são apresentadas corretamente                                                                                               | ⦁        Todas as ações checadas devem estar disponíves, e a página deve estar completamente responsiva e interativa |
| 3 | Tela Equipe OK   | RF-18               | ⦁        Acessar Tela da Equipe pela barra de navegação<br> ⦁        Checar se as informações da equipe são apresentadas corretamente                                                                                              | ⦁        Todas as ações checadas devem estar disponíves, e a página deve estar completamente responsiva e interativa |


## Funcionalidade de Visualização dos Perfis de Professores Cadastrados

| # | Cenário                        | Requisito Funcional | Ações                                                                                                                                                                                                                                                                                                                                                                                                 | Resultados Esperados                                                                                                                                                                                                       |
|---|--------------------------------|---------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1 | Página inicial                 | RF-02.1             | ⦁	Clicar no ícone ao lado da Logo<br>  ⦁	Clicar na aba de professores                                                                                                                                                                                                                                                                                                                                       | ⦁        Após selecionar a aba de professores, será redirecionados para a página que mostrará todos os professores cadastrados, sendo que, caso seja a primeira vez que entre, não irá mostrar nenhum professor            |
| 2 | Página de professores vazia    | RF-02.1             | ⦁	Clicar no botão de teste<br>  ⦁	Caso a página não carregue sozinha, apertar F5 para recarregá-la                                                                                                                                                                                                                                                                                                          | ⦁        Após clicar no botão de teste, irá carregar os perfis de teste dos professores no localStorage e recarregar a página para mostrá-los. Caso queira adicionar um professor manualmente, basta criar um novo usuário |
| 3 | Página de professores completa | RF-02.1             | ⦁	Verificar se as informações estão formatadas e funcionais<br>  ⦁	Clicar no botão de contratar ao lado direito de cada usuário para ser redirecionado para a página individual de cada um                                                                                                                                                                                                                  | ⦁	Com todos os usuários padrões e personalizados carregados, será possível verificar cada um individualmente em uma página separada.                                                                                        |
| 4 | Perfil do Professor            | RF-02.1             | ⦁	Verificar se as informações individuais de cada usuário condiz com as informações do mesmo na página anterior<br>  ⦁	Nota: Algumas informações estão apenas como placeholder, como as fotos de perfil<br>  ⦁	É possível clicar no ícone de chat para ser redirecionado para uma conversa em particular via Whatsapp<br>  ⦁	Os botões laterais que estão habilitados, te direcionam para a sessão indicada do perfil | ⦁	Cada perfil individual deve ter suas informações separadas, como o nome, matérias, número de contato, etc...                                                                                                              |


## Funcionalidade de Visualização, Edição e Exclusão de Perfil Pessoal

| # | Cenário                                       | Requisito Funcional | Ações                                                                                                                                                                                                   | Resultados Esperados                                                                                                                                                                                                                           |
|---|-----------------------------------------------|---------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1 | Registro de Usuário OK /  Inclusão de Usuário | RF-00               | ⦁	Clicar no botão de Inscreva-se<br>  ⦁	Informar os dados de usuário conforme orientações da tela<br>  ⦁	Confirmar o registro do usuário<br>  ⦁	Efetuar o login com as informações registradas                          | ⦁	Os dados do usuário devem ser registrados no Local Storage<br>  ⦁	Usuário encaminhado para página principal<br>  ⦁	Após a confirmação de login, o sistema deve apresentar uma tela informando que o usuário foi cadastrado com sucesso.                 |
| 2 | Visualização de Usuário                       | RF-01               | ⦁	Efetuar o login de um usuário cadastrado<br>  ⦁	Informar um login e senha corretos<br>  ⦁	Navegar até a página de perfil do usuário                                                                              | ⦁	Após login bem sucedido e navegação até a página de perfil, o usuário pode realizar a visualização de todos seus dados.                                                                                                                       |
| 3 | Edição de Usuário                             | RF-01               | ⦁	Acessar tela de login<br>  ⦁	Informar um login e senha corretos<br>  ⦁	Navegar até a página de perfil do usuário<br>  ⦁	Clicar no botão “Editar” <br> ⦁	Realizar todas as edições necessárias<br>  ⦁	Clicar no botão “Concluir” | ⦁	Após realização das alterações e confirmação clicando em “Concluir”, os dados do usuário no local e session storage serão alterados e ele será redirecionado para sua página de perfil, com todos os dados novos sendo exibidos corretamente. |
| 4 | Exclusão de Usuário                           | RF-01               | ⦁	Acessar tela de login<br>  ⦁	Informar um login e senha corretos<br>  ⦁	Navegar até a página de perfil do usuário<br>  ⦁	Clicar no botão “Apagar conta”                                                                | ⦁	Após selecionar a opção de apagar conta, todos os dados do usuário serão permanentemente deletados do local e session storage e não será mais possível realizar seu login.                                                                    |


## Funcionalidade de Busca de Usuário Cadastrado

| # | Cenário                                      | Requisito Funcional | Ações                                                                                                                                                         | Resultados Esperados                                                                                                                                                                                                        |
|---|----------------------------------------------|---------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1 | Página Inicial                               | RF-02, RF-04        | ⦁	Clicar no ícone ao lado da Logo<br>  ⦁	Clicar na aba de professores                                                                                               | ⦁	Após selecionar a aba de professores, irá ser redirecionados para a página onde irá mostrar todos os professores cadastrados, sendo que, caso seja a primeira vez que entre, não irá mostrar nenhum professor              |
| 2 | Página de Professores Vazia                  | RF-02, RF-04        | ⦁	Clicar no botão de teste<br>   ⦁	Caso a página não carregue sozinha, apertar F5 para recarrega-la                                                                  | ⦁	Após clicar no botão de teste, irá carregar os perfis de teste dos professores no localStorage e recarregar a página para mostra-los. Caso queira adicionar um professor manualmente, basta seguir os passos acima         |
| 3 | Página de Professores Filtrada pela Pesquisa | RF-02, RF-04        | ⦁	Verificar se a pesquisa condiz com os resultados<br>   ⦁	Pesquisar por mais de um item, sendo um de cada vez, e ver quais aparecem e quais não aparecem resultados | ⦁	O filtro de pesquisa deve ser eficiente, mostrando professores que dão aula de matemática, por exemplo, quando pesquisar por matemática, e caso não tenha nenhum professor cadastrado da matéria, mostrar nenhum professor |

## Funcionalidade de Busca de Professor por Matéria e Localização

| # | Cenário                                   | Requisito Funcional | Ações                                                                                         | Resultados Esperados                                                                                                                                     |
|---|-------------------------------------------|---------------------|-----------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1 | Busca Professor por Matéria e Localização | RF-03, RF-04        | ⦁        Encontrar caixa de busca na HomePage<br> ⦁        Inserir matéria e localização desejada | ⦁        O usuário será redirecionado para a página de busca de profesores, somente os professores que atendem aos critérios da busca serão demonstrados |


## Funcionalidade de Cadastro de Aluno no Perfil do Professor

| # | Cenário           | Requisito Funcional | Ações                                                                                                                                                                                                                                                                                                                                                            | Resultados Esperados                                                                                  |
|---|-------------------|---------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------|
| 1 | Perfil de Usuário | RF-19               | ⦁        Fazer login com o seu usuário<br> ⦁        entrar no seu perfil em "(seu nome)’Profile"<br> ⦁        Descer a página do seu perfil e ir em alunos, onde, caso seu usuário seja novo, não haverá nenhum aluno cadastrado, então clicar em cadastrar e digitar as informações do seu aluno e clicar em salvar, fazer esse processo quantas vezes forem necessárias | ⦁	Todos os alunos dever ser salvos e, mesmo fazendo logout e login novamente, aparecerem no seu perfil |

## Funcionalidade de Dark Mode com JavaScript

| # | Cenário       | Requisito Funcional | Ações                                                                                                                | Resultados Esperados                                                                                                                                                   |
|---|---------------|---------------------|----------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1 | Dark mode  OK | RF-17               | ⦁        Acessar página da HomePage<br> ⦁        Clicar no botão toggle que ao  ser clicado altera a aparência da  home  | ⦁       Após realização do código Javascript, deve apresentar na tela da home page em modo Dark,  um fundo escuro e uma cor de fonte branca ao clicar no botão toggle. |