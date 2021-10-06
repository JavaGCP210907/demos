import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todos-home',
  templateUrl: './todos-home.component.html',
  styleUrls: ['./todos-home.component.css']
})
export class TodosHomeComponent implements OnInit {

  //toggles whether the todo cards are visible
  hiddenToggle:boolean = true;

  //toggles whether the greeting div is visible
  greeterDiv:boolean = true;

  //stores the user inputted name from the greeting div
  name:string = "";

  todo1 = {
    id:1,
    content: "Wake Up",
    status: "Incomplete"
  }

  todo2 = {
    id:2,
    content: "Grab a Brush",
    status: "Incomplete"
  }

  todo3 = {
    id:3,
    content: "something else ",
    status: "Incomplete"
  }

  todo4 = {
    id:4,
    content: "demonstrate *ngIf",
    status: "Complete"
  }

  todo5 = {
    id:5,
    content: "demonstrate *ngFor",
    status: "Complete"
  }

//an Array filled with the above todo1-todo3 objects
//We'll be calling from this in our HTML with String Interpolation
todosArray = [this.todo1, this.todo2, this.todo3, this.todo4, this.todo5];

//this function changes hiddenToggle back and forth between true/false
//we'll be calling this in our HTML with event binding
toggleVisibility(){
  this.hiddenToggle = !this.hiddenToggle; //setting the boolean to the opposite of itself
}

//when the user submits their name, it will hide the div that asks for the name
submitName() {
  this.greeterDiv = false;
}

  constructor() { }

  ngOnInit(): void {
  }

}
