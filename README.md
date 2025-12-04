# Agent Logging

This repository provides a logging component of the multi-level explainability framework for multi-agent BDI systems. This component aims to capture snapshots and generate logs of the multi-agent system implemented using the `Jacamo` framework. The log file can be uploaded in the [Explanation Component](https://yan-elena.github.io/agent-explanation/) to explain the agent behaviour.

## A Multi-Level Explainability Framework for Engineering and Understanding BDI Agents

<img src="https://github.com/user-attachments/assets/69de5bc6-edee-4d47-a18b-ee5995800c3d" width=50%>

The primary levels of abstraction identified in this study are as follows:
- The **Implementation Level**: a detailed narrative closely related to the Agent and Multi-Agent Systems for debugging and testing.
- The **Design Level**: a level that describes the agent behaviour regardless of its implementation for analysis and verification.
- The **Domain Level**: a high-level narrative that explains the behaviour with reference to the domain and requirements of the system - *(work in progress)*.

## Requirements

Please use this version of Jason or JaCaMo in your multi-agent system project.

For Jason applications:
```
dependencies {
    implementation 'io.github.jason-lang:jason-interpreter:3.2.1-SNAPSHOT'
}
```

For JaCaMo applications:
```
dependencies {
    implementation 'org.jacamo:jacamo:1.2-SNAPSHOT'
}
```

## Configuration

You can follow the configuration instructions below to use the logging component as a library in your project.

1. Add this library as a dependency in your project gradle file:
```
dependencies {
    implementation 'io.github.yan-elena:agent-logging:latest'
}
```

2. In your **JaCaMo** project, configure the `ag-arch` and `ag-class` in your `.jcm` file as shown below for each agent you are interested in logging.
```
agent bob { 
  ag-arch:     log.LoggerArch
  ag-class:    log.LoggerAg
}
```

  If you want to use it in a **Jason** project, follow this configuration in your `.mas2j` file:
```
 agents:
        bob     agentArchClass      log.LoggerArch
                agentClass          log.LoggerAg;
```

3. Launch the application! The agent's logs generated as readable files (`.log`) and as `.json` files are located in the `/log` folder.
4. You can try our [web application](https://yan-elena.github.io/agent-explanation/), to explore the narrative of the system at multiple levels! 

## Example

An example of the configuration and use of this framework can be found in this repository: [Domestic Robot Example](https://github.com/yan-elena/domestic-robot-example)
