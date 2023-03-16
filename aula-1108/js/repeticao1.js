
//usando for - deve ser usado quando sabemos um número de repetições
for (let i = 0; i < 10; i++) {
    console.log(`Número sorteado : ${parseInt(Math.random()*100)}`);    
}
console.log(`-----------------------------------------------------------------`);
//usando o while - deve ser usado quando não sabemos o número de repetições
//sortear o número 22 em um universo de 0 a 100

let  numeroSorteado = parseInt(Math.random()*100);
let contador = 1;

while (numeroSorteado !== 22) {
    numeroSorteado = parseInt(Math.random()*100);
    contador++;
}
console.log(`Número sorteado : ${numeroSorteado}`);
console.log(`Foram feitos: ${contador} sorteios até o 22`);

//do while - obriga a execução da estrutur pelo menos 1 vez

let n = 0;
do {
        console.log(`Exibindo a contagem em ${n}`);
        n++;    
} while (n <= 10);

