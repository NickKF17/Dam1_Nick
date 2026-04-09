let i =0;
while (i < 10) {
    i++;

    if (i === 5) {
       continue; // Salta el resto del código en esta iteración y continúa con la siguiente
    }
    if (i === 8) {
        break; // Sale del bucle completamente
    }   
    console.log(i);
}