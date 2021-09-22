console.log("=========================(DOM Selection/Manipulation)")

//I want all my divs with classname coolclassname (DOM Selection)
let divElements = document.getElementsByClassName("coolclassname");

console.log(typeof divElements); //object! We have an array of the divs with classname "coolclassname"

//we can access the objects in the divElements array
let firstDiv = divElements[0];
console.log(firstDiv); //the div's contents will get printed


//we can set attributes of element directly (DOM Manipulation), though it's not best practice
//there's an actual style object you can set properties of for every element
firstDiv.setAttribute("style", "background-color:pink;");


console.log("=============================(Events)")

//Let's assign a variable that applies to all buttons
let myButton = document.getElementsByTagName('button')[0]; //this will get the first(and only) button
//we should have just selected the element by ID, but Ben wanted to show the other getBy methods

myButton.onclick = domfunc

function domfunc(){
    console.log("domfunc is running");
    document.getElementById("b1").textContent = "Thanks for the click!";
    document.getElementById("p3").textContent = "Now I have content!";
}

//using eventlistener to handle events 

//this adds a listener to our heaver element, which executes a function when moused over
document.getElementById("header").addEventListener("mouseover", hoverFunc)
document.getElementById("header").addEventListener("mouseleave", releaseFunc)

function hoverFunc(){
    console.log("hoverFunc is running!");
    document.getElementById("header").textContent = "don't touch me!";

}

function releaseFunc(){
    console.log("releaseFunc is running!");
    document.getElementById("header").textContent = "why did you leave me :(";
}