const url = "http://localhost:8090/" //putting our base URL in a variable for cleaner code below
//eventually we'll use this in our fetch requests and make calls to the server by appending endpoints

//add functionality to our buttons using a eventlisteners
//so when these buttons gets clicked, the appropriate function will be called
document.getElementById("getAvengerButton").addEventListener("click", assembleFunc);
document.getElementById("loginButton").addEventListener("click", loginFunc);


async function assembleFunc() { //async returns a promise (which fetch returns)

    //we will send a fetch request to get our avenger data
    let response = await fetch(url + "avengers");

    console.log(response);

    if(response.status === 200) { //if the request comes back successful...

        let data = await response.json(); //get the JSON data, turn it into a JS object

        //For every Avenger object we get back, put it in the table
        for(let avenger of data){

            let row = document.createElement("tr"); //create a table row

            let cell = document.createElement("td"); //create a cell for the field
            cell.innerHTML = avenger.av_id; //fill the cell with the appropriate avenger data
            row.appendChild(cell); //add the td element (cell) to the tr element (row)

            //then we do this ^ for every field in the avenger model
            let cell2 = document.createElement("td"); 
            cell2.innerHTML = avenger.av_name; 
            row.appendChild(cell2);

            let cell3 = document.createElement("td"); 
            cell3.innerHTML = avenger.av_power; 
            row.appendChild(cell3);

            let cell4 = document.createElement("td"); 
            cell4.innerHTML = avenger.first_name; 
            row.appendChild(cell4);

            let cell5 = document.createElement("td"); 
            cell5.innerHTML = avenger.last_name; 
            row.appendChild(cell5);

            let cell6 = document.createElement("td"); 
            cell6.innerHTML = avenger.power_level; 
            row.appendChild(cell6);

            let cell7 = document.createElement("td"); 
            //this would return the entire home object so we look only for the homeName
            cell7.innerHTML = avenger.home_fk.home_name; 
            row.appendChild(cell7);

            //the tr called row that we created in the for loop gets appended to the table body
            //a new row will be appended for ever Avenger object that comes in
            document.getElementById("avengerBody").appendChild(row);

        }

    }

}

//login functionality below-----------------

//this function will send the user-inputted login credentials to our server
async function loginFunc(){

    //gather the user input from the login inputs
    let usern = document.getElementById("username").value; 
    let userp = document.getElementById("password").value;



}

