# GRPCBasedPaymentGateClient
This is grpc based client for payment gate (https://github.com/IvanSergeiSh/PaymentGate.git), that is intended to emulate load on a grpc based application.

Classes: WalletServiceGrpc, BalanceResponse and Response will be generated during compilation by protobuf-maven-plugin.

Main class Application is launched with command line arguments:
first:  number of users
second: number of concurrently executed threads by each user
third:  number of behavior strategies that will be executed by each thread.

If command line arguments was not specified then default values will be used:
users:      100
threads:    10
strategies: 10
