clear-host
$cadena=Read-Host "Introduce cadena"
Write-host "introduciste" $cadena
$cont=0
$aux=""
for($i=0;$i -le $cadena.Length;$i++){
$c=$cadena[$i]
if($c -eq "a" -or $c -eq "e" -or $c -eq "i" -or $c -eq "o" -or $c -eq "u"){
$cont++
$aux+=","+$c 
}
}
Write-host "no. de vocales: " $cont" ,vocales obtenidas: "$aux 