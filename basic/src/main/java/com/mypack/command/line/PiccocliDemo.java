package com.mypack.command.line;

import picocli.CommandLine;

//https://picocli.info/
public class PiccocliDemo {
    public static void main(String... args) {
    	CommandLineData commandLineData = new CommandLineData();
        int exitCode = new CommandLine(commandLineData).execute(args);
        System.out.println(commandLineData.getJobName());
        System.out.println(commandLineData.getStepName());
        System.out.println(commandLineData.getMyMap());
        System.exit(exitCode);
    }
    
    
}
