// import { useState } from "react";


function CountLikes({ likes, dislikes }) {


  return (

    <div>
      <h2>총 카운트 수 : {likes + dislikes}</h2>
    </div>

  )

}

export default CountLikes;