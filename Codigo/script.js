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
    materia = [];
    descricao = '';
    avaliacao = 5;
    papel = 'professor';
    fotoPerfil = 'https://picsum.photos/id/237/200/300';
    genero = 'masc';
    username = nome.replace(' ','')+dataNascimento;
    let valorMin = 0.01;
    let valorMax = 999.99;
    let usuario = { 'id': newId, 'nome': nome,'genero':genero,'idade': calcIdade(dataNascimento),'username':username, 'estado': estado, 'cidade': cidade,'dataNascimento':dataNascimento, 'telefone': telefone, 'materia':materia,'descricao':descricao, 'avaliacao':avaliacao, 'email': email, 'senha': senha,'papel':papel, 'experiencia':experiencia, 'fotoPerfil':fotoPerfil,'valorMin':valorMin,'valorMax':valorMax};
   
    db_usuarios.push(usuario);

    localStorage.setItem('db_usuarios', JSON.stringify (db_usuarios));
}




/*Carrega os usuários do localStorage
users = JSON.parse(localStorage.getItem('db_usuarios'));
for(let i=0; i<users.length;i++){
    //let i = indice;
    //indice++;
    
    users[i].idade = calcIdade(users[i].data_nascimento);
    listaProfessores.innerHTML+=`<div class="col professorApresentacao">
        <div class="row">
            <div class="col-12 col-sm-8 col-md-3 col-lg-3">
                <div class="fotoPerfil">
                    <img src="${users[i].fotoPerfil}" alt="">
                    <p>Avaliação:</p>
                </div>
            </div>
            <div class="col-12 col-sm-4 col-md-5 col-lg-5">
                <div class="descricaoProfessor">
                    <h3 class="nomeProfessor">${users[i].nome}</h3>
                    <p><small>Professor particular - ${users[i].idade} anos de expêriência</small></p>
                    <div class="row">
                        <div class="col-6">
                            <div class="materiasLecionadas">
                                <ul id="materiasLecionadas${i}">
                                    <p><strong>Matérias:</strong></p>
                                </ul>
                            </div>
                        </div>
                        <div class="col-6">
                            <div class="regiaoLecionada">
                                <p>${users[i].cidade}</p>
                            </div>
                        </div>
                </div>
            </div>
            </div>
            <div class="col-12 col-sm-12 col-md-4 col-lg-4">
                <div class="valorAula">
                    <p><strong>De R$xxx,xx até R$xxx,xx</strong></p>
                    <p>Disponível</p>
                    <a class="btn btn-primary contratar" alt="perfilprofessor.html?id=${users[i].id}" href="perfilprofessor.html?id=${users[i].id}" role="button">Contratar</a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="professorResumo">
                <div class="col-12">
                    <p>${users[i].descricao}</p>
                </div>                       
            </div>
        </div>
    </div>`;
    
    let teste = document.getElementById(`materiasLecionadas${i}`);
    if(teste != null)
        for(let ind=0; ind<users[i].materia.length; ind++)
        {
            teste.innerHTML+= `<p>${users[i].materia[ind]}</p>`;
            console.log('Debug');
        }
    else
        console.log('Não entrou');

}
-----------------------------------*/


window.onload = () =>{}

