import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddComponent } from './components/add/add.component';
import { EmployeesComponent } from './components/employees/employees.component';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
const routes: Routes = [
  { path: 'employees-list', component: EmployeesComponent },
  { path: 'add-employees', component: AddComponent },
  { path: '**', redirectTo: '' } // Redirect to Home if the path is not found
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
