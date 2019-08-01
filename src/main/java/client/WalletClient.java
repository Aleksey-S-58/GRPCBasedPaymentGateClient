package client;

import grpc.Balance;
import grpc.BalanceResponse;
import grpc.Deposit;
import grpc.Response;
import grpc.WalletServiceGrpc;
import grpc.Withdraw;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class WalletClient implements Client {
	private WalletServiceGrpc.WalletServiceBlockingStub walletServiceBlockingStub;

	public void init() {
	    ManagedChannel managedChannel = ManagedChannelBuilder
	        .forAddress("localhost", 6565).usePlaintext().build();
		    walletServiceBlockingStub =
	        WalletServiceGrpc.newBlockingStub(managedChannel);
	}

	@Override
	public Response insert(long userId, String currencyName, int amount) {
		  Deposit deposit = Deposit.newBuilder().
				  setUserId(userId).
				  setCurrency(currencyName).
				  setAmount(amount).
				  build();
		Response response = walletServiceBlockingStub.deposit(deposit);
		return response;  
	}

	@Override
	public Response withdraw(long userId, String currencyName, int amount) {
		  Withdraw withdraw = Withdraw.newBuilder()
				  .setUserId(userId)
				  .setCurrency(currencyName)
				  .setAmount(amount)
				  .build();
		  Response response = walletServiceBlockingStub.withdraw(withdraw);
		  return response;
	}

	@Override
	public BalanceResponse balance(long userId) {
		  Balance balance = Balance.newBuilder().setUserId(userId).build();
		  BalanceResponse response = walletServiceBlockingStub.balance(balance);
		  return response;
	}
}