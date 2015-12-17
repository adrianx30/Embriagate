package co.edu.udea.embriagate.dao.impl.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.embriagate.dao.ClienteDAO;
import co.edu.udea.embriagate.dto.ClienteDTO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:springconfiguration.xml")
@Transactional
public class ClienteDAOImplTest {
	@Autowired
	ClienteDAO clienteDao;
	@Test
	public void test() {
		ClienteDTO cliente=null;
		try {
			cliente=clienteDao.consultar("1152700319");
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
