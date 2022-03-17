document.querySelector('#Cpesquisar').onclick = (evento) =>{
  let variavel = Cmaterias.value;
  variavel = removeAcento(variavel);
  console.log(variavel);
  location.href = `professores.html?search=${variavel}`;
  evento.preventDefault();
  //Clocalizacao
  //Cmateria
}
