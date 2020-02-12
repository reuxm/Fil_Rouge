import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

import data from '../conf';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

	private url = '/Rest/login/';
	
	private user = '';
	
	get loggedUser(): string {
		return this.user;
	}
	
	constructor( private http: HttpClient) { }
	
	async check( login: string, pwd: string ): Promise<boolean> {
		let ret = false;
		let d = await this.http.post(
			data.url + this.url + 'test',
			{ login:login, pwd:pwd }
		).toPromise();
		if( d ) {
			ret = true;
			this.user = login;
		}
		return ret;
	}
}
