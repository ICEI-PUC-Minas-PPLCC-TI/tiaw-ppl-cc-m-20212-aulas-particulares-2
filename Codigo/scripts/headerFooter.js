let aux = '`<tr><td scope="row">${usuario.nome}</td><td>${usuario.login}</td><td>${usuario.email}</td></td>`';
document.querySelector('header').innerHTML = `
<!--------------- LOGIN -------------->
<div class="container">
    <div class="row">
        <div class="col-12 col-sm-12 col-md-3 col-lg-3">
            <div class="logo_menu">
                <!--Logo-->
                <div class="logo">
                    <img id="papo" src="img/Logo_prov.png" alt="PAPO">
                </div>

                <!--Menu Dropdown -->
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <li class="fa fa-bars"></i>
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="#">Perfil</a>
                        <a class="dropdown-item" href="professores.html">Professores</a>
                        <a class="dropdown-item" href="#">Matérias</a>
                    </div>
                </div>
            </div>
        </div>

        <!--Menu principal-->
        <div class="col-12 col-sm-12 col-md-9 col-lg-9">
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link" href="index.html">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="sobrenos.html">Sobre</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="team.html">Nosso time</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contato.html">Contato</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="inscrever-perfil" href="cadastro.html">Inscreva-se</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="show-login" href="#">Login</a>
                </li>
                <li>
                    <img id="estrela" src="https://repetit.ru/img/star_add_to_favourites.png" width="21" height="19">
                </li>
            </ul>
        </div>
    </div>
</div>
<script>
            function exibeUsuarios() {
                let listaUsuarios = '';
                for (i = 0; i < db_usuarios.length; i++) {
                    let usuario = db_usuarios[i];
                    listaUsuarios += ${aux};
                }
                document.getElementById("table-usuarios").innerHTML = listaUsuarios;
            }
        
            function initPage() {
                
        
            }
            window.addEventListener('load', initPage);
          </script>
        
          <div class="popup">
            <div class="close-btn">&times;</div>
            <div class="form">
                <h2>Entrar</h2>
                <div class="form-element">
                    <label for="email">E-mail</label>
                    <input type="text" id="email" placeholder="Insira e-mail">
                </div>
                <div class="form-element">
                    <label for="senha">Senha</label>
                    <input type="password" id="senha" placeholder="Insira senha">
                </div>
                <div class="form-element">
                    <input type="checkbox" id="remember-me">
                    <label for="remember-me">Lembre-se de mim</label>
                </div>
                <div class="form-element">
                    <button id="login-form">Entrar</button>
                </div>
                <div class="form-element">
                    <div id="cadastrar">
                        <a href="cadastro.html">Não é cadastrado?</a>
                    </div>
                    <div id="recuperar">
                        <a href="#">Esqueceu sua senha?</a>
                    </div>
                </div>
            </div>
          </div>
        
          <script>
            
          </script>
        
          <!--------------- LOGIN -------------->
`;

/*Faz o login*/
function processaFormLogin(event) {
    event.preventDefault();

    var email = document.getElementById('email').value;
    var password = document.getElementById('senha').value;

    resultadoLogin = loginUser(email, password);
    if (resultadoLogin) {
        window.location.href = '#';
    } else {
        alert('Usuário ou senha incorretos');
    }
}
document.getElementById('login-form').addEventListener('click', processaFormLogin);
/**/

document.querySelector('footer.footer').innerHTML = `
<div class="row">
        <div class="col-12 col-sm-6 col-md-3 col-lfg-3">
            <ul>
                <li>
                    <div class="logo">
                        <img src="img/Logo_prov.png" alt="PAPO" >
                          
                    </div>
                </li>
                <li>
                    <p>Telefone: +xx (xx) 9xxxx-xxxx</p>
                </li>
                <li>
                    <p>E-mail: plataformapapo@gmail.com</p>
                </li>
                <li>
                    <p>Localização: <a href="https://goo.gl/maps/84exw4SQHGfMFRw89" target="_blank">Belo
                            Horizonte</a>
                    </p>
                </li>
            </ul>
        </div>
        <div class="col-12 col-sm-6 col-md-3 col-lfg-3">
            <ul>
                <li>
                    <p>Aluno</p>
                </li>
                <li><a href="#">Encontre um professor</a></li>
                <li><a href="#">Matérias</a></li>
            </ul>
        </div>
        <div class="col-12 col-sm-6 col-md-3 col-lfg-3">
            <ul>
                <li>
                    <p>Professor</p>
                </li>
                <li><a href="#">Registrar agora</a></li>
                <li><a href="#">Termos</a></li>
            </ul>
        </div>
        <div class="col-12 col-sm-6 col-md-3 col-lfg-3">
            <ul class="redes">
                <li>
                    <p>Estamos também</p>
                </li>
                <li class="link_rede"><a href="https://www.facebook.com/" target="_blank"><i
                            class="fa fa-facebook-square" aria-hidden="true"></i></a></li>
                <li class="link_rede"><a href="https://www.instagram.com/" target="_blank"><i
                            class="fa fa-instagram" aria-hidden="true"></i></a></li>
                <li class="link_rede"><a href="https://www.twitter.com/" target="_blank"><i
                            class="fa fa-twitter" aria-hidden="true"></i></a></li>
            </ul>
        </div>
    </div>
`;


document.querySelector('head').innerHTML += '<link rel="shortcut icon" href="img/logo.jpg" type="image/x-icon">'