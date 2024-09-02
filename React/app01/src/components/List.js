import axios from "axios";// axios 라이브러리를 가져와 HTTP 요청을 보냅니다.
import { useEffect, useState } from "react"; // React 훅을 가져옵니다. useEffect는 컴포넌트의 생명주기를 관리하고, useState는 상태를 관리합니다.

export default function List() {
  const [list, setList] = useState([]);  // 컴포넌트의 상태로 list를 설정합니다. 초기값은 빈 배열입니다.

  useEffect(() => {
    axios.get('http://localhost:8081/boards')  // axios를 사용하여 백엔드에서 데이터를 가져옵니다.
      .then(function (res) {
        if (res.status === 200) {
          setList(res.data.list); // 응답에서 list 배열만 추출하여 상태로 설정 
        } else {
          alert("비정상 응답");
        }
      })
      .catch(function (error) {
        console.error("There was an error fetching the board list:", error);
        alert("데이터를 가져오는 중 오류가 발생했습니다.");
      });
  }, []);// 빈 배열을 두 번째 인자로 전달하여 컴포넌트가 처음 렌더링될 때만 이 효과가 실행되도록 합니다.

  return (
    <div>
      <h2>글 목록</h2>

      {list.map((item, index) => (
        <div key={index}>
          <p>제목: {item.title}</p>
          <p> 내용: {item.content}</p>
          {/* writer가 객체일 경우 특정 속성을 사용하여 렌더링 */}
          <p>작성자: {item.writer.name}</p>
          <p>작성일: {new Date(item.wdate).toLocaleString()}</p> <hr />
        </div>
      ))}

    </div>
  );
}
