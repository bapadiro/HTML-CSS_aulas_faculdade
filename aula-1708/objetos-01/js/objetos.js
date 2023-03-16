// // Criando um objeto literalmente
// const pessoa1 = {
//     nome: 'Israel',
//     idade: 49,
//     email: 'profisrael.copi@fiap.com.br'   
// }
// console.log(pessoa1);
// console.log(pessoa1.email);

// const pessoa2 = {
//     nome: 'Gondo',
//     idade: 29,
//     email: 'profgondo@fiap.com.br'
// }
// console.log(pessoa2);
// console.log(`Idade: ${pessoa2.idade}`);


// criar uma fábrica de objetos através de uma função 

function criarPessoas(nome, idade, email) {
    return{
        nome,
        idade,
        email
    }
}

const pessoa1 = criarPessoas('Israel', 49, 'aaaa@gmail.com');
const pessoa2 = criarPessoas('Gondo', 29, 'gondo@gmail.com');
const pessoa3 = criarPessoas('Allen', 39, 'allen@gmail.com');

console.log(pessoa1);
console.log(pessoa2);
console.log(pessoa3);

//criando métodos
function criarPet(nome, raca, idade){
    return {
        nome,
        raca, 
        idade,
    
        aumentarIdade(){
            this.idade++;
        },

        reduzirIdade(){
            this.idade--;
        }
    }
}

const animal1 = criarPet('Taleban', 'Pastor', 15);
console.log(animal1);
console.log(animal1.idade);

//Taleban fez aniversario
animal1.aumentarIdade();
console.log(animal1);
console.log(animal1.idade);

//Taleban diminiuu a idade
animal1.reduzirIdade();
console.log(animal1.idade);

console.log('----------DESESTRUTURAÇÃO EM OBJETOS ---------------');

const coisas = {
    tipo : 'Mesa',
    material : 'Madeira',
    dimensoes: {
        comprimento: 3.5,
        largura:1.5,
        altura: 1.5
    }
};

console.log(coisas);
//fazendo a atribuição por desestruturaçao
// const {tipo, material} = coisas;
// console.log(tipo);
// console.log(material);

// console.log(coisas);
// //fazendo a atribuição por desestruturaçao = mudando o nome da variável
// const {tipo : novoNome, material} = coisas;
// console.log(novoNome);
// console.log(material);


const {dimensoes: {largura, comprimento} } = coisas;
console.log(largura);
console.log(comprimento);

