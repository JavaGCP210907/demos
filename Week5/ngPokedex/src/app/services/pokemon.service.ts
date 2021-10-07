import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pokemon } from '../models/pokemon';

@Injectable({
  providedIn: 'root'
})

//Remember, the Services are what give functionality to our components
//We inject services into components, thus giving the component the service's data/functions 
export class PokemonService {

  //we dependency inject HttpClient in order to make HTTP requests in this service class 
  constructor(private http:HttpClient) { }

  //This function will get Pokemon data from the API
  //Note - we use a GET request to get a Pokemon object, and return it as an observable
    //Note note - we use observables to get data from a server. 
  getPokemonFromApi(id:number):Observable<Pokemon>{
    return this.http.get("https://pokeapi.co/api/v2/pokemon/" + id + "/") as Observable<Pokemon>
  }
  
  //this^^^ is like an easier way to do fetch()
  //we now have to inject this service into the pokedex component to use this function

}
