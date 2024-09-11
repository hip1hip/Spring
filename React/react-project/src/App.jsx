import './App.css'
// import Student from './components/Student'
// import Counter from './components/Counter';
// import MyComponent from './components/MyComponent';
import CountLike from './components/CountLike'

function App() {

  // const students = [
  //   { name: "John", age: 20, major: 'Computer Science' },
  //   { name: "Jane", age: 22, major: 'Mathematucs' },
  //   { name: "Alice", age: 19, major: 'Physics' },
  //   { name: "Bob", age: 21, major: 'Chemistry' },
  // ];

  return (
    <>
      {/* <MyComponent /> */}
      <CountLike />


      {/* {students.map((student) =>
        <Student
          key={student.id}
          {...student}
        />

      )} */}

      {/* <Student {...students[0]} />
      <Student {...students[1]} />
      <Student {...students[2]} />
      <Student {...students[3]} /> */}
    </>
  )
}

export default App;
