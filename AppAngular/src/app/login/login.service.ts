import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

import data from '../conf';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

	private url = '/Rest/login/';
	
	private user = '';
	
	private com = false;
	
	private meca = false;
	
	get loggedUser(): string {
		return this.user;
	}
	
	get isCom() {
		return this.com;
	}
	
	get isMeca() {
		return this.meca;
	}
	
	constructor( private http: HttpClient) { }
	
	async check( login: string, pwd: string ): Promise<boolean> {
		let ret = false;
		console.warn(login,pwd);
		let d = await this.http.post(
			data.url + this.url + 'test',
			{ login:login, pwd:pwd }
		).toPromise();
		if( d ) {
			ret = true;
			this.user = login;
			this.com = d['com'];
			this.meca = d['meca'];
		}
		return ret;
	}
	
	logout() {
		this.user="";
		this.com=false;
		this.meca=false;
	}
}
