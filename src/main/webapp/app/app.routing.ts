import { RouterModule }   from '@angular/router';
import { LoginComponent } from './login.component';
import { GameComponent } from './game.component';
import { PageNotFoundComponent } from './page-not-found.component';

const appRoutes = [
    { path: '', component: LoginComponent },
    { path: 'login', component: LoginComponent },
    { path: 'game', component: GameComponent },
    { path: '**', component: PageNotFoundComponent }
];

export const appRoutingProviders: any[] = [

];

export const routing = RouterModule.forRoot(appRoutes);