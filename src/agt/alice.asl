!sayHello.

+!sayHello
    <-  .print("say hello to bob");
        .send(bob, signal, signalHello);
        .send(bob, tell, tellHello);
        .send(bob, achieve, achieveHello).


{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }