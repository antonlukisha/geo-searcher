import React, { useState } from 'react';
import WeatherInfo from './WeatherInfo';
import PlacesInfo from './PlacesInfo';
import "./styles.css";

function Info({ location }) {
    const [weatherData, setWeatherData] = useState(null);
    const [placesData, setPlacesData] = useState(null);
    const [loadingWeather, setLoadingWeather] = useState(false);
    const [loadingPlaces, setLoadingPlaces] = useState(false);
    const [isOpenWeather, setIsOpenWeather] = useState(false);
    const [isOpenPlaces, setIsOpenPlaces] = useState(false);
    const [error, setError] = useState(null);

    const fetchWeatherData = async (lat, lng) => {
        setError(null);
        setWeatherData(null);
        if (isOpenWeather) {
            setIsOpenWeather(false);
            return;
        }
        setIsOpenWeather(true);
        setLoadingWeather(true);
        try {
            const response = await fetch(`http://localhost:8080/weather?lat=${lat}&lon=${lng}`);
            if (!response.ok) {
                throw new Error('Не удалось получить данные о погоде');
            }
            const data = await response.json();
            setWeatherData(data);
        } catch (error) {
            console.error('Ошибка при получении данных о погоде:', error);
            setError('Не удалось получить данные о погоде. Попробуйте снова.');
        } finally {
            setLoadingWeather(false);
        }
    };

    const fetchPlacesData = async (lat, lng) => {
        setError(null);
        setPlacesData(null);
        if (isOpenPlaces) {
            setIsOpenPlaces(false);
            return;
        }
        setIsOpenPlaces(true);
        setLoadingPlaces(true);
        try {
            const response = await fetch(`http://localhost:8080/places?lat=${lat}&lon=${lng}`);
            if (!response.ok) {
                throw new Error('Не удалось получить данные о местах');
            }
            const data = await response.json();
            setPlacesData(data);
        } catch (error) {
            console.error('Ошибка при получении данных о местах:', error);
            setError('Не удалось получить данные о местах. Попробуйте снова.');
        } finally {
            setLoadingPlaces(false);
        }
    };

    return (
        <>
            <button onClick={() => fetchWeatherData(location.point.lat, location.point.lng)}>Показать погоду</button>
            {loadingWeather && <p>Загрузка погоды...</p>}
            {weatherData && <WeatherInfo weather={weatherData} />}
            <button onClick={() => fetchPlacesData(location.point.lat, location.point.lng)}>Показать места</button>
            {loadingPlaces && <p>Загрузка мест...</p>}
            {placesData && <PlacesInfo places={placesData} />}
            {error && <p style={{ color: 'red' }}>{error}</p>}
        </>
    );
}

export default Info;
