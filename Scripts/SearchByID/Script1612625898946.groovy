import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS 
import sample.CommonKW


String location =searchLocation
String description = searchDescription
String fullTime = searchFullTime
String lat = latitude
String longPar = longitude

GlobalVariable.location=location
GlobalVariable.description=description
GlobalVariable.fullTime=fullTime
GlobalVariable.latitude = lat
GlobalVariable.longitude = longPar


println "GlobalVariable.location::: "+GlobalVariable.location
println "GlobalVariable.description::: "+GlobalVariable.description
println "GlobalVariable.fullTime::: "+GlobalVariable.fullTime
println "GlobalVariable.latitude::: "+GlobalVariable.latitude
println "GlobalVariable.longitude::: "+GlobalVariable.longitude
ResponseObject SearchRes

def slurper = new groovy.json.JsonSlurper()


if(!(((GlobalVariable.longitude).toString().isEmpty())) || !(((GlobalVariable.latitude).toString().isEmpty()))) 
	{
		SearchRes = WS.sendRequest(findTestObject('Object Repository/SearchAPIs/positions.json - lat_long'))
		println "lat_long API"
}else {
	SearchRes = WS.sendRequest(findTestObject('Object Repository/SearchAPIs/positions.json'))
	println "location API"
}




//verifyStatusCode
new CommonKW().verifyStatusCode(SearchRes,200)

SearchResBody = slurper.parseText(SearchRes.getResponseBodyContent())
String JobID = SearchResBody.get(0).get('id')


println "JobID::: "+JobID

GlobalVariable.jobID =JobID

SearchByIDRes = WS.sendRequest(findTestObject('Object Repository/SearchAPIs/positions'))
SearchByIDResBody = slurper.parseText(SearchByIDRes.getResponseBodyContent())

//verifyStatusCode
new CommonKW().verifyStatusCode(SearchRes,200)

println "SearchByIDResBody:: "+SearchByIDResBody.get('description')
println "SearchByIDResBody:: "+SearchByIDResBody.get('how_to_apply')