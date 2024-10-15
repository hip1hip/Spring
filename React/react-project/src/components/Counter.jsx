import { useState } from "react";


function Counter() {

  const [count, setCount] = useState(0);

  function handleCountUp() {
    setCount(count + 1)


  }


  return (

    <div>

      <p>You clicked <span>{count}</span> times </p>

      <button onClick={handleCountUp}>

        Click me !

      </button>

    </div>

  )

}

export default Counter;