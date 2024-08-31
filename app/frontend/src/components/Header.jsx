import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { useUser } from '../context/UserContext';
import '../styles/Header.css'
import Logo from '../images/logo-musicplay.png'

const Header = () => {
  const { user: { username }, isLoggedIn, logout } = useUser();

  const navigate = useNavigate();

  const handleLogOut = () => {
    logout();
    navigate('/');
  }

  const handleLogIn = () => {
    navigate('/')
  }

  const handleSignUp = () => {
    navigate('/register')
  }

  const handleLogoClick = () => {
    navigate('/search')
  }

  return (
    <header className='header-content'>
      <img
        src={Logo}
        alt="MusicPlay Logo"
        onClick={handleLogoClick}
        style={{ cursor: 'pointer' }}
      />
      <div className='links-content'>
        <Link to="/search">Search</Link>
        <Link to="/favorites">Favorites</Link>
      </div>
      <div>
        {isLoggedIn ? 
        <div className='account'>
          <p>{username}</p>
          <button onClick={handleLogOut}>Log out</button>
        </div> :
        <div className='account'>
          <button onClick={handleLogIn}>Log in</button>
          <button onClick={handleSignUp}>Sign up</button>
        </div>}
      </div>
    </header>
  );
};

export default Header;

{/* <span className='user-content'>
  {`Welcome, ${username}`}
</span>
<button className='btn-logout' onClick={handleLogOut}>
  Log out
</button> */}