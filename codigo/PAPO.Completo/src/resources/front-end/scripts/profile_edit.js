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
  let senha = (usuarioCorrente.password != undefined && usuarioCorrente.password.length > 0) ? usuarioCorrente.password : usuarioCorrente.senha;
  usuarioCorrente.senha = senha;
  usuarioCorrente.password = senha;
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
  usuarioCorrente.materia = (materias == 'insira' || materias == '') ? '' : materias;
  usuarioCorrente.CEP = CEP;
  console.log(CEP)
  sessionStorage.clear();
  sessionStorage.setItem('usuarioCorrente', JSON.stringify(usuarioCorrente));
  
  if (usuarioCorrente['papel'] == 'p') {
    alert(`http://localhost:3001/updateProfessor/${usuarioCorrente['id']}/${username}/${nome}/${email}/${telefone}/${senha}/${usuarioCorrente['genero']}/${usuarioCorrente['dataNascimento']}/${CEP}/${cidade}/${estado}/${usuarioCorrente['papel']}/${experiencia}/${descricao}/${usuarioCorrente.materia}`);
      fetch(`http://localhost:3001/updateProfessor/${usuarioCorrente['id']}/${username}/${nome}/${email}/${telefone}/${senha}/${usuarioCorrente['genero']}/${usuarioCorrente['dataNascimento']}/${CEP}/${cidade}/${estado}/${usuarioCorrente['papel']}/${experiencia}/${descricao}/${usuarioCorrente.materia}`)
    //.catch((error) => {alert('Erro ao atualizar o professor');});
  }
  else{
    fetch(`http://localhost:3001/updateAluno/${usuarioCorrente['id']}/${username}/${nome}/${email}/${telefone}/${senha}/${usuarioCorrente['genero']}/${usuarioCorrente['dataNascimento']}/${email}/${cidade}/${estado}/${usuarioCorrente['papel']}/${descricao}`)
    .catch((error) => {alert('Erro ao atualizar o aluno');});
  }
  
}
