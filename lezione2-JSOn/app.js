const listaUtenti = document.getElementById("listaUtenti")
const loadingButton = document.getElementById("loadingButton")
const filterText = document.getElementById("filterText")

const addToUserList = user => {
  const li = document.createElement("li")
  li.innerHTML = user
  listaUtenti.appendChild(li)
}

let users = []

const UpdateList = filterPattern => {
  listaUtenti.innerHTML = ""
  let toDisplay
  if (filterPattern === "") {
    toDisplay = users
  } else {
    toDisplay = users.filter(user => user.includes(filterPattern))
  }
  toDisplay.forEach(user => addToUserList(user))
}

const loadData = () => {
  users = []
  fetch("https://provajson--professorandrea.repl.co/api/users")
    .then(response => response.json())
    .then(body => {
      const { people } = body
      people.forEach(user => users.push(user))
    })
    .then(() => UpdateList(""))
}

loadingButton.onclick = loadData
filterText.oninput = e => {
  const toMatch = e.target.value
  //console.log("change " + toMatch)
  UpdateList(toMatch)
}
