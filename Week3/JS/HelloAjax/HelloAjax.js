//Get by id the HTML elements that I want to populate with data
let pokename = document.getElementById("pokename");
let poketype = document.getElementById("poketype");
let pokenum = document.getElementById("pokenum");
let pokepic = document.getElementById("pokepic");

//set event listener for button click
let button = document.getElementById("btn");
button.addEventListener("click", ajaxFunc); 
//when the button clicked, it will send a request to the pokeapi server using the ajaxFunc below

//this function will send the user input to the server, and get a request back
function ajaxFunc() {

    //gather the user's input
    let num = document.getElementById("userInput").value; //.value is how we can parse user input

    //initialize an XHR object to send/recieve data
    let xhr = new XMLHttpRequest();

    //this functionality will execute every time the event listener fires (since readystate changes)
    xhr.onreadystatechange = function() {

        //if (and ONLY if) the response is ready && if status code === 200 (ok)
        if(this.readyState===4 && this.status===200) {
            //this takes the JSON we get back as a response, and puts it into a JS object
            let data = JSON.parse(xhr.responseText);
            //see function below - takes our data variable and change the HTML accordingly
            renderHTML(data);
        }
    }

    //open will open a connection to the server we want to send requests to
    //open(method, URL, async)
    xhr.open("GET", "https://pokeapi.co/api/v2/pokemon/" + num, true)
    //send will send the request to the server
    xhr.send();

    //so every time the button is clicked, this function will run...
    //it will open and sane a request to the server with the URL on line 35
    //which should give us back a pokemon object from the pokeAPI.

}

//this function will manipulate the DOM based on the user's input & the response from the server
function renderHTML(data) {

    //populate the previously empty text held by the elements
    pokename.innerText = data.name;
    pokenum.innerText = data.id;
    poketype.innerText = data.types[0].type.name;
    if(data.types[1]){ //if there's a second pokemon type...
        poketype.append(", " + data.types[1].type.name); //append it!
    }

    //pokepic - need to set the previously empty src attribute
    pokepic.setAttribute("src", data.sprites.front_shiny);

}
