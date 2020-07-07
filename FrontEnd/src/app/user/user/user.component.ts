import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { fromEvent } from 'rxjs';
import { ajax } from 'rxjs/ajax';
import { debounceTime, distinctUntilChanged, filter, map, switchMap } from 'rxjs/operators';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  constructor(private userService: UserService) { }
  public users: any;
  private input: any;
  ngOnInit(): void {

    const searchBox = document.getElementById('search-box');

    const typeahead = fromEvent(searchBox, 'input').pipe(
      map((e: KeyboardEvent) => {
        this.input = (e.target as HTMLInputElement).value;
        return this.input;
      }),
      filter(text => text.length > 2),
      debounceTime(10),
      distinctUntilChanged(),
      switchMap(() => ajax('https://5b344f77d167760014c265ab.mockapi.io/_tai/user')),

    );

    typeahead.subscribe(data => {
      this.users = data.response.filter((res) =>  res.name.includes(this.input));
    });
  }

}
