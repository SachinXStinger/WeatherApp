// src/components/Weather.js
import { useState } from "react";
import axios from "axios";

const Weather = () => {
  const [city, setCity] = useState("");
  const [weatherData, setWeatherData] = useState(null);
  const [error, setError] = useState(null);

  const getWeather = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/weather/${city}`);
      setWeatherData(response.data);
      setError(null);
    } catch (err) {
      setWeatherData(null);
      setError(
        "City not found !!"
      );
    }
  };

  const kelvinToCelsius = (kelvin) => {
    return (kelvin - 273.15).toFixed(2);
  };

  return (
    <div className="mt-5 m-auto flex  justify-center text-center ">
      <div className="text-center">
        <h1 className="text-4xl text-white font-semibold ">Weather App</h1>
        <input
          type="text"
          value={city}
          onChange={(e) => setCity(e.target.value)}
          placeholder="Enter city name"
           className="input input-bordered input-primary m-3 max-w-xs mt-4"
        />
        <button onClick={getWeather} className="btn bg-purple-500 text-white">Get Weather</button>
        {error ? <p className="text-2xl mt-4">{error}</p> : null}
        {weatherData ? (
          <div className="card bg-neutral text-white w-96 mt-5 w-full">
            <div className="card-body items-center text-center ">
              <h2 className="card-title text-3xl">Weather in {weatherData.name}</h2>
              <p className="text-lg">Temperature : {kelvinToCelsius(weatherData.main.temp)} °C</p>
              <p className="text-lg">Humidity : {weatherData.main.humidity}%</p>
              <p className="text-lg">Temperature can be described as <span className="text-purple-500">{weatherData.weather[0].description}</span> , and feels like <span className="text-purple-500">{kelvinToCelsius(weatherData.main.feels_like)} °C</span></p>
              
            </div>
          </div>
        ) : null}
      </div>
    </div>
  );
};

export default Weather;
