<?php
if($_SERVER["REQUEST_METHOD"]=='POST'){
    require_once 'Conexion.php';

    $codeP=$_POST["codeP"];
    $nombreP=$_POST["nombreP"];
    $precioP=$_POST["precioP"];
    $categoriaP=$_POST["categoriaP"];
    $descuentoP=$_POST["descuentoP"];

    $query="UPDATE producto SET nombreP='$nombreP', precioP='$precioP', categoriaP='$categoriaP', descuentoP='$descuentoP' WHERE codeP='$codeP'";
    
    $resultado=$conexion->query($query);
    
    if($conexion->affected_rows > 0){
        if ($resultado === TRUE){

        }else{

        }
    }else{
        echo "error no hay consultas";
    }

    $conexion->close();
}
?>