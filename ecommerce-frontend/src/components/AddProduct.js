import React, { useState } from "react";
import API from "../services/api";
import "./AddProduct.css";

function AddProduct() {

  const [product, setProduct] = useState({
    pname: "",
    price: "",
    quantity: "",
    category: ""
  });

  const handleChange = (e) => {
    setProduct({
      ...product,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await API.post("/products/save", product);
      alert("✅ Product Added Successfully");

      setProduct({
        pname: "",
        price: "",
        quantity: "",
        category: ""
      });

    } catch (error) {
      alert("❌ Error adding product");
      console.error(error);
    }
  };

  return (
    <div className="add-product-container">

      <div className="product-card">

        <h2>Add New Product</h2>

        <form onSubmit={handleSubmit}>

          <div className="form-group">
            <label>Product Name</label>
            <input
              type="text"
              name="pname"
              value={product.pname}
              placeholder="Enter product name"
              onChange={handleChange}
              required
            />
          </div>

          <div className="form-group">
            <label>Price</label>
            <input
              type="number"
              name="price"
              value={product.price}
              placeholder="Enter price"
              onChange={handleChange}
              required
            />
          </div>

          <div className="form-group">
            <label>Quantity</label>
            <input
              type="number"
              name="quantity"
              value={product.quantity}
              placeholder="Enter quantity"
              onChange={handleChange}
              required
            />
          </div>

          <div className="form-group">
            <label>Category</label>
            <input
              type="text"
              name="category"
              value={product.category}
              placeholder="Enter category"
              onChange={handleChange}
              required
            />
          </div>

          <button type="submit" className="submit-btn">
            Save Product
          </button>

        </form>

      </div>

    </div>
  );
}

export default AddProduct;