# Apuntes de Python con funciones

### Cosillas básicas
- _type()_: devuelve el tipo de dato que es
~~~
x = 5
y = "John"
print(type(x))
print(type(y))
~~~
- _for x in "banana":_ Forma básica de usar un for
```
for x in "banana":
  print(x)
```
- _len()_: devuelve longitud de un texto
```
a = "Hello, World!"
print(len(a))
```
- _in:_ es para saber si algo está dentro de algo, principalmente cadenas
```
txt = "The best things in life are free!"
if "free" in txt:
  print("Yes, 'free' is present.")
```
-   _Slicing:_ recortar cosas de cadenas, tuplas o listas
```
b = "Hello, World!"
print(b[2:])
print(b[-5:-2])
```
- Cosas para modificar strings
```
a = " Hello, World!"
print(a.upper())
print(a.lower())
print(a.strip()) # returns "Hello, World!"
print(a.replace("H", "J"))
print(a.split(",")) # returns ['Hello', ' World!']
    #Con esto se puede dividir cosas en dos secciones
    c, b = a.split(",")
```
- Para formatear cosillas
```
age = 36
txt = f"My name is John, I am {age}"
print(txt)
price = 59
txt = f"The price is {price:.2f} dollars"
print(txt)
```
- Esto es para poner caracteres literales como comillas o tabulaciones
```
\'	Single Quote	
\\	Backslash	
\n	New Line	
\r	Carriage Return	
\t	Tab	
\b	Backspace
```
- Más metodos con cadenas
```
capitalize()	Converts the first character to upper case
casefold()	Converts string into lower case
center()	Returns a centered string
count()	Returns the number of times a specified value occurs in a string
encode()	Returns an encoded version of the string
endswith()	Returns true if the string ends with the specified value
expandtabs()	Sets the tab size of the string
find()	Searches the string for a specified value and returns the position of where it was found
format()	Formats specified values in a string
format_map()	Formats specified values in a string
index()	Searches the string for a specified value and returns the position of where it was found
isalnum()	Returns True if all characters in the string are alphanumeric
isalpha()	Returns True if all characters in the string are in the alphabet
isascii()	Returns True if all characters in the string are ascii characters
isdecimal()	Returns True if all characters in the string are decimals
isdigit()	Returns True if all characters in the string are digits
isidentifier()	Returns True if the string is an identifier
islower()	Returns True if all characters in the string are lower case
isnumeric()	Returns True if all characters in the string are numeric
isprintable()	Returns True if all characters in the string are printable
isspace()	Returns True if all characters in the string are whitespaces
istitle()	Returns True if the string follows the rules of a title
isupper()	Returns True if all characters in the string are upper case
join()	Joins the elements of an iterable to the end of the string
ljust()	Returns a left justified version of the string
lower()	Converts a string into lower case
lstrip()	Returns a left trim version of the string
maketrans()	Returns a translation table to be used in translations
partition()	Returns a tuple where the string is parted into three parts
replace()	Returns a string where a specified value is replaced with a specified value
rfind()	Searches the string for a specified value and returns the last position of where it was found
rindex()	Searches the string for a specified value and returns the last position of where it was found
rjust()	Returns a right justified version of the string
rpartition()	Returns a tuple where the string is parted into three parts
rsplit()	Splits the string at the specified separator, and returns a list
rstrip()	Returns a right trim version of the string
split()	Splits the string at the specified separator, and returns a list
splitlines()	Splits the string at line breaks and returns a list
startswith()	Returns true if the string starts with the specified value
strip()	Returns a trimmed version of the string
swapcase()	Swaps cases, lower case becomes upper case and vice versa
title()	Converts the first character of each word to upper case
translate()	Returns a translated string
upper()	Converts a string into upper case
zfill()	Fills the string with a specified number of 0 values at the beginning
```
### Listas
#### La forma básica de una lista es así
```
thislist = ["apple", "banana", "cherry"]
print(thislist)
print(thislist[-1])
print(thislist[2:5])
```
- Otra vez el _in_ para saber si algo existe:
```
thislist = ["apple", "banana", "cherry"]
if "apple" in thislist:
  print("Yes, 'apple' is in the fruits list")
```
- cambiar elementos de una lista
```
thislist = ["apple", "banana", "cherry"]
thislist[1] = "blackcurrant"
print(thislist)
thislist = ["apple", "banana", "cherry", "orange", "kiwi", "mango"]
thislist[1:3] = ["blackcurrant", "watermelon"]
print(thislist)
```
- Añadir elementos a una lista _.append()_
```
thislist = ["apple", "banana", "cherry"]
thislist.append("orange")
print(thislist)
```
- Reemplazar elementos de una lista a través de indexación _.insert()_
```
thislist = ["apple", "banana", "cherry"]
thislist.insert(1, "orange")
print(thislist)
```
- Unir dos listas en python _.extend()_
```
thislist = ["apple", "banana", "cherry"]
tropical = ["mango", "pineapple", "papaya"]
thislist.extend(tropical)
print(thislist)
```
- Se pueden eliminar elementos de una lista de varias maneras:
    1. Por el elemento _.remove()_, este elimina el primer elemento que se encuentra, en el caso de que los elementos se repitan
    ```
    thislist = ["apple", "banana", "cherry", "banana", "kiwi"]
    thislist.remove("banana")
    print(thislist)
    ```
    2. remover por indexación o eliminar el último elemento (sin un numero dentro del paréntesis) _.pop()_
    ```
    thislist = ["apple", "banana", "cherry"]
    thislist.pop(1)
    print(thislist)
    ```
    3. remover por indexacion o eliminar la lista entera con _.del()_
    ```
    thislist = ["apple", "banana", "cherry"]
    del thislist[0]
    print(thislist)
    del thislist
    ```
    4. Limpiar la lista con _.clear()_
    ```
    thislist = ["apple", "banana", "cherry"]
    thislist.clear()
    print(thislist)
    ```
- Ordenar una lista
```
thislist = ["orange", "mango", "kiwi", "pineapple", "banana"]
thislist.sort #(reverse = True)
print(thislist)
```
### Diccionarios
#### Crear y printar un diccionario
```
thisdict = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
print(thisdict)
```     
            - duplicar dos cosas hacen que se sobreescriban dentro del diccionario
- Acceder a items de diccionarios
```
thisdict = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
print(thisdict["brand"])
x = thisdict.get("model")
print(x)
```
- Obtener todas las llaves, así tambien se puede añadir cosas en un diccionario
```
x = thisdict.keys()
car = {
"brand": "Ford",
"model": "Mustang",
"year": 1964
}

x = car.keys()

print(x) #before the change

car["color"] = "white"

print(x)
```
- con _.items()_ imprimes o asignas un diccionario con tuplas, ira we
```
car = {
"brand": "Ford",
"model": "Mustang",
"year": 1964
}

x = car.items()

print(x) #before the change

car["year"] = 2020

print(x) #after the change
```
- asegurarse de que una llave exista
```
thisdict = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
if "model" in thisdict:
  print("Yes, 'model' is one of the keys in the thisdict dictionary")
```
- otra forma de cambiar datos
```
thisdict = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}
thisdict.update({"year": 2020})
```
- 
```
```
- 
```
```
- 
```
```
- 
```
```