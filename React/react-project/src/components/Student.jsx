

function Student({ name, age, major }) {

  return (
    <>
      <h2 style={{ textDecoration: age >= 20 ? 'underline' : 'none' }}>
        {name} :{age} : {major}
      </h2>
    </>
  );
}

export default Student;