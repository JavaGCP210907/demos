import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-pokedex',
  templateUrl: './pokedex.component.html',
  styleUrls: ['./pokedex.component.css']
})
export class PokedexComponent implements OnInit {

  //this is the input variable referred to by the two way binding in our HTML
  public input:number = 0; 

  //This pokemon object will be populated by the observable we get from the PokeAPI
  public pokemon:any = null; //left it of "any" type, but it will get populated with a Pokemon

  //dependency injection so that we can use the getPokeFromApi function of the service
  constructor(private ps:PokemonService) { }

  ngOnInit(): void {
  }

  //This is the function that gets our Pokemon object 
  //...from the funtion that gets it in the service as an observable
  //This will take an observable that we must SUBSCRIBE to in order to get the data it sends
  getPoke():void {
    this.ps.getPokemonFromApi(this.input).subscribe(
        //get the data out of the observable we subscribed to, and putting it in a Pokemon object
        (data:Pokemon) => {
           //assign it to our pokemon variable above
           this.pokemon = data;
           console.log(this.pokemon); //log the details of our pokemon
        },
        () => { //in case of errors, set pokemon to null, since we didn't get anything back
          this.pokemon = null;
          console.log("It got away!"); //quirky error message 0.o
        }
      
    )
  }



}
