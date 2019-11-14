const urlApi = document.getElementById('urlApi')
const loadingButton = document.getElementById('loadingButton')

loadingButton.onclick = loadData

const accessKey =
    'd069cc2dd9e584b20a67073c45d5d1a037cddac68c067e9ff32442eabc862df4'

const loadData = () => {
  fetch('https://api.unsplash.com/photos/?client_id=' + accessKey)
      .then(response => response.json())
      .then(body => {})
}
