package client.round;

import client.Client;

public class WithdrawCommand implements Command {
	
	private Currency currency;
	
	private int amount;
	
	public WithdrawCommand(Currency currency, int amount) {
		this.currency = currency;
		this.amount = amount;
	}

	@Override
	public void execute(long userId, Client client) {
		client.withdraw(userId, currency.name(), amount);
	}

}
