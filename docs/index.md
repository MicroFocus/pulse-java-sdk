# SDK for Plugins to integrate with Micro Focus Pulse

## License

> **MIT License**
>
> Copyright &copy; 2019 Micro Focus or one of its affiliates.
>
> Licensed under the MIT License (the &ldquo;License&rdquo;); you may not use this file
> except in compliance with the License. You may obtain a copy of the License
> at
>
> [https://opensource.org/licenses/MIT](https://opensource.org/licenses/MIT)
>
> Unless required by applicable law or agreed to in writing, software
> distributed under the License is distributed on an &ldquo;AS IS&rdquo; BASIS, WITHOUT
> WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
> License for the specific language governing permissions and limitations
> under the License.

## Introduction

Micro Focus Pulse's Plugin Development Kit provides an easy way to integrate functionality into Micro Focus Pulse application server and agents.

The SDK is broken down into 5 modules with a parent SDK module tying everything together:

1. [pulse-plugin-core-api](apidocs/pulse-plugin-core-api/index.html): provides a number of interfaces that form the base for all plugins.
2. [pulse-plugin-chain-api](apidocs/pulse-plugin-chain-api/index.html): interfaces that allow chain plugins to be written, including chain step and chain finding plugins. You can
use these to tightly integrate external tools such as build or static analysis into your chains.
3. [pulse-plugin-chain-dto](apidocs/pulse-plugin-chain-dto/index.html): definition of all the DTO objects used by the pulse-plugin-chain-api
4. [pulse-plugin-event-api](apidocs/pulse-plugin-event-api/index.html): interfaces that allow plugins to be written that will be called when an internal event happens, such as a review changes state or a comment is made on a review.
5. [pulse-plugin-event-dto](apidocs/pulse-plugin-event-dto/index.html): definition of all the DTO objects used by the pulse-plugin-event-api

## Usage Examples

A number of example plugins are provided in **pulse-plugin-examples** that show how to write simple plugins using the SDK.

1. [pulse-plugin-chainstep-worddetector](https://github.com/MicroFocus/pulse-java-sdk/blob/master/pulse-plugin-examples/pulse-plugin-chainstep-worddetector) detects *banned* words in the files within a commit.
2. [pulse-plugin-event-statelogger](https://github.com/MicroFocus/pulse-java-sdk/blob/master/pulse-plugin-examples/pulse-plugin-event-statelogger) logs the state change for a review.

##  Chain Plugins

Pulse provides an Agent architecture that allows chains to be run in a distributed environment. Each chain is made up
of a collection of steps, with each step calling a Chain Step Plugin to perform some work, for example to run a build
tool, perform some static analysis or trigger a deployment. The possibilities of what a chain can do are only limited
by the Chain Step Plugins, and if there are no plugins that do what you want, it is possible to write a new plugin using
the Pulse Chain Plugin API.

We recommend that you use one of the example plugins as a starting point for your new plugin.

### Packaging Chain Plugins

Both the Pulse Agent and Pulse Server expect chain plugins to be packaged into `spar` files that combine both the compiled plugin and the configuration UI needed to run the plugin.
Spar files are simply a zip file containing all of the jars that are required for the chain plugin and a `package.json` file that describes the plugins contained within the `spar`. 

Each `spar` can contain multiple plugins, but they will share the same libraries contained within the spar. If your plugins need different library versions, then they should be packaged independently.

The structure of the `package.json` file is as follows (explanation for the fields are below):

````
{
  "name": "pulse-plugin-chainstep-worddetector",
  "version": "19.1.1",
  "requires": {
    "java": "1.8",
    "plugin-api": "19.1"
  },
  "experts": [
    {
      "className": "com.microfocus.pulse.example.worddetector.WordDetectorPulseExample"
    }
  ]
}
```` 

1. `name` - normally the artifact ID if the Maven project used to build the plugin. This is used to name the directory that the plugin is copied to and should be considered to be unique.
2. `version` - version of your plugin. Normally this would be the version from the Maven project.
3. `requires.java` - version of the Java needed by the plugin. As of this time, only `1.8` is supported.
4. `requires.plugin-api` - version of the chain API the plugin requires. Currently Pulse supports `19.1`.
5. `experts` - Array of objects declaring the entry point of the plugin.

### Debugging Chain Plugins

To aid in development and to make it easy to debug plugins, it is possible to run a Pulse Agent on the command line, pointing
it to the `spar` file containing the built plugin, a configuration file, and a directory of code to be passed to the plugin to work on. Running
the agent in this way means you do not need to have a full Micro Focus Pulse install in order to verify  your plugin is behaving as you expect.

The commands below assume the agent is running on a Windows machine and is installed in`c:\pulse-agent-install`, however it is possible to run the agent on a Linux machine as long
as a compatible Java 8 JRE is installed.

Before you start, it is worth switching the *agent* to run as a single process rather than spawning another process to run the chain. This
can be done by adding the line `agent.development.worker.mode=inprocess` to the configuration file in `c:\pulse-agent-install\conf\config.properties`

Assuming an agent installed in `c:\pulse-agent-install`, and the example plugin located in `c:\example-chain-plugin-word-detector` you would
use the following command to run the plugin.

````
java "-Duser.dir=c:\pulse-agent-install"
     "-Dlogback.configurationFile=c:\pulse-agent-install\conf\agent-logback.xml"
     -classpath "c:\pulse-agent-install\lib\*" com.serena.starlight.agent.AgentEntryPoint 
     "config:c:\pulse-agent-install\conf\config.properties" 
     "run:.\example-chain.json"  
     "result:.\chainresult.json" 
     "install:.\target\example-chain-plugin-word-detector.spar"
     "workspace:c:\directory_to_be_processed"
````

*Note: Although the example is on multiple lines, it should run as a single line. You might find it simpler to create a batch file with the command.*

The command will take a *chain definition* file  called `chainrun.json` in the current directory and use that to configure the plugin
and the result of the run will be output to `chainresult.json`. Examples of these files are located in the top level directory of the example plugin.
