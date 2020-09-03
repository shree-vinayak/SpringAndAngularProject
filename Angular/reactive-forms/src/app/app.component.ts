import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, FormArray } from '@angular/forms';
import { forbiddenNameValidator } from './shared/user-name.validator';
import { PasswordValidator } from './shared/password.validator';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'reactive-forms';
  registrationForm: FormGroup;

  constructor(private fb: FormBuilder) { }


  get userName() {
    return this.registrationForm.get('userName');
  }

  get email() {
    return this.registrationForm.get('email');
  }

  get alternateEmails() {
    return this.registrationForm.get('alternateEmails') as FormArray;
  }

  addAlternateEmail() {
    this.alternateEmails.push(this.fb.control(''));
  }

  ngOnInit() {
    this.registrationForm = this.fb.group({
      userName: ['Ankit', [Validators.required, Validators.minLength(3), forbiddenNameValidator(/password/)]],
      email: [''],
      subscribe: [false],
      password: [''],
      confirmPassword: [''],
      address: this.fb.group({
        city: [''],
        state: [''],
        postalCode: ['']
      }),
      alternateEmails: this.fb.array([])
    }, { validator: PasswordValidator });


    this.registrationForm.get('subscribe').valueChanges.subscribe(checkedValue => {

      const email = this.registrationForm.get('email');
      if (checkedValue) {
        email.setValidators(Validators.required);
      }
      else {
        email.clearValidators();
      }
      email.updateValueAndValidity();
    })
  }






  // registrationForm = new FormGroup({
  //   userName: new FormControl('ankit'),
  //   password: new FormControl(''),
  //   confirmPassword: new FormControl(''),
  //   address: new FormGroup({
  //     city: new FormControl(''),
  //     state: new FormControl(""),
  //     postalCode: new FormControl('')
  //   })
  // })

  loadApiData() {
    // this.registrationForm.setValue({
    //   userName: "rajat",
    //   password: "pass",
    //   confirmPassword: "pass",
    //   // address: {
    //   //   city: 'Banmore',
    //   //   state: 'MP',
    //   //   postalCode: "123456"
    //   // }
    // });

    this.registrationForm.patchValue({
      userName: "rajat",
      password: "pass",
      confirmPassword: "pass",
    });
  }

}
