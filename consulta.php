<?php
include 'db_connection.php';
$conn = OpenCon();
echo "Connected Successfully";

$sql = "SELECT * FROM teste";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
  // output data of each row
  while($row = $result->fetch_assoc()) {
    echo "id: " . $row["id"]. " - Name: " . $row["nome"]. " " . $row["image_src"]. " " . $row["empresas"]. "<br>";
    echo("<img src='".$row["image_src"]."' alt='imagem' width='200px' height='200px'><br/><br/>");
}
} else {
  echo "0 results";
}
$conn->close();
//CloseCon($conn);

?>
