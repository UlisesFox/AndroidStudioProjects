<?php

    $hostname="localhost"; 
    $username="root";
    $password=""; 
    $database="electronics_fox";

    $conexion= new mysqli($hostname,$username,$password,$database);

if($conexion->connect_error){
    die("Error ". $mysql->connect_error);
}else{
}

?>