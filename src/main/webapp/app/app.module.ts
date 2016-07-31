import { NgModule }       from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { routing,
    appRoutingProviders } from './app.routing';

import { AppComponent }       from './app.component';
import { LoginComponent }    from './login.component';
import { GameComponent }    from './game.component';
import { PageNotFoundComponent }    from './page-not-found.component';

@NgModule({ 
    imports: [
        BrowserModule,
        FormsModule,
        routing
    ],
    declarations: [
        AppComponent,
        LoginComponent,
        GameComponent,
        PageNotFoundComponent
    ],
    providers: [
        appRoutingProviders
    ],
    bootstrap: [ AppComponent ]
})
export class AppModule {
}