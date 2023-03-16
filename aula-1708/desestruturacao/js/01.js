const pessoas = ['Eu', 'Tu', 'Ele', 'Nós', 'Vós', 'Eles'];
console.log(pessoas);

// retrabalho
// const pessoa1 = pessoas[0];
// const pessoa2 = pessoas[1];

// atribuição por desestruturação
// const [pessoa1, pessoa2] = pessoas;
// console.log(pessoa1);
// console.log(pessoa2);

// atribuição - pegando os conteúdos e o resto do Array
// //operador rest - restante
// const [pessoa1, pessoa2, ...restante] = pessoas;
// console.log(pessoa1);
// console.log(pessoa2);
// console.log(restante);

//pulando elementos do array usar vírgula para pular
//o elemento
const [pessoa0, , pessoa2, ,pessoa4] = pessoas;
console.log(pessoa0);
console.log(pessoa2);
console.log(pessoa4);

const estados = [
    sudeste = ['SP', 'RJ', 'MG'], // 0
    norte = ['AC', 'AM', 'AP'],  // 1
    nordeste = ['BA', 'MA', 'PE'] // 2
];
console.log(estados);
console.log(estados[2][0]);

//pegar via desestruturação + trabalhosa
const [, ,[sigla]] = estados;
console.log(`Sigla do estao da Bahia: ${sigla}`);

//teoricamente mais fácil
const [regiao1, regiao2, regiao3] = estados;
console.log(`Exibindo: ${regiao2[1]}`);


