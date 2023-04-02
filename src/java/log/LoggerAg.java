package log;

import java.util.List;

import jason.asSemantics.Agent;
import jason.asSemantics.CircumstanceListener;
import jason.asSemantics.Event;
import jason.asSemantics.GoalListener;
import jason.asSemantics.Message;
import jason.asSemantics.Option;

public class LoggerAg extends Agent implements GoalListener, CircumstanceListener {

    @Override
    public void initAg() {
        super.initAg();

        // add listeners
        getTS().addGoalListener(this);
        getTS().getC().addEventListener(this);
    }

    @Override // from Agent class
    public Option selectOption(List<Option> options) {
        printLog("options for "+getTS().getC().getSelectedEvent().getTrigger()+" are "+options);        
        return super.selectOption(options);
    }

    // Goal  Listener Interface 

    @Override
    public void goalStarted(Event goal) {
        printLog("goal "+goal.getTrigger()+" started!");
    }

    // Circumstance Listener Interface

    @Override
    public void eventAdded(Event e) {
        printLog("new event "+e.getTrigger());
    }

    // TODO: see other methods of Goal & Circumstance Listeners

    void printLog(String m) {
        if (!m.contains("+!jcm::")) // filter some msgs
            System.out.println("log: "+m);
    }
}
