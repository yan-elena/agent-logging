!g1.

+!g1 : count(X) & X < 3  <- a1; !g2; a3.
+!g1 : count(X) & X >= 3 <- a4; !g3.

+!g2 <- a2; inc.
+!g3 <- a5; inc.

+count(3) <- a7.

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
