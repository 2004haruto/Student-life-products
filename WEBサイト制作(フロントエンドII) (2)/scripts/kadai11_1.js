document.addEventListener('DOMContentLoaded', () => {
    const app = document.getElementById('app');
    const loadButton = document.getElementById('loadButton');

    const loadDogImages = async () => {
        const response = await fetch('https://dog.ceo/api/breeds/image/random/12');
        const data = await response.json();
        return data.message;
    };

    const renderImages = async () => {
        const images = await loadDogImages();
        app.innerHTML = images.map(imgSrc => `<img src="${imgSrc}" alt="Dog">`).join('');
    };

    loadButton.addEventListener('click', renderImages);

    renderImages(); // ページロード時に画像を表示
});
