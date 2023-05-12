import React, { useEffect, useState } from 'react';
import logo from './logo.svg';
import './App.css';

function App() {
  const [movies, setMovies] = useState([]);
  const [finalMovie, setFinalMovie] = useState(null);

  // useEffect(() => {
  //   fetchMovies();
  // }, []);

  const fetchMovies = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/v1/movies/getallmovies');
      const data = await response.json();
      setMovies(data);
      setFinalMovie(null);
    } catch (error) {
      console.error('Error fetching movies:', error);
    }
  };

  const handleGetFinalMovie = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/v1/movies/getfinalmovie');
      const data = await response.json();
      setFinalMovie(data);
    } catch (error) {
      console.error('Error fetching final movie:', error);
    }
  };

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <h2>Movie Recommender</h2>
        
        <div className="button-grid">
          <button className="button" onClick={fetchMovies}>Explore Movie Database API</button>
          <button className="button" onClick={handleGetFinalMovie}>Find a Movie to watch today API</button>
        </div>
        
        <div className="grid-content">
          {finalMovie && (
            <div>
              <h4>Final Movie</h4>
              <p>Title: {finalMovie.movieName}</p>
              <p>Genre: {finalMovie.movieGenre}</p>
              <p>Rating: {finalMovie.movieRating}</p>
              {finalMovie.svgLogo && (
                <div className="logo-container">
                  <img src={`data:image/svg+xml;charset=utf-8,${encodeURIComponent(finalMovie.svgLogo)}`} alt="Movie Logo" />
                </div>
              )}
            </div>
          )}

          {!finalMovie && (
            <div>
              {movies.length === 0 ? (
                <p>Loading movies...</p>
              ) : (
                <ul>
                  <h4>All Movies in the Database</h4>
                  {movies.map((movie) => (
                    <li key={movie.movieId}>{movie.movieName}</li>
                  ))}
                </ul>
              )}
            </div>
          )}
        </div>

        
      </header>
    </div>
  );
  
  
  }
  export default App;
