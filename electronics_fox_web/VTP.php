<?php
if($_SERVER["REQUEST_METHOD"]=='GET'){
    require_once 'Conexion.php';

    $query = "SELECT * FROM producto";

    $resultados = array();

    if ($resultado = $conexion->query($query)) {
        while ($fila = $resultado->fetch_assoc()) {
            $resultados[] = $fila;
        }
        echo json_encode($resultados);
    } else {
        echo "error en la consulta";
    }

    $conexion->close();
}
?>
