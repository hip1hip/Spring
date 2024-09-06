import { useState } from "react";
import axios from "axios";

export default function ProductRegister() {
  const [inputs, setInputs] = useState({ name: '', description: '', price: '', quantity: '' });
  const [imageFile, setImageFile] = useState(null);

  const { name, description, price, quantity } = inputs;

  const onChange = (e) => {
    const { name, value } = e.target;
    setInputs({
      ...inputs,
      [name]: value
    });
  };

  const onFileChange = (e) => {
    setImageFile(e.target.files[0]);
  };

  const submitProduct = () => {
    const formData = new FormData();
    // 상품 정보를 각각 FormData에 추가
    formData.append('name', name);
    formData.append('description', description);
    formData.append('price', price);
    formData.append('quantity', quantity);
    formData.append('image', imageFile); // 이미지 파일 추가

    axios.post('http://localhost:8081/products', formData, {
      headers: { 'Content-Type': 'multipart/form-data' }
    })
      .then((response) => {
        console.log('상품 등록 성공', response.data);
        alert('상품 등록에 성공했습니다!');
      })
      .catch((error) => {
        console.error('상품 등록 실패', error);
        alert('상품 등록에 실패했습니다.');
      });
  };

  return (
    <div>
      <h2>상품 등록</h2>
      <input type="text" name="name" value={name} onChange={onChange} placeholder="상품명" />
      <input type="text" name="description" value={description} onChange={onChange} placeholder="설명" />
      <input type="number" name="price" value={price} onChange={onChange} placeholder="가격" />
      <input type="number" name="quantity" value={quantity} onChange={onChange} placeholder="수량" />
      <input type="file" onChange={onFileChange} />
      <button onClick={submitProduct}>상품 등록</button>
    </div>
  );
}
