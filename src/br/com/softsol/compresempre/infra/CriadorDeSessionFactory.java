package br.com.softsol.compresempre.infra;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

/**
 * @author Wesley Martins
 * @last update 21/01/2013
 */

@ApplicationScoped
@Component
public class CriadorDeSessionFactory implements
		ComponentFactory<SessionFactory> {

	private SessionFactory factory;

	@PostConstruct
	public void abre() {
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();
		this.factory = configuration.buildSessionFactory();
	}

	public SessionFactory getInstance() {
		return this.factory;
	}

	@PreDestroy
	public void fecha() {
		this.factory.close();
	}

}