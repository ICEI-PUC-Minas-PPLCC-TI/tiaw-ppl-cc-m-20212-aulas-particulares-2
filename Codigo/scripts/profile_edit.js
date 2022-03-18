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
  
  db_usuarios[userIndex].nome = nome;
  db_usuarios[userIndex].username = username;
  db_usuarios[userIndex].descricao = descricao;
  db_usuarios[userIndex].experiencia = experiencia;
  db_usuarios[userIndex].cidade = cidade;
  db_usuarios[userIndex].estado = estado;
  db_usuarios[userIndex].telefone = telefone;
  db_usuarios[userIndex].email = email;
  db_usuarios[userIndex].valorMin = min;
  db_usuarios[userIndex].valorMax = max;
  db_usuarios[userIndex].materia = materias;
  db_usuarios[userIndex].CEP = CEP;
  localStorage.clear();
  localStorage.setItem('db_usuarios', JSON.stringify(db_usuarios));
  sessionStorage.clear();
  sessionStorage.setItem('usuarioCorrente', JSON.stringify(db_usuarios[userIndex]));
  
  window.location.href = `profile.html?username=${username}`;
}
