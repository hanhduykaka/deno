import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserComponent } from './user/user.component';
import { AcountComponent } from './acount/acount.component';



@NgModule({
  declarations: [UserComponent, AcountComponent],
  imports: [
    CommonModule
  ],
  exports: [
    UserComponent
  ]
})
export class UserModule { }
