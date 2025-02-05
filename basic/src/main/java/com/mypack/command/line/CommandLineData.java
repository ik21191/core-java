package com.mypack.command.line;

import java.util.Map;
import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "commandLineData", mixinStandardHelpOptions = true, version = "version 1.0",
description = "Arguments need to pass while calling the main method e.g. -j TestJob -s step1")
public class CommandLineData implements Callable<Integer> {
	
	@Option(names = {"-j", "--jobName"}, required = true ,description = "Test job name")
    private String jobName;
    
    @Option(names = {"-s", "--stepName"}, description = "Test step name")
    private String stepName;
    
    @Option(names = {"-m", "--myMap"}, description = "a=1,b=2,c=3,d=4,e=5")
    private Map<String, String> myMap;

	// this example implements Callable, so parsing, error handling and handling user
    // requests for usage help or version help can be done with one line of code.
	
	@Override
    public Integer call() throws Exception { // your business logic goes here...
       return 0;
    }

	public String getJobName() {
		return jobName;
	}

	public String getStepName() {
		return stepName;
	}

	public Map<String, String> getMyMap() {
		return myMap;
	}
	
	

}
