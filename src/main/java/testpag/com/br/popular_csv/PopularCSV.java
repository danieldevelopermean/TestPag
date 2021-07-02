package testpag.com.br.popular_csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

@Component
public class PopularCSV {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:mem:testdb";
	// Database credentials
	static final String USER = "sa";
	static final String PASS = "";

	public void popularCSVMetodo() throws ClassNotFoundException, SQLException {

		Connection conn = null;
		Statement stmt = null;

		try {

			String fileName = "contas_bancarias.csv";
			ClassLoader classLoader = getClass().getClassLoader();

			InputStream inputStream = classLoader.getResourceAsStream(fileName);
			InputStreamReader is = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
			BufferedReader br = new BufferedReader(is);

			String linha;

			Class.forName("org.h2.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			do {
				linha = br.readLine();
				if (linha != null) {

					String[] campo = linha.split(",");

					String nome = campo[0];
					String numeroConta = campo[1];
					String agencia = campo[2];
					String chequeEspecialLiberado = campo[3];
					String saldo = campo[4];
					String cheque_especial = campo[5];
					String taxa = campo[6];

					stmt = conn.createStatement();
					String sql = "insert into conta_bancaria (nome,numero_conta,agencia,cheque_especial_liberado,saldo,cheque_especial,taxa) values "
							+ "("  + "'" + nome + "'" + "," + "'" + numeroConta + "'" + "," + "'" + agencia
							+ "'" + "," + chequeEspecialLiberado + "," + saldo + "," + cheque_especial + "," + taxa
							+ ")";


					stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
					stmt.close();

				}
			} while (linha != null);
		} catch (IOException e) {
			System.out.println("Erro ao ler Arquivo");
		}
	}

}
