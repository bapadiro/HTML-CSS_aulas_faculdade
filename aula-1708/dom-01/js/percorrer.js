//pergar os elementos desejados

// pegar pelo id 
// forma 1 - mais antiga
const todosHerois = document.getElementById('tabela-herois');
console.log(todosHerois);

//forma 2 mais atual - mais genérica - apenas o primeiro que ele encontar
const heroiUm = document.querySelector('#heroi-um');
console.log(heroiUm);

// pegar pela class 
//forma 1 - mais antiga
const pegarHeroi = document.getElementsByClassName('heroi');
console.log(pegarHeroi);

// forma 2  querySelectorAll - RETORNA TODOS QUE ENCONTRAR
const nomeHeroi = document.querySelectorAll('.nome');
console.log(nomeHeroi);
console.log(nomeHeroi[3]);
console.log(nomeHeroi[3].textContent);
nomeHeroi[3].textContent = 'Mulher Maravilha';

//pegar pela tag - forma 1
const heroisTds = document.getElementsByTagName('td');
console.log(heroisTds);

// pegar pela tag - forma 2
const heroisTrs = document.querySelectorAll('tr');
console.log(heroisTrs);







