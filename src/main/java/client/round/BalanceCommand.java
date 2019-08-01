package client.round;

import client.Client;

public class BalanceCommand implements Command {

	@Override
	public void execute(long userId, Client client) {
		client.balance(userId);
	}

}
