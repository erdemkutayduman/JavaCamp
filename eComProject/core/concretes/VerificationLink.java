package core.concretes;

import java.util.UUID;

import core.abstracts.VerificationService;

public class VerificationLink implements VerificationService{

	@Override
	public void send() {
		UUID uuid = UUID.randomUUID();
		String verificationLink = "https://ecommerce.com/" + uuid.toString();
		System.out.println("Please click on the link to verify your account:  " + verificationLink );
	}

}
