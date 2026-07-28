import { Routes } from '@angular/router';
import { ListComponent } from './components/list/list.component';
import { AddempComponent } from './components/addemp/addemp.component';
import { UpdateempComponent } from './components/updateemp/updateemp.component';
import { InfoempComponent } from './components/infoemp/infoemp.component';

export const routes: Routes = [
    {path:"list",component:ListComponent},
    {path:"",component:ListComponent},
    {path:"add",component:AddempComponent},
    // ,{path:"home",component="HomeComponent"}
    {path:"update/:id",component: UpdateempComponent},
    {path:"info/:id",component:InfoempComponent}
];
