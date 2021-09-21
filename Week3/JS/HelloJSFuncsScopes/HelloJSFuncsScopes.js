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


console.log("======================================================(Global Scope)");





console.log("======================================================(Local Scope)");


