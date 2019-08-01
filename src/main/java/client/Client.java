package client;

import grpc.BalanceResponse;
import grpc.Response;

/**
 * 
 * This interface provides requests to PaymentGate service.
 * @author Aleksey-S-58
 *
 */
public interface Client {
	
	public Response insert(long userId, String currencyName, int amount);
	
	public Response withdraw(long userId, String currencyName, int amount);
	
	public BalanceResponse balance(long userId);

}
