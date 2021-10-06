import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PokedexComponent } from './components/pokedex/pokedex.component';
import { WelcomeComponent } from './components/welcome/welcome.component';

//Remember, routing lets us move components in and out of the page dynamically
//Actions on the webpage will result in different paths, thus moving components in and out
const routes: Routes = [

{
  path:"welcome",
  component:WelcomeComponent
},

{
  //empty string is the base path. So when I go to localhost:4200, I get WelcomeComponent
  //so why have any path with "welcome" at all? In case we want to go back to it!
  path:"", 
  component:WelcomeComponent 
},

{
  path:"pokedex",
  component:PokedexComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
