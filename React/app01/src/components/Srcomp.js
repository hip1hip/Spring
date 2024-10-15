import { useNavigate } from "react-router-dom"

export default function Srcomp() {
  const navigate = useNavigate();  // 페이지 이동 
  const a = () => {
    navigate('/dest', { state: { id: 1, job: '개발자' } }); //제이슨 형태로 값을 반환 
  }

  return (
    <div>
      <h2>Button</h2>
      <button onClick={a}>다른페이지 이동 </button>
    </div>
  )
}