// CArtAgO artifact code for project log_ag

package example;

import cartago.*;

public class Counter extends Artifact {
	void init(int initialValue) {
		defineObsProperty("count", initialValue);
	}

	@OPERATION
	void inc() {
		ObsProperty prop = getObsProperty("count");
		prop.updateValue(prop.intValue()+1);
		signal("tick");
	}

	@OPERATION
	void inc_get(int inc, OpFeedbackParam<Integer> newValueArg) {
		ObsProperty prop = getObsProperty("count");
		int newValue = prop.intValue()+inc;
		prop.updateValue(newValue);
		newValueArg.set(newValue);
	}

	@OPERATION void a1() { System.out.println("done a1");	}
	@OPERATION void a2() { System.out.println("done a2");	}
	@OPERATION void a3() { System.out.println("done a3");	}
	@OPERATION void a4() { System.out.println("done a4");	}
	@OPERATION void a5() { System.out.println("done a5");	}
	@OPERATION void a6() { System.out.println("done a6");	}
	@OPERATION void a7() { System.out.println("done a7");	}

}

