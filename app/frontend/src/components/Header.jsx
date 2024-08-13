import React, { useState, useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { useUser } from '../context/UserContext';
import '../styles/Header.css'
import Logo from '../images/logo-musicplay.png'

const Header = () => {
  const { user: {username} } = useUser();
  const navigate = useNavigate();

  const handleLogOut = () => {
    navigate('/');
  }

  const handleLogIn = () => {
    navigate('/')
  }

  const handleSignUp = () => {
    navigate('/register')
  }

  const handleLogoClick = () => {
    navigate('/home')
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
      <div className='account'>
        <button onClick={handleLogIn}>Log in</button>
        <button onClick={handleSignUp}>Sign up</button>
        {/* <span className='user-content'>
          {`Welcome, ${username}`}
        </span>
        <button className='btn-logout' onClick={handleLogOut}>
          Log out
        </button> */}
      </div>
    </header>
  );
};

export default Header;
