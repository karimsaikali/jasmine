# jasmine


A JavaScript Testing Framework

[Jasmine](https://github.com/jasmine/jasmine) is a Behavior Driven Development testing framework for JavaScript. It can now be used with Scriptr.


##How to create a jasmine test in Scriptr

Start by creating a scriptr script.

Require the jasmine boot 

`var jasmine = require("<path-to-jasmine-directory>/boot")`

Write the test using [jasmine's syntax](https://jasmine.github.io/2.5/introduction) . Note that asynch and timeout features are not yet supported in scriptr. 
```javascript
jasmine.describe("MyTest", function() {

  jasmine.beforeAll(function(){

  }); 
  
  jasmine.beforeEach(function() {
   
  });

  jasmine.it("should check something ", function() {
    //assert on something
  });
 
});
```
Finally you call 
 ```javascript
jasmine.execute();
```

Check the SampleTest under the test folder for a working example.

## Getting the Results

Due to the fantastic design by the Pivotal Lab Team and jasmine contributors, you can simply write a reporter or use the scriptr reporters under the reporters folder that are enabled by default. 

### Default Reporters

#### PubSubReporter 

It pushes the test results to a channel "jasmine", you can subscribe a script to the channel to immediately do something based  on the results, the script could pick up the json message, and then create a ticket in zoho or JIRA or any other third party ticketing platform used by your team or perhaps push a notification (a little drastic) to your phone? Send an email? 

Of course you need to save a channel in scriptr called "jasmine", or you could alternatively use a different channel by changing the value of channel in boot.

#### Console Reporter 

Nothing fancy there , It just prints the results in a human friendly format to your scriptr console / response script logs using console.log .


#### Write Your Own Reporter

 You can write your own reporter by creating a script with the following interface 
```javascript
function SomeReporter() {
    
   this.jasmineStarted = function(options) {
   
   };

   this.suiteStarted = function(message) {
   
   };

   this.suiteDone = function(message) {
   
   };

   this.specStarted = function(message) {
   
   }; 

   this.specDone = function(message) {
   
   };

   this.jasmineDone = function(doneResult) { 
   
	 };
   
   return this;
}
```

In the boot script, you require the reporter module and instantiate the reporter and you add it to the jasmine core.


## Setting up nightly Builds 

 You can just cron the testing script you created, and you got nightly builds combined with the PubSubReporter and your script that creates tickets.


#TODO 
* Configuration file for reporters / auto load reporters in configuration file ? 
* A nice UI using some customizable template on top of a templating engine that listens to the jasmine channel to see the test results in real time. 
* Use the same UI template to generate reports by nightly builds if necessary ? 


Happy Test Automation.
