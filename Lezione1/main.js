console.log("skre");

const listaElementi = document.getElementById("listaElementi");

const nuovoElemento = (nomeTag, contenuto) => {
  const newElement = document.createElement(nomeTag);
  newElement.innerText = contenuto;
  return newElement;
};

const creaElementoByTag = tag => {
  return contenuto => {
    return nuovoElemento(tag, contenuto);
  };
};

const creaLi = creaElementoByTag("li");

const elementiDaAggiungere = [
  "primo elemento",
  "secondo elemento",
  "terzo elemento"
];

elementiDaAggiungere.forEach(e => {
  listaElementi.appendChild(creaLi(e));
});

console.log([1, 2, 3].map(x => x * x));

console.log(
  [1, 2, 1, 0, 23, 3.14, 3].filter(x => {
    return x < 2;
  })
);

const prova = "valore di prova";

const a = {
  test: 2,
  test2: 3,
  prova
};

const { test, test2 } = a; //destructuring

console.log(a);
