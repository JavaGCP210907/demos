console.log("==========================================(Functions)");

//Let's first make a basic named JS function
//Note, because of hoisting we can call the function before we declare it
helloWorld();

function helloWorld() {
    console.log("HELLO WORLD :)")
}

//Here's an anonymous function, it hasn't been named, but it's been assigned to a variable
var anon = function () {
    console.log("I'm an anonymous function!")
}
anon(); //using the anonymous function


//Arrow functions are pretty much like lambdas in Java, (arguments => expression)
var arrow = () => {console.log("I'm in an arrow function!")}
arrow(); //using the arrow function

//Callback functions take another function as a parameter and excute them
function func1(x) {
    console.log("Inside func1");
    console.log("x = " + x);
}

function func2(y, cb){
    console.log("Inside func2");
    cb(y); //so "cb" is intended to be a function, and take y as an argument
} 

func2(9, func1); //so we're going to call func2, and pass in func1 as the "cb" argument

//let's pass in an arrow function as the "cb" argument instead
func2(5, (x) => {console.log("You gave the arrow function: " + x)});

//In these two cases^^ func1 and the arrow function are the callback functions that func2 is invoking

//Let's look at closures
let HelloName = function (name){
    return function (){
        console.log("Hello " + name)
    }
}
//The nested function can access the name argument, but not change it

//assigning the variable nameBen to the HelloName function with the argument "Ben"
let nameBen = HelloName("Ben"); 

nameBen(); //"Hello Ben"

HelloName = HelloName("Nancy"); //now, we can never change the name value from Nancy

HelloName(); //"Hello Nancy"

let nameJohn = HelloName("John"); //this just causes helloName to run, with an argument it ignores

//nameJohn(); //error: nameJohn is not a function! it's not recognized by the compiler


console.log("=========================================(Global Scope)");

console.log(a); //prints undefined, because the declaration was hoisted 
                //(but the assignment to 5 happens later)

var a = 5; //var is globally scoped

console.log(a); //NOW it prints 5, because the assignment to 5 has happened.

//console.log(b); //error in console - b is a "let", so it's not hoisted

let b = "b"; 

console.log("now I can print the let variable of " + b);

console.log("==========================================(Local Scope)");

//block scope--------------------------------------------------------------------------------

console.log(c); //undefined, c has been defined in a block scope, so the value isn't visible out here

if(true) {
    var c = "I'm a var in a block. I'm block scoped!"
    console.log(c);
}

console.log(c); //NOW it prints out the String 

if(true) {
    let d = "I'm a let in a block. I'm block scoped!"
    console.log(d);
}

//console.log(d); //another reference error! let d is out of scope so it doesn't exist here

//functional scope-------------------------------------------------------------------------------------

function testScope() {
//var e is hoisted only to the top of the function, not the global scope. Since this is functional scoped.
    console.log(e); //undefined
    var e = "I'm a var in a function!";
    console.log(e); //"I'm a var in a function"
}

//the main difference between functional and block scopes is... 
//vars are not visible outside of functional scopes, while they are from block scopes

testScope(); //this prints the content of testScope
//console.log(e); //e is out of scope so this causes a reference error