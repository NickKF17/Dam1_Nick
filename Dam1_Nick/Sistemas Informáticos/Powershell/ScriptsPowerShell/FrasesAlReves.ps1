clear-host
$frase = Read-Host "Frase a darle la vuelta"

$frasesinsalto=""

for($i=$frase.Length-1 ;$i -ge 0;$i--){
Write-host $frase.Substring($i,1)
$frasesinsalto+=$frase.Substring($i,1)
}
write-host $frasesinsalto