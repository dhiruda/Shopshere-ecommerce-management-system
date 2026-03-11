import React, { useState } from "react";
import AddProduct from "./components/AddProduct";
import ViewProducts from "./components/ViewProducts";
import PlaceOrder from "./components/PlaceOrder";
import Login from "./components/Login";
import Register from "./components/Register";
import "./App.css";

function App() {

  const [page, setPage] = useState("login");
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  // Dashboard
  if (isLoggedIn) {
    return (
      <div>

        <h1 className="main-title">ShopSphere E-Commerce System</h1>

        {/* Logout Button */}
        <div className="logout-container">
          <button
            className="logout-btn"
            onClick={() => setIsLoggedIn(false)}
          >
            Logout
          </button>
        </div>

        <AddProduct />
        <ViewProducts />
        <PlaceOrder />

      </div>
    );
  }

  return (
    <div>

      {page === "login" && (
        <Login
          onLogin={() => setIsLoggedIn(true)}
          goToRegister={() => setPage("register")}
        />
      )}

      {page === "register" && (
        <Register goToLogin={() => setPage("login")} />
      )}

    </div>
  );
}

export default App;