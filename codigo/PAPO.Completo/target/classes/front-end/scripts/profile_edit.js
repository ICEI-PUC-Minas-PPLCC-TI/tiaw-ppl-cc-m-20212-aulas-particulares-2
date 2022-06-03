function changeUser (nome, username, descricao, experiencia, cidade, estado, telefone, email, min, max, materias,CEP) {
  usuarioCorrente = JSON.parse(sessionStorage.getItem('usuarioCorrente'));
  db_usuarios = JSON.parse(localStorage.getItem('db_usuarios'));

  var userIndex = 0;
  for (let i = 0; i < db_usuarios.length; i++) {
      if(db_usuarios[i]['id'] == usuarioCorrente['id']){
          userIndex = i;
          break;
      }
  }
  usuarioCorrente.nome = nome;
  usuarioCorrente.username = username;
  usuarioCorrente.descricao = descricao;
  usuarioCorrente.experiencia = experiencia;
  usuarioCorrente.cidade = cidade;
  usuarioCorrente.estado = estado;
  usuarioCorrente.telefone = telefone;
  usuarioCorrente.email = email;
  usuarioCorrente.valorMin = min;
  usuarioCorrente.valorMax = max;
  usuarioCorrente.materia = (materias == 'insira') ? '' : materias;
  usuarioCorrente.CEP = CEP;
  console.log(CEP)
  sessionStorage.clear();
  sessionStorage.setItem('usuarioCorrente', JSON.stringify(usuarioCorrente));
  
  if (usuarioCorrente['papel'] == 'p') {
    //console.log(`http://localhost:3001/updateProfessor/${usuarioCorrente['id']}/${username}/${nome}/${email}/${telefone}/${usuarioCorrente['senha'] + usuarioCorrente['password']}/${usuarioCorrente['genero']}/${usuarioCorrente['dataNascimento']}/${CEP}/${cidade}/${estado}/${usuarioCorrente['papel']}/${experiencia}/${descricao}`);
      fetch(`http://localhost:3001/updateProfessor/${usuarioCorrente['id']}/${username}/${nome}/${email}/${telefone}/${usuarioCorrente['senha'] + usuarioCorrente['password']}/${usuarioCorrente['genero']}/${usuarioCorrente['dataNascimento']}/${CEP}/${cidade}/${estado}/${usuarioCorrente['papel']}/${experiencia}/${descricao}`)
    //.catch((error) => {alert('Erro ao atualizar o professor');});
  }
  else{
    fetch(`http://localhost:3001/updateAluno/${usuarioCorrente['id']}/${username}/${nome}/${email}/${telefone}/${usuarioCorrente['senha'] + usuarioCorrente['password']}/${usuarioCorrente['genero']}/${usuarioCorrente['dataNascimento']}/${email}/${cidade}/${estado}/${usuarioCorrente['papel']}/${descricao}`)
    .catch((error) => {alert('Erro ao atualizar o aluno');});
  }
  
}
