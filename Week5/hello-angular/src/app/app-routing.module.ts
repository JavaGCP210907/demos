import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnotherComponentComponent } from './components/another-component/another-component.component';

//The more dynamic way to display components is through ROUTING!!
//We use routing to move components in and out of the page
//For this basic demo, we have to manually append a URI to see this component
//In the future, we'll use our webpage logic to move components around
const routes: Routes = [
  //every valid route needs a path, and a component connected to that path
  {
   path:"another", //path is the URI to reach this component
   component: AnotherComponentComponent //component refers to the class name of the component
    //remember to IMPORT the component 
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
