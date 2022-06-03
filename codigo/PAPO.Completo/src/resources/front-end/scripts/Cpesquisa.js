document.querySelector('#Cpesquisar').onclick = (evento) =>{
  let variavel = Cmaterias.value;
  variavel = removeAcento(variavel);
  //console.log(variavel);
  //Faz a requisição para o banco de dados

  location.href = `professores.html?search=${variavel}`;
  evento.preventDefault();
  //Clocalizacao
  //Cmateria
}
