// usando construtor forma mais antiga
const letras = new Array('g','k','p','t','i','o');
console.log(letras);

//forma mais simples - atual
const personagens = ['Leia', 'Anakin', 'Han Solo', 'Chewbacca', 'R2D2', 'Darth Vader', 'Obi Wan'];
console.log(personagens);
console.log(personagens[3]);

// exibir na forma de uma tabela
console.table(personagens);

//evite esse tipo de coisa
const coisas = ['Batman', 12355, true, 666.77, 'Robin'];
console.log(coisas);

//alterando conteúdo
personagens[0] = 'Yoda'
console.log(personagens);

personagens[0] = 'Leia';

//inserir um novo conteúdo no fim do array
personagens.push('C3PO');
console.log(personagens);

//remover o elemento
const conteudoRetirado1 = personagens.pop();
console.log(personagens);
console.log(conteudoRetirado1);

//inserir no início 
personagens.unshift('BB8');
console.log(personagens);

//retirar o primeiro indice
const conteudoRetirado2 = personagens.shift();
console.log(personagens);
console.log(conteudoRetirado2);

//retirar um elemento de um posição qualquer // posicao inicial + quantos remover
personagens.splice(3,2);
console.log(personagens);

// inserir novos elementos no indice desejado - posição inicial + quantos remover + os novos valores
personagens.splice(3,0,'R2D2', 'Chewbacca');
console.log(personagens);

//retirar conteúdo mas manter o indice
delete personagens[0];
console.log(personagens);

personagens[0] = 'Leia';
console.log(personagens);

//percorrer uma parte do array - fatiar o array
console.log(personagens.slice(2,6));

//copiar uma parte do array
const arrayCopiado = personagens.slice(2,6);
console.log(personagens);
console.log(arrayCopiado);

//valores por referência - o que vc faz em um reflete no outro
const personagens1 = personagens;

personagens1.pop();
console.log(personagens1);
//modificar também o personagens
console.log(personagens);

personagens.push('Obi Wan');
console.log(personagens);
console.log(personagens1);

//para copiar um array - spread operator(...) - não faz referência
const personagens2 = [...personagens];
console.log(personagens2);

personagens2.pop()
console.log(personagens2);
console.log(personagens);

//tornando uma string um array
const frase = 'O rato roeu a roupa do rei de Roma';
console.log(frase);

// nesse exemplo o espaço a cada espaço em branco encontrado, gera um novo indice -
// Podemos também definir a quantidade de elementos que será usada
//caso não passe nenhum parâmetro, a frase inteira será o um array de apenas 1 indice
const fraseVirouArray = frase.split(' ',3);
console.log(fraseVirouArray);

//tornar um array uma frase
const arrayVirouFrase = fraseVirouArray.join(' ');
console.log(arrayVirouFrase);

//concatenar arrays
const novosPersonagens = ['Hank','Sheila','Boby'];
const personagensJuntos = personagens.concat(novosPersonagens,'teste', fraseVirouArray);
console.table(personagensJuntos);

//concatenar com spread(...)
const novosPersonagens2 = [...personagens, ...personagensJuntos, ...novosPersonagens, 'Israel', ...[4,5,6,7,8]];
console.table(novosPersonagens2);