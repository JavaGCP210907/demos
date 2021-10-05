import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todos-home',
  templateUrl: './todos-home.component.html',
  styleUrls: ['./todos-home.component.css']
})
export class TodosHomeComponent implements OnInit {

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





  constructor() { }

  ngOnInit(): void {
  }

}
