const titulo = document.querySelector('h1');
console.log(titulo);


//criar a variável dos dados
let totalFinal = 0;

//sorteio + somatória + exibição dentro da página
for (let i = 0; i <= 9; i++) {
    let numeroSorteado = parseInt(Math.random()*7);
        while (numeroSorteado === 0) {
            numeroSorteado = parseInt(Math.random()*7);
        }
    
        //acumular valor dos dados
        totalFinal+=numeroSorteado;
        // criando uma tag img
        let img = document.createElement('img');

        // define o endereço das imagens após o sorteio
        img.src = './images/' + numeroSorteado + '.png';
        
        // buscar no html o id que receberá as imagens - dentro dele é que será
        // inserida a tag de imagem
        document.getElementById('elemento').appendChild(img);    
}
//pegar o id total e escrever o resultado final
document.querySelector('#total').innerHTML = `Somatória dos lançamentos: ${totalFinal}`;