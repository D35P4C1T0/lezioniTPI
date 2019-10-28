let results = [];

// control references
const txtSearch = document.getElementById('txtSearch')
txtSearch.oninput = (evt) => {
  const searchText = evt.target.value
  if (searchText.length < 3) return;

  const filteredResults = results.filter(el => el.includes(searchText))
  updateResultList(filteredResults)
};

const GetData = () => {
  return ['primo', 'secondo', 'terzo']
};

GetData()

console.log(results)