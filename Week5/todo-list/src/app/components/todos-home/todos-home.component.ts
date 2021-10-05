import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todos-home',
  templateUrl: './todos-home.component.html',
  styleUrls: ['./todos-home.component.css']
})
export class TodosHomeComponent implements OnInit {

  hiddenToggle:boolean = true;

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

//an Array filled with the above todo1-todo3 objects
//We'll be calling from this in our HTML with String Interpolation
todosArray = [this.todo1, this.todo2, this.todo3];

//this function changes hiddenToggle back and forth between true/false
//we'll be calling this in our HTML with event binding
toggleVisibility(){
  this.hiddenToggle = !this.hiddenToggle; //setting the boolean to the opposite of itself
}



  constructor() { }

  ngOnInit(): void {
  }

}
