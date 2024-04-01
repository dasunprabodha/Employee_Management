import { Component } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isEmployeeListRoute: boolean = false;
  isAddEmployeeRoute: boolean = false;

  constructor(private router: Router) {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.isEmployeeListRoute = this.router.url === '/employees-list';
        this.isAddEmployeeRoute = this.router.url === '/add-employees';
      }
    });
  }
}