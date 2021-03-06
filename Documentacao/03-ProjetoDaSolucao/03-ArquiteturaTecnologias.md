# Arquitetura da Solução 

### Todos os componentes que fazem parte da arquitetura adotada pelo projeto estão representados na figura abaixo:
![ArquiteturaSolucao](https://user-images.githubusercontent.com/79855405/145764336-9a0657b3-7d2c-4aba-aa91-67c0e50595c4.jpg)<br><br>

## Definição dos elementos da arquitetura abaixo: <br><br>
### Camada de Apresentação 
 - **Página Web Final** - Parte da solução que é visível pelo usuário e responsável pela troca de informações em forma de input e output.
 - **Document Object Model** - Responsável pela geração da Página Web Final através da execução do código.
 - **Código HTML/CSS/JavaScript** - Código responsável por processar toda informação necessária do lado Client, gerando assim o DOM.
### Camada do Navegador
 - **Navegador Web** - Aplicação de navegador responsável por gerenciar toda a parte do projeto no lado Client e realizar a comunicação com o servidor por meio da internet.
 - **Aplicação API / Local Storage / Session Storage** - Funcionalidades do navegador responsáveis pela funcionalidade de grande parte do conteúdo do projeto.
### Camada do Servidor Web
 - **Hospedagem no Replit** - O site do Replit foi escolhido como serviço responsável por realizar a hospedagem do site, exercendo o papel de servidor.<br><br>

## Arquitetura das páginas do projeto 
 ### Todas as páginas do projeto podem ser acessadas pela HomePage, a página principal. Dentre os diversos caminhos que podem ser seguidos, os principais são:
 - HomePage -> Página de Busca por Profesores -> Perfil do Professor Selecionado 
 - HomePage -> Cadastro
 - HomePage -> Contato / Nosso Time
 - Homepage -> Login -> Perfil Pessoal -> Editar Perfil <br>
 
 ![FluxoUsuario](https://user-images.githubusercontent.com/79855405/145918355-e33ea92d-46b6-45fc-a704-0e98255d38ee.jpg)<br><br><br>
 
 # Tecnologias Utilizadas
 ### As principais tecnologias utilizadas no desenvolvimento do projeto foram:
 - HTML5 / CSS3
 - JavaScript
 - Bootstrap v5.1.1
 - API do Navegador / LocalStorage / Session Storage
 - Arquivos JSON
