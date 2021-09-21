console.log("=================================================(Printing and Declaring Variables)");

//console.log will print to the console, not the actual webpage
console.log("Hello JavaScript! Please be nice to me"); //you don't need semicolons, but I like them

//JavaScript is loosely typed, so I can change the type of value that a variable holds.
var a = 100;
console.log(a);
a = true;
a = null;
a = "Now I'm a String!";
console.log(a);

//using the JS undefined data type
var b; //he exists, but has no value. It's value hasn't been defined
console.log("hello " + b);

//JS will add "var" implicitly if you're writing a variable for the first time
c = "I wasn't declared. JS will do the work for me though."
console.log("c is a " + typeof c); //string


//testing type coercion
var tc1 = "5" * 5;
console.log(tc1 + " is a " + typeof tc1); //25 is a number

var tc2 = "5" * "5";
console.log(tc2 + " is a " + typeof tc2); //25 is a number

var tc3 = 5 + "5";
console.log(tc3 + " is a " + typeof tc3); //55 is a string

var tc4 = "5" + 5;
console.log(tc4 + " is a " + typeof tc4); //55 is a string

//order doesn't matter when it comes to JS type coercion between two variables, but the operator does

//when we add more than two variables though, order tends to matter
var tc5 = 5 + 5 + "5"; //this becomes "10" + "5"
console.log(tc5 + " is a " + typeof tc5); //"105"

var tc6 = "5" + 5 + 5; //this becomes "5" + "5" + "5"
console.log(tc6 + " is a " + typeof tc6); //"555"

//"it's just math until a string gets in the mix" -Kevin 2021

console.log("================================================(Truthy/Falsy)")

//I want to write a function that compares two vars
function test(var1, var2) {
    console.log(var1 + " compared to " + var2);
    console.log(var1 == var2); //== compares values, as opposed to === which compares types
}

test("3", 3); //true - both evaluate to 3
test(0, false); //true - both evaluate to false
test(1, true); //true - both evalute to true
//this is where truthy/falsy gets quirky
test(2, true); //false - see below
test(2, false); //false - see below

//while 2 IS truthy, the boolean true is evaluated as the number 1, and false is evaluated to the number 0
//so comparing any number besides 1 and 0 to booleans will result in false

//some if statements to drive this point home ^
if(2){
    console.log("2 is truthy")
} else {
    console.log("2 is falsy")
}

if(0){
    console.log("0 is truthy")
} else {
    console.log("0 is falsy")
}

//a couple more falsy tests
test('', false); //true - both falsy
test(null, undefined); //true - both falsy

