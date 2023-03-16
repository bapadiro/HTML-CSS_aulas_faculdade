// recuperar do html as classes links-menu e hamburguer
// armazenar em variáveis

const hamburguer =  document.querySelector('.hamburguer');
const linksMenu = document.querySelector('.links-menu');

// criar uma função que quando o botão de hamburguer for clicador irá aplicar/retirar a classe open, assim o menu será exibido e ocultado

hamburguer.addEventListener('click',() =>{
      linksMenu.classList.toggle('open');
  });
