import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pokedex',
  templateUrl: './pokedex.component.html',
  styleUrls: ['./pokedex.component.css']
})
export class PokedexComponent implements OnInit {

  //this is the input variable referred to by the two way binding in our HTML
  public input:number = 0; 


  constructor() { }

  ngOnInit(): void {
  }

  getPoke():void {
    
  }

}
