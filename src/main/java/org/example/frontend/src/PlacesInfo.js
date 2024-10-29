import React from 'react';
import Description from "./Description";
import "./styles.css";

function PlacesInfo({ places }) {
    return (
        <div className="places-info">
            <h3>Интересные места</h3>
            <ul>
                {places.features
                    .filter(place => place.properties.name)
                    .map((place) => (
                        <li key={place.properties.xid}>
                            <Description place={place} />
                        </li>
                ))}
            </ul>
        </div>
      );
}

export default PlacesInfo;
