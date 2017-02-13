var jasmine = require("./jasmine");
var reporterModule = require("./reporters/PubSubReporter");
var consoleReporterModule = require("./reporters/ConsoleReporter");
var terminalReporterModule = require("./reporters/TerminalReporter");

var jasmineCore = jasmine.jasmineRequire.core(jasmine.jasmineRequire);
var env = jasmineCore.getEnv();
var describe = env.describe;
var to = env.to;
var xdescribe = env.xdescribe;
var it = env.it;
var xit = env.xit;
var fit = env.fit;
var beforeEach = env.beforeEach;
var afterEach = env.afterEach;
var beforeAll = env.beforeAll;
var afterAll = env.afterAll;
var expect = env.expect;
var pending = env.pending;
var fail = env.fail;
var spyOn =env.spyOn;

var any = jasmineCore.any;
var anything = jasmineCore.anything;
var objectContaining = jasmineCore.objectContaining;
var arrayContaining = jasmineCore.arrayContaining;
var stringMatching = jasmineCore.stringMatching;
var execute = env.execute;

var name = request.parameters["testName"];
if(name == null){
  name = "Test-" + Date.now();
}

var pubSubReporter = new reporterModule.PubSubReporter({"name": name});
var reporter = new consoleReporterModule.ConsoleReporter({"name": name});

env.addReporter(pubSubReporter);
env.addReporter(reporter);


