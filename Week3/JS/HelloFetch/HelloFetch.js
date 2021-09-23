//PokeAPI endpoint - making a variable to hold the URL, which will make for cleaner code 
const api="https://pokeapi.co/api/v2/pokemon/";

//when user clicks a button, execute the getData function
document.getElementById("btn").onclick = getData;

//This function will return our pokemon data
//I'm going to use the fetch api to return a promise object
//Remember, async tells a function to return a promise instead of a direct value
async function getData() {

    //put the user input into a variable
    let userInput = document.getElementById("userInput").value;

    //use the fetch() method to send a request to the PokeAPI with the user's input
    let response = await fetch(api+userInput); 
    //remember, await pauses the function until the promise is returned

    if(response.status === 200){ //if the response comes back with a successful status code
        let data = await response.json(); //parse the JSON in the response and turn it into a JS object
        populateData(data); //use our new JS object in the method below to populate the HTML
    } else {
        document.getElementById("data").innerHTML = "It got away!";
    }
}
//compare the getData() function to the ajaxFunc() in HelloAjax. This is cleaner/more concise


//this function will use the JS object we parsed from the response to populate our webpage with data
function populateData(data) {

    let dataSection = document.getElementById("data"); //this is our currently empty section element

    let nameTag = document.createElement("h3"); //create a header element
    nameTag.innerHTML = data.name; //assign the name of the Pokemon to the new header

    let pokePic = document.createElement("img");
    pokePic.setAttribute("src", data.sprites.front_default);

    let pokePic2 = document.createElement("img");
    pokePic2.setAttribute("src", data.sprites.back_default);

    //Actually populate the section element with the data gathered from the response
    dataSection.appendChild(nameTag);
    dataSection.appendChild(pokePic);
    dataSection.appendChild(pokePic2);

}
//see if we truly need await for the JSON parsing code - seems like we do