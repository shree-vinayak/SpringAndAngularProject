import { Component } from '@angular/core';
import { User } from './user';
import { UserService } from './user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'tdf';

  topics = ['angular', 'react', 'vue'];
  submitted = false;
  topicHasError = true;

  errorMsg = '';

  userModel = new User('', 'ankit@gmail.com', '7898311713', 'default', 'morning', true);

  constructor(private userService: UserService) { }

  validateTopic(value) {

    if (value === 'default') {
      this.topicHasError = true;
    }
    else {
      this.topicHasError = false;
    }
  }


  onSubmit() {

    this.submitted = true
    this.userService.enroll(this.userModel).subscribe(data =>
      console.log('Success !', data)
      , error => this.errorMsg = error.statusText

    )
  }
}
