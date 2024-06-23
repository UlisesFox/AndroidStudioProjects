<?php
if($_SERVER["REQUEST_METHOD"]=='POST'){
    require_once 'Conexion.php';

    $nombreT =$_POST["nombreT"];
    $contraT=$_POST["contraT"];
    $bin=$_POST["bin"];
    $entidad=$_POST["entidad"];
    $tipoT=$_POST["tipoT"];
    $cvv=$_POST["cvv"];
    $caducidad=$_POST["caducidad"];

    $query="INSERT INTO tarjeta (nombreT, contraT, bin, entidad, tipoT, cvv, caducidad)
        VALUES('".$nombreT."','".$contraT."','".$bin."','".$entidad."','".$tipoT."','".$cvv."','".$caducidad."')";
    
    $resultado=$conexion->query($query);
    if($resultado==true){
    }else{
        echo "error";
    }
    $conexion->close();
}
?>