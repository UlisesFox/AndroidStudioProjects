<?php
if($_SERVER["REQUEST_METHOD"]=='POST'){
    require_once 'Conexion.php';

    $codeP=$_POST["codeP"];
    $nombreP=$_POST["nombreP"];
    $precioP=$_POST["precioP"];
    $categoriaP=$_POST["categoriaP"];
    $descuentoP=$_POST["descuentoP"];

    $query="INSERT INTO producto (codeP, nombreP, precioP, categoriaP, descuentoP)
        VALUES('".$codeP."','".$nombreP."','".$precioP."','".$categoriaP."','".$descuentoP."')";
    
    $resultado=$conexion->query($query);
    if($resultado==true){
    }else{
        echo "error";
    }
    $conexion->close();
}
?>