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
String pageNum = pageNumber
String Search = generalSearch

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
println "pageNumber::: "+pageNum
println "Search value::: "+Search

ResponseObject SearchRes

def slurper = new groovy.json.JsonSlurper()
//note for page number
if(pageNum.isEmpty()) {
//note for general search 
if(Search.isEmpty()) {
	
//note for lat&long
if(!(((GlobalVariable.longitude).toString().isEmpty())) || !(((GlobalVariable.latitude).toString().isEmpty()))) 
	{
		SearchRes = WS.sendRequest(findTestObject('Object Repository/SearchAPIs/positions.json - lat_long'))
		println "lat_long API/Search and Page is empty"
}else {
	SearchRes = WS.sendRequest(findTestObject('Object Repository/SearchAPIs/positions.json'))
	println "location API/Search and Page is empty"
}
}else {
	GlobalVariable.positionsAPI = GlobalVariable.positionsAPI+"search="+Search+"&"
	
	if(!(((GlobalVariable.longitude).toString().isEmpty())) || !(((GlobalVariable.latitude).toString().isEmpty())))
		{
			SearchRes = WS.sendRequest(findTestObject('Object Repository/SearchAPIs/positions.json - lat_long'))
			println "lat_long API/Search not empty and Page is empty"
	}else {
		SearchRes = WS.sendRequest(findTestObject('Object Repository/SearchAPIs/positions.json'))
		println "location API/Search not empty and Page is empty"
	}
	
}
}else {
	GlobalVariable.positionsAPI = GlobalVariable.positionsAPI+"page="+pageNum+"&"
	
	if(Search.isEmpty()) {
		if(!(((GlobalVariable.longitude).toString().isEmpty())) || !(((GlobalVariable.latitude).toString().isEmpty())))
			{
				SearchRes = WS.sendRequest(findTestObject('Object Repository/SearchAPIs/positions.json - lat_long'))
				println "lat_long API/Search is and Page not empty"
		}else {
			SearchRes = WS.sendRequest(findTestObject('Object Repository/SearchAPIs/positions.json'))
			println "location API/Search is and Page not empty"
		}
		}else {
			GlobalVariable.positionsAPI = GlobalVariable.positionsAPI+"search="+Search+"&"
			
			if(!(((GlobalVariable.longitude).toString().isEmpty())) || !(((GlobalVariable.latitude).toString().isEmpty())))
				{
					SearchRes = WS.sendRequest(findTestObject('Object Repository/SearchAPIs/positions.json - lat_long'))
					println "lat_long API/Search not empty and Page not empty"
			}else {
				SearchRes = WS.sendRequest(findTestObject('Object Repository/SearchAPIs/positions.json'))
				println "location API/Search not empty and Page not empty"
			}
			
		}
	
	
	
	
}
//verifyStatusCode
new CommonKW().verifyStatusCode(SearchRes,200)

SearchResBody = slurper.parseText(SearchRes.getResponseBodyContent())

//Check number of Jobs
List<Map<String,Object>> toList = SearchResBody
if ((toList.size()).equals(50)) {
	KeywordUtil.markPassed("Jobs number is 50")
} else {
	KeywordUtil.markErrorAndStop('Jobs number isn\'t 50. Expected: 50' + ' - Actual: ' +toList.size())
}

for(i=0;i<50;i++) {
println "Job title "+(i+1)+" :: "+ SearchResBody.get(i).get('title')
}