import { useState } from "react";

function MyComponent() {

  const [text, setText] = useState('');
  const handleTextChange = (event) => {
    setText(event.target.value);
  };

  return (

    <div>
      <input type="text" value={text} onChange={handleTextChange} />
      <p>Input: {text}</p>
    </div>

  );

}
export default MyComponent;