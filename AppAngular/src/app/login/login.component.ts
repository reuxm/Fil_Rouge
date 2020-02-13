import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
	
	login: string;
	password: string;

	constructor( private service: LoginService, private router: Router ) { }

	ngOnInit() { }

	async log() {
		if( await this.service.check( this.login, this.password ) ) {
			this.router.navigate(['/home'], { queryParams: { login: true } });
		}
	}
	
}
