package client.round;

import client.Client;

public class DepositCommand implements Command {
	
	private Currency currency;
	
	private int amount;
	
	public DepositCommand(Currency currency, int amount) {
		this.currency = currency;
		this.amount = amount;
	}

	@Override
	public void execute(long userId, Client client) {
		client.insert(userId, currency.name(), amount);
	}

}
