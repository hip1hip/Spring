import { useState } from "react";
import CountLikes from "./CountLikes";


function CountLike() {

  const [likes, setLikes] = useState(0);
  const [dislikes, setDislikes] = useState(0);

  function hendleLike() {
    setLikes(likes + 1)
  }
  function hendleDislike() {
    setDislikes(dislikes + 1)
  }


  return (

    <div>
      <button onClick={hendleLike}> 좋아요 </button>
      <span>{likes}</span>
      &nbsp;
      <button onClick={hendleDislike}> 싫어요 </button>
      <span>{dislikes}</span>

      <CountLikes likes={likes} dislikes={dislikes} />
    </div>

  )

}

export default CountLike;