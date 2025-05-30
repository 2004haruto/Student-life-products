async function getWeather() {
    const apiKey = '5b15c2502be34f6c88fffe80170ab019'; 
    const city = document.getElementById('city').value;

    if (!city) {
        alert('都市名を入力してください。');
        return;
    }

    const apiUrl = `https://api.openweathermap.org/data/2.5/weather?q=${city}&units=metric&lang=ja&appid=${apiKey}`;
    try {
        const response = await fetch(apiUrl);
        const data = await response.json();

        if (data.cod === '404') {
            alert('都市が見つかりません。有効な都市名を入力してください。');
            return;
        }

        displayWeather(data);
    } catch (error) {
        console.error('天気情報の取得中にエラーが発生しました:', error);
        alert('天気情報の取得中にエラーが発生しました。再試行してください。');
    }
}

function displayWeather(data) {
    const weatherInfo = document.getElementById('weather-info');
    const cityName = data.name;
    const temperature = data.main.temp;
    const weatherDescription = data.weather[0].description;
    const iconId = data.weather[0].icon;

    // URLの構築
    const iconUrl = `https://openweathermap.org/img/wn/${iconId}@4x.png`;

    const weatherHtml = `
        <h2>${cityName}</h2>
        <p>気温：${temperature} ℃</p>
        <p>天気：${weatherDescription}</p>
        <img id="weather-icon" src="${iconUrl}" alt="天気アイコン">
    `;

    weatherInfo.innerHTML = weatherHtml;
}
