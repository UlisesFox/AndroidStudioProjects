<?php
if($_SERVER["REQUEST_METHOD"]=='POST'){
    require_once 'Conexion.php';

    $code=$_POST["code"];
    $nombre=$_POST["nombre"];
    $costo=$_POST["costo"];
    $correo=$_POST["correo"];
    $categoria=$_POST["categoria"];
    $entrega=$_POST["entrega"];

    $query="INSERT INTO proveedor (code, nombre, costo, correo, categoria, entrega)
        VALUES('".$code."','".$nombre."','".$costo."','".$correo."','".$categoria."','".$entrega."')";
    
    $resultado=$conexion->query($query);
    if($resultado==true){
    }else{
        echo "error";
    }
    $conexion->close();
}
?>