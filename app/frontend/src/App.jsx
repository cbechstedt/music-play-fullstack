import './App.css'
import Login from './pages/Login'
import { Routes, Route, Navigate } from 'react-router-dom'
import Search from './pages/Search'
import { UserProvider } from './context/UserContext'
import Profile from './pages/Profile'
import Favorites from './pages/Favorites'
import Album from './pages/Album'
import Register from './pages/Register'
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Home from './pages/Home'

function App() {

  return (
    <>
      <UserProvider>
        <Routes>
          <Route path='/home' element={<Home />}></Route>
          <Route path='/' element={<Login />}></Route>
          <Route path='/search' element={<Search />}></Route>
          <Route path='/album/:id' element={<Album />}></Route>
          <Route path='/favorites' element={<Favorites />}></Route>
          <Route path='/profile' element={<Profile />}></Route>
          <Route path='/register' element={<Register />}></Route>
          <Route path='*' element={<Navigate to='/home' />}></Route>
        </Routes>
      </UserProvider>
      <ToastContainer />
    </>
  )
}

export default App
