const urls = document.getElementById('urls')
const loadingButton = document.getElementById('loadingButton')



const accessKey =
    'd069cc2dd9e584b20a67073c45d5d1a037cddac68c067e9ff32442eabc862df4'

const loadData = () => {
  fetch('https://api.unsplash.com/photos/?client_id=' + accessKey)
      .then(response => response.json())
      .then(body => {
        body.forEach(element => {const li = document.createElement('li')
    li.innerHTML = '<img> src="'} + );
      })
};

loadingButton.onclick = loadData