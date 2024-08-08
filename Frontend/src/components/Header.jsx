const Header = () => {
  return (
    <div className="navbar bg-purple-500 text-white">
    <div className="flex-1">
      <a className="btn btn-ghost text-2xl">WeatherApp</a>
    </div>
    <div className="flex-none">
      <ul className="menu menu-horizontal px-2 text-xl">
        <li><a>Login</a></li>
       
      </ul>
    </div>
  </div>
  );
};

export default Header;
