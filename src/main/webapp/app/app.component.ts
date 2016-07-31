import { Component } from '@angular/core';
import { LoginComponent } from './login.component';
import './rxjs-operators';

import { HTTP_PROVIDERS } from '@angular/http';

@Component({
    selector: 'my-app',
    template: `
    <nav>
        <a routerLink="/game" routerLinkActive="active">Game</a>
        <a routerLink="/login" routerLinkActive="active">Login</a>
    </nav>
    <router-outlet></router-outlet>
  `,
    providers: [ HTTP_PROVIDERS ],
    directives: [ LoginComponent ]
})
export class AppComponent {}

/*
<hs-login></hs-login>
<nav *ng-if="false">
<a routerLink="/game" routerLinkActive="active">Game</a>
<a routerLink="/login" routerLinkActive="active">Login</a>
    </nav>*/
