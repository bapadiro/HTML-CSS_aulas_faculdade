
//pegar o botao que chamará a funcão
const btnCalcular = document.querySelector('#calcular');
btnCalcular.addEventListener('click', CalcularXP);

function CalcularXP() {

    //pegar todos os elementos com a classe heroi
    const herois = document.querySelectorAll('.heroi');
    console.log(herois);

    // for que irá percorrer o array de herois - pegando as informações para calcular o XP
    for (let i = 0; i < herois.length; i++) {

        //pegando os dados de cada heroi - ELES RETORNAM COMO STRING - CUIDADO
        let velocidadeHeroi = Number(herois[i].querySelector('.velocidade').textContent);

        //pegar a agilidade 
        let agilidadeHeroi = Number(herois[i].querySelector('.agilidade').textContent);

        //pegar a força
        let forcaHeroi = Number(herois[i].querySelector('.forca').textContent);

        // calcular o xp
        let xpFinal = (velocidadeHeroi + agilidadeHeroi + forcaHeroi);
        // console.log(xpFinal);

        //exibindo na página
        herois[i].querySelector('.xp-final').textContent = xpFinal;

        if (xpFinal < 250) {
            //aplicando CSS aqui dentro - fora de boa prática - não faça
            // herois[i].style.backgroundColor = '#f60';
            // herois[i].style.color = '#fff';

            // adicionar uma classe
            herois[i].classList.add('bg-warning', 'text-light');

        }
    }
}