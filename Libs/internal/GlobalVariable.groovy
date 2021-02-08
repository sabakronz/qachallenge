package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object baseUrl
     
    /**
     * <p></p>
     */
    public static Object successCode
     
    /**
     * <p></p>
     */
    public static Object globalId
     
    /**
     * <p></p>
     */
    public static Object positionsAPI
     
    /**
     * <p></p>
     */
    public static Object location
     
    /**
     * <p></p>
     */
    public static Object description
     
    /**
     * <p></p>
     */
    public static Object fullTime
     
    /**
     * <p></p>
     */
    public static Object latitude
     
    /**
     * <p></p>
     */
    public static Object longitude
     
    /**
     * <p></p>
     */
    public static Object jobID
     
    /**
     * <p></p>
     */
    public static Object markdown
     
    /**
     * <p></p>
     */
    public static Object positionsIDAPI
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            baseUrl = selectedVariables['baseUrl']
            successCode = selectedVariables['successCode']
            globalId = selectedVariables['globalId']
            positionsAPI = selectedVariables['positionsAPI']
            location = selectedVariables['location']
            description = selectedVariables['description']
            fullTime = selectedVariables['fullTime']
            latitude = selectedVariables['latitude']
            longitude = selectedVariables['longitude']
            jobID = selectedVariables['jobID']
            markdown = selectedVariables['markdown']
            positionsIDAPI = selectedVariables['positionsIDAPI']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
