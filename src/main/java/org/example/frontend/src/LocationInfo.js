import React from 'react';
import Info from './Info';
import "./styles.css";

function LocationInfo({ locations = [] }) {
    return (
        <div className="location-info">
            <h1 className="location-cap">Найденные локации</h1>
            <ul>
                {Array.isArray(locations) && locations.length > 0 ? (
                    locations.map((location) => (
                        <li key={location.osm_id}>
                            <h2>Локация: {location.name}, {location.country}</h2>
                            <p>Широта: {location.point.lat}</p>
                            <p>Долгота: {location.point.lng}</p>
                            <br></br>
                            <Info location={location}/>
                        </li>
                    ))
                ) : (
                    <p>Локации не найдены.</p>
                )}
            </ul>
        </div>
    );
}

export default LocationInfo;
