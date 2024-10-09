
import { useState, useEffect } from "react";
import axios from "axios";

export default function ProductList() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8081/products')
      .then(res => setProducts(res.data))
      .catch(err => console.error(err));
  }, []);

  return (
    <div>
      <h2>상품 목록</h2>
      <ul>
        {products.map(product => (
          <li key={product.id}>
            {product.name} - {product.price}원
          </li>
        ))}
      </ul>
    </div>
  );
}
