import { useLocation } from "react-router-dom"

export default function DestComp() {
  const loc = useLocation();  // url 관련된 정보 ( url에 넣은 값이 뭔지 )
  const id = loc.state.id; // state 에 담은 id 
  const job = loc.state.job;
  return (
    <div>
      <h3> 이동한 컴포넌트 </h3>
      id:{id}<br />
      job:{job}


    </div>
  )
}