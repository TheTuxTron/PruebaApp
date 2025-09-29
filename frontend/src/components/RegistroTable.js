import React from "react";

function RegistroTable({ registros }) {
  if (!registros || registros.length === 0) {
    return <p>No se encontraron registros.</p>;
  }

  return (
    <table border="1" cellPadding="8" style={{ borderCollapse: "collapse", width: "100%" }}>
      <thead>
        <tr>
          <th>ID</th>
          <th>Estudiante</th>
          <th>Código</th>
          <th>Materia</th>
          <th>Periodo</th>
          <th>Aprobada</th>
        </tr>
      </thead>
      <tbody>
        {registros.map((r) => (
          <tr key={r.id}>
            <td>{r.id}</td>
            <td>{r.nombreEstudiante}</td>
            <td>{r.codigoEstudiante}</td>
            <td>{r.nombreMateria}</td>
            <td>{r.nombrePeriodo}</td>
            <td>{r.aprobada ? "Sí" : "No"}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default RegistroTable;
