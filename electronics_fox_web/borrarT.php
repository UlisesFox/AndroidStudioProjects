<?php
if($_SERVER["REQUEST_METHOD"]=='POST'){
    require_once 'Conexion.php';

    $nombreT =$_POST["nombreT"];

    $query="DELETE FROM tarjeta WHERE nombreT = '$nombreT'";

    $resultado=$conexion->query($query);

    if($conexion->affected_rows > 0){
        if ($resultado === TRUE){
            
        }
    }else{
        echo "error no hay consultas";
    }

    $conexion->close();
}
?>