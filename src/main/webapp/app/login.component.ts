import { Component } from '@angular/core';
import { LoginService } from './login.service';
import { Router } from '@angular/router';

@Component({
    selector: 'hs-login',
    templateUrl: 'app/partials/login.html',
    providers: [ LoginService ]
})
export class LoginComponent {
    username: string;
    password: string;

    constructor (private loginService: LoginService, private router: Router) {
    }

    login () {
        if (!this.username || !this.password) { return; }
        this.loginService.login(this.username, this.password)
            .subscribe(
                login => this.logSuccess(login),
                error =>  this.logError(error));
    }

    logSuccess(login) {
        this.router.navigate(['game']);
    }

    logError(error) {
        console.error(error);
    }
}