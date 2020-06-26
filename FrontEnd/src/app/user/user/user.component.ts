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

  ngOnInit(): void {

    const searchBox = document.getElementById('search-box');

    const typeahead = fromEvent(searchBox, 'input').pipe(
      map((e: KeyboardEvent) => (e.target as HTMLInputElement).value),
      filter(text => text.length > 2),
      debounceTime(10),
      distinctUntilChanged(),
      switchMap(() => ajax('https://5b344f77d167760014c265ab.mockapi.io/_tai/user')),
      filter((res) => {
        const results = res.response;
        console.log(results)
        return results;
      })
    );

    typeahead.subscribe(data => {
      this.users = data;
    });
  }

}
