import React, { useEffect, useState } from "react";
import API from "../services/api";
import "./ViewProducts.css";

function ViewProducts() {

  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {

    API.get("/products/all")
      .then(res => {
        setProducts(res.data);
        setLoading(false);
      })
      .catch(err => {
        console.error("Error fetching products", err);
        setLoading(false);
      });

  }, []);

  return (

    <div className="product-list-container">

      <div className="product-list-card">

        <h2>Product List</h2>

        {loading ? (
          <p className="loading">Loading products...</p>
        ) : (

          <table className="product-table">

            <thead>
              <tr>
                <th>ID</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Category</th>
              </tr>
            </thead>

            <tbody>

              {products.length === 0 ? (
                <tr>
                  <td colSpan="5" className="no-data">
                    No products found
                  </td>
                </tr>
              ) : (

                products.map(p => (
                  <tr key={p.pid}>
                    <td>{p.pid}</td>
                    <td>{p.pname}</td>
                    <td>₹{p.price}</td>
                    <td>{p.quantity}</td>
                    <td>{p.category}</td>
                  </tr>
                ))

              )}

            </tbody>

          </table>

        )}

      </div>

    </div>

  );
}

export default ViewProducts;