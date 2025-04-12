package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Cucumber",glue="Step",monochrome=true,plugin= {"html:target/cucumber.html"})
public class CucumberRunner extends AbstractTestNGCucumberTests	 
{

}
