var users = [];
if(localStorage.getItem('db_usuarios') == null)
{
    localStorage.setItem('db_usuarios',JSON.stringify(users));
}
if (localStorage.getItem('usuarioCorrente') != null) {
    var usuarioCorrente = JSON.parse(localStorage.getItem('usuarioCorrente'));
}

/*------Estrutura de dados
function Usuario()
    {
        this.id = users.length,
        this.nome = 'Fulano',
        this.genero = 'tal',
        this.username = 'Fulano123',
        this.email = 'fulano@xxxx.com',
        this.senha = 'xpto@345',
        this.papel = 'aluno',
        this.data_nascimento = 'ddmmaa',
        this.estado = 'amazonas',
        this.cidade = 'manaus'
        this.experiencia = 'mmaa',
        this.telefone = '3234242',
        this.materia = ['matematica', 'fisica'],
        this.avaliacao = '4.5',
        this.descricao = 'Lorem ipsum',
        this.fotoPerfil = `imagens/perfil/${id}.jpg`
        this.idade = function(){
            let data = new Date();
            let anoAt = data.getFullYear();
            let mesAt = data.getMonth()+1;
            let diaAt = data.getDay();
            let dia = this.data_nascimento+this.data_nascimento;
            let mes = this.data_nascimento+this.data_nascimento;
            let ano = this.data_nascimento+this.data_nascimento;
            let idade = anoAt - ano;
            if(mesAt>=mes && diaAt>=dia){
                idade++;
            }
            return idade;
        }
    }

/*------------------*/

/*Função que remove o acento*/
function removeAcento(frase){
    comAcento = 'áãâàéèêíìîóòôõúùûü';
    semAcento = 'aaaaeeeiiioooouuuu';
    let novaFrase = '';
    for(i = 0;i<frase.length;i++){
        if(comAcento.includes(frase[i])){
            novaFrase += frase[i].replace(comAcento[comAcento.indexOf(frase[i])],semAcento[comAcento.indexOf(frase[i])]);
        }
        else{
            novaFrase+=frase[i];
        }                
    }
    return novaFrase;
}
/*--------------------------------------*/

/*Calcular idade do usuário*/
function calcIdade(data_nasc){
    let data = new Date();
    let anoAt = data.getFullYear();
    let mesAt = data.getMonth();
    let diaAt = data.getDay();
    let dia = data_nasc[0]+data_nasc[1];
    let mes = data_nasc[2]+data_nasc[3];
    let ano = data_nasc[4]+data_nasc[5]+data_nasc[6]+data_nasc[7];
    let idade = anoAt - ano;
    if(mesAt>=mes && diaAt>=dia){
        idade++;
    }
    return idade;
}
/*-------------------------*/


/*-Comando para criar users no LocalStorage-*/
//criaUser('Pedro','Masculino','Pamps','pmend25@email.com','admin','aluno','30112000','mg','bh','0000','3134',["matematica","fisica"],'5','teste descricao oi','https://picsum.photos/id/225/200/300')
//criaUser('Clara','Feminino','Lapompi','cmend6@email.com','admin','aluno','23072004','mg','bh','0000','3134',["matematica","fisica","biologia","redação"],'5','teste descricao oi','https://picsum.photos/id/237/200/300')
//criaUser('Jose','Masculino','Contabilidade','conta@email.com','admin','professor','01071963','mg','bh','0000','3134',["matematica","fisica","quimica"],'5','teste descricao oi','https://picsum.photos/id/247/200/300')
//criaUser('Cassia','Feminino','MinimumVita','minium@email.com','admin','professor','01071970','mg','bh','0000','3134',["matematica","fisica","quimica"],'5','teste descricao oi','https://picsum.photos/id/257/200/300')
/*------------------------*/

var indice = 0;

function criaUser(nome,genero,username,email,senha,papel,dataNascimento,estado,cidade,experiencia,telefone,materia,avaliacao,descricao,fotoPerfil)
{
    let newId = generateUUID ();
    dataNascimento = '30112000';
    materia = ['Matemática','Física','Português'];
    descricao = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.';
    avaliacao = 5;
    let avaliacaoQuanti = 1;
    papel = 'professor';
    fotoPerfil = 'https://picsum.photos/id/237/200/300';
    genero = 'masc';
    username = removeAcento(nome.replaceAll(' ',''))+newId.replaceAll('-','');
    let valorMin = 0.01;
    let valorMax = 999.99;
    let alunos = [];
    let usuario = { 'id': newId, 'nome': nome,'genero':genero,'idade': calcIdade(dataNascimento),'username':username, 'estado': estado, 'cidade': cidade,'dataNascimento':dataNascimento, 'telefone': telefone, 'materia':materia,'descricao':descricao, 'avaliacao':avaliacao, 'avaliacaoQuanti':avaliacaoQuanti, 'email': email, 'senha': senha,'papel':papel, 'experiencia':experiencia, 'fotoPerfil':fotoPerfil,'valorMin':valorMin,'valorMax':valorMax,'alunos':alunos};
   
    db_usuarios.push(usuario);

    localStorage.setItem('db_usuarios', JSON.stringify (db_usuarios));
}



window.onload = () =>{
    document.getElementById('inscrever-perfil').onclick = () =>{
        if(document.getElementById('inscrever-perfil').classList.contains('logado')){
            location.href = `profile.html?username=${usuarioCorrente.username}`;
        }
        else{
            location.href = `cadastro.html`;
        }
    };

    document.querySelector(".dropdown>.dropdown-menu").children[0].onclick = () =>{
        if(document.querySelector(".dropdown>.dropdown-menu").children[0].classList.contains('logado')){
            location.href = `profile.html?username=${usuarioCorrente.username}`;
        }
    }

}

var chatBotMem = [];

document.querySelector('main').innerHTML+= `
    <div id="chatbot_chat">
        <div class="container">
            <div class="chat">

                    <p class="miniaturaChatbot">Assistente virtual</p>

                    <div class="mensagens"></div>

                    <form id="chatbotInput" class="d-flex input" role="search">
                        <input class="form-control me-2" type="search" placeholder="Digite..." aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Enviar</button>
                    </form>

            </div>
        </div>
    </div>
    <div id="chatbot">
        <img src="img/chatbot/icone.png" alt="">
    </div>`;

document.querySelector("#chatbot").addEventListener('click',()=>{
    let msg = document.querySelector('#chatbot_chat');
    if (msg.style.display == 'block') {
        msg.style.display = 'none';
    }
    else{
        msg.style.display = 'block';
        msg.style.bottom = 'calc(5% + 100px)'
    }
});

document.querySelector('#chatbotInput').addEventListener('submit',(evento) =>{
    let chatMsg = document.querySelector('#chatbot_chat .mensagens');
    let msg = document.querySelector('#chatbotInput input');
    if (msg.value.length > 0) {
        chatMsg.innerHTML += `<div class="msgBox darker msgRemetente">
                                <p>${msg.value}</p>
                                <span class="time-left">${new Date().getHours() + ":" + new Date().getMinutes()}</span>
                            </div>`;
        let string = msg.value;

        if (chatBotMem.length == 0) {
            if (string.includes('cadast') || string.includes('Cadast')) {
                chatBotAddMsg('Deseja cadastrar novo usuário?');
                chatBotMem.push('cadastro');
            }
            else if(string.includes('menu') || string.includes('Menu')){
                chatBotAddMsg('Retornar ao menu principal?')
                chatBotMem.push('menu');
            }
            else if(string.includes('login') || string.includes('Login')){
                chatBotAddMsg('Digite seu email:');
                chatBotMem.push('email');
            }
            else if(string.includes('perfil') || string.includes('Perfil')){
                chatBotAddMsg('Deseja entrar no seu perfil ou de algum professor?');
                chatBotMem.push('perfil');
            }
            else if(string.includes('buscar') || string.includes('Buscar')){
                chatBotAddMsg('Qual o nome do professor ou matéria para pesquisar?');
                chatBotMem.push('professorPesquisar');
            }
            else if(string.includes('sair') || string.includes('Sair') || string.includes('logout') || string.includes('Logout') || string.includes('logoff') || string.includes('Logoff')){
                chatBotAddMsg('Deseja realmente sair?');
                chatBotMem.push('logout');
            }
            else{
                chatBotAddMsg('Não entendi');
                chatBotMem = [];
            }
        }
        else{
            if(chatBotMem[chatBotMem.length-1] == "cadastro"){
                if (string == 'sim' || string == 'Sim' || string == 's' || string == 'S') {
                    window.location.replace('/cadastro.html');
                }
                else if (string == 'não' || string == 'nao' || string == 'Não' || string == 'não' || string == 'n' || string == 'N') {
                    chatBotMem = [];
                }
                else{
                    chatBotMem = [];
                    chatBotAddMsg('Não entendi, deseja cadastrar?');
                }
            }
            else if(chatBotMem[chatBotMem.length-1] == "menu"){
                if (string == 'sim' || string == 'Sim' || string == 's' || string == 'S') {
                    window.location.replace('/index.html');
                }
                else if (string == 'não' || string == 'nao' || string == 'Não' || string == 'não' || string == 'n' || string == 'N') {
                    chatBotMem = [];
                }
                else{
                    chatBotAddMsg('Não entendi');
                }
            }
            else if(chatBotMem[chatBotMem.length-1] == "email"){
                chatBotMem.push(string);
                chatBotAddMsg('Digite sua senha:');
                chatBotMem.push('senha');
            }
            else if(chatBotMem[chatBotMem.length-1] == 'senha'){
                let email = chatBotMem[chatBotMem.indexOf('email')+1];
                let senha = string;
                console.log(`email: ${email} senha: ${senha}`)
                fetch(`http://localhost:3001/login/${email}/${senha}`)
                .then((response) => response.json())
                .then((data) =>{
                    let listaParams = Object.keys(data[0]);
                    let tempUser = {'nome':'','genero':'','username':'','email':'','senha':'','papel':'','dataNascimento':'','estado':'','cidade':'','experiencia':'','telefone':'','materia':[],'avaliacao':'','descricao':'','fotoPerfil':'https://picsum.photos/id/237/200/300'};
                    for (let i = 0; i < listaParams.length; i++) {
                        tempUser[listaParams[i]] = data[0][listaParams[i]];  
                        console.log(`${tempUser[listaParams[i]]} = ${data[0][listaParams[i]]}`)
                    }
                    if (rememberme == true) {
                        localStorage.setItem('usuarioCorrente', JSON.stringify (tempUser));
                    }
                    sessionStorage.setItem('usuarioCorrente', JSON.stringify (tempUser));
                    
                    window.location.reload();
                })
                .catch((error) => {chatBotAddMsg('Usuário ou senha incorretos');chatBotMem=[];});
            }
            else if(chatBotMem[chatBotMem.length-1] == "perfil"){
                if(string.includes('meu') || string.includes('seu') || string.includes('Meu') || string.includes('Seu')){
                    if (usuarioCorrente.username) {
                        chatBotMem = [];
                        window.location.replace(`/profile.html?username=${usuarioCorrente.username}`);
                    }
                    else{
                        chatBotMem = [];
                        chatBotAddMsg('Por favor, faça login primeiro');
                    }                    
                }
                else if(string.includes('prof') || string.includes('Prof') || string.includes('buscar') || string.includes('Buscar')){
                    chatBotAddMsg('Qual o nome do professor para pesquisar?');
                    chatBotMem.push('professorPesquisar');
                }
                else{
                    chatBotAddMsg('Não entendi');
                    chatBotMem = [];
                }
            }
            else if(chatBotMem[chatBotMem.length-1] == "professorPesquisar"){
                chatBotMem = [];
                chatBotAddMsg('Ok, vou pesquisar, 1 instante');
                fetch(`http://localhost:3001/search/${string}`)
                .then((response) => response.json())
                .then((data) => {

                    let listaParams = Object.keys(data[0]);
                    let listaProf = [];
                    for (let j = 0; j < data.length; j++) {
                        let tempUser = { 'nome': '', 'genero': '', 'username': '', 'email': '', 'senha': '', 'papel': '', 'dataNascimento': '', 'estado': '', 'cidade': '', 'experiencia': '', 'telefone': '', 'materia': [], 'avaliacao': '', 'descricao': '', 'fotoPerfil': 'https://picsum.photos/id/237/200/300' };
                        for (let i = 0; i < listaParams.length; i++) {
                            tempUser[listaParams[i]] = data[j][listaParams[i]];
                        }
                        listaProf.push(tempUser);
                    }
                    sessionStorage.setItem('resultadoBusca', JSON.stringify(listaProf));

                    window.location.href = 'professores.html?search=' + string;

                })
                .catch((error)=>{chatBotAddMsg('Não encontrei ninguém');chatBotMem = []})
            }
            else if(chatBotMem[chatBotMem.length-1] == "logout"){
                if (string == 'sim' || string == 'Sim' || string == 's' || string == 'S') {
                    logoutUser();
                }
                else if (string == 'não' || string == 'nao' || string == 'Não' || string == 'não' || string == 'n' || string == 'N') {
                    chatBotMem = [];
                }
                else{
                    chatBotAddMsg('Não entendi');
                }
            }
            else{
                chatBotAddMsg('Não entendi ultimo');
            }
        }

        msg.value = '';
        document.querySelector('#chatbot_chat .mensagens').scroll(0,9999999999);
    }
    
    evento.preventDefault();
});


chatBotAddMsg('Bem vindo(a) à assistente virtual da PAPO');

function chatBotAddMsg(string){
    document.querySelector('#chatbot_chat .mensagens').innerHTML += `
        <div class="msgBox darker msgDestinatario">
            <p>${string}</p>
            <span class="time-left">${new Date().getHours() + ":" + new Date().getMinutes()}</span>
        </div>`;
}
