package client.round;

import client.Client;

/**
 * This interface describes user's behavior.
 * An object that will implement this interface will contain a sequence of user's commands.
 * 
 * @author Aleksey-S-58
 *
 */
@FunctionalInterface
public interface Round {

	public void execute(long userId, Client client);
	
}
