import React from 'react';
import "./styles.css";

function WeatherInfo({ weather }) {
  return (
    <div>
      <h3>Информация о погоде</h3>
      <p>Температура: {parseInt(weather.main.temp) - 273}°C</p>
      <p>Ощущается как: {parseInt(weather.main.feels_like) - 273}°C</p>
      <p>Влажность: {weather.main.humidity}</p>
      <p>Описание: {weather.weather[0].description}</p>
      <br></br>
    </div>
  );
}

export default WeatherInfo;
