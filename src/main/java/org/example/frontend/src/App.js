import React, { useState } from 'react';
import SearchBar from './SearchBar';
import LocationInfo from './LocationInfo';
import "./styles.css";

function App() {
    const [locationData, setLocationData] = useState(null);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    const fetchLocationData = async (location) => {
        setLoading(true);
        setLocationData(null);
        setError(null);
        try {
            const response = await fetch(`http://localhost:8080/locations?location=${location}`);
            if (!response.ok) {
                throw new Error('Не удалось получить данные о местоположении');
            }
            const data = await response.json();
            setLocationData(data);
        } catch (error) {
            console.error('Ошибка при получении данных о местоположении:', error);
            setError('Не удалось получить данные о местоположении. Попробуйте снова.');
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="app">
            <SearchBar onSearch={(location) => fetchLocationData(location)} />
            {loading && <p>Загрузка...</p>}
            {error && <p style={{ color: 'red' }}>{error}</p>} {}
            {locationData && <LocationInfo locations={locationData.hits} />} {}
        </div>
    );
}

export default App;
