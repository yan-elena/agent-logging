# Agent Logging

This repository provides a logging component of the multi-level explainability framework for multi-agent BDI systems. This component aims to capture snapshots and generate logs of the multi-agent system implemented using the `Jacamo` framework. The log file can be uploaded in the [Explanation Component](https://yan-elena.github.io/agent-explanation/) to explain the agent behaviour.

## Configuration

To use this logging component in your systems, you can follow the following configuration instructions.

1. Add this library as a dependency in your project gradle file:
```
dependencies {
    implementation 'io.github.yan-elena:agent-logging:0.1.0'
}
```

2. In a JaCaMo project, configure the `ag-arch` and `ag-class` in your `.jcm` file as shown below for each agent you are interested in logging.
```
    agent bob { 
      ag-arch:     log.LoggerArch
      ag-class:    log.LoggerAg
    }
```

  If you want to use it in a Jason project, follow this configuration in your `.mas2j` file:
```
     agents:
            bob     agentArchClass      log.LoggerArch
                    agentClass          log.LoggerAg;
```

3. Launch the application! The agent's logs generated as readable files (`.log`) and as `.json` files for use in the application for explanation are located in the `/log` folder.

## Example

An example of the configuration and use of this framework can be found in this repository: [Domestic Robot Example](https://github.com/yan-elena/domestic-robot-example)
