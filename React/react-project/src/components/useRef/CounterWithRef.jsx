import { useState, useRef } from 'react';

function CounterWithRef() {
  const [count, setCount] = useState(0); // 상태를 사용하여 카운트 값 관리
  const countRef = useRef(0); // useRef로 카운트 값 관리

  const increment = () => {
    setCount(count + 1); // 상태 값을 1 증가
    countRef.current += 1; // useRef의 current 값도 1 증가
    console.log("count (state):", count); // 상태 값 출력
    console.log("countRef (ref):", countRef.current); // ref 값 출력
  };

  return (
    <div>
      <p>상태로 관리하는 카운트: {count}</p>
      <p>useRef로 관리하는 카운트: {countRef.current}</p>
      <button onClick={increment}>증가</button>
    </div>
  );
}

export default CounterWithRef;
