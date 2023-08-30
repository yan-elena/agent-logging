test1(1).

!g1.

+!g1 : count(X) & X < 3  <- a1; !g2; a3.
+!g1 : count(X) & X < 5  <- a1; !g2; a3.
+!g1 : count(X) & X >= 3 <- a4; !g3.

+!g2 <- a2; inc; +b(0); -b(0); ?test1(T1); ?test2(T2); .print(T1, T2); A=10.

+?test2(2).

+count(3) <- a7.

+tellHello
    <-  .print("receive tell hello").

+!achieveHello
    <-  .print("receive achieve hello").

+tick
    <-  .print("tick message").

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
