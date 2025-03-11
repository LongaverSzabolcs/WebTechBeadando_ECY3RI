//kiiratas
console.log('Hello World.');

//valtozok
let variable = 15;
console.log(variable);
variable = 'str;'
console.log(variable);
variable = false;
console.log(variable);

//konstans
const constant = 1;
console.log(constant);

//random
console.log(Math.random());

//elagazasok
const nameasd = 'feri';

if (nameasd) {
    console.log('felhnev:', nameasd);
} 
else {
    console.log('nincs ilyen feri');
}

//falsy: '', 0, false, null, undefined
//truthy: minden egyéb

//tombok
const values = [ 'red', 'blue', 0, true, null ];
let valuestwo = [ 'green', 1.3, undefined ];

//ciklusok
for(let i = 0; i < 5; i++) {
    console.log(i);
}

for(let i = 0; i < values.length; i++) {
    console.log(values[i]);
}

for(let i = 0; i < valuestwo.length; i++) {
    console.log(valuestwo[i]);
}

//indexek vegigjarasa
for (const index in values) {
    if (index % 2 == 1) {
        console.log(values[index]);
    }
}

//elemek vegigjarasa
for (const value of valuestwo) {
    console.log(value);
}

//transzformacios metodusok: map, filter
const exchangeRates = [ 201, 218, 209, 223, 193, 256, 189, 299 ];

//egyes honapokban 1500 ft hany eurot ert? (valami valami early 2010s)
const newArray = exchangeRates.map((rate) => 1500 / rate);

for (const val of newArray) console.log(val);

//200 ft feletti arfolyamok?
const secondArray = exchangeRates.filter((filt) => filt > 200);

for (const val of secondArray) console.log(val);

//fuggvenyek
function greet(name) {
    console.log('asd, ', name);
}

greet('janika');

function square(num) {
    return num * num;
}

console.log(square(2));

//objektumok
const person = {
    name: 'Janika',
    age: 99,
    active: true,
    dogs: [ 'n', '(You)' ],
    greet: function () {
        console.log('Hello, ', this.name);
    }
}

person.greet();
