!sayHello.

+!sayHello
    <-  .print("say hello to bob");
        .send(bob, tell, tellMsg("msg"));
        .send(bob, achieve, achieveMsg("msg"));
        .my_name(N);
        .kill_agent(N).


{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }