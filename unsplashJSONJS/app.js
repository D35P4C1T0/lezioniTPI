const urlList = document.getElementById('urlList')
const loadingButton = document.getElementById('loadingButton')
const searchBar = document.getElementById('searchBar')
let searchTerm = searchBar.value

const client_id =
    'd069cc2dd9e584b20a67073c45d5d1a037cddac68c067e9ff32442eabc862df4'

const loadData = () => {
  urlList.innerHTML = ''
  searchTerm = document.getElementById('searchBar').value
  fetch('https://api.unsplash.com/search/photos?client_id=' + client_id + '&query=' + searchTerm)
    .then(response => response.json())
    .then(data => {
      data.results.forEach(element => {
        const li = document.createElement('li')
  li.innerHTML = '<img src="' + element.urls.regular + '">'
        urlList.appendChild(li)
      })
    })
};

loadingButton.onclick = loadData
searchBar.onchange = loadData