test1(1).

!g1.

+!g1 : count(X) & X < 3  <- a1; !g2; a3.
+!g1 : count(X) & X < 5  <- a1; !g2; a3.
+!g1 : count(X) & X >= 3 <- a4; !g3.

+!g2 <- a2; inc; +b(0); -b(0); +b(1); -+b(2); ?test1(T1); ?test2(T2); .print(T1, T2); A=10.

+?test2(2).

+!g.

+count(3) <- !g; a7.

+b(0) <- !g.

+tellHello
    <-  !g; .print("receive tell hello").

+!achieveHello
    <-  !g; .print("receive achieve hello").

+signalHello <- !g.

+tick
    <-  !g; .print("tick message").

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
