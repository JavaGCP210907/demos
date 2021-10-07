//You can think of the models folder in Angular like the models package in Java
//We fill it with classes that we intend to make objects from
export class Pokemon {

    //this constructor will initialize the Pokemon's variables when we create one
    constructor(
        public name:string,
        public types:object,
        public sprite:object
    ) { }
}
