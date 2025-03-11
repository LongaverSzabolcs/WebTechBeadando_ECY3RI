let tippCounter = 0;
const random = getRandomInt(1000000);
console.log('GO');
alert(`Gondoltam egy számra 0 és egymillió között.`);
console.log(random);

while(tippCounter < 20) {
    let tipp = parseInt(prompt(`Eddigi tippjeid száma: ${tippCounter}`));

    if(tipp < 0 || isNaN(tipp) || tipp > 1000000) {
        console.log('INVALID');
        alert('Ervenytelen tipp');
        tippCounter++;
    }
    
    else if (tipp > random) {
        console.log('BIG');
        alert(`${tippCounter}. tipp nem talált: A megoldás kisebb.`);
        tippCounter++;
    }

    else if (tipp < random) {
        console.log('SMALL');
        alert(`${tippCounter}. tipp nem talált: A megoldás nagyobb.`);
        tippCounter++;
    }

    else if (tipp == random) {
        console.log('EXACT');
        alert(`Eltaláltad. A megoldás: ${random}`);
        tippCounter = 777;
    }

}

if (tippCounter==777) {
    console.log('YOURE WIRAR');
    alert(`Gratulálok, ${tippCounter} lépésből eltaláltad!`);
}
else {
    console.log('its joever');
    alert('Sajnos ez most nem sikerült!')
}

//lopva a mozilla.org oldalrol - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Math/random
function getRandomInt(max) {
    return Math.floor(Math.random() * max);
  }
  