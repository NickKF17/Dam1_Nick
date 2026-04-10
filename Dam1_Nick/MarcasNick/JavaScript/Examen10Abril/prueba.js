const items = document.querySelector(".item");

items.style.backgroundColor="blue" 
//Con el query selector si funciona perfectamente

const username = document.querySelector('#username').value;
const form = document.querySelector('#login-form');

form.addEventListener('submit', (e) => {
if (username == "") {

alert("El campo es obligatorio");
}
e.preventDefault();
});
// El prevent default va fuera del if

const btn = document.querySelector('#delete-btn');
btn.addEventListener('onclick', () => {
this.remove();
});

//Es onclick en lugar de click a secas