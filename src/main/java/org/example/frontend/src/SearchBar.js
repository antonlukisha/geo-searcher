import React, { useState } from 'react';
import "./styles.css";

function SearchBar({ onSearch }) {
  const [inputValue, setInputValue] = useState('');

  const handleSearch = () => {
    if (inputValue.trim() !== '') {
      onSearch(inputValue);
    }
  };

  return (
    <div className="search-bar">
      <input
        type="text"
        value={inputValue}
        onChange={(event) => setInputValue(event.target.value)}
        placeholder="Введите местоположение..."
      />
      <button onClick={handleSearch}>Поиск</button>
    </div>
  );
}

export default SearchBar;
