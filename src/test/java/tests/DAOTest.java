package tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.usuarioDAO;
import repositorio.Repositorio;
import usuario.Usuario;

public class DAOTest {
	
	private static final String PERSISTENCE_UNIT_NAME = "DDS";
	private static EntityManagerFactory emf;
	private static Repositorio repositorio;
	
	public static void main(String[] args) throws Exception {
		
	//Creamos el gestor de persistencia (EM)
	emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	
		
		
	//Creo un usuario
	Usuario javier = new Usuario("Javier");
	javier.setMail("javier@gmail.com");
	javier.setPassword("Javier123");
	
	
	
	//Persisto el usuario
	
	usuarioDAO usuario = new usuarioDAO(emf.createEntityManager());
	usuario.crearUsuario(javier);
	
	
}	
}
