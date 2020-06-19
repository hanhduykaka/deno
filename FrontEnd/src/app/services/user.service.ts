import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() {

    console.log(environment.production);
  }

  getUSer(){

  }

}
