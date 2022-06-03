function valida() {
  if (document.querySelector('#cemail').value.length == 0) {
    alert('Insira seu e-mail.');
	  document.frmEnvia.email.focus();
    return false;
  }
  return true;
}
 
function verificaEmail(){
  let corpoEmail = document.querySelector('#cemail').value;
  if( corpoEmail =="" || !(corpoEmail.includes('@')) || !(corpoEmail.includes('.com')) )
  {
    alert("Por favor, informe um E-MAIL válido!");
    return false;
  }
  return true;
}
