package br.com.mcoder.HibernateJPATeste;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.mcoder.HibernateJPATeste.entities.Cliente;
import br.com.mcoder.HibernateJPATeste.entities.LojaDAO;
import br.com.mcoder.HibernateJPATeste.interfaces.ILojaDAO;

@SpringBootTest
class HibernateJpaTesteApplicationTests {

	private ILojaDAO lojaDao;

	@Test
	public void cadastrar() {
		Cliente cli = new Cliente();
	
		cli.setId(31L);
		cli.setNome("Marcello");
		cli.setEndereco("Endereço");
		cli = lojaDao.cadastrar(cli);
		
		assertNotNull(cli);
		assertNotNull(cli.getId());
	}

}
