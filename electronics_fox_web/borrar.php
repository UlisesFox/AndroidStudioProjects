<?php
if($_SERVER["REQUEST_METHOD"]=='POST'){
    require_once 'Conexion.php';

    $code=$_POST["code"];

    $query="DELETE FROM proveedor WHERE code = '$code'";

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