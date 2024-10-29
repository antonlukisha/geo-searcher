import React, { useState } from 'react';
import "./styles.css";

function Description({ place }) {
    const [descriptionData, setDescriptionData] = useState(null);
    const [isOpen, setIsOpen] = useState(false);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    const fetchDescription = async (id) => {
        setError(null);
        setDescriptionData(null);
        if (isOpen) {
            setIsOpen(false);
            return;
        }
        setIsOpen(true);
        setLoading(true);
        try {
            const response = await fetch(`http://localhost:8080/description?id=${id}`);
            if (!response.ok) {
                throw new Error('Не удалось получить данные о погоде');
            }
            const data = await response.json();
            setDescriptionData(data);
        } catch (error) {
            console.error('Ошибка при получении данных описания:', error);
            setError('Не удалось получить данные описания. Попробуйте снова.');
        } finally {
            setLoading(false);
        }
    };

    return (
        <>
            <button onClick={() => fetchDescription(place.properties.xid) }>{place.properties.name}</button>
            {loading && <p>Загрузка данных...</p>}
            {error && <p style={{ color: 'red' }}>{error}</p>} {}
            {descriptionData && <p>{descriptionData.wikipedia_extracts ? descriptionData.wikipedia_extracts.text : "Описание отсутствует"}</p>}
        </>
      );
}

export default Description;
