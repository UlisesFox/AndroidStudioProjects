<?php
if($_SERVER["REQUEST_METHOD"]=='POST'){
    require_once 'Conexion.php';

    $codeP=$_POST["codeP"];

    $query="DELETE FROM producto WHERE codeP = '$codeP'";

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