package company.JRTP701_SSA_Web_API;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ssa-web-api")
public class SSAWebOperationsRestController {
	
	@GetMapping("/find/{ssn}")
	public ResponseEntity<String> getStateBySSN(@PathVariable Integer ssn){
		
		if(String.valueOf(ssn).length()!=9) {
			return new ResponseEntity<String>("Invalid SSN NUmber",HttpStatus.BAD_REQUEST);
			
		}
		
		
		int statusCode=ssn%100;
		
		String stateName;
		
		if(statusCode==01)
			stateName="Washington DC";
		else if(statusCode==02)
			stateName="Ohio";
		else if(statusCode==03)
			stateName="Texas";
		else if(statusCode==04)
			stateName="California";
		else if(statusCode==05)
			stateName="florida";
		else
			stateName="invalid ssn";
		System.out.println("HI ");
		
		return new ResponseEntity<String>(stateName,HttpStatus.OK);
		
		
	}

}
