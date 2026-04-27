async function fetchWeather() {
    const city = document.getElementById("cityInput").value.trim();
    const days = document.getElementById("daysInput").value;

    if (!city || !days) {
        alert("Enter city and days");
        return;
    }

    const API_URL = `http://localhost:8080/weather/forecast?city=${city}&days=${days}`;

    try {
        const response = await fetch(API_URL);
        const data = await response.json();

        renderCurrent(data.weatherResponse);
        renderForecast(data.dayTemp);

    } catch (error) {
        console.error("Error:", error);
    }
}

function renderCurrent(current) {
    document.getElementById("location").innerText =
        `${current.city}, ${current.region}, ${current.country}`;

    document.getElementById("condition").innerText = current.condition;

    document.getElementById("temp").innerHTML =
        `${parseFloat(current.temp).toFixed(1)}°C`;
}

function renderForecast(days) {
    const forecastDiv = document.getElementById("forecast");
    forecastDiv.innerHTML = "";

    days.forEach(day => {
        const card = document.createElement("div");
        card.className = "card";

        const date = new Date(day.date);
        const dayName = date.toLocaleDateString("en-US", { weekday: "short" });

        card.innerHTML = `
            <h4>${dayName}</h4>
            <p>${day.date}</p>
            <p>Avg: ${day.avgTemp}°C</p>
            <p class="max">Max: ${day.maxTemp}°C</p>
            <p class="min">Min: ${day.minTemp}°C</p>
        `;

        forecastDiv.appendChild(card);
    });
}