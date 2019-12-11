package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

/**
 *  if we look at the .drl file, any modification will also require technical knowledge. As the .drl becomes more complicated the more difficult it will become for non technical persons like Business Analysts. Also frequent changes to the drools file is cumbersome.Hence this format, decision tables, is a very good option to use where something is going to be changed frequently by non-programmers.*/
public class DroolsTest {

	public static final void main(String[] args) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
//Get the session named kseesion-rule that we defined in kmodule.xml above.
//Also by default the session returned is always stateful. 
			KieSession kSession = kContainer.newKieSession("ksession-rule");

			Product product = new Product();
			product.setType("gold");

			FactHandle fact1;

			fact1 = kSession.insert(product);
			kSession.fireAllRules();

			System.out.println("The discount for the jewellery product "
					+ product.getType() + " is " + product.getDiscount());

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
