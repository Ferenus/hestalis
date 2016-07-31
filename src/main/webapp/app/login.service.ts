import { Injectable }     from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';

import { Login }          from './login';
import { Observable }     from 'rxjs/Observable';

@Injectable()
export class LoginService {
    constructor (private http: Http) {}

    private loginUrl = 'rest/v1/login';

    login (username: string, password: string): Observable<string> {
        let body = 'username=' + username + '&password=' + password;
        let headers = new Headers({ 'Content-Type': 'application/x-www-form-urlencoded' });
        let options = new RequestOptions({ headers: headers });

        return this.http.post(this.loginUrl, body, options)
            .map(res => res.text());
    }
}