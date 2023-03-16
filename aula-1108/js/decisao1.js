const numero = parseInt(Math.random()*100);
console.log(`O número sorteado foi : ${numero}`);

if (numero % 2 === 0) {
    console.log(`O número ${numero} é par`);
} else {
    console.log(`O número ${numero} é ímpar`);
}

//switch testar uma variável
const numero2 = parseInt(Math.random()*3);
switch (numero2) {
    case 0:
        console.log(`Sorteou o número zero`);
        break;
    case 1:
        console.log(`Sorteou o numero um`);
        break;
    default:
       console.log(`Sorteou o número dois`);    
}




