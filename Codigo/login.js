const LOGIN_URL = "index.html";

document.querySelector("#show-login").addEventListener("click", function() {
  usuarioCorrenteJSON1 = sessionStorage.getItem('usuarioCorrente');
  if (sessionStorage.getItem('usuarioCorrente')) {
    document.getElementById("show-login").innerText="Login"
    logoutUser();
  } else {
    document.querySelector(".popup").classList.add("active");
  }
});


document.querySelector(".popup .close-btn").addEventListener("click", function(){document.querySelector(".popup").classList.remove("active");
});
document.querySelector(".popup .close-btn").addEventListener("click", function() {
  document.getElementById('email').value='';
})
document.querySelector(".popup .close-btn").addEventListener("click", function() {
  document.getElementById('senha').value='';
})



var db_usuarios = {};
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
        { "id": generateUUID (), "nome": "Gustavo Gomes", "estado": "Bahia", "cidade": "Igapora",
        "telefone": "77998705917", "email": "gustavoiga@outlook.com", "senha": "123", "experiencia": "2"},
        { "id": generateUUID (), "nome": "Ali Baba", "estado": "Acre", "cidade": "Rio Preto",
        "telefone": "77998703948", "email": "alibaba@outlook.com", "senha": "123", "experiencia": "66"},
    ]
};


function initLoginApp() {
    
    usuarioCorrenteJSON = sessionStorage.getItem('usuarioCorrente');
    if (usuarioCorrenteJSON) {
        usuarioCorrente = JSON.parse(usuarioCorrenteJSON);

        document.getElementById("inscrever-perfil").href="#";
        var userName = usuarioCorrente["nome"];
        userName = userName.split(" ")[0];
        document.getElementById("inscrever-perfil").innerText=(userName + "'s Profile");
        document.getElementById("show-login").href="#"
        document.getElementById("show-login").innerText="Logout"
    }

    var usuariosJSON = localStorage.getItem('db_usuarios');

    if(!usuariosJSON) {
        db_usuarios = dadosIniciais;

        localStorage.setItem('db_usuarios', JSON.stringify (dadosIniciais));
    } else {
        db_usuarios = JSON.parse(usuariosJSON); 
    }
};

function loginUser(email, senha) {
    for (var i = 0; i < db_usuarios.usuarios.length; i++) {
        var usuario = db_usuarios.usuarios[i];

        if (email == usuario.email && senha == usuario.senha) {
            usuarioCorrente.id = usuario.id;
            usuarioCorrente.email = usuario.email;
            usuarioCorrente.nome = usuario.nome;

            sessionStorage.setItem('usuarioCorrente', JSON.stringify (usuarioCorrente));
            alert('Logado com sucesso');
            window.location.reload();

            return true;
        }
    }
    return false;
}

function logoutUser () {
    sessionStorage.clear()
    window.location = LOGIN_URL;
}

function addUser (nome, estado, cidade, telefone, email, senha, experiencia) {
    
    let newId = generateUUID ();
    let usuario = { "id": newId, "nome": nome, "estado": estado, "cidade": cidade, "telefone": telefone, "email": email, "senha": senha, "experiencia":experiencia };
    
    db_usuarios.usuarios.push (usuario);

    localStorage.setItem('db_usuarios', JSON.stringify (db_usuarios));
}

function setUserPass () {
}


initLoginApp ();
