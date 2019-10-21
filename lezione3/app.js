const inputText = document.getElementById('inputText')
let emoji

const loadData = () => {
  fetch('https://provajson--professorandrea.repl.co/emoji.json')
      .then(r => r.json())
      .then(body => {
        if (emoji.lenght > 0) return;
        emoji = body
      })
};

const replaceEmoji = (text) => {
  let originalText = text
  text.split(' ').forEach(word => {
    const filteredEmoji = emoji.filter(e => e.name.includes(word))
    if (filteredEmoji) {
      originalText.replace(word, filteredEmoji[0].char)
    }
  })
  return originalText
};

inputText.onchange = (e => {
let content = e.target.value
inputText.value = replaceEmoji(content)
})