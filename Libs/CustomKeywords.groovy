
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import com.kms.katalon.core.testobject.ResponseObject

import com.kms.katalon.core.testobject.TestObject

import java.lang.String


/**
	 * Send request and verify status code
	 * @param request request object, must be an instance of RequestObject
	 * @param expectedStatusCode
	 * @return a boolean to indicate whether the response status code equals the expected one
	 */
def static "sample.CommonKW.verifyStatusCode"(
    	ResponseObject response	
     , 	int expectedStatusCode	) {
    (new sample.CommonKW()).verifyStatusCode(
        	response
         , 	expectedStatusCode)
}

/**
	 * Add Header basic authorization field,
	 * this field value is Base64 encoded token from user name and password
	 * @param request object, must be an instance of RequestObject
	 * @param username username
	 * @param password password
	 * @return the original request object with basic authorization header field added
	 */
def static "sample.CommonKW.addBasicAuthorizationProperty"(
    	TestObject request	
     , 	String username	
     , 	String password	) {
    (new sample.CommonKW()).addBasicAuthorizationProperty(
        	request
         , 	username
         , 	password)
}
