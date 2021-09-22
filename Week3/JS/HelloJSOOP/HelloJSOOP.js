console.log("=======================(A class declaration for the Baby class)")
//defining a class with a class declaration (using the class keyword)
//we'll also add a constructor

class Baby {
    constructor(name, stinky, eyeColor){
        this.name = name;
        this.stinky = stinky;
        this.eyeColor = eyeColor;
    }

    cry() {
        alert(this.name + " goes *WAAAAAAAAAAAAAAHHH* from a class declaration")
    }
}

console.log(Baby); //print the contents of the Baby Class to the console

let baby1 = new Baby("Ben", false, "brown"); //create a new Baby object using the constructor

baby1.cry(); //make ben cry 



console.log("=======================(A variable called baby assigned to an object)");

//defining a class with a class expression (assigning an object to a variable)
//notice how baby and Baby can coexist! JavaScript treats them as two different things

let baby = {
    name:"Wilton",
    stinky:true,
    eyeColor:"gray",
    cry(){
        alert(this.name + " ALSO goes *WHAHAHWHWHWHWAAWAWAAWWA* from a class expression")
    }
}

console.log(baby); //print the contents of the baby variable (assigned to a class expression)

baby.cry(); //invoke the cry method

console.log("=====================(A variable called roboBaby that inherits from baby")

//using inheritance in JS!!

//here's a new object using another class expression
//use the __proto__ property to declare baby as a parent class
let roboBaby = {
    isRobotic:true,
    __proto__:baby //this makes the baby variable the parent of roboBaby
};

console.log(roboBaby.name); //we can access the "name" property of the baby variable

roboBaby.name = "BabyBot"; //we can also change the values of roboBaby's variables

console.log(roboBaby.name); //name changed!

roboBaby.cry(); //we can also invoke the inherited cry() method of the baby class 