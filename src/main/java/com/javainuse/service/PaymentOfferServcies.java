package com.javainuse.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javainuse.model.PaymentOffer;

@Service
public class PaymentOfferServcies {

	private final KieContainer kieContainer;

	@Autowired
	public PaymentOfferServcies(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}
	
	public PaymentOffer getPaymentOfferChennel(PaymentOffer paymentoffer) {
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(paymentoffer);
		kieSession.fireAllRules();
		kieSession.dispose();
		return paymentoffer;
	}
	
	
	
}
