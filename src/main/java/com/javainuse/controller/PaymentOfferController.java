package com.javainuse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.PaymentOffer;
import com.javainuse.service.PaymentOfferServcies;

@RestController
public class PaymentOfferController {
	
	private final PaymentOfferServcies paymentOfferServcies;
	@Autowired
	public PaymentOfferController(PaymentOfferServcies paymentOfferServcies) {
		this.paymentOfferServcies = paymentOfferServcies;
	}
	@RequestMapping(value = "/getPaymentDiscount", method = RequestMethod.GET, produces = "application/json")
	public PaymentOffer getPaymentQuestions(@RequestParam(required = true) String channel) {
		PaymentOffer paymentOffer = new PaymentOffer();
		paymentOffer.setChannel(channel);
		paymentOfferServcies.getPaymentOfferChennel(paymentOffer);
		return paymentOffer;
	}
	
	
	

}
