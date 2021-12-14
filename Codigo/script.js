var users = [];
if(localStorage.getItem('db_usuarios') == null)
{
    localStorage.setItem('db_usuarios',JSON.stringify(users));
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
    };

    document.querySelector(".dropdown>.dropdown-menu").children[0].onclick = () =>{
        if(document.querySelector(".dropdown>.dropdown-menu").children[0].classList.contains('logado')){
            location.href = `profile.html?username=${usuarioCorrente.username}`;
        }
    }
}

