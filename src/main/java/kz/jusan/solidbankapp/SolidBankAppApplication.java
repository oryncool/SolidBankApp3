package kz.jusan.solidbankapp;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@SecurityScheme(name = "basicauth", scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class SolidBankAppApplication{
	private final ApplicationContext context;

	@Autowired
	public SolidBankAppApplication(ApplicationContext context) {
		this.context = context;
	}

	public static void main(String[] args) {
		SpringApplication.run(SolidBankAppApplication.class, args);
	}

	/*
	@Override
	public void run(String... arg0) {
		TransactionWithdrawCLI transactionWithdrawCLI = context.getBean("transactionWithdrawCLI", TransactionWithdrawCLI.class);
		TransactionDepositCLI transactionDepositCLI = context.getBean("transactionDepositCLI", TransactionDepositCLI.class);
		AccountBasicCLI accountBasicCLI = context.getBean("accountBasicCLI", AccountBasicCLI.class);
		System.out.println("Welcome to CLI bank service");
		System.out.println("""
							Enter operation number:
							1 - show accounts
							2 - create account
							3 - deposit
							4 - withdraw
							5 - transfer
							6 - this message
							7 - exit""");
		Scanner scanner = new Scanner(System.in);
		loop:
		while (true) {
			switch (scanner.nextInt()) {
				case 1:
					accountBasicCLI.getAccounts("1");
					break;
				case 2:
					accountBasicCLI.createAccountRequest("1");
					break;
				case 3:
					transactionDepositCLI.depositMoney("1");
					break;
				case 4:
					transactionWithdrawCLI.withdrawMoney("1");
					break;
				case 6:
					System.out.println("""
							Enter operation number:
							1 - show accounts
							2 - create account
							3 - deposit
							4 - withdraw
							5 - transfer
							6 - this message
							7 - exit""");
					break;
				case 7:
					System.out.println("Application Closed");
					break loop;
				default:
					System.out.println("Incorrect command");

			}
		}
		scanner.close();
	}
	 */

}
