import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { LoginService } from '../login/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

	private login='';
	
 	constructor( private logServ: LoginService, private route: ActivatedRoute ) { }

 	ngOnInit() { 
		this.route.queryParamMap.subscribe(d => {
			let log = d.get('login');
			if( log )
				this.login = this.logServ.loggedUser;
		});
 	}

}
