document.addEventListener('DOMContentLoaded', async () => {
  const content = document.getElementById('content');
  const searchBtn = document.getElementById('searchBtn');
  const searchDialog = document.getElementById('searchDialog');

  const fetchHeritageList = async () => {
    try {
      const response = await fetch('https://click.ecc.ac.jp/ecc/y_arikawa/web2/getHeritageList.php');
      const data = await response.json();
      return data;
    } catch (error) {
    }
  };

  const displayHeritageList = async (list) => {
    content.innerHTML = '';
    const heritageContainer = document.createElement('div');
    heritageContainer.classList.add('heritage');
  
    list.forEach((heritage) => {
      const heritageItem = document.createElement('div');
      heritageItem.classList.add('item');
      heritageItem.innerHTML = `
        <img src="images/${heritage.id}.webp" alt="${heritage.name}" width="250">
        <div class="description">
          <p class="name">${heritage.name}</p>
          <p class="country">${heritage.country}</p>
        </div>
      `;
      heritageContainer.appendChild(heritageItem);
    });
  
    content.appendChild(heritageContainer);
  };

  const performSearch = async (searchName, searchCountry) => {
    try {
      const response = await fetch(`https://click.ecc.ac.jp/ecc/y_arikawa/web2/searchHeritageList.php?name=${searchName}&country=${searchCountry}`);
      const searchData = await response.json();
      if (searchData.length === 0) {
      } else {
        displayHeritageList(searchData);
      }
    } catch (error) {
    }
    searchDialog.close();
  };

  searchBtn.addEventListener('click', () => {
    searchDialog.showModal();
  });

  const searchForm = searchDialog.querySelector('form');
  searchForm.addEventListener('submit', async (event) => {
    event.preventDefault();
    const searchName = document.getElementById('searchName').value;
    const searchCountry = document.getElementById('searchCountry').value;
    await performSearch(searchName, searchCountry);
  });

  const closeIcon = searchDialog.querySelector('.material-icons');
  closeIcon.addEventListener('click', () => {
    searchDialog.close();
  });

  // 初期表示
  const heritageList = await fetchHeritageList();
  displayHeritageList(heritageList);
});
