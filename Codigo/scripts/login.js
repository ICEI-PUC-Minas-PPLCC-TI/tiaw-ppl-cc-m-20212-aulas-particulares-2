const LOGIN_URL = window.location.href;

document.querySelector('#show-login').addEventListener('click', function(evento) {
  usuarioCorrenteJSON1 = sessionStorage.getItem('usuarioCorrente');
  if (sessionStorage.getItem('usuarioCorrente')) {
    document.getElementById('show-login').innerText='Login'
    logoutUser();
  } else {
    document.querySelector('.popup').classList.add('active');
  }
  evento.preventDefault();
});


document.querySelector('.popup .close-btn').addEventListener('click', function(){document.querySelector('.popup').classList.remove('active');
});
document.querySelector('.popup .close-btn').addEventListener('click', function() {
  document.getElementById('email').value='';
})
document.querySelector('.popup .close-btn').addEventListener('click', function() {
  document.getElementById('senha').value='';
})


var usuariosJSON = localStorage.getItem('db_usuarios');
var db_usuarios = {};
db_usuarios = JSON.parse(usuariosJSON); 
var usuarioCorrente = {};

function generateUUID() { // Public Domain/MIT
    var d = new Date().getTime();
    var d2 = (performance && performance.now && (performance.now()*1000)) || 0;
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = Math.random() * 16;
        if(d > 0){
            r = (d + r)%16 | 0;
            d = Math.floor(d/16);
        } else {
            r = (d2 + r)%16 | 0;
            d2 = Math.floor(d2/16);
        }
        return (c === 'x' ? r : (r & 0x3 | 0x8)).toString(16);
    });
}

const dadosIniciais = {
    usuarios: [
        { 'id': generateUUID (), 'nome': 'Gustavo Gomes', 'estado': 'Bahia', 'cidade': 'Igapora',
        'telefone': '77998705917', 'email': 'gustavoiga@outlook.com', 'senha': '123', 'experiencia': '2'},
        { 'id': generateUUID (), 'nome': 'Ali Baba', 'estado': 'Acre', 'cidade': 'Rio Preto',
        'telefone': '77998703948', 'email': 'alibaba@outlook.com', 'senha': '123', 'experiencia': '66'},
    ]
};


function initLoginApp() {
    
    usuarioCorrenteJSON = sessionStorage.getItem('usuarioCorrente');
    if (usuarioCorrenteJSON) {
        usuarioCorrente = JSON.parse(usuarioCorrenteJSON);

        document.getElementById('inscrever-perfil').href='#';
        var userName = usuarioCorrente['nome'];
        userName = userName.split(' ')[0];
        document.getElementById('inscrever-perfil').innerText=(userName + `'s Profile`);
        document.getElementById('inscrever-perfil').classList.add('logado');
        document.getElementById('show-login').href='#'
        document.getElementById('show-login').classList.add('logado');
        document.querySelector(".dropdown>.dropdown-menu").children[0].classList.add('logado');        
        document.getElementById('show-login').innerText='Logout';
    }

    var usuariosJSON = localStorage.getItem('db_usuarios');
    
/*
    if(!usuariosJSON) {
        db_usuarios = dadosIniciais;

        localStorage.setItem('db_usuarios', JSON.stringify (dadosIniciais));
    } else {
        db_usuarios = JSON.parse(usuariosJSON); 
    }*/
};

function loginUser(email, senha) {
    for (var i = 0; i < db_usuarios.length; i++) {
        var usuario = db_usuarios[i];

        if (email.toLocaleLowerCase() == usuario.email.toLocaleLowerCase() && senha == usuario.senha) {
            usuarioCorrente = db_usuarios[i];

            sessionStorage.setItem('usuarioCorrente', JSON.stringify (usuarioCorrente));
            //alert('Logado com sucesso');
            window.location.reload();

            return true;
        }
    }
    return false;
}

function logoutUser () {
    sessionStorage.clear()
    document.getElementById('inscrever-perfil').classList.remove('logado');
    document.getElementById('show-login').classList.remove('logado');
    document.querySelector(".dropdown>.dropdown-menu").children[0].classList.remove('logado'); 
    window.location.href = 'index.html';
}

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

function pegaGenero(){
    let masc = document.getElementById('masculino');
    let femi = document.getElementById('feminino');
    if(masc.checked){
        return 'Masculino';
    }
    else if(femi.checked){
        return 'Feminino';
    }
    else{
        return 'Not';
    }
}

function addUser (nome, estado, cidade, telefone, email, senha, experiencia) {
    
    let newId = generateUUID ();
    let dn = document.getElementById('data').value.replaceAll('-','');
    let dataNascimento =  dn[6]+dn[7]+dn[4]+dn[5]+dn[0]+dn[1]+dn[2]+dn[3];
    let materia = [];
    let descricao = '';
    let avaliacao = 5;
    let avaliacaoQuanti = 1;
    let papel = 'professor';
    let fotoPerfil = 'https://picsum.photos/id/237/200/300';
    let genero = pegaGenero();
    let username = removeAcento(nome.replaceAll(' ',''))+newId.replaceAll('-','');
    let valorMin = 0.01;
    let valorMax = 999.99;
    let alunos = [];
    let usuario = { 'id': newId, 'nome': nome,'genero':genero,'idade': calcIdade(dataNascimento),'username':username, 'estado': estado, 'cidade': cidade,'dataNascimento':dataNascimento, 'telefone': telefone, 'materia':materia,'descricao':descricao, 'avaliacao':avaliacao, 'avaliacaoQuanti':avaliacaoQuanti, 'email': email, 'senha': senha,'papel':papel, 'experiencia':experiencia, 'fotoPerfil':fotoPerfil,'valorMin':valorMin,'valorMax':valorMax,'alunos':alunos};
   
    db_usuarios.push(usuario);

    localStorage.setItem('db_usuarios', JSON.stringify (db_usuarios));
}

function setUserPass () {
}


initLoginApp ();


