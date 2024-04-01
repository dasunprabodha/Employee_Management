import { Component } from '@angular/core';
import { Employee } from '../../employee'; 
import { AddService } from '../../services/add.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent {
  employee: Employee = { id: 0, firstName: '', lastName: '', email: '' }; 

  constructor(private addService: AddService) {}

  saveEmployee(employee: Employee): void {
    this.addService.saveEmployee(employee).subscribe(
      (response: any) => {
        console.log('Employee saved successfully:', response);
        this.employee = { id: 0, firstName: '', lastName: '', email: '' };
      },
      (error: any) => {
        if (error.status === 201) {
          console.log('Employee saved successfully:', error);
          this.employee = { id: 0, firstName: '', lastName: '', email: '' };
        } else {
          console.error('Error saving employee:', error);
        }
      }
    );
  }
}  