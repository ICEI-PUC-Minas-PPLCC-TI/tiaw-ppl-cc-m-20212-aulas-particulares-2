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

function initLoginApp() {
    if (localStorage.getItem('usuarioCorrente') != null) {
        var usuarioCorrenteJSON = localStorage.getItem('usuarioCorrente');
    }
    else{
        usuarioCorrenteJSON = sessionStorage.getItem('usuarioCorrente');
    }    
    if (usuarioCorrenteJSON != '{}' && usuarioCorrenteJSON != null && usuarioCorrenteJSON != undefined) {
        usuarioCorrente = JSON.parse(usuarioCorrenteJSON);
        console.log(usuarioCorrente)
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

//Funções para alterar o cep
let atualizaEndereco = () =>{
    
    return [cidade,estado];
}

let erro

function addUser (nome, estado, cidade, telefone, email, senha, experiencia,gender,funcao,CEP) {
    
    let newId = generateUUID ();
    let dataNascimento = document.getElementById('data').value.replaceAll('-','_');
    let materia = '';
    let descricao = 'nada';
    let avaliacao = 5;
    let avaliacaoQuanti = 1;
    let papel = funcao;
    let fotoPerfil = 'https://picsum.photos/id/237/200/300';
    let genero = gender;
    let username = removeAcento(nome.replaceAll(' ',''))+newId.replaceAll('-','');
    let valorMin = 0.01;
    let valorMax = 999.99;
    let alunos = [];
    let city = cidade;
    let state = estado;

    let CEPApi = new XMLHttpRequest();
    CEPApi.onload = function (responseText){
        let cep = JSON.parse(this.responseText);
        city = cep['city'];
        state = cep['state'];
        console.log(cep);
        console.log("cidade: " + city + " estado: " + state);
    };
    CEPApi.onerror = (err) =>{
        console.log(err);
        
    }
    CEPApi.open('GET',`https://ws.apicep.com/cep/${CEP.toString()}.json`);
    CEPApi.send();
    
     //Salva o usuário no localStorage
     let usuario = { 'id': newId, 'nome': nome,'genero':genero,'idade': calcIdade(dataNascimento),'username':username, 'CEP':CEP, 'estado': state, 'cidade': city,'dataNascimento':dataNascimento, 'telefone': telefone, 'materia':materia,'descricao':descricao, 'avaliacao':avaliacao, 'avaliacaoQuanti':avaliacaoQuanti, 'email': email, 'senha': senha,'papel':papel, 'experiencia':experiencia, 'fotoPerfil':fotoPerfil,'valorMin':valorMin,'valorMax':valorMax,'alunos':alunos};
        
     if (papel == 'p') {
         fetch(`http://localhost:3001/insertProfessor/${newId}/${username}/${nome}/${email}/${telefone}/${senha}/${genero}/${dataNascimento}/${CEP}/${cidade}/${estado}/${funcao}/${experiencia}/nada/[]`)
         .catch((error) => {alert('Usuário ou senha incorretos');});
     }
     else{
         fetch(`http://localhost:3001/insertAluno/${newId}/${username}/${nome}/${email}/${telefone}/${senha}/${genero}/${dataNascimento}/${CEP}/${cidade}/${estado}/${funcao}/`)
         .catch((error) => {alert('Usuário ou senha incorretos');});
     }

    //sessionStorage.setItem('usuarioCorrente', JSON.stringify (usuario));
    
}



initLoginApp ();


