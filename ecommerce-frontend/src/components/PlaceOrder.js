import React, { useState } from "react";
import API from "../services/api";
import "./PlaceOrder.css";

function PlaceOrder() {

  const [order, setOrder] = useState({
    orderDate: "",
    quantity: "",
    totalPrice: "",
    user: { eid: "" },
    product: { pid: "" }
  });

  const handleChange = (e) => {

    const { name, value } = e.target;

    if (name === "eid") {
      setOrder({ ...order, user: { eid: value } });
    } 
    else if (name === "pid") {
      setOrder({ ...order, product: { pid: value } });
    } 
    else {
      setOrder({ ...order, [name]: value });
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await API.post("/orders/save", order);
      alert("✅ Order Placed Successfully");

      setOrder({
        orderDate: "",
        quantity: "",
        totalPrice: "",
        user: { eid: "" },
        product: { pid: "" }
      });

    } catch (error) {
      alert("❌ Failed to place order");
      console.error(error);
    }
  };

  return (

    <div className="order-container">

      <div className="order-card">

        <h2>Place Order</h2>

        <form onSubmit={handleSubmit}>

          <div className="form-group">
            <label>Order Date</label>
            <input
              type="date"
              name="orderDate"
              value={order.orderDate}
              onChange={handleChange}
              required
            />
          </div>

          <div className="form-group">
            <label>Quantity</label>
            <input
              type="number"
              name="quantity"
              placeholder="Enter quantity"
              value={order.quantity}
              onChange={handleChange}
              required
            />
          </div>

          <div className="form-group">
            <label>Total Price</label>
            <input
              type="number"
              name="totalPrice"
              placeholder="Enter total price"
              value={order.totalPrice}
              onChange={handleChange}
              required
            />
          </div>

          <div className="form-group">
            <label>User ID</label>
            <input
              type="number"
              name="eid"
              placeholder="Enter user ID"
              value={order.user.eid}
              onChange={handleChange}
              required
            />
          </div>

          <div className="form-group">
            <label>Product ID</label>
            <input
              type="number"
              name="pid"
              placeholder="Enter product ID"
              value={order.product.pid}
              onChange={handleChange}
              required
            />
          </div>

          <button type="submit" className="order-btn">
            Place Order
          </button>

        </form>

      </div>

    </div>

  );
}

export default PlaceOrder;