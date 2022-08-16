import {HttpHeaders} from "@angular/common/http";


export class UrlService {

  static headers: { headers: HttpHeaders } = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }


  //static urlApi: string = "https://topchefapp.azurewebsites.net";
  static urlApi: string = "http://localhost:8080"

  static urlSignIn : string = "/auth/signin";
  static urlLogIn : string = "/auth/login";

  static urlGetUserByToken : string = "/users/getUser"

  static urlCreateCook : string='/users/createCook';
  static urlGetListCooks : string='/users/getCookList'
  static urlGetCookById: string = "/cook/";
  static urlGetIngredient : string = "/cook/ingredients/";

  //Recipes
  static urlGetRecipes : string = "/cook/getRecipe/";
  static urlDoRecipe : string ="/cook/doRecipe/";

  //Lessons
  static urlGetOwnedLessons : string = "/cook/lessons/ownedByCook/";
  static urlGetLessonsToBuy : string ="/cook/lessons/toBuy/";
  static urlBuyLesson : string= "/cook/lessons/buy/";
  static urlDoLesson : string= "/cook/lessons/doLesson/";

}
